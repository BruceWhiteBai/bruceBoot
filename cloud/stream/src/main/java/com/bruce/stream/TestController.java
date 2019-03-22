package com.bruce.stream;

import com.bruce.stream.source.SinkSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @Autowired
    private SinkSender testTopic;

    @Autowired
    @Qualifier(Sink.INPUT)
    MessageChannel source;

    @GetMapping("/sendMessage")
    public String messageWithMQ(@RequestParam String message) {
        testTopic.outPut().send(MessageBuilder.withPayload(message).build());
        source.send(org.springframework.messaging.support.MessageBuilder.withPayload("from source ").build());
        return "ok";
    }

}
