package com.bruce.stream.source;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

@EnableBinding(value = {SinkSender.class})
public class SinkSenderActivator {

    private final Logger logger = LoggerFactory.getLogger(SinkSenderActivator.class);

    /**
     * 使用 poller 参数将该方法设置为轮询执行， 这里我们定义为2000毫秒，所以它会以2秒的频率向 SinkOutput.OUTPUT 通道输出当前时间
     *
     */
    @Bean
    @InboundChannelAdapter(value = SinkSender.INPUT_ACTIVATOR,poller = @Poller(fixedDelay = "2000"))
    public MessageSource<Date> timerMessageSource(){
//        return () -> new GenericMessage(transform(new Date()));
//        return () -> new GenericMessage<>(new Date());
        return () -> new GenericMessage("{\"name\":\"bruce\",\"age\":\"123\"}");

    }

    @Transformer(inputChannel = SinkSender.INPUT_ACTIVATOR, outputChannel = SinkSender.INPUT_ACTIVATOR)
    public Object transform(Date message) {
        return new SimpleDateFormat("yyyy-M-dd HH:mm:ss") .format(message);
    }



}
