package com.exam.web;

import com.exam.entity.Film;
import com.exam.service.FilmServer;
import com.exam.service.FilmServerImpl;
import com.exam.service.LoginChecking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dx on 2018/8/13.
 *
 * @author dx
 */
@WebServlet(name = "FilmListServlet")
public class FilmListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        FilmServer filmServer = new FilmServerImpl();
        List<Film> films = filmServer.listFilm();
        request.setAttribute("films",films);
        request.getRequestDispatcher("/filmlist.jsp").forward(request,response);
        return;
    }
}
