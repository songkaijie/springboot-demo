package com.rm.example.demo.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/24
 */
public class QueueCustomer {
    public void testQueueCustomer() throws Exception {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://172.20.10.3:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("FirstQueue");
        MessageConsumer customer = session.createConsumer(queue);
        customer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                String text;
                try {
                    text = textMessage.getText();
                    System.out.print(text);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        //等待接收消息
        System.in.read();
        customer.close();
        session.close();
        connection.close();
    }

    public static void main(String[] args) throws Exception {
        QueueCustomer queueCustomer = new QueueCustomer();
        queueCustomer.testQueueCustomer();
    }
}
