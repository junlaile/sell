package com.warrior.sell.dao.impl;

import com.warrior.sell.dao.ProductCategoryDao;
import com.warrior.sell.entity.ProductCategory;
import com.warrior.sell.mapper.ProductCategoryMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

@Repository
public class ProductCategoryDaoImpl implements ProductCategoryDao {
    @Resource
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategory> selectAll() {
        return productCategoryMapper.selectAll();
    }

    @Override
    public ProductCategory selectOne(int categoryId) {
        return productCategoryMapper.selectOne(categoryId);
    }

    @Override
    public ProductCategory findByCategoryType(int CategoryTypeNumber) {
        return productCategoryMapper.findByCategoryType(CategoryTypeNumber);
    }

    @Override
    public List<ProductCategory> selectForId(Integer[] ids) {
        return productCategoryMapper.selectForId(ids);
    }

    @Override
    public void saveOneProductCategory(ProductCategory productCategory) {
        productCategoryMapper.saveOneProductCategory(productCategory);
    }

    @Override
    public void updateOneProductCategory(ProductCategory productCategory) {
        productCategoryMapper.updateOneProductCategory(productCategory);
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(Collection<Integer> categoryTypeCollection) {
        return productCategoryMapper.findByCategoryTypeIn(categoryTypeCollection);
    }

    @Override
    public int insertProductCategoryToBatch(List<ProductCategory> list) {
        return productCategoryMapper.insertProductCategoryToBatch(list);
    }
}
