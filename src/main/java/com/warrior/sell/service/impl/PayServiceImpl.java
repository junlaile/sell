package com.warrior.sell.service.impl;

import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.warrior.sell.dto.OrderDTO;
import com.warrior.sell.service.PayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jun
 * @data 2020/8/12
 */
@Service
public class PayServiceImpl implements PayService {

    @Resource
    private BestPayServiceImpl bestPayService;

    @Override
    public void create(OrderDTO orderDTO) {
        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        bestPayService.pay(payRequest);
    }
}
