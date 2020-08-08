package com.warrior.sell.service.impl;

import com.warrior.sell.dto.CartDTO;
import com.warrior.sell.dto.OrderDTO;
import com.warrior.sell.entity.OrderDetail;
import com.warrior.sell.entity.OrderMaster;
import com.warrior.sell.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class OrderServiceTest {
    @Resource
    private OrderService orderService;

    @Test
    void createOrder(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("张三");
        orderDTO.setBuyerAddress("四川图书馆");
        orderDTO.setBuyerPhone("12356897458");
        orderDTO.setBuyerOpenid("123525");

        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setProductId("124");
        orderDetail1.setProductQuantity(1);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setProductId("125");
        orderDetail2.setProductQuantity(1);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        orderDetailList.add(orderDetail1);
        orderDetailList.add(orderDetail2);

        orderDTO.setOrderDetailList(orderDetailList);
        orderService.create(orderDTO);

    }

    @Test
    void findOneDemo1(){
        OrderDTO one = orderService.findOne("1291623458953867264");
        System.out.println(one);
    }

    @Test
    void findAllDemo1(){
        List<OrderDTO> list = orderService.findList("1");
        System.out.println(list);
    }

    @Test
    void updateCancel(){
        OrderDTO one = orderService.findOne("1291623458953867264");
        orderService.cancel(one);
    }

    @Test
    void updateFinish(){
        OrderDTO one = orderService.findOne("1291623458953867264");
        OrderDTO finish = orderService.finish(one);
        System.out.println(finish.getOrderStatus());
    }

    @Test
    void paid(){
        OrderDTO one = orderService.findOne("1291623458953867264");
        OrderDTO paid = orderService.paid(one);
        System.out.println(paid.getPayStatus());
    }
}