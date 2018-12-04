package com.bruce.active.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.stereotype.Service;

import javax.jms.ConnectionFactory;

@Service
public class Subscriber {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @JmsListener(destination = "test.topic",containerFactory = "myJmsListenerContainerFactory")
    public void subscribe(String message){
        logger.info("test.topic--11-->"+message);
    }

    @Bean
    JmsListenerContainerFactory<?> myJmsListenerContainerFactory(ConnectionFactory connectionFactory){
        SimpleJmsListenerContainerFactory simpleJmsListenerContainerFactory = new SimpleJmsListenerContainerFactory();
        simpleJmsListenerContainerFactory.setConnectionFactory(connectionFactory);
        simpleJmsListenerContainerFactory.setPubSubDomain(true);
        return simpleJmsListenerContainerFactory;
    }


    @JmsListener(destination = "test.topic",containerFactory = "myJmsListenerContainerFactory")
    public void subscribe2(String message){
        logger.info("test.topic--22-->"+message);
    }
}
