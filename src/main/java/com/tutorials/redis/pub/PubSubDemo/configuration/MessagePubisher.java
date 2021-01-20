package com.tutorials.redis.pub.PubSubDemo.configuration;

public interface MessagePubisher {
    void publish(String message);

}
