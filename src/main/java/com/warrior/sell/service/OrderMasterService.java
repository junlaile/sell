package com.warrior.sell.service;

import com.warrior.sell.entity.OrderMaster;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMasterService {
//    int deleteByPrimaryKey(String orderId);

    int insert(OrderMaster record);

    int insertSelective(OrderMaster record);

    OrderMaster selectByPrimaryKey(String orderId);

    List<OrderMaster> findByBuyerOpenid(String buyerOpenid);

    int updateByPrimaryKeySelective(OrderMaster record);

    int updateByPrimaryKey(OrderMaster record);

    int batchInsert(@Param("list") List<OrderMaster> list);
}
