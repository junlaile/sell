package com.warrior.sell.utils;

import com.warrior.sell.dto.OrderDTO;
import com.warrior.sell.form.OrderForm;

/**
 * @author jun
 */
public class EntityTypeConversion {

    /**
     * 将 OrderForm 转换为 OrderDTO
     *
     * @param orderForm 接收一个 order表单对象
     * @return 拥有orderForm所有属性值的 OrderDTO 对象
     */
    public static OrderDTO orderFormToOrderDTO(OrderForm orderForm) {
        return EntityConverter.CONVERTER.orderFormToOrderDTO(orderForm);
    }
}
