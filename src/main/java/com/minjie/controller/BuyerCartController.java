package com.minjie.controller;

import com.minjie.dataobject.ProductInfo;
import com.minjie.dataobject.UserCart;
import com.minjie.service.BuyerService;
import com.minjie.service.ProductService;
import com.minjie.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Map;

/**
 * Created by zhengjie on 2020/2/12.
 */

@RestController
@RequestMapping("/buyer/cart")
public class BuyerCartController {
    @Autowired
    private ProductService productService;

    @Autowired
    private BuyerService buyerService;

    @GetMapping("/insert")
    public ModelAndView insert(@RequestParam("productId") String productId,
                               @RequestParam("userId") String userId,
                               Map<String,Object> map){

        UserCart userCart=buyerService.findByUserIdAndProductId(userId,productId);

        //查询单个物品详情
        ProductInfo productInfo=productService.findOne(productId);
        //购物车入库
        if(userCart==null) {
            userCart=new UserCart();
            userCart.setCartId(KeyUtil.genUniqueKey());
            userCart.setUserId(userId);
            userCart.setProductId(productInfo.getProductId());
            userCart.setProductName(productInfo.getProductName());
            userCart.setProductPrice(productInfo.getProductPrice());
            userCart.setProductQuantity(1);
        }else  {
            userCart.setProductQuantity(userCart.getProductQuantity()+1);
        }
        buyerService.insertCart(userCart);
        map.put("msg","加入购物车成功");
        map.put("productInfo",productInfo);
        return new ModelAndView("/login/BookInfo");

    }
}
