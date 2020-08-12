package com.warrior.sell.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.warrior.sell.constant.ResultEnum;
import com.warrior.sell.entity.OrderDetail;
import com.warrior.sell.exception.SellException;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author jun
 * @data 2020/8/11
 */
@Slf4j
class Hidden {
    public static List<OrderDetail> json2OrderDetailList(String json) {
        Gson gson = new Gson();
        List<OrderDetail> list;
        try {
            list = gson.fromJson(json, new TypeToken<List<OrderDetail>>() {
            }.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误 string = {}", json);
            log.error(e.getMessage());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        return list;
    }
}
