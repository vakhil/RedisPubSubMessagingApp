package com.tutorials.redis.pub.PubSubDemo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


public class RedisMessagePublisher implements MessagePubisher{

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private ChannelTopic channelTopic;

    public RedisMessagePublisher(RedisTemplate<String,Object> redisTemplate, ChannelTopic topic){
        this.redisTemplate = redisTemplate;
        this.channelTopic = topic;
    }

    public RedisMessagePublisher() {
    }

    @Override
    public void publish(String message) {
        redisTemplate.convertAndSend(channelTopic.getTopic(),message);
    }

}
