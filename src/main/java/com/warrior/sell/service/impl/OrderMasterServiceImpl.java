package com.warrior.sell.service.impl;

import com.warrior.sell.dao.OrderMasterDao;
import com.warrior.sell.entity.OrderMaster;
import com.warrior.sell.service.OrderMasterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderMasterServiceImpl implements OrderMasterService {
    @Resource
    private OrderMasterDao orderMasterDao;

    @Override
    public int insert(OrderMaster record) {
        return orderMasterDao.insert(record);
    }

    @Override
    public int insertSelective(OrderMaster record) {
        return orderMasterDao.insertSelective(record);
    }

    @Override
    public OrderMaster selectByPrimaryKey(String orderId) {
        return orderMasterDao.selectByPrimaryKey(orderId);
    }

    @Override
    public List<OrderMaster> findByBuyerOpenid(String buyerOpenid) {
        return orderMasterDao.findByBuyerOpenid(buyerOpenid);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderMaster record) {
        return orderMasterDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderMaster record) {
        return orderMasterDao.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<OrderMaster> list) {
        return orderMasterDao.batchInsert(list);
    }
}
