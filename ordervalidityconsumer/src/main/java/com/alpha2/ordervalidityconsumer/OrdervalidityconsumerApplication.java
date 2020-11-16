package com.alpha2.ordervalidityconsumer;
//
//import com.alpha2.ordervalidityconsumer.service.OrderService;
//import com.alpha2.ordervalidityconsumer.wsdlfiles.GetOrderRequest;
//import com.alpha2.ordervalidityconsumer.wsdlfiles.GetOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController


public class OrdervalidityconsumerApplication {

//    @Autowired
//    private OrderService orderService;
//
//    @PostMapping("/singleOrder")
//    public GetOrderResponse getOrderResponse(@RequestBody GetOrderRequest request) {
//        return orderService.getOrderResponse(request);
//    }
//
//
//

    public static void main(String[] args) {
        SpringApplication.run(OrdervalidityconsumerApplication.class, args);



    }

}