package com.example.student1.controller;

import com.example.student1.bean.User;
import com.example.student1.service.UserService;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
public class UserMVC {

    @Autowired
    private UserService service = new UserService();

    @ResponseBody
    @RequestMapping("/userServlet")
    public String request1(@RequestParam("username") String username, @RequestParam("password")  String password, HttpServletRequest req) {
        String result;
        //封装User对象
        User user = new User(username, password);
        //调用业务层的登录方法
        List<User> list = service.login(user);
        //判断是否查询出结果
        if (list.size() != 0) {
            req.getSession().setAttribute("username",username);
            //响应给客户端true
            result = "true";
        } else {
            result = "false";
        }
        return result;
    }
}