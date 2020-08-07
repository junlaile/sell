package com.warrior.sell.service.impl;

import com.warrior.sell.constant.ResultEnum;
import com.warrior.sell.dao.ProductInfoDao;
import com.warrior.sell.dto.CartDTO;
import com.warrior.sell.entity.ProductInfo;
import com.warrior.sell.exception.SellException;
import com.warrior.sell.service.ProductService;
import com.warrior.sell.constant.ProductStatusEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jun
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductInfoDao productInfoDao;

    @Override
    public int saveComplete(ProductInfo record) {
        return productInfoDao.insert(record);
    }

    @Override
    public int save(ProductInfo record) {
        return productInfoDao.insertSelective(record);
    }

    @Override
    public ProductInfo findByPrimaryKey(String productId) {
        return productInfoDao.selectByPrimaryKey(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findDownAll() {
        return productInfoDao.findByProductStatus(ProductStatusEnum.DOWN.getCode());
    }

    @Override
    public List<ProductInfo> findAll() {
        return productInfoDao.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int increaseStock(List<CartDTO> cartDTOList) {

        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = findByPrimaryKey(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            int result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoDao.updateByPrimaryKey(productInfo);
        }
    }

    @Override
    public int updateByPrimaryKeySelective(ProductInfo record) {
        return productInfoDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ProductInfo record) {
        return productInfoDao.updateByPrimaryKey(record);
    }

    @Override
    public int batchSave(List<ProductInfo> list) {
        return productInfoDao.batchInsert(list);
    }
}
