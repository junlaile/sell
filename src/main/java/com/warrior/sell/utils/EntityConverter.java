package com.warrior.sell.utils;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.warrior.sell.constant.ResultEnum;
import com.warrior.sell.dto.OrderDTO;
import com.warrior.sell.entity.OrderDetail;
import com.warrior.sell.exception.SellException;
import com.warrior.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author jun
 * //@Mapper(componentModel = "string") //使用依赖注入的方式
 * @data 2020/8/11
 */
@Mapper
public interface EntityConverter {
    EntityConverter CONVERTER = Mappers.getMapper(EntityConverter.class);

    @Mappings({
            @Mapping(source = "name", target = "buyerName"),
            @Mapping(source = "phone", target = "buyerPhone"),
            @Mapping(source = "address", target = "buyerAddress"),
            @Mapping(source = "openid", target = "buyerOpenid"),
            @Mapping(target = "orderDetailList", expression = "java(com.warrior.sell.utils.Hidden.json2OrderDetailList(orderForm.getItems()))")
    })
    OrderDTO orderFormToOrderDTO(OrderForm orderForm);
}
