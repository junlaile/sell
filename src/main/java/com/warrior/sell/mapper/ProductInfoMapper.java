package com.warrior.sell.mapper;
import java.util.Collection;

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

    List<ProductInfo> findByProductStatus(@Param("productStatus")Byte productStatus);

    List<ProductInfo> findAll();

    int updateByPrimaryKeySelective(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);

    批量修改
    //<update id="batchUpdate" parameterType="java.util.List">
    //  <foreach collection="list" item="item" index="index" open="" close="" separator=";">
    //   update test
    //      <set>
    //      test=#{item.test}+1
    //      </set>
    //      where id = #{item.id}
    //  </foreach>
    //</update>

    int batchInsert(@Param("list") List<ProductInfo> list);

}