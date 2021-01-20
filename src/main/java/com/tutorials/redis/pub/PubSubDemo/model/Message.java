package com.tutorials.redis.pub.PubSubDemo.model;


public class Message {

    public int serverNo;
    public String data;

    public int getServerNo() {
        return serverNo;
    }

    public void setServerNo(int serverNo) {
        this.serverNo = serverNo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "server"+String.valueOf(serverNo)+":Message{" +
                "data='" + data + '\'' +
                '}';
    }

}
