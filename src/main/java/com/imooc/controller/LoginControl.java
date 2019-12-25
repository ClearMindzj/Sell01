package com.imooc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhengjie on 2019/12/25.
 */
@Controller
@RequestMapping("/seller")
public class LoginControl {

    @RequestMapping("/login")
    public String login(){
        return "Login";
    }
}
