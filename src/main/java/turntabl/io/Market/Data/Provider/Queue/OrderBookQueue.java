package turntabl.io.Market.Data.Provider.Queue;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import redis.clients.jedis.Jedis;
import turntabl.io.Market.Data.Provider.ClientOrder.Order;
import turntabl.io.Market.Data.Provider.OrderBook.PendingOrders;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class OrderBookQueue {

    private List<PendingOrders> orderBookRepository = new ArrayList<>();

    private List<Order> orderRepository = new ArrayList<>();

    private WebClient getBuild(String url) {
        return WebClient.builder()
                .baseUrl(url)
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    WebClient web_client = getBuild("https://exchange.matraining.com");
    WebClient web_client_2 = getBuild("https://exchange2.matraining.com");

    public void thread() {
        //create a thread
        new Thread(new Runnable() {
            //overriding runnable
            Jedis jedis = new Jedis();

            @Override
            public void run() {
                while (true) {

                    try {
                        Thread.sleep(5000);
                    } catch (Exception e) {

                    }

                    orderRepository.clear();
                    orderBookRepository.clear();

                    String data = jedis.rpop("OrderBookRequest");
                    if(data == null) continue;
                    Order order = Ultility.convertToObject(data, Order.class);
                    orderRepository.add(order);

                    Flux<PendingOrders> orderBook1 = web_client.get()
                            .uri("/orderbook/" + orderRepository.get(0).getTicker() + "/" +
                                    orderRepository.get(0).getSide().toLowerCase())
                            .accept(MediaType.APPLICATION_JSON)
                            .retrieve()
                            .bodyToFlux(PendingOrders.class);
                    orderBook1.toStream().forEach((PendingOrders object) -> {
                        object.setUrl("https://exchange.matraining.com");
                        PendingOrders pendingOrders = new PendingOrders(object.getProduct(),
                                object.getQuantity(), object.getPrice(), object.getSide(),
                                object.getCumulativeQuantity(), object.getUrl());
                        orderBookRepository.add(pendingOrders);
                    });

                    Flux<PendingOrders> orderBook2 = web_client_2.get()
                            .uri("/orderbook/"+ orderRepository.get(0).getTicker() + "/" +
                                    orderRepository.get(0).getSide().toLowerCase())
                            .accept(MediaType.APPLICATION_JSON)
                            .retrieve()
                            .bodyToFlux(PendingOrders.class);
                    orderBook2.toStream().forEach((PendingOrders object) -> {
                        object.setUrl("https://exchange2.matraining.com");
                        PendingOrders pendingOrders = new PendingOrders(object.getProduct(),
                                object.getQuantity(), object.getPrice(), object.getSide(),
                                object.getCumulativeQuantity(), object.getUrl());
                        orderBookRepository.add(pendingOrders);
                    });
                    switch (orderBookRepository.get(0).getSide()){
                        case "BUY":
                            if(orderBookRepository == null) continue;
                            String buyOrderBook = Ultility.convertToString(orderBookRepository.stream()
                                    .min(Comparator.comparing(PendingOrders::getPrice)).get());
                            System.out.println(buyOrderBook);
                            jedis.lpush("OrderBook", buyOrderBook);
                            break;
                        case "SELL":
                            if(orderBookRepository == null) continue;
                            String sellOrderBook = Ultility.convertToString(orderBookRepository.stream()
                                    .max(Comparator.comparing(PendingOrders::getPrice)).get());
                            System.out.println(sellOrderBook);
                            jedis.lpush("OrderBook", sellOrderBook);
                            break;
                    }
                }
            }
        }).start();
    }
}
