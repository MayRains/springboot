package com.dlnu.springboot.service;

import com.dlnu.springboot.dao.accountMapper;
import com.dlnu.springboot.pojo.account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class accountService {
    @Autowired
    private accountMapper accountmapper;

    public account findByName(String name){
        return accountmapper.findByName(name);
    }

    public List<account> findAll() {
        return accountmapper.findAll();
    }
}
