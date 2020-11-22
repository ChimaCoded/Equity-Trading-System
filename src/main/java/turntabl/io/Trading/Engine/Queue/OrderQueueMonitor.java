package turntabl.io.Trading.Engine.Queue;

import redis.clients.jedis.Jedis;
import turntabl.io.Trading.Engine.Order.Order;
import java.util.ArrayList;
import java.util.List;
public class OrderQueueMonitor {
    public List<Order> orderRepository = new ArrayList<>();

    private String data;

    public List<Order> getFromQueue(){
        new Thread(new Runnable() {
            Jedis jedis = new Jedis();
            @Override
            public void run() {
                while (true){

                    try {
                        Thread.sleep(5000);
                    } catch (Exception e) {

                    }

                    orderRepository.clear();

                    data = jedis.rpop("Client Order");
                    if(data == null) continue;
                    Order order = Ultility.convertToObject(data, Order.class);
                    orderRepository.add(order);
                    System.out.println(orderRepository.get(0).toString());
                    jedis.lpush("Order for OrderBook Request", Ultility.convertToString(orderRepository));

                    switch (orderRepository.get(0).getTicker()){
                        case "BUY":

                    }
//                    System.out.println(orderRepository.get(0).getTicker());
//                    System.out.println(orderRepository.get(0).getSide().toLowerCase());
//                    System.out.println(orderRepository.get(0).getClientId());
                }
            }
        }).start();

        return orderRepository;
    }
}
