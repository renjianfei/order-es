package com.hualala.order.es.mapper;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Document(indexName = "order", type = "order")
public class TblOrderMaster {
    private Integer orderID;
    @Id
    private Long orderKey;

    private Long parentOrderKey;

    private String shopOrderKey;

    private String channelKey;

    private String channelOrderKey;

    private String quoteID; //购物车IDs, 如果多个购物车ID，ID1,ID2

    private Integer orderType;

    private Integer orderSubType;

    private Integer orderStatus;

    private Integer orderState;

    private Integer paymentStatus;

    private String orderRemark;

    private Long groupID;

    private String groupName;

    private Long brandID;

    private Long shopID;

    private String shopName;

    private String sessionKey;

    private Long userID;

    private String userName;

    private String userMobile;

    private BigDecimal originTotalAmount;

    private BigDecimal originTotalPoint;

    private BigDecimal discountTotalAmount;

    private String appliedPromoteIDs;

    private BigDecimal dueTotalAmount;

    private BigDecimal dueTotalPoint;

    private BigDecimal paidTotalAmount;

    private BigDecimal paidTotalPoint;

    private BigDecimal refundTotalAmount;

    private BigDecimal refundTotalPoint;

    private Date paidTime;

    private String invoiceTitle;

    private Date orderTime;

    private String targetType;

    private String targetKey;

    private BigDecimal serviceAmount;

    private String cancelRemark;

    private Date cancelTime;

    private String extraInfo;

    private String clientType;

    private String clientIP;

    private String operator;

    private Integer action;

    private Date actionTime;

    private Date createTime;

    @Field(type = FieldType.Nested)
    private List<TblOrderItem> orderItemList;

    @Field(type = FieldType.Nested)
    private List<TblPaymentDetail> paymentDetailList;

}
