package com.example.student1.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//学生实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;//姓名
    private int age;//年龄
    private String address;//籍贯
    private String numbersss;//电话号码
}