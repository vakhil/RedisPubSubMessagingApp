package com.tutorials.redis.pub.PubSubDemo.controller;

import com.tutorials.redis.pub.PubSubDemo.configuration.RedisMessagePublisher;
import com.tutorials.redis.pub.PubSubDemo.configuration.RedisMessageSubscriber;
import com.tutorials.redis.pub.PubSubDemo.model.Message;
import com.tutorials.redis.pub.PubSubDemo.model.ServerName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/redis")
public class RedisController {

    @Autowired
    ServerName serverName;

    @Autowired
    private RedisMessagePublisher messagePublisher;

    @Autowired
    private RedisMessageSubscriber redisMessageSubscriber;

    private static Logger log = LoggerFactory.getLogger(RedisController.class);


    @PostMapping("/publish")
    public void publish(@RequestBody Message message){
        message.setServerNo(serverName.getServerNo());
        log.info("Publishign");
        messagePublisher.publish(message.toString());
    }

    @GetMapping("/subscribe")
    public List<String> getMessages(){
        return RedisMessageSubscriber.messageList;
    }

    public List<String> getMessage(){
        return RedisMessageSubscriber.messageList;
    }
}
