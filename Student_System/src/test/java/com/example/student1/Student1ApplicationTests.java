package com.example.student1;

import com.example.student1.bean.User;
import com.example.student1.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Student1ApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        //List<User> list = userMapper.testfindAll();
        //System.out.println(list);
    }

}
