package com.warrior.sell.controller;

import com.warrior.sell.constant.ResultEnum;
import com.warrior.sell.dto.OrderDTO;
import com.warrior.sell.exception.SellException;
import com.warrior.sell.form.OrderForm;
import com.warrior.sell.service.OrderService;
import com.warrior.sell.utils.EntityTypeConversion;
import com.warrior.sell.utils.ResultVOUtil;
import com.warrior.sell.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author jun
 * 买家端 订单
 */
@RestController
@RequestMapping("/buyer/order")
public class BuyerOrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BuyerOrderController.class);

    @Resource
    private OrderService orderService;
    /**
     * 创建订单
     */
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            LOGGER.error("【创建订单】 参数不正确");
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        OrderDTO orderDTO = EntityTypeConversion.orderFormToOrderDTO(orderForm);
        if (orderDTO.getOrderDetailList().isEmpty()){
            LOGGER.error("【创建订单】 购物车不能为空");
            throw new SellException(ResultEnum.CART_ISEMPTY);
        }
        String orderId = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>(1);
        map.put("orderId",orderId);
        return ResultVOUtil.success(map);
    }
    //查询订单
    //TODO
    //订单详情
    //取消订单
}
