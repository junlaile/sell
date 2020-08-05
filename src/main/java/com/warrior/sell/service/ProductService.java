package com.warrior.sell.service;

import com.warrior.sell.entity.ProductInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductService {
//    int deleteByPrimaryKey(String productId);

    int saveComplete(ProductInfo record);

    int save(ProductInfo record);

    ProductInfo findByPrimaryKey(String productId);

    List<ProductInfo> findUpAll();

    List<ProductInfo> findDownAll();

    List<ProductInfo> findAll();

    int updateByPrimaryKeySelective(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);

    int batchSave(@Param("list") List<ProductInfo> list);
}
