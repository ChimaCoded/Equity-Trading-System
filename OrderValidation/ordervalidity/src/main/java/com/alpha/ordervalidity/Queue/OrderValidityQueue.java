package com.alpha.ordervalidity.Queue;

import com.alpha.ordervalidity.Model.GetOrderRequest;
import com.alpha.ordervalidity.Model.GetOrderResponse;
import com.alpha.ordervalidity.Queue.Ultility;
import com.alpha.ordervalidity.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import redis.clients.jedis.Jedis;

public class OrderValidityQueue {

    GetOrderResponse resp = new GetOrderResponse();
    @Autowired
    private OrderService ordSer = new OrderService();

    GetOrderRequest request = new GetOrderRequest();
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

//                    OrderService orderService = new OrderService();
////                    orderService.newOrder();
//                    request.setClientId(ordSer.getOrder());
                    try {
                        resp.setOrder(ordSer.getOrder());
                        String order = Ultility.convertToString(resp.getOrder());
                        System.out.println(order);
                        jedis.lpush("ClientOrder", order);
                        ordSer.clearList();
                    } catch (Exception e) {
                        System.out.println("No Incoming Order");
                    } finally {
                        continue;
                    }



                }
            }
        }).start();

    }
}
