package com.hualala.order.es.mapper;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Document(indexName = "order", type = "orderItem")
public class TblOrderItem {
    @Id
    private Integer ID;

    private Long orderKey;

    private Integer itemType;

    private Long itemID;

    private String itemName;

    private String itemDetail;

    private String remark; //备注

    private String unit;

    private Long unitID;

    private Long categoryID;

    private String categoryName;

    private BigDecimal count;

    private Boolean isSet;

    private BigDecimal point;

    private BigDecimal originPrice;

    private BigDecimal promotePrice;

    private String promoteTags;

    private BigDecimal vipPrice;

    private Integer action;

    private Date actionTime;

    private Date createTime;

}
