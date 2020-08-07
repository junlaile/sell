package com.warrior.sell.service;

import com.warrior.sell.dto.OrderDTO;
import com.warrior.sell.entity.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class OrderDetailServiceTest {
    @Resource
    private OrderDetailService orderDetailService;

    /**
     * detail_id,
     * order_id,
     * product_id,
     * product_name,
     * product_price,
     * product_quantity,
     * product_icon,
     * create_time,
     * update_time
     */
    @Test
    void insert() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1234");
        orderDetail.setOrderId("1234");
        orderDetail.setProductId("124");
        orderDetail.setProductName("油条");
        orderDetail.setProductPrice(new BigDecimal("2.00"));
        orderDetail.setProductQuantity(1);
        orderDetail.setProductIcon("htt://ssxxx");
        orderDetailService.save(orderDetail);
    }
}