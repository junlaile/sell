package com.warrior.sell.controller;

import com.warrior.sell.dto.PCategoryMergePInfoDTO;
import com.warrior.sell.entity.ProductInfo;
import com.warrior.sell.service.CategoryMergeProductService;
import com.warrior.sell.utils.ResultVOUtil;
import com.warrior.sell.vo.ProductInfoVO;
import com.warrior.sell.vo.ProductVO;
import com.warrior.sell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 买家商品
 * @author jun
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Resource
    private CategoryMergeProductService categoryMergeProductService;

    /*查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //查询类目
        List<Integer> CategoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType).collect(Collectors.toList());
        */

    @GetMapping("/list")
    public ResultVO<List<ProductVO>> list() {
        // 使用 多表关联查询 并封装数据
        List<PCategoryMergePInfoDTO> upList = categoryMergeProductService.findUpList();
        List<ProductVO> productVOList = new ArrayList<>();
        for (PCategoryMergePInfoDTO infoDTO : upList) {
            ProductVO productVO = new ProductVO();
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            productVO.setCategoryName(infoDTO.getCategoryName());
            productVO.setCategoryType(infoDTO.getCategoryType());
            for (ProductInfo productInfo : infoDTO.getProductInfoList()) {
                ProductInfoVO productInfoVO = new ProductInfoVO();
                BeanUtils.copyProperties(productInfo, productInfoVO);
                productInfoVOList.add(productInfoVO);
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }

}
