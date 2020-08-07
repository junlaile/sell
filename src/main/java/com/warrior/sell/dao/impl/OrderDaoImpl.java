package com.warrior.sell.dao.impl;

import com.warrior.sell.dao.OrderDao;
import com.warrior.sell.dto.OrderDTO;
import com.warrior.sell.mapper.OrderMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author jun
 */
@Repository
public class OrderDaoImpl implements OrderDao {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public OrderDTO findByMasterForOrderId(String orderId) {
        return orderMapper.findByMasterForOrderId(orderId);
    }
}
