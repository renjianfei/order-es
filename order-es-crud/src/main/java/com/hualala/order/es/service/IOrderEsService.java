package com.hualala.order.es.service;

import com.hualala.order.es.enums.OrderStatusEnum;
import com.hualala.order.es.mapper.TblOrderMaster;

import java.util.List;

/**
 * Created by ben on 6/7/17.
 */
public interface IOrderEsService {
    TblOrderMaster queryByOrderKey(long orderKey);

    List<TblOrderMaster> queryByShopID(String shopID, OrderStatusEnum orderStatusEnum);
}
