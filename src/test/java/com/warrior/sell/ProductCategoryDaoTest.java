package com.warrior.sell;

import com.warrior.sell.dao.ProductCategoryDao;
import com.warrior.sell.entity.ProductCategory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
//@Transactional
class ProductCategoryDaoTest {
    @Resource
    private ProductCategoryDao dao;

    @Test
    public void findAllTest() {
        List<ProductCategory> all = dao.selectAll();
        System.out.println(all);
    }

    @Test
    public void findOneTest() {
        ProductCategory one = dao.selectOne(1);
        System.out.println(one);
    }

    @Test
    public void findById() {
        List<ProductCategory> forId = dao.selectForId(new Integer[]{1, 2});
    }

    @Test
    public void savePC() {
        ProductCategory productCategory = new ProductCategory("秋日清爽", 2);
        dao.saveOneProductCategory(productCategory);
    }

    @Test
    public void setPC() {
        ProductCategory productCategory = dao.selectOne(2);
        productCategory.setCategoryName("秋高气爽");
        dao.updateOneProductCategory(productCategory);
    }

    @Test
    public void saveBatchPC() {
        List<ProductCategory> list = new ArrayList<>();
        list.add(new ProductCategory("寒冬腊月", 4));
        list.add(new ProductCategory("春暖花开", 5));
        int batch = dao.insertProductCategoryToBatch(list);
        System.out.println(batch);
    }

    @Test
    public void findCategoryTypeIn() {
        List<ProductCategory> categoryTypeIn = dao.findByCategoryTypeIn(Arrays.asList(4, 2, 5));
        System.out.println(categoryTypeIn);
    }
}