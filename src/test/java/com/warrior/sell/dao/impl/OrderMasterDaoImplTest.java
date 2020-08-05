package com.warrior.sell.dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.warrior.sell.dao.OrderMasterDao;
import com.warrior.sell.entity.OrderMaster;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrderMasterDaoImplTest {
    @Resource
    private OrderMasterDao orderMasterDao;
    @Test
    public void orderDemo1(){
//        PageHelper.startPage(0,2);
//        List<OrderMaster> byBuyerOpenid = orderMasterDao.findAll();
//        List<OrderMaster> byBuyerOpenid = orderMasterDao.findByBuyerOpenid("0");
    }

    @Test
    public void orderDemo2(){
        ArrayList<OrderMaster> orderMasters = new ArrayList<>();
        OrderMaster orderMaster1 = new OrderMaster();
        orderMaster1.setOrderId("1234");
        orderMaster1.setBuyerName("jun");
        orderMaster1.setBuyerPhone("12345678998");
        orderMaster1.setBuyerAddress("imooc");
        orderMaster1.setBuyerOpenid("1");
        orderMasters.add(orderMaster1);
        OrderMaster orderMaster2 = new OrderMaster();
        orderMaster2.setOrderId("1235");
        orderMaster2.setBuyerName("jun");
        orderMaster2.setBuyerPhone("12345678998");
        orderMaster2.setBuyerAddress("imooc");
        orderMaster2.setBuyerOpenid("1");
        orderMasters.add(orderMaster2);
        int i = orderMasterDao.batchInsert(orderMasters);
    }

}