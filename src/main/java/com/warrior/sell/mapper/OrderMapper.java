package com.warrior.sell.mapper;

import com.warrior.sell.dto.OrderDTO;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    OrderDTO findByMasterForOrderId(@Param("orderId") String orderId);
}
