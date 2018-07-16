package com.scut.seckill.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;


/**
 * 可靠确认模式
 */
@Slf4j
@Component
public class RabbitMQSender implements  RabbitTemplate.ConfirmCallback{

    @Autowired
    private RabbitTemplate rabbitTemplate;
    private Logger log;
    public void send(String message) {
        rabbitTemplate.setConfirmCallback(this);
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("seckillExchange", "seckillRoutingKey", message, correlationData);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("callbakck confirm: " + correlationData.getId());
        if (ack){
            System.out.println("插入record成功，更改库存成功");
        }else{
            System.out.println("cause:"+cause);
        }
    }
}
