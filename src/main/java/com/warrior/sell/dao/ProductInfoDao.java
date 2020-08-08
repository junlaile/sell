package com.warrior.sell.dao;

import com.warrior.sell.dto.CartDTO;
import com.warrior.sell.entity.ProductInfo;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 增加库存 库存
     *
     * @param cartDTO 购物车对象
     * @return 修改条数
     */
    int updateProductStockUpByProductId(@Param("cartDTO")CartDTO cartDTO);


    int batchInsert(List<ProductInfo> list);
}
