package com.dlnu.springboot.service;

import com.dlnu.springboot.dao.StdMapper;
import com.dlnu.springboot.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StdService {
    @Autowired
    private StdMapper stdMapper;

    public List<Student> getStu() {
        return stdMapper.getAllInfo();
    }
}
