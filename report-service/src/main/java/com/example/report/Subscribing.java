package com.example.report;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.util.ArrayList;
import java.util.List;

@Service
public class Subscribing {

        private final List<String> messageList = new ArrayList<>();
        Jedis jedis = new Jedis();


        @Bean
        public void receiver() {
            this.jedis.subscribe(new JedisPubSub() {
                @Override
                public void onMessage(String channel, String message) {
//                super.onMessage(channel, message);
                    messageList.add(channel + "---" + message);
                    System.out.println(channel + " : " + message);
                    // System.out.println(messageList);
                }
            }, "Trade", "ClientConnectivityService", "ExchangeConnectivityService"); //This refers to the services you would like to listen to



        }

}
