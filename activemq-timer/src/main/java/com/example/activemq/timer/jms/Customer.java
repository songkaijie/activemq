package com.example.activemq.timer.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/25
 */
@Component
public class Customer {
    @JmsListener(destination = "queue")
    public void queueCustomer(String message) {
        System.out.println("queue消费了customer1" + message);
    }

    @JmsListener(destination = "topic", containerFactory = "jmsListenerContainerTopic")
    public void topic(String message) {
        System.out.println("topic消费了customer1" + message);
    }
}
