package com.minjie.controller;

import com.minjie.service.BuyerLoginService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by zhengjie on 2019/12/25.
 */
@Controller
@RequestMapping("/seller")
public class LoginControl {
    @Autowired
    private BuyerLoginService buyerLoginService;


    @RequestMapping("/login")
    public ModelAndView login(@RequestParam(value = "username", required = false) String username,
                              @RequestParam(value = "password",required = false)String password,
                              Map<String,Object> map){
        String s=buyerLoginService.buyerLogin(username,password);
        map.put("s",s);
        return new ModelAndView("login/Login",map);
    }
    @RequestMapping("/bookinfo")
    public String login(){
        return  "login/BookInfo";
    }
    @RequestMapping("/cart")
    public String cart(){
        return "login/Cart";
    }
}
