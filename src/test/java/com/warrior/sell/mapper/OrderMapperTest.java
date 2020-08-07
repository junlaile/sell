package com.warrior.sell.mapper;

import com.warrior.sell.dto.OrderDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrderMapperTest {
    @Resource
    private OrderMapper orderMapper;

    @Test
    void findByMasterForOrderId() {
        OrderDTO orderDTO = orderMapper.findByMasterForOrderId("1291623458953867264");
        System.out.println(orderDTO);
    }
}