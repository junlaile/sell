package com.warrior.sell.mapper;

import com.warrior.sell.dto.OrderDTO;
import org.apache.ibatis.annotations.Param;

/**
 * @author jun
 */
public interface OrderMapper {
    /**
     * 关联 订单主表和详情表
     * @param orderId 通过关联 订单主表主键查询
     * @return 订单组装类
     */
    OrderDTO findByMasterForOrderId(@Param("orderId") String orderId);
}
