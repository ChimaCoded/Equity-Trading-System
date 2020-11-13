package com.trading.ExchangeConnect.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;

public class MessagePublisher implements PublisherInterface {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private ChannelTopic topic;


    public MessagePublisher(RedisTemplate<String,Object> redisTemplate, ChannelTopic topic){
        this.redisTemplate  = redisTemplate;
        this.topic = topic;
    }

    @Override
    public void publish(String msg){
        redisTemplate.convertAndSend(topic.getTopic(), msg);
    }
}
