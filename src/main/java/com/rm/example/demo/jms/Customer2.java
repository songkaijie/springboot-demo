package com.rm.example.demo.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/24
 */
@Component
public class Customer2 {
    @JmsListener(destination = "test.queue")
    @SendTo("out.queue")
    public String receiveQueue(String text) {
        System.out.println("customer2接收到的报文为" + text);
        return "return message "+text;
    }
}
