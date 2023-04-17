package com.example.student1.service;

import com.example.student1.bean.User;
import com.example.student1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> login(User user){
        return userMapper.login(user);
    }
}
