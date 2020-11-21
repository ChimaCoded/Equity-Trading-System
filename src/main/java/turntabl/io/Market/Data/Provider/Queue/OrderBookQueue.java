package turntabl.io.Market.Data.Provider.Queue;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import redis.clients.jedis.Jedis;
import turntabl.io.Market.Data.Provider.OrderBook.PendingOrders;
import turntabl.io.Market.Data.Provider.Queue.Ultility;

import java.util.ArrayList;
import java.util.List;

public class OrderBookQueue {

    private List<Object> repository = new ArrayList<>();

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

                    Flux<PendingOrders> orderBook1 = web_client.get()
                            .uri("/orderbook/TSLA/buy")
                            .accept(MediaType.APPLICATION_JSON)
                            .retrieve()
                            .bodyToFlux(PendingOrders.class);
                    orderBook1.toStream().forEach((PendingOrders object) -> {
                        PendingOrders pendingOrders = new PendingOrders(object.getProduct(),
                                object.getQuantity(), object.getPrice(), object.getSide(),
                                object.getCumulativeQuantity());
                        repository.add(pendingOrders);
                    });

                    Flux<PendingOrders> orderBook2 = web_client_2.get()
                            .uri("/orderbook")
                            .accept(MediaType.APPLICATION_JSON)
                            .retrieve()
                            .bodyToFlux(PendingOrders.class);
                    orderBook2.toStream().forEach((PendingOrders object) -> {
                        PendingOrders pendingOrders = new PendingOrders(object.getProduct(),
                                object.getQuantity(), object.getPrice(), object.getSide(),
                                object.getCumulativeQuantity());
                        repository.add(pendingOrders);
                    });

                    String orderBook = Ultility.convertToString(repository);
                    jedis.lpush("Order Book", orderBook);
                }
            }
        }).start();
    }
}
