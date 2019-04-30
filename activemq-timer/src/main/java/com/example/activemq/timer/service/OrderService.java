package com.example.activemq.timer.service;

import com.example.activemq.timer.entity.Order;
import com.example.activemq.timer.repository.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/25
 */
@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public void addOrder(Order order) {
        orderMapper.addOrder(order);
    }
}
