package com.minjie.service;

import com.minjie.dataobject.UserCart;
import com.minjie.dto.OrderDTO;

/**
 * 买家
 * Create by zj on 2019/8/3
 */
public interface BuyerService {

    //查询该用户之前有没有加入该商品
    UserCart findByUserIdAndProductId(String userId, String productId);

    //加入购物车
    void insertCart(UserCart userCart);

    //查询一个订单
    OrderDTO findOrderOne(String userId, String orderId);

    //取消订单
    OrderDTO cancelOrder(String userId, String orderId);


}
