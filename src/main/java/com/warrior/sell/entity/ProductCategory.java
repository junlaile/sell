package com.warrior.sell.entity;

import java.util.Objects;

public class ProductCategory {

  /**类目 id*/
  private Integer categoryId;
  /**类目 名字*/
  private String categoryName;
  /**类目 编号*/
  private Integer categoryType;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;

  public ProductCategory() {
  }

  public ProductCategory(String categoryName, Integer categoryType) {
    this.categoryName = categoryName;
    this.categoryType = categoryType;
  }

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


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public java.sql.Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.sql.Timestamp updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ProductCategory that = (ProductCategory) o;
    return Objects.equals(categoryId, that.categoryId) &&
            Objects.equals(categoryName, that.categoryName) &&
            Objects.equals(categoryType, that.categoryType) &&
            Objects.equals(createTime, that.createTime) &&
            Objects.equals(updateTime, that.updateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(categoryId, categoryName, categoryType, createTime, updateTime);
  }

  @Override
  public String toString() {
    return "ProductCategory{" + "categoryId=" + categoryId +
            ", categoryName='" + categoryName + '\'' +
            ", categoryType=" + categoryType +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            '}';
  }
}
