package com.dlnu.springboot.controller;

import com.dlnu.springboot.pojo.Student;
import com.dlnu.springboot.service.StdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class StudentController {
    @Autowired
    private StdService stdService;

    @RequestMapping(value = "datacollect", method = RequestMethod.GET)
    public String dataanalyse(ModelMap map) {
        List<Student> list = stdService.getStu();
        map.addAttribute("stds", list);
        System.out.println("读取数据");
        return "echarts";
    }

    @RequestMapping(value = "pie", method = RequestMethod.GET)
    public String datapie(ModelMap map) {
        List<Student> list = stdService.getStu();
        map.addAttribute("users", list);
        System.out.println("读取数据");
        return "pie";
    }

    @RequestMapping(value = "redis")
    public Object getStudent() {
        //线程 该线程调用底层查询所有学生的方法
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                stdService.getStu();
            }
        };
        //多线程测试一下缓存穿透问题
        ExecutorService service = Executors.newFixedThreadPool(25);
        for (int i = 0; i < 10000; i++) {
            service.submit(runnable);
        }
        return stdService.getStu();
    }
}
