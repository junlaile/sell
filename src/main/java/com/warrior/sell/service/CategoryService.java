package com.warrior.sell.service;

import com.warrior.sell.entity.ProductCategory;

import java.util.Collection;
import java.util.List;

/**
 * @author jun
 */
public interface CategoryService {
    List<ProductCategory> selectAll();

    ProductCategory selectOne(int categoryId);

    ProductCategory findByCategoryType(int categoryTypeNumber);

    List<ProductCategory> findByCategoryTypeIn(Collection<Integer> categoryTypeCollection);

    int insertProductCategoryToBatch(List<ProductCategory> list);

    List<ProductCategory> selectForId(Integer[] ids);

    void saveOneProductCategory(ProductCategory productCategory);

    void updateOneProductCategory(ProductCategory productCategory);

}
