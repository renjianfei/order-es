package com.hualala.order.es.listener.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hualala.order.es.listener.IMqCallback;
import com.hualala.order.es.mapper.TblOrderMaster;
import com.hualala.order.es.repository.TblOrderMasterEsRepository;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by ben on 6/7/17.
 */
@Component("orderEsCallback")
public class OrderEsCallback implements IMqCallback {
    private static final Logger logger = LoggerFactory.getLogger(OrderEsCallback.class);
    @Autowired
    private TblOrderMasterEsRepository orderRepository;
    @Override
    public void callback(String mqMsg) {
        logger.info("es callback msg is {}", mqMsg);

        try {
            TblOrderMaster orderMaster = new ObjectMapper().readValue(mqMsg, TblOrderMaster.class);
            orderRepository.save(orderMaster);
        } catch (IOException e) {
            logger.error("invalid mq msg!!!, exception is {}", ExceptionUtils.getStackTrace(e));
        }
    }
}
