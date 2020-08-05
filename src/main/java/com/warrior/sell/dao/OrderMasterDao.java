package com.warrior.sell.dao;

import com.warrior.sell.entity.OrderMaster;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMasterDao {
    int deleteByPrimaryKey(String orderId);

    int insert(OrderMaster record);

    int insertSelective(OrderMaster record);

    OrderMaster selectByPrimaryKey(String orderId);

    List<OrderMaster> findByBuyerOpenid(String buyerOpenid);

    int updateByPrimaryKeySelective(OrderMaster record);

    int updateByPrimaryKey(OrderMaster record);

    int batchInsert(List<OrderMaster> list);
}
