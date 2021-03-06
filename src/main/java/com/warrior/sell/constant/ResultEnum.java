package com.warrior.sell.constant;

/**
 * @author jun
 */

public enum ResultEnum {
    /**
     * 参数不正确
     */
    PARAM_ERROR(501, "参数不正确"),
    /**
     * 商品不存在
     */
    PRODUCT_NOT_EXIST(510, "商品不存在"),
    /**
     * 库存不足
     */
    PRODUCT_STOCK_ERROR(511, "库存不足"),
    /**
     * 订单不存在
     */
    ORDER_NOT_EXIST(512, "订单不存在"),
    /**
     * 订单详情不存在
     */
    ORDER_DETAIL_NOT_EXIST(513, "订单详情不存在"),
    /**
     * 订单状态不正确
     */
    ORDER_STATUS_ERROR(514, "订单状态不正确"),
    /**
     * 订单更新失败
     */
    ORDER_UPDATE_FAIL(515, "订单更新失败"),
    /**
     * 订单详情为空
     */
    ORDER_DETAIL_EMPTY(516, "订单详情为空"),
    /**
     * 订单支付状态不正确
     */
    ORDER_PAY_STATUS_ERROR(517, "订单支付状态不正确"),
    /**
     * 购物车为空
     */
    CART_ISEMPTY(518, "购物车为空"),

    /**
     * 该订单不属于当前用户
     */
    ORDER_OWNER_ERROR(519, "该订单不属于当前用户"),

    /**
     * 微信公众账号方法错误
     */
    WECHAT_MP_ERROR(520, "微信公众账号方法错误"),

    /**
     * 微信编码错误
     */
    WECHAT_MP_ENCODE_ERROR(601, "微信编码错误"),
    ;

    private final int code;
    private final String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
