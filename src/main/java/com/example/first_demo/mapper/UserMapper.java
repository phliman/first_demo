package com.example.first_demo.mapper;

import com.example.first_demo.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> findAllUser();

    @Insert("insert into user(username,password,nickname,email,phone,address) " +
            "value(#{username} ,#{password},#{nickname},#{email},#{phone},#{address}) ")
    Integer insert(User user);


    int update(User user);

    @Select("select * from user limit #{pageNum} ,#{pageSize}")
    List<User> selectPage(Integer pageNum, Integer pageSize);

    /*查询总条数*/
    @Select("select  count(*) from user")
    Integer selectTotal();
}
