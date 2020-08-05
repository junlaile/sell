package com.warrior.sell.dao.impl;

import com.warrior.sell.dao.PCategoryMergePInfoDao;
import com.warrior.sell.dto.PCategoryMergePInfoDTO;
import com.warrior.sell.mapper.PCategoryMergePInfoMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
@Repository
public class ProductCategoryMergeProductInfoDaoImpl implements PCategoryMergePInfoDao {
    @Resource
    private PCategoryMergePInfoMapper pCategoryMergePInfoMapper;

    @Override
    public List<PCategoryMergePInfoDTO> findProductInfoByProductStatus() {
        return pCategoryMergePInfoMapper.findProductInfoByProductStatus();
    }
}
