package com.tutorials.redis.pub.PubSubDemo.model;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


public class ServerName {
    
    int serverNo = 0;

    public int getServerNo() {
        return serverNo;
    }

    public void setServerNo(int serverNo) {
        this.serverNo = serverNo;
    }
}
