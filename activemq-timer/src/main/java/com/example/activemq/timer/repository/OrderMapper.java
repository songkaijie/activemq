package com.example.activemq.timer.repository;

import com.example.activemq.timer.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/25
 */
@Mapper
@Component
public interface OrderMapper {
    @Insert("INSERT INTO `order` (name,price) values (#{order.name},#{order.price})")
    void addOrder(@Param("order") Order order);
}
