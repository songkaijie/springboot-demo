package com.rm.example.demo.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/24
 */
public class TopicCustomer {
    public void testTopicCustomer() throws Exception {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://172.20.10.3:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("test-topic");
        MessageConsumer customer = session.createConsumer(topic);
        customer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                String text;
                try {
                    text = textMessage.getText();
                    System.out.println(text);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("topic消费者3启动。。。。");
        //等待接收消息
        System.in.read();
        //关闭资源
        customer.close();
        session.close();
        connection.close();

    }

    public static void main(String[] args) throws Exception {
        TopicCustomer topicCustomer = new TopicCustomer();
        topicCustomer.testTopicCustomer();
    }
}
