package com.exam.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by dx on 2018/8/13.
 *
 * @author dx
 */
@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String servletPath = request.getServletPath();
        HttpSession session = request.getSession();
        String flag = (String) session.getAttribute("flag");
        if (servletPath != null && (servletPath.equals("/index.jsp") || servletPath.equals("/login.jsp") || servletPath.equals("/login.action"))) {
            chain.doFilter(request, response);
        } else {
            if (flag != null && flag.equals("login_sucess")) {
                chain.doFilter(request, response);
            } else if (flag != null && flag.equals("login_fail")) {
                request.setAttribute("loginError", "用户名错误");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
                return;
            } else {
                request.setAttribute("loginError", "请登录");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
                return;
            }
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

}
