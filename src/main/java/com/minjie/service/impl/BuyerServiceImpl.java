package com.minjie.service.impl;

import com.minjie.dto.OrderDTO;
import com.minjie.enums.ResultEnum;
import com.minjie.exception.SellException;
import com.minjie.service.BuyerService;
import com.minjie.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by zj on 2019/8/3
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;
    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
       return checkOrderOwener(openid,orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO=checkOrderOwener(openid,orderId);
        if(orderDTO==null){
            log.error("【取消订单】查不到该订单,orderId={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO) ;
    }

    private OrderDTO checkOrderOwener(String userId, String orderId){
        OrderDTO orderDTO=orderService.findOne(orderId);
        if(orderDTO==null){
            return  null;
        }
        //判断是否是自己的订单
        if(!orderDTO.getUserId().equalsIgnoreCase(userId)){
            log.error("【查询订单】订单的openid不一致. openid={},orderDTO={}",userId,orderDTO);
            throw  new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
