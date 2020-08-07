package com.warrior.sell.dao;

import com.warrior.sell.dto.OrderDTO;

/**
 * @author jun
 */
public interface OrderDao {
    /**
     * 关联 订单主表和详情表
     * @param orderId 通过关联 订单主表主键查询
     * @return 订单组装类
     */
    OrderDTO findByMasterForOrderId(String orderId);
}
