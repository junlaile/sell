package com.warrior.sell.constant;

/**
 * 订单 状态
 */
public enum OrderStatusEnum {
    NEW((byte)0,"新下单"),
    FINISHED((byte)1,"下单完成"),
    CANCEL((byte)2,"取消下单")
    ;
    /**
     * 状态值
     */
    private final Byte code;
    /**
     * 状态值信息
     */
    private final String msg;
    OrderStatusEnum(Byte code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Byte getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
