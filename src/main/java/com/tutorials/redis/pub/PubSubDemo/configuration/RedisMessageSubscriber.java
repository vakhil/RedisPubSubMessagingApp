package com.tutorials.redis.pub.PubSubDemo.configuration;

import com.tutorials.redis.pub.PubSubDemo.model.ServerName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RedisMessageSubscriber implements MessageListener {


    @Autowired
    ServerName serverName;

    public static Logger log = LoggerFactory.getLogger(RedisMessageSubscriber.class);

    public static List<String> messageList = new ArrayList<>();
    @Override
    public void onMessage(Message message, byte[] bytes) {
        String[] messageParts = message.toString().split(":");
        if(messageParts[0].equals("server"+String.valueOf(serverName.getServerNo())))
            return;

        messageList.add(message.toString());
        //getChatMessageFromText(messageParts[1]);

        //String parsedChatMessage = messageParts[0]+": "+messageParts[1].split("=")[1].split("'")[1];
        System.out.println(message.toString());

       // cliCommand.displayReceiveMessage(message.toString());
        //log.info("Message recieved "+message.toString());
    }

    private void getPreviousChatMessages(String text){
        //Get all previous chat messages except your own !!!
        for(String message : messageList){
            String[] messageParts = message.toString().split(":");
            if(messageParts[0].equals("server"+String.valueOf(serverName.getServerNo())))
                continue;
            System.out.println(message.toString());
            //To be continued !!!
        }
    }
}
