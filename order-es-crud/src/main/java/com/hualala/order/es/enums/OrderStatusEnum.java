package com.hualala.order.es.enums;

import java.util.Optional;

/**
 * Created by ben on 2/27/17.
 */
public enum  OrderStatusEnum {
//    //增序
//    STATE_DEFAULT = 0; //创建
//
//    STATE_CREATED = 10;
//
//    STATE_SUBMITED = 15; //用户确认提交
//
//
//    STATE_CANCELLED = 18; // 订单取消
//
//
//    STATE_PAID = 20; //支付完成,待发货
//
//    STATE_PENDING_REVOKE = 29; //退订中
//
//    STATE_REVOKED = 30; //已退订
//
//    STATE_CONFIRMED = 40; //商家接单
//
//
//    STATE_DELIVERYING = 46; //配送中
//
//
//    STATE_PENDING_REVIEW = 50; //待评价
//
//    STATE_COMPLETED = 60; // 订单完成
//
//    STATE_PENDING_REFUND = 64; //退款中
//
//    STATE_REFUNDED = 65; //退款完成


    SUBMITTED(15, "提交/代付款"),

    CANCELLED(18, "订单取消"),

    PENDING_PAY(19, "支付中"),

    PAID(20, "支付完成/待发货"),

    PENDING_REVOKE(29, "退订中"),

    REVOKED(30, "已退订"),

    CONFIRMED(40, "商家接单"),

    DELIVERYING(46, "配送中"),

    PENDING_REVIEW(50, "待评价"),

    COMPLETED(60, "订单完成"),

    PENDING_REFUND(64, "退款中"),

    REFUNDED(65, "退款完成");



    OrderStatusEnum(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public static Optional<OrderStatusEnum> getOrderStatusEnumByID(int id){
        for(OrderStatusEnum orderStatusEnum : OrderStatusEnum.values()){
            if(orderStatusEnum.getId() == id){
                return Optional.of(orderStatusEnum);
            }
        }
        return Optional.empty();
    }

    private int id;

    private String desc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
