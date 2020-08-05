package com.warrior.sell.service;

import com.warrior.sell.entity.ProductInfo;
import com.warrior.sell.constant.ProductStatusEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;

@SpringBootTest
class ProductServiceTest {
    @Resource
    private ProductService productService;

    @Test
    public void findUp(){
        productService.findUpAll();
    }

    /**
     * product_id,
     * product_name,
     * product_price,
     * product_stock,
     * product_description,
     * product_icon,
     * product_status,
     * category_type,
     */
    @Test
    public void save1(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("125");
        productInfo.setProductName("银耳汤");
        productInfo.setProductPrice(new BigDecimal("2.0"));
        productInfo.setProductStock(30);
        productInfo.setProductDescription("精品早饭");
        productInfo.setProductIcon("htt.sss");
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        productInfo.setCategoryType(6);
        productService.save(productInfo);
    }

}