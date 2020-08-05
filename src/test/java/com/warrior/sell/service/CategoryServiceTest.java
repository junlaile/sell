package com.warrior.sell.service;

import com.warrior.sell.entity.ProductCategory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class CategoryServiceTest {

    @Resource
    private CategoryService categoryService;

    @Test
    void selectAll() {
        List<ProductCategory> productCategories = categoryService.selectAll();
    }

    @Test
    void selectOne() {
        categoryService.selectOne(2);
    }

    @Test
    void findByCategoryType() {
        ProductCategory byCategoryType = categoryService.findByCategoryType(4);
    }

    @Test
    void findByCategoryTypeIn() {
        categoryService.findByCategoryTypeIn(Arrays.asList(2,5,3,4));
    }

    @Test
    void insertProductCategoryToBatch() {
        ProductCategory hot = new ProductCategory("hot", 6);
        ArrayList<ProductCategory> list = new ArrayList<>();
        list.add(hot);
        categoryService.insertProductCategoryToBatch(list);
    }

    @Test
    void selectForId() {
        categoryService.selectForId(new Integer[]{2,4});
    }

    @Test
    void saveOneProductCategory() {
        ProductCategory could = new ProductCategory("could", 7);
        categoryService.saveOneProductCategory(could);
    }

    @Test
    void updateOneProductCategory() {
//        productCategoryService.findByCategoryType()
        ProductCategory could = new ProductCategory("could", 8);
        categoryService.updateOneProductCategory(could);
    }
}