package com.exam.web;

import com.exam.service.FilmServer;
import com.exam.service.FilmServerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dx on 2018/8/13.
 *
 * @author dx
 */
@WebServlet(name = "DeleteFilmServlet")
public class DeleteFilmServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FilmServer filmServer = new FilmServerImpl();
        int film_id = Integer.parseInt(request.getParameter("film_id"));
        filmServer.deleteFilmById(film_id);

        response.sendRedirect(request.getContextPath()+"/filmlist.action");
    }
}
