package com.warrior.sell.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Collection;

import com.warrior.sell.entity.ProductCategory;
import com.warrior.sell.mapper.provider.ProductCategoryProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProductCategoryMapper {
//    @Select("select category_id,category_name,category_type,create_time,update_time from product_category")
    List<ProductCategory> selectAll();

    ProductCategory selectOne(@Param("categoryId") int categoryId);

    List<ProductCategory> findByCategoryTypeIn(@Param("categoryTypeCollection")Collection<Integer> categoryTypeCollection);

    ProductCategory findByCategoryType(@Param("CategoryTypeNumber") int CategoryTypeNumber);

    int insertProductCategoryToBatch(List<ProductCategory> list);

    @SelectProvider(type = ProductCategoryProvider.class,method="selectProductCategoryByIds")
    List<ProductCategory> selectForId(@Param("ids") Integer[] ids);

    @InsertProvider(type = ProductCategoryProvider.class, method="insertForProductCategory")
    void saveOneProductCategory(ProductCategory productCategory);

    @UpdateProvider(type = ProductCategoryProvider.class,method = "updateForProductCategory")
    void updateOneProductCategory(ProductCategory productCategory);


}
