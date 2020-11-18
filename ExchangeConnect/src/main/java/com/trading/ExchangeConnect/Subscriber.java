package com.trading.ExchangeConnect;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.util.ArrayList;
import java.util.List;

public class Subscriber {
    public List<String> messages = new ArrayList<>();

    Jedis jSubscriber = new Jedis();

    @Bean
    public void subscribeToChannel(){
        jSubscriber.subscribe(new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                messages.add(message);
                System.out.println(channel + "published\n\t" + message);
            }
        }, "Hello");

    }
}
