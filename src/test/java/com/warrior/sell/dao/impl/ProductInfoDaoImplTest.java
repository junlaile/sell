package com.warrior.sell.dao.impl;

import com.warrior.sell.dao.ProductInfoDao;
import com.warrior.sell.entity.ProductInfo;
import com.warrior.sell.constant.ProductStatusEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ProductInfoDaoImplTest {

    @Resource
    private ProductInfoDao productInfoDao;
    @Test
    void findByProductStatus() {
        List<ProductInfo> byProductStatus = productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}