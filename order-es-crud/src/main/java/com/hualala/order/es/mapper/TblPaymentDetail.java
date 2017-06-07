package com.hualala.order.es.mapper;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Document(indexName = "order", type = "orderBalance")
public class TblPaymentDetail {
    @Id
    private Integer ID;

    private Long orderKey;

    private String paymentID;

    private Integer paymentSubjectCode;

    private String paymentSubjectName;

    private String payorAccount;

    private String payeeAccount;

    private String paymentRemark;

    private BigDecimal dueAmount;

    private BigDecimal paidAmount;

    private Integer paymentStatus;

    private Date paidBeginTime;

    private Timestamp paidTime;

    private Integer transType;


    private String settleID;

    private Date settleTime;

    private Date createTime;

    private Date actionTime;

    private String thirdPartyAccount;
    private int thirdPartyCode;

    private String scanType;
    private int refunded;
    private Timestamp paymentVersion;
    private String cardTypeID;
    private String paymentExtraInfo;


}
