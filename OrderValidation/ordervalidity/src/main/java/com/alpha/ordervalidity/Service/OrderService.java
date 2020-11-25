package com.alpha.ordervalidity.Service;

import com.alpha.ordervalidity.Model.Order;
import com.alpha.ordervalidity.Queue.Ultility;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RestController
public class OrderService {

    public static final List<Order> order = new ArrayList<>();

//    @PostConstruct
//    public void initialize(){
//        Order od1 = new Order();
//        od1.setClientId("C01");
//        od1.setPortfolioId("P01");
//        od1.setPrice(2.5);
//        od1.setQuantity(2);
//        od1.setSide("Sell");
//        od1.setTicker("APPL");
//        od1.setTimeStamp("12:01:02");
//
//
//        Order od2 = new Order();
//        od2.setOrderId("O01");
//        od2.setClientId("C02");
//        od2.setPortfolioId("P01");
//        od2.setPrice(3.5);
//        od2.setQuantity(2);
//        od2.setSide("BUY");
//        od2.setTicker("IBM");
//        od2.setTimeStamp("13:01:02");
//
//
//        Order od3 = new Order();
//        od3.setClientId("C03");
//        od3.setPortfolioId("P01");
//        od3.setPrice(3.5);
//        od3.setQuantity(2);
//        od3.setSide("BUY");
//        od3.setTicker("APPL");
//        od3.setTimeStamp("13:01:02");
//
//
//
//        order.put(od1.getClientId(), od1);
//        order.put(od2.getClientId(), od2);
//        order.put(od3.getClientId(), od3);
//
//    }
//


//
        public Order getOrder(){
            return order.get(0);
    }

    public void clearList(){
            order.clear();
    }



    @PostMapping("/neworder")
    public String newOrder(@RequestBody Order newOrder){
            order.clear();
        order.add(newOrder);

        return Ultility.convertToString(newOrder);
    }

}
