package com.dlnu.springboot.controller;

import com.dlnu.springboot.pojo.account;
import com.dlnu.springboot.service.accountService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("update")
    public String update_Shirotest() {
        return "account/update";
    }

    @RequestMapping("shiroLogin")
    public String shiro_login() {
        return "account/login";
    }

    @RequestMapping("getAll")
    public String getAll(ModelMap map, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 5);
        List<account> list = accountservice.findAll();
        PageInfo<account> page = new PageInfo<account>(list);
        map.addAttribute("users", page);
        return "list";
    }
}
