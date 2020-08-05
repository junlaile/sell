package com.warrior.sell.dao;


import com.warrior.sell.entity.ProductCategory;

import java.util.Collection;
import java.util.List;

public interface ProductCategoryDao {
    List<ProductCategory> selectAll();

    ProductCategory selectOne(int categoryId);

    ProductCategory findByCategoryType(int CategoryTypeNumber);

    int insertProductCategoryToBatch(List<ProductCategory> list);

    List<ProductCategory> selectForId(Integer[] ids);

    void saveOneProductCategory(ProductCategory productCategory);

    void updateOneProductCategory(ProductCategory productCategory);

    List<ProductCategory> findByCategoryTypeIn(Collection<Integer> categoryTypeCollection);

}
