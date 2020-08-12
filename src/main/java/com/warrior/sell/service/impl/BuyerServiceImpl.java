package com.warrior.sell.service.impl;

import com.warrior.sell.constant.ResultEnum;
import com.warrior.sell.dto.OrderDTO;
import com.warrior.sell.exception.SellException;
import com.warrior.sell.service.BuyerService;
import com.warrior.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jun
 * @data 2020/8/9 13:33
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Resource
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return getOrderDTO(openid, orderId);
    }


    @Override
    public void cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = getOrderDTO(openid, orderId);
        if (orderDTO == null){
            log.error("【取消订单】 查不到该订单");
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        orderService.cancel(orderDTO);
    }

    private OrderDTO getOrderDTO(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            return null;
        }
        if (!orderDTO.getBuyerOpenid().equals(openid)) {
            log.error("【查询订单】 与订单的openid不一致 openid = {},orderDTO={}", openid, orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
