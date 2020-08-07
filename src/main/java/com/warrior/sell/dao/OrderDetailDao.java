package com.warrior.sell.dao;

import com.warrior.sell.entity.OrderDetail;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author jun
 */
@Repository
public interface OrderDetailDao {
    int deleteByPrimaryKey(String detailId);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(String detailId);

    List<OrderDetail> findByOrderId(String orderId);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);

    int batchInsert(List<OrderDetail> list);
}
