package com.tutorials.redis.pub.PubSubDemo;

import com.tutorials.redis.pub.PubSubDemo.configuration.MessagePubisher;
import com.tutorials.redis.pub.PubSubDemo.configuration.RedisMessagePublisher;
import com.tutorials.redis.pub.PubSubDemo.configuration.RedisMessageSubscriber;
import com.tutorials.redis.pub.PubSubDemo.model.ServerName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Lazy;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@SpringBootApplication
public class PubSubDemoApplication {

	@Autowired
	@Lazy
	ServerName serverName;

	@Autowired
	private MessagePubisher messagePublisher;

	@Autowired
	@Lazy
	private RedisMessageSubscriber redisMessageSubscriber;



	public static void main(String[] args) {
		SpringApplication.run(PubSubDemoApplication.class, args);
	}



}
