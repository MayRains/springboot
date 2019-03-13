package com.dlnu.springboot.dao;

import com.dlnu.springboot.pojo.account;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface accountMapper {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "money", column = "money"),
            @Result(property = "password",column = "password")
    })

    @Select("select * from account where name = #{name} ")
    account findByName(@Param("name") String name);

}
