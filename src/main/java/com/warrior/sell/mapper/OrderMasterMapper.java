package com.warrior.sell.mapper;
import java.util.Date;

import com.warrior.sell.entity.OrderMaster;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMasterMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(OrderMaster record);

    int insertSelective(OrderMaster record);

    OrderMaster selectByPrimaryKey(String orderId);

    List<OrderMaster> findByBuyerOpenid(@Param("buyerOpenid")String buyerOpenid);

//    List<OrderMaster> findAll();

    int updateByPrimaryKeySelective(OrderMaster record);

    int updateByPrimaryKey(OrderMaster record);

    int batchInsert(@Param("list") List<OrderMaster> list);
}