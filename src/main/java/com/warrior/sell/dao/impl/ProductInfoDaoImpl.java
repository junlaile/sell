package com.warrior.sell.dao.impl;

import com.warrior.sell.dao.ProductInfoDao;
import com.warrior.sell.entity.ProductInfo;
import com.warrior.sell.mapper.ProductInfoMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jun
 */
@Repository
public class ProductInfoDaoImpl implements ProductInfoDao {
    @Resource
    private ProductInfoMapper productInfoMapper;

    @Override
    public int deleteByPrimaryKey(String productId) {
        return productInfoMapper.deleteByPrimaryKey(productId);
    }

    @Override
    public int insert(ProductInfo record) {
        return productInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(ProductInfo record) {
        return productInfoMapper.insertSelective(record);
    }

    @Override
    public ProductInfo selectByPrimaryKey(String productId) {
        return productInfoMapper.selectByPrimaryKey(productId);
    }

    @Override
    public List<ProductInfo> findByProductStatus(Byte productStatus) {
        return productInfoMapper.findByProductStatus(productStatus);
    }

    @Override
    public List<ProductInfo> findAll() {
        return productInfoMapper.findAll();
    }

    @Override
    public int updateByPrimaryKeySelective(ProductInfo record) {
        return productInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ProductInfo record) {
        return productInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<ProductInfo> list) {
        return productInfoMapper.batchInsert(list);
    }
}
