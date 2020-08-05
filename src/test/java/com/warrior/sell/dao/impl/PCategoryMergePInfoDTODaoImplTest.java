package com.warrior.sell.dao.impl;

import com.warrior.sell.dao.PCategoryMergePInfoDao;
import com.warrior.sell.dto.PCategoryMergePInfoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

@SpringBootTest
class PCategoryMergePInfoDTODaoImplTest {
    @Resource
    private PCategoryMergePInfoDao productCategoryMergeProductInfoDao;
    @Test
    public void moreTableTest1(){
        List<PCategoryMergePInfoDTO> status = productCategoryMergeProductInfoDao.findProductInfoByProductStatus();
        System.out.println(status);
    }

}