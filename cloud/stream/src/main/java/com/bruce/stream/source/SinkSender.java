package com.bruce.stream.source;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;
@Component
public interface SinkSender {

    String INPUT = "example-topic-input";
    String INPUT_ACTIVATOR = "example-topic-input_activator"; //ctr+shift+u 大小写切换
    String OUTPUT = "example-topic-output";


    @Output(SinkSender.OUTPUT)
    MessageChannel outPut();


    @Input(SinkSender.INPUT)
    SubscribableChannel input();


    @Output(Sink.INPUT)
    MessageChannel output();

//    @Output(SinkSender.INPUT)
//    MessageChannel outPut1();
}
