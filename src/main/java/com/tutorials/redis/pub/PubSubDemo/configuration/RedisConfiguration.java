package com.tutorials.redis.pub.PubSubDemo.configuration;

import com.tutorials.redis.pub.PubSubDemo.model.ServerName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RedisConfiguration {

    @Bean
    ServerName getUniqueServerName(){
        Random rm = new Random();
        ServerName serverName = new ServerName();
        serverName.setServerNo(rm.nextInt(11)+1);
        return serverName;
    }

    @Autowired
    RedisMessageSubscriber redisMessageSubscriber;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory redisConnectionFactory,
                                            MessageListenerAdapter messageListenerAdapter){
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
        redisMessageListenerContainer.addMessageListener(messageListenerAdapter,getTopic());
        return redisMessageListenerContainer;
    }

    @Bean
    MessageListenerAdapter messageListenerAdapter(){
        return new MessageListenerAdapter(redisMessageSubscriber,"onMessage");
    }

    @Bean
    private ChannelTopic getTopic(){
        return new ChannelTopic("stackForTech");
    }

    @Bean
    RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setValueSerializer(new GenericToStringSerializer<>(Object.class));
        return redisTemplate;
    }

    @Bean
    MessagePubisher messagePubisher(){
        return new RedisMessagePublisher(redisTemplate(redisConnectionFactory),getTopic());
    }
}
