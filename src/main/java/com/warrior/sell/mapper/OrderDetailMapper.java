package com.warrior.sell.mapper;

import com.warrior.sell.entity.OrderDetail;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author jun
 */
public interface OrderDetailMapper {
    int deleteByPrimaryKey(String detailId);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(String detailId);

    List<OrderDetail> findByOrderId(@Param("orderId")String orderId);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);

    int batchInsert(@Param("list") List<OrderDetail> list);
}