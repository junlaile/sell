package com.warrior.sell.dao.impl;

import com.warrior.sell.dao.OrderMasterDao;
import com.warrior.sell.entity.OrderMaster;
import com.warrior.sell.mapper.OrderMasterMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class OrderMasterDaoImpl implements OrderMasterDao {
    @Resource
    private OrderMasterMapper orderMasterMapper;

    @Override
    public int deleteByPrimaryKey(String orderId) {
        return orderMasterMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    public int insert(OrderMaster record) {
        return orderMasterMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderMaster record) {
        return orderMasterMapper.insertSelective(record);
    }

    @Override
    public OrderMaster selectByPrimaryKey(String orderId) {
        return orderMasterMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public List<OrderMaster> findByBuyerOpenid(String buyerOpenid) {
        return orderMasterMapper.findByBuyerOpenid(buyerOpenid);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderMaster record) {
        return orderMasterMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderMaster record) {
        return orderMasterMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<OrderMaster> list) {
        return orderMasterMapper.batchInsert(list);
    }
}
