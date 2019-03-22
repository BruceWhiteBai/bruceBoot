package com.bruce.stream.receivers;


import com.bruce.stream.source.SinkSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(SinkSender.class)
public class SinkSenderReceive {

    private static Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

    @StreamListener(SinkSender.INPUT)
    public void  processInput(String message) {
        logger.info("streamReceiver1={}", message);
    }

    @StreamListener(SinkSender.OUTPUT)
    public void processOutput(String message) {
        logger.info("streamReceiver2={}", message);
    }
}
