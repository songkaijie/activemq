package com.example.activemq.order.controller;

import com.example.activemq.order.dto.Order;
import com.example.activemq.order.jms.Producer;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/25
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private Producer producer;

    @PostMapping("/addOrder")
    public void addOrder(@RequestBody Order order) {
        Destination destination = new ActiveMQQueue("addOrder");
        for (int i = 0; i < 10; i++) {
            producer.sendMessage(destination, order);
        }
    }
}
