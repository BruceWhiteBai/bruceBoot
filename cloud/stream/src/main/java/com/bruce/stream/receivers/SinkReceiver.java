package com.bruce.stream.receivers;

import com.bruce.stream.source.SinkSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * 注解用来指定 一个或多个定义了@Input 或@Output 注解的接口， 以此实现对消息通道(Channel) 的绑定。
 * 在下面的例子中， 我们通过 @EnableBinding(Sink.class)绑定了 Sink接口， 该接口是 Spring Cloud
 * Stream中默认实现的对输入消息通道绑定的定义
 */
@EnableBinding(SinkSender.class)
//@EnableBinding(value={SinkSender.class,Sink.class})
//@EnableBinding(value={Sink.class})
public class SinkReceiver {

    private static Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

    /**
     * @StreamListener 将被修饰的方法注册为消息中间件上数据流的事件监听器， 注解中的属性值对应了监听的消息通道名
     * @Input注解绑定了 一个名为input的通道
     */
    @StreamListener(Sink.INPUT)
    public void receive(Object payload) {
        logger.info("received {}", payload);
    }
}
