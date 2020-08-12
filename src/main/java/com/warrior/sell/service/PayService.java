package com.warrior.sell.service;

import com.warrior.sell.dto.OrderDTO;

/**
 * 支付
 *
 * @author jun
 * @data 2020/8/12
 */
public interface PayService {
    /**
     * 创建支付订单
     *
     * @param orderDTO 传输对象层
     */
    void create(OrderDTO orderDTO);
}
