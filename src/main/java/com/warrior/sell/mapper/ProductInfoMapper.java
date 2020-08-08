package com.warrior.sell.mapper;

import java.util.Collection;

import com.warrior.sell.dto.CartDTO;
import com.warrior.sell.entity.ProductInfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author jun
 */
public interface ProductInfoMapper {
    int deleteByPrimaryKey(String productId);

    int insert(ProductInfo record);

    int insertSelective(ProductInfo record);

    ProductInfo selectByPrimaryKey(String productId);

    List<ProductInfo> findByProductStatus(@Param("productStatus") Byte productStatus);

    List<ProductInfo> findAll();

    int updateByPrimaryKeySelective(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);

    /**
     * 增加库存 库存
     *
     * @param cartDTO 购物车对象
     * @return 修改条数
     */
    int updateProductStockUpByProductId(@Param("cartDTO")CartDTO cartDTO);


    int batchInsert(@Param("list") List<ProductInfo> list);

}