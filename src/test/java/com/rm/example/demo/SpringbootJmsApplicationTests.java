package com.rm.example.demo;

import com.rm.example.demo.jms.Producer;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJmsApplicationTests {
    @Autowired
    private Producer producer;

    @Test
    public void contextLoads() throws InterruptedException {
        Destination destination = new ActiveMQQueue("test.queue");
        //Destination destination = new ActiveMQTopic("test.queue");
        //for (int i = 0; i < 4; i++) {
        producer.sendMessage(destination, "myname is songkaijie!!!");
        //}
    }
}
