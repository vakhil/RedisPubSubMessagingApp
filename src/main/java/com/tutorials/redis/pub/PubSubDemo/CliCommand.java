package com.tutorials.redis.pub.PubSubDemo;

import com.tutorials.redis.pub.PubSubDemo.configuration.RedisMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Set;

@ShellComponent
public class CliCommand {

    @Autowired
    private RedisMessagePublisher messagePublisher;


    @ShellMethod("Send message to Redis PubSub Topic")
    public void send(String message) {
        messagePublisher.publish(message);
        System.out.println(message);
    }

}



