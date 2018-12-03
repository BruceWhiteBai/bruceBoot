package com.bruce.active.controller;

import com.bruce.active.config.ActivemqConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@RestController
@RequestMapping("/activeMq")
public class ActivemqController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("/sendMsg")
    public void send(String msg) {
        this.jmsMessagingTemplate.convertAndSend(ActivemqConfig.queue(), msg);
    }

}
