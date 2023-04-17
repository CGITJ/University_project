package com.example.student1.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//用户实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;//账号
    private String password;//密码
}