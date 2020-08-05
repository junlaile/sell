package com.warrior.sell.mapper;

import com.warrior.sell.entity.ProductInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductInfoMapper {
    int deleteByPrimaryKey(String productId);

    int insert(ProductInfo record);

    int insertSelective(ProductInfo record);

    ProductInfo selectByPrimaryKey(String productId);

    List<ProductInfo> findByProductStatus(@Param("productStatus")Byte productStatus);

    int updateByPrimaryKeySelective(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);

    int batchInsert(@Param("list") List<ProductInfo> list);

    List<ProductInfo> findAll();
}