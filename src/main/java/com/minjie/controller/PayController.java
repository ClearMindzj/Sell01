package com.minjie.controller;

import com.minjie.dto.OrderDTO;
import com.minjie.enums.ResultEnum;
import com.minjie.exception.SellException;
import com.minjie.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Create by zj on 2019/8/12
 */
@Controller
@RequestMapping("/pay")
public class PayController {
    @Autowired
    private OrderService orderService;
    @GetMapping("create")
    public void create(@RequestParam("orderId") String orderId,
                       @RequestParam("returnUrl") String returnUrl){
        //1.查询订单
        OrderDTO orderDTO=orderService.findOne(orderId);
        if(orderDTO==null){
            throw  new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //发起支付

    }
}
