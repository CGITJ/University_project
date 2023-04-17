package com.example.student1.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//检查登录
@WebFilter(value = {"/列表.html"})
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1.将请求和响应对象转换为和HTTP协议相关
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //2.获取会话域对象中数据
        Object username = request.getSession().getAttribute("username");
        //3.判断用户名
        if(username == null || "".equals(username)){
            //重定向到登录页面
            response.sendRedirect(request.getContextPath()+"/login.html");
            return;
        }
        //4.放行
        filterChain.doFilter(request,response);
    }
}
