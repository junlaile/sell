package com.warrior.sell.service;

import com.warrior.sell.dto.OrderDTO;

import java.util.List;

/**
 * @author jun
 */
public interface OrderService {
    /**
     * 创建订单
     *
     * @param orderDTO 传输层封装对象
     * @return orderId
     */
    String create(OrderDTO orderDTO);

    /**
     * 查询单个订单
     *
     * @param orderId 传输层封装对象 id
     * @return 传输层封装对象
     */
    OrderDTO findOne(String orderId);

    /**
     * 查询订单列表
     * 默认分页20条
     *
     * @param openid 通过微信的支付id查询
     * @return 传输层封装对象列表
     */
    List<OrderDTO> findList(String openid);

    /**
     * 查询订单列表
     *
     * @param openid 通过微信的支付id查询
     * @param begin       分页开始位置
     * @param size        分页条数
     * @return 传输层封装对象列表
     */
    List<OrderDTO> findList(String openid, int begin, int size);

    /**
     * 取消订单
     *
     * @param orderDTO 传输层封装对象
     */
    void cancel(OrderDTO orderDTO);

    /**
     * 完结订单
     *
     * @param orderDTO 传输层封装对象
     * @return 传输层封装对象
     */
    OrderDTO finish(OrderDTO orderDTO);

    /**
     * 支付订单
     *
     * @param orderDTO 传输层封装对象
     * @return 传输层封装对象
     */
    OrderDTO paid(OrderDTO orderDTO);
}
