package com.warrior.sell.exception;

import com.warrior.sell.constant.ResultEnum;

/**
 * @author jun
 */
public class SellException extends RuntimeException {
    private final int code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public int getCode() {
        return code;
    }
}
