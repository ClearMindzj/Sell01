package com.imooc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhengjie on 2019/12/25.
 */
@Controller
@RequestMapping("/seller")
public class LoginControl {

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("uid",1234567);
        model.addAttribute("name","zj");
        return "login/Login";
    }
    @RequestMapping("/bookinfo")
    public String login(){
        return  "login/BookInfo";
    }
}
