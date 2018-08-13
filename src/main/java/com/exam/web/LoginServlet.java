package com.exam.web;

import com.exam.service.LoginChecking;
import com.exam.service.LoginCheckingImpl;

import java.io.IOException;

/**
 * Created by dx on 2018/8/13.
 *
 * @author dx
 */
public class LoginServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
            doGet(request,response);
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //获取表单数据,若有中文进行转码
        request.setCharacterEncoding("UTF-8");
        String loginName = request.getParameter("loginName");
        //调用业务逻辑层判断登陆是否成功
        LoginChecking loginChecking = new LoginCheckingImpl();
        boolean mark = loginChecking.nameChecking(loginName);
        if (mark == true){
        //响应
            request.getSession().setAttribute("flag","login_sucess");
            response.sendRedirect(request.getContextPath()+"/filmlist.action");
            return;
        }else {
            request.getSession().setAttribute("flag","login_fail");
            //传递错误信息
            request.setAttribute("loginError","用户名错误");
            //转发错误信息
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }
}
