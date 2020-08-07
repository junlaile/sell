package com.warrior.sell.mapper;

import com.warrior.sell.entity.OrderMaster;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMasterMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(OrderMaster record);

    int insertSelective(OrderMaster record);

    OrderMaster selectByPrimaryKey(String orderId);
//    List<OrderMaster> findAll();

    int updateByPrimaryKeySelective(OrderMaster record);

    int updateByPrimaryKey(OrderMaster record);

    int batchInsert(@Param("list") List<OrderMaster> list);

    List<OrderMaster> findByBuyerOpenid(@Param("buyerOpenid") String buyerOpenid);
}