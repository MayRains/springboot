package com.dlnu.springboot.controller;

import com.dlnu.springboot.pojo.Student;
import com.dlnu.springboot.service.StdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
