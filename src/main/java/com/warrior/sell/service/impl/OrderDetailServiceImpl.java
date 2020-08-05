package com.warrior.sell.service.impl;

import com.warrior.sell.dao.OrderDetailDao;
import com.warrior.sell.entity.OrderDetail;
import com.warrior.sell.service.OrderDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Resource
    private OrderDetailDao orderDetailDao;

    @Override
    public int save(OrderDetail record) {
        return orderDetailDao.insert(record);
    }

    @Override
    public int insertSelective(OrderDetail record) {
        return orderDetailDao.insertSelective(record);
    }

    @Override
    public OrderDetail selectByPrimaryKey(String detailId) {
        return orderDetailDao.selectByPrimaryKey(detailId);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderDetail record) {
        return orderDetailDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderDetail record) {
        return orderDetailDao.updateByPrimaryKey(record);
    }

    @Override
    public int batchSave(List<OrderDetail> list) {
        return orderDetailDao.batchInsert(list);
    }
}
