package com.warrior.sell.dto;

import com.warrior.sell.entity.ProductInfo;

import java.sql.Timestamp;
import java.util.List;

/**
 * 多表连接查询
 */
public class PCategoryMergePInfoDTO {
    /**类目 id*/
    private Integer categoryId;
    /**类目 名字*/
    private String categoryName;
    /**类目 编号*/
    private Integer categoryType;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp updateTime;
    /**
     * 关联info表
     */
    private List<ProductInfo> productInfoList;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public List<ProductInfo> getProductInfoList() {
        return productInfoList;
    }

    public void setProductInfoList(List<ProductInfo> productInfoList) {
        this.productInfoList = productInfoList;
    }

    @Override
    public String toString() {
        return "ProductCategoryMergeProductInfo{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryType=" + categoryType +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", productInfoList=" + productInfoList +
                '}';
    }
}
