package com.warrior.sell.controller;

import com.warrior.sell.constant.ResultEnum;
import com.warrior.sell.dto.OrderDTO;
import com.warrior.sell.exception.SellException;
import com.warrior.sell.form.OrderForm;
import com.warrior.sell.service.BuyerService;
import com.warrior.sell.service.OrderService;
import com.warrior.sell.utils.EntityTypeConversion;
import com.warrior.sell.utils.ResultVOUtil;
import com.warrior.sell.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author jun
 * 买家端 订单
 */
@RestControllerAdvice
@RestController
@RequestMapping("/buyer/order")
public class BuyerOrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BuyerOrderController.class);

    @Resource
    private OrderService orderService;
    @Resource
    private BuyerService buyerService;

    /**
     * 创建订单
     */
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            LOGGER.error("【创建订单】 参数不正确");
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        OrderDTO orderDTO = EntityTypeConversion.orderFormToOrderDTO(orderForm);
        if (orderDTO.getOrderDetailList().isEmpty()) {
            LOGGER.error("【创建订单】 购物车不能为空");
            throw new SellException(ResultEnum.CART_ISEMPTY);
        }
        String orderId = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>(1);
        map.put("orderId", orderId);
        return ResultVOUtil.success(map);
    }

    /**
     * 订单列表
     */
    @GetMapping("/list")
    @ExceptionHandler(SellException.class)
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") int page,
                                         @RequestParam(value = "size", defaultValue = "10") int size) {
        if (StringUtils.isEmpty(openid)) {
            LOGGER.error("【查询订单列表】 openid 为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        List<OrderDTO> list = orderService.findList(openid, page, size);
        return ResultVOUtil.success(list);
    }

    /**
     * 订单详情
     */
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId) {
        if (StringUtils.isEmpty(openid)) {
            LOGGER.error("【查询订单详情】 openid 为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        if (StringUtils.isEmpty(orderId)) {
            LOGGER.error("【查询订单详情】 orderId 为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);
        return ResultVOUtil.success(orderDTO);
    }

    /**
     * 取消订单
     */
    @PostMapping("/cancel")
    public ResultVO<Object> cancel(@RequestParam("openid") String openid,
                                   @RequestParam("orderId") String orderId) {
        if (StringUtils.isEmpty(openid)) {
            LOGGER.error("【取消订单】 openid 为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        if (StringUtils.isEmpty(orderId)) {
            LOGGER.error("【取消订单】 orderId 为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        buyerService.cancelOrder(openid,orderId);
        return ResultVOUtil.success();
    }
}
