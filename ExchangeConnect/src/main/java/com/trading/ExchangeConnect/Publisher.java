package com.trading.ExchangeConnect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class Publisher {

    Jedis messagePublisher = new Jedis();

    public String publishMessage(String message){
        messagePublisher.publish("Hello", message);
        return message;
    }


}
