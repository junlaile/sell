package com.warrior.sell.mapper;

import com.warrior.sell.dto.PCategoryMergePInfoDTO;

import java.util.List;

public interface PCategoryMergePInfoMapper {
    List<PCategoryMergePInfoDTO> findProductInfoByProductStatus();
}
