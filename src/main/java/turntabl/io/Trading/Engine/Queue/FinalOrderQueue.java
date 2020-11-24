package turntabl.io.Trading.Engine.Queue;

import redis.clients.jedis.Jedis;
import turntabl.io.Trading.Engine.Order.Buy;
import turntabl.io.Trading.Engine.Order.Order;
import turntabl.io.Trading.Engine.Order.Sell;
import turntabl.io.Trading.Engine.OrderBook.OrderBook;

import java.util.ArrayList;
import java.util.List;

public class FinalOrderQueue {

    public List<OrderBook> orderBookRepository = new ArrayList<>();

    public List<Order> orderRepository = new ArrayList<>();


    private String data;

    public void thread() {
        new Thread(new Runnable() {
            Jedis jedis = new Jedis();

            @Override
            public void run() {
                while (true) {

                    try {
                        Thread.sleep(5000);
                    } catch (Exception e) {

                    }

                    orderRepository.clear();

                    data = jedis.rpop("ClientOrder");
                    if(data == null) continue;
                    Order order = Ultility.convertToObject(data, Order.class);
                    jedis.lpush("OrderBookRequest", Ultility.convertToString(order));
                    orderRepository.add(order);

                    try {
                        Thread.sleep(10000);
                    } catch (Exception e) {

                    }

                    orderBookRepository.clear();

                    String data = jedis.rpop("OrderBook");
                    if(data == null) continue;
                    OrderBook orderBook = Ultility.convertToObject(data, OrderBook.class);
                    orderBookRepository.add(orderBook);

                    switch (orderRepository.get(0).getSide()) {
                        case "BUY":
                            Buy buy = new Buy(orderRepository.get(0).getPrice(),
                                    orderBookRepository.get(0).getPrice(),
                                    orderRepository.get(0).getQuantity(),
                                    orderBookRepository.get(0).getQuantity());
                            buy.setBidPrice();
                            buy.setOrderQuantity();
                            Order buyOrder = new Order(orderRepository.get(0).getOrderId(),
                                    orderRepository.get(0).getClientId(),
                                    orderRepository.get(0).getPortfolioId(),
                                    orderRepository.get(0).getTicker(),
                                    buy.balance(),
                                    buy.getOrderQuantity(),
                                    orderRepository.get(0).getSide(),
                                    orderRepository.get(0).getTimeStamp(),
                                    buy.getBidPrice(), orderBookRepository.get(0).getUrl()
                            );
                            System.out.println(buyOrder.toString());
                            String finalBuyOrder = Ultility.convertToString(buyOrder);
                            jedis.lpush("ExchangeOrder", finalBuyOrder);
                            break;
                        case "SELL":
                            Sell sell = new Sell(orderBookRepository.get(0).getPrice());
                            sell.setSellPrice();
                            Order sellOrder = new Order(orderRepository.get(0).getOrderId(),
                                    orderRepository.get(0).getClientId(),
                                    orderRepository.get(0).getPortfolioId(),
                                    orderRepository.get(0).getTicker(),
                                    orderRepository.get(0).getQuantity(),
                                    orderBookRepository.get(0).getSide(),
                                    orderRepository.get(0).getTimeStamp(),
                                    orderBookRepository.get(0).getUrl()
                                    , sell.getSellPrice());
                            System.out.println(sellOrder.toString());
                            String finalSellOrder = Ultility.convertToString(sellOrder);
                            jedis.lpush("ExchangeOrder", finalSellOrder);
                            break;
                    }
                }
            }
        }).start();
    }
}