package com.bruce.active.jms;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class Publisher {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;


    public void publish(String destinationName,String message){
        logger.info("发送{}到{}",message,destinationName);
        ActiveMQTopic destination = new ActiveMQTopic("test.topic");
        jmsMessagingTemplate.convertAndSend(destination, message);

    }
}
