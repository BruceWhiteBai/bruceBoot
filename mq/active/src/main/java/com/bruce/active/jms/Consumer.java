package com.bruce.active.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @JmsListener(destination = "test.queue")
    public void receiveQueue(String msg){
        logger.info("test.queue---->"+msg);

    }
}
