package com.warrior.sell.constant;

/**
 * 支付状态
 * @author jun
 */
public enum PayStatusEnum {
    /**
     * 等待支付
     */
    WAIT((byte)0,"等待支付"),
    /**
     * 支付成功
     */
    SUCCESS((byte)1,"支付成功"),
    ;
    /**
     * 状态值
     */
    private final Byte code;
    /**
     * 状态值信息
     */
    private final String msg;
    PayStatusEnum(Byte code, String msg) {
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
