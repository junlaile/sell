package com.warrior.sell.dao.impl;

import com.warrior.sell.dao.OrderDetailDao;
import com.warrior.sell.entity.OrderDetail;
import com.warrior.sell.mapper.OrderDetailMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class OrderDetailDaoImpl implements OrderDetailDao {
    @Resource
    private OrderDetailMapper orderDetailMapper;

    @Override
    public int deleteByPrimaryKey(String detailId) {
        return orderDetailMapper.deleteByPrimaryKey(detailId);
    }

    @Override
    public int insert(OrderDetail record) {
        return orderDetailMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderDetail record) {
        return orderDetailMapper.insertSelective(record);
    }

    @Override
    public OrderDetail selectByPrimaryKey(String detailId) {
        return orderDetailMapper.selectByPrimaryKey(detailId);
    }

    @Override
    public List<OrderDetail> findByOrderId(String orderId) {
        return orderDetailMapper.findByOrderId(orderId);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderDetail record) {
        return orderDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderDetail record) {
        return orderDetailMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<OrderDetail> list) {
        return orderDetailMapper.batchInsert(list);
    }
}
