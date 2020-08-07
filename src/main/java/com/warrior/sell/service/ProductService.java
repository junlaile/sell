package com.warrior.sell.service;

import com.warrior.sell.dto.CartDTO;
import com.warrior.sell.entity.ProductInfo;

import java.util.List;

/**
 * @author jun
 */
public interface ProductService {
//  int deleteByPrimaryKey(String productId);

    /**
     * 保存商品信息
     *
     * @param record 商品信息
     * @return 保存条数
     */
    int saveComplete(ProductInfo record);

    /**
     * 保存商品信息
     *
     * @param record 商品信息
     * @return 保存条数
     */
    int save(ProductInfo record);

    /**
     * 通过主键查询单条数据
     *
     * @param productId 主键
     * @return 单条数据
     */
    ProductInfo findByPrimaryKey(String productId);

    /**
     * 查询所有上架商品
     *
     * @return 商品信息列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询所有下架商品
     *
     * @return 商品信息列表
     */
    List<ProductInfo> findDownAll();

    /**
     * 查询所有商品
     *
     * @return 商品信息列表
     */
    List<ProductInfo> findAll();

    /**
     * 增加库存
     *
     * @param cartDTOList 传输层 购物车信息
     * @return 修改条目
     */
    int increaseStock(List<CartDTO> cartDTOList);

    /**
     * 减库存
     *
     * @param cartDTOList 传输层 购物车信息
     */
    void decreaseStock(List<CartDTO> cartDTOList);

    /**
     * 通过主键更新指定
     *
     * @param record 商品信息对象
     * @return 更改条目
     */
    int updateByPrimaryKeySelective(ProductInfo record);

    /**
     * 通过主键更新全部
     *
     * @param record 商品信息对象
     * @return 更改条目
     */
    int updateByPrimaryKey(ProductInfo record);

    /**
     * 批量插入
     *
     * @param list 商品信息对象列表
     * @return 插入条数
     */
    int batchSave(List<ProductInfo> list);
}
