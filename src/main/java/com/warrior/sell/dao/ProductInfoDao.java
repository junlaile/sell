package com.warrior.sell.dao;

import com.warrior.sell.entity.ProductInfo;

import java.util.List;

/**
 * @author jun
 */
public interface ProductInfoDao {
    int deleteByPrimaryKey(String productId);

    int insert(ProductInfo record);

    int insertSelective(ProductInfo record);

    ProductInfo selectByPrimaryKey(String productId);

    List<ProductInfo> findByProductStatus(Byte productStatus);

    List<ProductInfo> findAll();

    int updateByPrimaryKeySelective(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);

    int batchInsert(List<ProductInfo> list);
}
