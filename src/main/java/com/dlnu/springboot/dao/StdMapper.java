package com.dlnu.springboot.dao;

import com.dlnu.springboot.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface StdMapper {

    @Select("select * from tzb_student")
    List<Student> getAllInfo();
}
