package com.warrior.sell.dao;

import com.warrior.sell.dto.PCategoryMergePInfoDTO;

import java.util.List;

public interface PCategoryMergePInfoDao {
    List<PCategoryMergePInfoDTO> findProductInfoByProductStatus();

}
