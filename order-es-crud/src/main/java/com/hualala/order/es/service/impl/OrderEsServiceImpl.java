package com.hualala.order.es.service.impl;

import com.hualala.order.es.enums.OrderStatusEnum;
import com.hualala.order.es.mapper.TblOrderMaster;
import com.hualala.order.es.service.IOrderEsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ben on 6/7/17.
 */
@Service
public class OrderEsServiceImpl implements IOrderEsService {
    private static final Logger logger = LoggerFactory.getLogger(OrderEsServiceImpl.class);

    @Override
    public TblOrderMaster queryByOrderKey(long orderKey) {
        return null;
    }

    @Override
    public List<TblOrderMaster> queryByShopID(String shopID, OrderStatusEnum orderStatusEnum) {
        return null;
    }
}
