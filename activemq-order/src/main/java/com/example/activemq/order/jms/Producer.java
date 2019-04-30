package com.example.activemq.order.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Destination;
import java.util.Date;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/25
 */
@Component
public class Producer {
    @Resource(name = "queue")
    private Destination queue;

    @Resource(name = "topic")
    private Destination topic;
    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    public void sendMessage(Destination destination, final Object message) {
        jmsTemplate.convertAndSend(destination, message);
    }

    public void covertAndSend(Destination destination, String msg) {
        jmsTemplate.convertAndSend(destination, msg);
        System.out.println("send : " + msg);
    }

    @Scheduled(fixedDelay = 10000)
    public void send() {
        this.covertAndSend(this.queue, "this fist queue 01" + System.currentTimeMillis());
        //this.covertAndSend(this.topic, "this first topic 02" + System.currentTimeMillis());
    }
}
