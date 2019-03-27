package com.bruce.stream.receivers;


import com.bruce.stream.bo.User;
import com.bruce.stream.source.SinkSender;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    /**
     * 切换监听注解,两种方式，分别实现了消息的接收和ack
     * @param message
     */
    @ServiceActivator(inputChannel = SinkSender.INPUT_ACTIVATOR,outputChannel = Sink.INPUT)
   /* @StreamListener(SinkSender.INPUT_ACTIVATOR)
    @SendTo(Sink.INPUT)*/
    public Object processOutput3(User message) {
        logger.info("streamReceiver3 ={}", message);
        logger.info("streamReceiver3 age={}，name={}", message.getAge(), message.getName());
        return "streamReceiver3 age={"+message.getAge()+"}，name={"+ message.getName()+"}";
    }

    /**
     * 接收方转换不靠谱啊，还是在发送方转换吧
     * @param message
     * @return
     */
    @Transformer(inputChannel = SinkSender.INPUT_ACTIVATOR, outputChannel = SinkSender.INPUT_ACTIVATOR)
    public Object transform(Date message) {
        return new SimpleDateFormat("yyyy-M-dd HH:mm:ss") .format(message);
    }

    @Transformer(inputChannel = SinkSender.INPUT_ACTIVATOR, outputChannel = SinkSender.INPUT_ACTIVATOR)
    public Object transformObj(String message) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(message,User.class);
        return user;
    }


}
