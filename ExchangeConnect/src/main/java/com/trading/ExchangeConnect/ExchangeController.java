package com.trading.ExchangeConnect;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ExchangeController {



    @GetMapping("/data")
    public String getExchange(){
        ExchangeData data = new ExchangeData();

        return data.data();

        // "Exchange Connectivity";
    }
}
