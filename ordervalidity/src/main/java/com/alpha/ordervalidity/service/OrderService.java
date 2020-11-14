package com.alpha.ordervalidity.service;

import com.alpha.ordervalidity.model.Order;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {
    private static final Map<String, Order> order = new HashMap<>();
    @PostConstruct
    public void initialize(){
        Order od1 = new Order();
        od1.setClientId("C01");
        od1.setPortfolioId("P01");
        od1.setPrice(2.5);
        od1.setQuantity(2);
        od1.setStatus("Sell");
        od1.setTickerName("APPL");
        od1.setTimeStamp("12:01:02");


        Order od2 = new Order();
        od2.setClientId("C02");
        od2.setPortfolioId("P01");
        od2.setPrice(3.5);
        od2.setQuantity(2);
        od2.setStatus("BUY");
        od2.setTickerName("APPL");
        od2.setTimeStamp("13:01:02");


        Order od3 = new Order();
        od3.setClientId("C03");
        od3.setPortfolioId("P01");
        od3.setPrice(3.5);
        od3.setQuantity(2);
        od3.setStatus("BUY");
        od3.setTickerName("APPL");
        od3.setTimeStamp("13:01:02");

        order.put(od1.getClientId(), od1);
        order.put(od2.getClientId(), od2);
        order.put(od3.getClientId(), od3);

    }


        public Order getOrder(String clientId){
            return order.get(clientId);
    }

}
