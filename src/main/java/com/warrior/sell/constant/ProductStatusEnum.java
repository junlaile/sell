package com.warrior.sell.constant;

/**
 * 商品状态
 */
public enum ProductStatusEnum {
    /**
     * 上架
     */
    UP((byte) 0),
    /**
     * 下架
     */
    DOWN((byte) 1);
    /**
     * 商品状态
     */
    private final Byte code;

    /**
     * 状态信息
     */
    ProductStatusEnum(Byte code) {
        this.code = code;
    }

    public Byte getCode() {
        return code;
    }
}
