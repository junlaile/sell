package com.warrior.sell.service.impl;

import com.warrior.sell.dao.PCategoryMergePInfoDao;
import com.warrior.sell.dto.PCategoryMergePInfoDTO;
import com.warrior.sell.service.CategoryMergeProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author jun
 */
@Service
public class CategoryMergeProductServiceImpl implements CategoryMergeProductService {
    @Resource
    private PCategoryMergePInfoDao pCategoryMergePInfoDao;

    @Override
    public List<PCategoryMergePInfoDTO> findUpList() {
        return pCategoryMergePInfoDao.findProductInfoByProductStatus();
    }
}
