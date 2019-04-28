package com.rm.example.demo.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/24
 */
public class TopicProducer {
    public void testTopicProducer() throws Exception {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://172.20.10.3:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        //是否开启事务   应答方式
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("test-topic");
        MessageProducer producer = session.createProducer(topic);
        TextMessage textMessage = session.createTextMessage("topic message");
        //8、发送消息
        producer.send(textMessage);
        producer.close();
        session.close();
        connection.close();

    }

    public static void main(String[] args) throws Exception {
        TopicProducer topicProducer = new TopicProducer();
        topicProducer.testTopicProducer();
    }
}
