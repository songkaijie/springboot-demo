package com.rm.example.demo.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/24
 */
public class QueueProducer {
    public void testQueueProducer() throws Exception {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://172.20.10.3:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("FirstQueue");
        MessageProducer producer = session.createProducer(queue);
        TextMessage textMessage = session.createTextMessage("hello activemq");
        producer.send(textMessage);
        producer.close();
        session.close();
        connection.close();
    }

    public static void main(String[] args) throws Exception {
        QueueProducer queueProducer = new QueueProducer();
        queueProducer.testQueueProducer();
    }
}
