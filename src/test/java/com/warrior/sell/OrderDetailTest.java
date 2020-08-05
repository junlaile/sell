package com.warrior.sell;

import com.warrior.sell.dao.OrderDetailDao;
import com.warrior.sell.entity.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class OrderDetailTest {
    @Resource
    private OrderDetailDao orderDetailDao;

    @Test
    public void orderDetailDemo1(){
        OrderDetail detail = orderDetailDao.selectByPrimaryKey("1");
        System.out.println(detail);
    }
}
