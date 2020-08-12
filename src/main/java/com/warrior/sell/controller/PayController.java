package com.warrior.sell.controller;

import com.warrior.sell.constant.ResultEnum;
import com.warrior.sell.dto.OrderDTO;
import com.warrior.sell.exception.SellException;
import com.warrior.sell.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @author jun
 * @data 2020/8/12
 */
@Controller
@RequestMapping("/pay")
public class PayController {
    @Resource
    private OrderService orderService;

    @GetMapping("/create")
    public String create(@RequestParam("orderId") String orderId, @RequestParam("returnUrl") String returnUrl) {
        //查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO==null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //发起支付
        return null;
    }

}
