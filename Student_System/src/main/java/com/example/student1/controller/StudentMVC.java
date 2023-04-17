package com.example.student1.controller;

import com.example.student1.bean.Student;
import com.example.student1.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@Controller
public class StudentMVC {
    @Autowired
    private StudentService service;

    @ResponseBody
    @RequestMapping("/studentServlet")
    public String request1(@RequestParam("method") String method, @RequestParam("currentPage") String currentPage, @RequestParam("pageSize") String pageSize, HttpServletResponse resp, HttpServletRequest req) throws IOException, InvocationTargetException, IllegalAccessException {
        String abc = null;
        switch (method) {
            case "selectByPage":
                abc = selectByPage(currentPage, pageSize);
                break;
            case "addStu":
                // 添加学生数据
                addStu(currentPage, pageSize, resp, req);
                break;
            case "updateStu":
                // 修改学生数据
                updateStu(currentPage, pageSize, resp, req);
                break;
            case "deleteStu":
                // 删除学生数据
                deleteStu(currentPage, pageSize, resp, req);
                break;
        }
        return abc;
    }

    private String selectByPage(@RequestParam("currentPage") String currentPage, @RequestParam("pageSize") String pageSize) throws IOException {
        Page page = service.selectByPage(Integer.parseInt(currentPage),Integer.parseInt(pageSize));
        PageInfo info = new PageInfo(page);
        return new ObjectMapper().writeValueAsString(info);
    }

    // 添加学生数据
    private void addStu(@RequestParam("currentPage") String currentPage, @RequestParam("pageSize") String pageSize, HttpServletResponse resp, HttpServletRequest req) throws InvocationTargetException, IllegalAccessException, IOException {
        // 获取请求参数
        Map<String, String[]> map = req.getParameterMap();
        // 封装Student对象
        Student stu = new Student();
        // 封装Student对象
        BeanUtils.populate(stu, map);
        // 调用业务层的添加方法
        service.addStu(stu);
        // 添加完数据后，重定向分页查询功能
        resp.sendRedirect(req.getContextPath()+"/studentServlet?method=selectByPage&currentPage="+currentPage+"&pageSize="+pageSize);
    }

    // 修改学生数据
    private void updateStu(@RequestParam("currentPage") String currentPage, @RequestParam("pageSize") String pageSize, HttpServletResponse resp, HttpServletRequest req) throws InvocationTargetException, IllegalAccessException, IOException {
        // 获取请求参数
        Map<String, String[]> map = req.getParameterMap();
        // 封装Student对象
        Student stu = new Student();
        // 封装Student对象
        BeanUtils.populate(stu, map);
        // 调用业务层的添加方法
        service.updateStu(stu);
        // 添加完数据后，重定向分页查询功能
        resp.sendRedirect(req.getContextPath()+"/studentServlet?method=selectByPage&currentPage="+currentPage+"&pageSize="+pageSize);
    }

    // 删除学生数据
    private void deleteStu(@RequestParam("currentPage") String currentPage, @RequestParam("pageSize") String pageSize, HttpServletResponse resp, HttpServletRequest req) throws IOException {
        // 获取请求参数
        String name = req.getParameter("name");
        // 调用业务层的添加方法
        service.deleteStu(name);
        // 添加完数据后，重定向分页查询功能
        resp.sendRedirect(req.getContextPath()+"/studentServlet?method=selectByPage&currentPage="+currentPage+"&pageSize="+pageSize);
    }
}
