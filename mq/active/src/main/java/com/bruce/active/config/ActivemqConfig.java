package com.bruce.active.config;


import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

@EnableJms
public class ActivemqConfig {

    @Bean
    public static Queue queue() {
        return new ActiveMQQueue("test.queue");
    }
}
