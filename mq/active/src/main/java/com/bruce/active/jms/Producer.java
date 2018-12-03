package com.bruce.active.jms;

import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.print.attribute.standard.Destination;

@Service
public class Producer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMsg(String destinationName,String msg){
        logger.info("发送{}到{}",msg,destinationName);
        ActiveMQQueue destination = new ActiveMQQueue("test.queue");
        jmsMessagingTemplate.convertAndSend(destination, msg);

    }


}
