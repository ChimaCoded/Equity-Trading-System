package com.alpha2.ordervalidityconsumer.endpoint;


import com.alpha2.ordervalidityconsumer.service.OrderService;
import com.alpha2.ordervalidityconsumer.wsdlfiles.GetOrderRequest;
import com.alpha2.ordervalidityconsumer.wsdlfiles.GetOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderEndpoint {
    @Autowired
    private OrderService orderService;

    @PostMapping("/singleOrder")
    public GetOrderResponse getOrderResponse(@RequestBody GetOrderRequest request){
        return orderService.getOrderResponse(request);


    }




}
