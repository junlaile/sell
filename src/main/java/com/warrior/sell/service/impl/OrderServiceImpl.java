package com.warrior.sell.service.impl;

import com.github.pagehelper.PageHelper;
import com.warrior.sell.constant.OrderStatusEnum;
import com.warrior.sell.constant.PayStatusEnum;
import com.warrior.sell.constant.ResultEnum;
import com.warrior.sell.dao.OrderDao;
import com.warrior.sell.dao.OrderDetailDao;
import com.warrior.sell.dao.OrderMasterDao;
import com.warrior.sell.dto.CartDTO;
import com.warrior.sell.dto.OrderDTO;
import com.warrior.sell.entity.OrderDetail;
import com.warrior.sell.entity.OrderMaster;
import com.warrior.sell.entity.ProductInfo;
import com.warrior.sell.exception.SellException;
import com.warrior.sell.service.OrderService;
import com.warrior.sell.service.ProductService;
import com.warrior.sell.utils.KeyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jun
 */
@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Resource
    private ProductService productService;
    @Resource
    private OrderDetailDao orderDetailDao;
    @Resource
    private OrderMasterDao orderMasterDao;
    @Resource
    private OrderDao orderDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String create(OrderDTO orderDTO) {
        //在订单创建时生成 订单 id
        String orderId = KeyUtil.generatorUniqueKey();
        //记录总价
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        // 1、查询商品 数量 和 价格
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productService.findByPrimaryKey(orderDetail.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            // 2、计算总价
            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);
            // 3-1、将订单详情写入数据库
            orderDetail.setDetailId(KeyUtil.generatorUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetailDao.insert(orderDetail);
        }
        // 3-2、将订单概览写入数据库
        orderDTO.setOrderId(orderId);
        OrderMaster orderMaster = new OrderMaster();

        BeanUtils.copyProperties(orderDTO, orderMaster);

        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterDao.insert(orderMaster);
        // 4、减少库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productService.decreaseStock(cartDTOList);

        return orderId;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        OrderDTO orderDTO = orderDao.findByMasterForOrderId(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        if (orderDTO.getOrderDetailList().isEmpty()) {
            throw new SellException(ResultEnum.ORDER_DETAIL_NOT_EXIST);
        }
        return orderDTO;
    }

    @Override
    public List<OrderDTO> findList(String buyerOpenid) {
        return findList(buyerOpenid, 0, 20);
    }

    @Override
    public List<OrderDTO> findList(String buyerOpenid, int begin, int size) {
        PageHelper.startPage(begin, size);
        List<OrderMaster> orderMasterList = orderMasterDao.findByBuyerOpenid(buyerOpenid);
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (OrderMaster orderMaster : orderMasterList) {
            OrderDTO orderDTO = new OrderDTO();
            BeanUtils.copyProperties(orderMaster, orderDTO);
            orderDTOList.add(orderDTO);
        }
        return orderDTOList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderDTO cancel(OrderDTO orderDTO) {
        // 判断订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            //使用日志记录
            LOGGER.error("【取消订单】 订单状态不正确 orderId={},orderStatus={}",
                    orderDTO.getOrderId(), orderDTO.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //修改订单状态
        orderDTO.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(orderDTO.getOrderId());
        orderMaster.setOrderStatus(orderDTO.getOrderStatus());
        int i = orderMasterDao.updateByPrimaryKeySelective(orderMaster);
        if (i == 0) {
            LOGGER.error("【取消订单】 更新失败 orderMaster={}", orderMaster);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }
        //返回库存
        if (orderDTO.getOrderDetailList().isEmpty()) {
            LOGGER.error("【取消订单】 订单中无商品详情 orderDTO={}", orderDTO);
            throw new SellException(ResultEnum.ORDER_DETAIL_EMPTY);
        }
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productService.increaseStock(cartDTOList);
        //如果以支付需要退款
        if (orderDTO.getPayStatus().equals(PayStatusEnum.SUCCESS.getCode())) {
            //TODO
        }
        return orderDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderDTO finish(OrderDTO orderDTO) {
        //判断订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            LOGGER.error("【订单完结】 订单状态不正确 orderId ={}, orderStatus = {}",
                    orderDTO.getOrderId(), orderDTO.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //修改订单状态
        orderDTO.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(orderDTO.getOrderId());
        orderMaster.setOrderStatus(orderDTO.getOrderStatus());
        int i = orderMasterDao.updateByPrimaryKeySelective(orderMaster);
        if (i == 0) {
            LOGGER.error("【订单完结】 更新失败 orderMaster={}", orderMaster);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }
        return orderDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderDTO paid(OrderDTO orderDTO) {
        // 判断订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            LOGGER.error("【订单支付完成】 订单状态不正确 orderId ={}, orderStatus = {}",
                    orderDTO.getOrderId(), orderDTO.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        // 判断支付状态
        if (!orderDTO.getPayStatus().equals(PayStatusEnum.WAIT.getCode())){
            LOGGER.error("【订单支付完成】 订单支付状态不正确 orderDTO = {}",orderDTO);
            throw new SellException(ResultEnum.ORDER_PAY_STATUS_ERROR);
        }
        // 修改支付状态

        orderDTO.setPayStatus(PayStatusEnum.SUCCESS.getCode());
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(orderDTO.getOrderId());
        orderMaster.setPayStatus(orderDTO.getPayStatus());
        int i = orderMasterDao.updateByPrimaryKeySelective(orderMaster);
        if (i == 0) {
            LOGGER.error("【订单支付完成】 更新失败 orderMaster={}", orderMaster);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }
        return orderDTO;
    }
}
