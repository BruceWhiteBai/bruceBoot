package com.bruce.stream;

import com.bruce.stream.source.SinkSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@EnableBinding(SinkSender.class)
public class StreamApplicationTests {

    @Autowired
    SinkSender sinkSender;

    @Autowired
    @Qualifier(Sink.INPUT)
    MessageChannel source;


    @Test
    public void contextLoads0() {
        sinkSender.outPut().send(MessageBuilder.withPayload("from SinkSender ").build());
    }

    @Test
    public void contextLoads1() {
        source.send(MessageBuilder.withPayload("from source ").build());
    }

}
