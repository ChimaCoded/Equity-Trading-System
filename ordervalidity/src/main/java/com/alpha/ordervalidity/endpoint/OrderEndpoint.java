package com.alpha.ordervalidity.endpoint;

import com.alpha.ordervalidity.model.GetOrderRequest;
import com.alpha.ordervalidity.model.GetOrderResponse;
import com.alpha.ordervalidity.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class OrderEndpoint {
    @Autowired
    private OrderService ordSer = null;

    @PayloadRoot(namespace = "http://alpha.com/ordervalidity/model", localPart = "getOrderRequest")
    @ResponsePayload
    public GetOrderResponse getOrder(@RequestPayload GetOrderRequest request){
        GetOrderResponse resp = new GetOrderResponse();
        resp.setOrder(ordSer.getOrder(request.getClientId()));
        return resp;
    }

}
