package com.example.student1.mapper;

import com.example.student1.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    //登录方法
    @Select("SELECT * FROM user where username=#{username} AND password=#{password}")
    public List<User> login(User user);

    /*
    @Select("SELECT * FROM user")
    public List<User> testfindAll();
    */
}