package com.dlnu.springboot.controller;

import com.dlnu.springboot.pojo.account;
import com.dlnu.springboot.service.accountService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

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
            str = "account/shiroIndex";
            System.out.println(username + password);
            System.out.println(acc.getName() + acc.getPassword());
        }else str = "redirect:index";
        return str;
    }

    @RequestMapping(value = "shirovalidate", method = RequestMethod.POST)
    public String shiroLogin(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        /*使用shiro重构validate代码*/
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //3.执行登录方法
        try {
            subject.login(token);
            //验证成功
            return "success";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            return "index";//用重定向 thymeleaf接收不到 model 即不识别msg attributeName
        }
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(@ModelAttribute account acc) {
        acc.setName(acc.getName());
        acc.setMoney(acc.getMoney());
        acc.setPassword(acc.getPassword());
        accountservice.register(acc);
        System.out.println("register successfully");
        return "index";
    }

    @RequestMapping("toRegister")
    public String toRegister() {
        return "register";
    }
    @RequestMapping("update")
    public String update_Shirotest() {
        return "account/update";
    }

    @RequestMapping("delete")
    public String shiro_delete() {
        return "account/delete";
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
