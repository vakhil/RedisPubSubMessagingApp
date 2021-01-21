package com.tutorials.redis.pub.PubSubDemo.configuration;

import com.tutorials.redis.pub.PubSubDemo.configuration.RedisMessagePublisher;
import com.tutorials.redis.pub.PubSubDemo.model.ServerName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;


@ShellComponent
public class CliCommand {

    @Autowired
    ServerName serverName;

    @Resource(name="messagePubisher")
    private RedisMessagePublisher messagePublisher;


    @ShellMethod("Send message to Redis PubSub Topic")
    public void send(String message) {
        messagePublisher.publish("server"+String.valueOf(serverName.getServerNo()) + ":"  + message);
        //System.out.println(message);
    }

    @PostConstruct
    void sendHelloNote(){
        System.out.println("OK");
         messagePublisher.publish("server"+String.valueOf(serverName.getServerNo()) + " has joined the chat");
        //redisMessageSubscriber.s
        //GEt all the previous messages from the chat , except of course yours !!!
    }

}



