package com.warrior.sell.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.warrior.sell.constant.ResultEnum;
import com.warrior.sell.dto.OrderDTO;
import com.warrior.sell.entity.OrderDetail;
import com.warrior.sell.exception.SellException;
import com.warrior.sell.form.OrderForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author jun
 */
public class EntityTypeConversion {
    private static final Logger LOGGER = LoggerFactory.getLogger(EntityTypeConversion.class);

    /**
     * 将 OrderForm 转换为 OrderDTO
     *
     * @param orderForm 接收一个 order表单对象
     * @return 拥有orderForm所有属性值的 OrderDTO 对象
     */
    public static OrderDTO orderFormToOrderDTO(OrderForm orderForm) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        Gson gson = new Gson();
        List<OrderDetail> list;
        try {
            //加上大括弧 表示其为匿名内部类
            list = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        } catch (Exception e) {
            LOGGER.error("【对象转换】错误 string = {}", orderForm.getItems());
            LOGGER.error(e.getMessage());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(list);
        return orderDTO;
    }
}
