package com.bruce.stream.source;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

public interface SinkSender {

    String INPUT = "example-topic-input";
    String OUTPUT = "example-topic-output";


    @Output(OUTPUT)
    MessageChannel outPut();


    @Input(INPUT)
    SubscribableChannel input();


    @Output(Sink.INPUT)
    MessageChannel output();
}
