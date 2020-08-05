package com.warrior.sell.service.impl;

import com.warrior.sell.dao.ProductCategoryDao;
import com.warrior.sell.entity.ProductCategory;
import com.warrior.sell.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private ProductCategoryDao productCategoryDao;

    @Override
    public List<ProductCategory> selectAll() {
        return productCategoryDao.selectAll();
    }

    @Override
    public ProductCategory selectOne(int categoryId) {
        return productCategoryDao.selectOne(categoryId);
    }

    public ProductCategory findByCategoryType(int CategoryTypeNumber) {
        return productCategoryDao.findByCategoryType(CategoryTypeNumber);
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(Collection<Integer> categoryTypeCollection) {
        return productCategoryDao.findByCategoryTypeIn(categoryTypeCollection);
    }

    @Override
    public int insertProductCategoryToBatch(List<ProductCategory> list) {
        return productCategoryDao.insertProductCategoryToBatch(list);
    }

    @Override
    public List<ProductCategory> selectForId(Integer[] ids) {
        return productCategoryDao.selectForId(ids);
    }

    @Override
    public void saveOneProductCategory(ProductCategory productCategory) {
        productCategoryDao.saveOneProductCategory(productCategory);
    }

    @Override
    public void updateOneProductCategory(ProductCategory productCategory) {
        productCategoryDao.updateOneProductCategory(productCategory);
    }
}
