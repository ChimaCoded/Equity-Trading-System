package turntabl.io.Trading.Engine.Queue;

import redis.clients.jedis.Jedis;
import turntabl.io.Trading.Engine.MarketData.MarketData;
import turntabl.io.Trading.Engine.OrderBook.OrderBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderBookQueueMonitor {

    public List<OrderBook[]> repository = new ArrayList<>();

    public List<OrderBook[]> getFromQueue(){
        new Thread(new Runnable() {
            Jedis jedis = new Jedis();
            @Override
            public void run() {
                while (true){

                    try {
                        Thread.sleep(5000);
                    } catch (Exception e) {

                    }

                    String data = jedis.rpop("Order Book");
                    if(data == null) continue;
                    OrderBook[] orderBook = Ultility.convertToObject(data, OrderBook[].class);
                    repository.add(orderBook);
                    System.out.println(Arrays.stream(orderBook).filter(
                            ticker -> ticker.getProduct().equals("TSLA")));
                }
            }
        }).start();

        return repository;
    }

}
