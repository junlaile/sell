package com.warrior.sell.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.warrior.sell.entity.OrderDetail;
import com.warrior.sell.utils.serializer.DateToSecond;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

//@JsonInclude(JsonInclude.Include.NON_NULL)

/**
 * 关联 orderDetailDao
 * 一对多查询
 *
 * @author jun
 */
@Data
public class OrderDTO {
    private String orderId;

    /**
     * 买家名字
     */
    private String buyerName;

    /**
     * 买家电话
     */
    private String buyerPhone;

    /**
     * 买家地址
     */
    private String buyerAddress;

    /**
     * 买家微信open ID
     */
    private String buyerOpenid;

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态，默认为0 新下单
     */
    private Byte orderStatus;

    /**
     * 支付状态，默认0未支付
     */
    private Byte payStatus;

    /**
     * 创建时间
     */
    @JsonSerialize(using = DateToSecond.class)
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonSerialize(using = DateToSecond.class)
    private Date updateTime;

    /**
     * 关联详细订单表
     */
    private List<OrderDetail> orderDetailList;

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", buyerPhone='" + buyerPhone + '\'' +
                ", buyerAddress='" + buyerAddress + '\'' +
                ", buyerOpenid='" + buyerOpenid + '\'' +
                ", orderAmount=" + orderAmount +
                ", orderStatus=" + orderStatus +
                ", payStatus=" + payStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", orderDetailList=" + orderDetailList +
                '}';
    }
}
