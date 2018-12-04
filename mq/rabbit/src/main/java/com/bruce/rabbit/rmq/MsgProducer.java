package com.bruce.rabbit.rmq;

import com.bruce.rabbit.config.RabbitConfig;
import com.rabbitmq.client.AMQP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MsgProducer implements RabbitTemplate.ConfirmCallback {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     *
     * 由于rabbitTemplate的scope属性设置为ConfigurableBeanFactory.SCOPE_PROTOTYPE，所以不能自动注入
     *
     */
    private RabbitTemplate rabbitTemplate;

    /**
     * 构造方法注入rabbitTemplate
     * rabbitTemplate如果为单例的话，那回调就是最后设置的内容
     */
    @Autowired
    public MsgProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this);
    }

    public void sendMsg(String content) {
        AMQP.BasicProperties persistentTextPlain = com.rabbitmq.client.MessageProperties.PERSISTENT_TEXT_PLAIN;
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        logger.info("发送消息id--{}",correlationId);
        //把消息放入ROUTINGKEY_A对应的队列当中去，对应的是队列A
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_A, RabbitConfig.ROUTINGKEY_A, content, correlationId);
    }

    public void sendAll(String content) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        logger.info("发送消息id--{}",correlationId);
        rabbitTemplate.convertAndSend(RabbitConfig.FANOUT_EXCHANGE,"", content,correlationId);
    }


    public void sendTopicMsg(String content) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        logger.info("发送消息id--{}",correlationId);
        //把消息放入ROUTINGKEY_A对应的队列当中去，对应的是所有绑定的队列
        rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE, "QUEUE_", content, correlationId);
    }

    /**
     * 回调
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        logger.info(" 回调id:" + correlationData);
        if (ack) {
            logger.info("消息成功消费");
        } else {
            logger.info("消息消费失败:" + cause);
        }
    }
}