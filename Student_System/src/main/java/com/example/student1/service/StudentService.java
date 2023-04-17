package com.example.student1.service;


import com.example.student1.bean.Student;
import com.example.student1.mapper.StudentMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    Page page = null;

    public Page selectByPage(Integer currentPage, Integer pageSize){
        page= PageHelper.startPage(currentPage,pageSize);
        studentMapper.selectAll();
        return page;
    }
    public void addStu(Student stu) {
        studentMapper.addStu(stu);
    }
    public void updateStu(Student stu) {
        studentMapper.updateStu(stu);
    }
    public void deleteStu(String name) {
        studentMapper.deleteStu(name);
    }
}
