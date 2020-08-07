package com.warrior.sell.dao;


import com.warrior.sell.entity.ProductInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ProductInfoDaoTest {
    @Resource
    private ProductInfoDao productInfoDao;

    @Test
    void selectByPrimaryKey() {
//        ProductInfo productInfo = productInfoDao.selectByPrimaryKey("124");
        List<ProductInfo> all = productInfoDao.findAll();
        System.out.println(all);
    }
}