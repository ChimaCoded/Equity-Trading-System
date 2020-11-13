package com.trading.ExchangeConnect.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

public class RedisConfiguration {
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    public RedisMessageListenerContainer container(RedisConnectionFactory redisConnectionFactory, MessageListenerAdapter messageListenerAdaptor){
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory((redisConnectionFactory));
        redisMessageListenerContainer.addMessageListener(messageListenerAdaptor, topic());
        return redisMessageListenerContainer;
    }

    @Bean
    MessageListenerAdapter messageadapter(){
        return new MessageListenerAdapter(new MessageSubscriber(), "onMessage");
    }

    @Bean
    private ChannelTopic topic(){
        return new ChannelTopic("Reporting");
    }

    @Bean
    RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
        return redisTemplate;
    }

    @Bean
    PublisherInterface messagePublisher(RedisTemplate redisTemplate){
        return new MessagePublisher(redisTemplate, topic());
    }

}
