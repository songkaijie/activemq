package com.example.activemq.order.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.jms.Destination;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/25
 */
@EnableScheduling
@Configuration
public class MainConfig {
    @Bean(value ="queue",name = "queue")
    public Destination queue(){
        return new ActiveMQQueue("queue");
    }
    @Bean(value ="topic",name = "topic")
    public Destination topic(){
        return new ActiveMQTopic("topic");
    }
}
