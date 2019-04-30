package com.example.activemq.timer.jms;

import com.example.activemq.timer.entity.Order;
import com.example.activemq.timer.service.OrderService;
import org.apache.activemq.Message;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/25
 */
@Component
public class OrderCustomer {
    @Autowired
    private OrderService orderService;

    @JmsListener(destination = "addOrder")
    public void getMessage(Message message) throws Exception{
        ActiveMQObjectMessage activeMQObjectMessage = (ActiveMQObjectMessage) message;
        Order order = (Order) activeMQObjectMessage.getObject();
        orderService.addOrder(order);
    }
}
