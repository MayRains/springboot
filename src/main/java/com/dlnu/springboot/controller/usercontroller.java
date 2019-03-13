package com.dlnu.springboot.controller;

import com.dlnu.springboot.pojo.account;
import com.dlnu.springboot.service.accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class usercontroller {
    @Autowired
    private accountService accountservice;

    @RequestMapping(value = "/hello")
    public String index(){
        return "/index";
    }

    @RequestMapping(value = "validate",method = RequestMethod.POST)
    public String validateUser(@RequestParam("username") String username,@RequestParam(value = "password") String password){
        String str;
        account acc = accountservice.findByName(username);
        if (password.equals(acc.getPassword())){
            str = "success";
        }else str = "redirect:index";
        return str;
    }
}
