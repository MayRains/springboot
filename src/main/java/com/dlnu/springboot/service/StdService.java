package com.dlnu.springboot.service;

import com.dlnu.springboot.dao.StdMapper;
import com.dlnu.springboot.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StdService {
    @Autowired
    private StdMapper stdMapper;

    //注入spring配置好的redis template
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    public synchronized List<Student> getStu() {
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        List<Student> list = (List<Student>) redisTemplate.opsForValue().get("allStudent");
        if (list == null) {
            System.out.println("database");
            list = stdMapper.getAllInfo();
            redisTemplate.opsForValue().set("allStudent", list);
        } else {
            System.out.println("cache");
        }
        return list;
    }

}
