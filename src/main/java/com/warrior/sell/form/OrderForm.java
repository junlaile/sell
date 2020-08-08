package com.warrior.sell.form;

import javax.validation.constraints.NotNull;

/**
 * @author jun
 * 用于接收从前端穿回的表单信息
 */
public class OrderForm {

    /**
     * 买家姓名
     */
    @NotNull(message = "姓名必填")
    private String name;

    /**
     * 买家手机号
     */
    @NotNull(message = "电话必填")
    private String phone;

    /**
     * 买家地址
     */
    @NotNull(message = "地址必填")
    private String address;

    /**
     * 买家微信openid
     */
    @NotNull(message = "openid必填")
    private String openid;

    /**
     * 购物车信息
     */
    @NotNull(message = "购物车不能为空")
    private String items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }
}
