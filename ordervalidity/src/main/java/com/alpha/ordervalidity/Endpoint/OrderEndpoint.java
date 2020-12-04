package com.alpha.ordervalidity.Endpoint;

import com.alpha.ordervalidity.Model.GetOrderRequest;
import com.alpha.ordervalidity.Model.GetOrderResponse;
import com.alpha.ordervalidity.Queue.Ultility;
import com.alpha.ordervalidity.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import redis.clients.jedis.Jedis;


@Endpoint
public class OrderEndpoint {

    @Autowired
    private OrderService ordSer = new OrderService();

    GetOrderResponse resp = new GetOrderResponse();

    @PayloadRoot(namespace = "http://alpha.com/ordervalidity/model", localPart = "getOrderRequest")
    @ResponsePayload
    public GetOrderResponse getOrder(@RequestPayload GetOrderRequest request){
        resp.setOrder(ordSer.getOrder(request.getClientId()));
        return resp;
    }




}
