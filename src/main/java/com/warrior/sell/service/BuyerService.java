package com.warrior.sell.service;

import com.warrior.sell.dto.OrderDTO;

/**
 * @author jun
 * @data 2020/8/9 13:32
 */
public interface BuyerService {
    /**
     * 查询一个订单
     *
     * @param openid  微信支付id
     * @param orderId 订单id
     * @return orderDTO
     */
    OrderDTO findOrderOne(String openid, String orderId);

    /**
     * 取消订单
     *
     * @param openid  微信支付id
     * @param orderId 订单id
     */
    void cancelOrder(String openid, String orderId);
}
