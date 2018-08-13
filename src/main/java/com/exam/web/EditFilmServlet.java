package com.exam.web;

import com.exam.entity.Film;
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
@WebServlet(name = "EditFilmServlet")
public class EditFilmServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FilmServer filmServer = new FilmServerImpl();
        int film_id = Integer.parseInt(request.getParameter("film_id"));
        Film film = filmServer.getFilmById(film_id);
        String title = film.getTitle();
        String description = film.getDescription();
        if (request.getParameter("title") != null && request.getParameter("title") != "") {
            title = request.getParameter("title");
        }
        if (request.getParameter("description") != null && request.getParameter("description") != "") {
            description = request.getParameter("description");
        }
        int language_id = Integer.parseInt(request.getParameter("language_id"));
        filmServer.editFilm(film_id, title, description, language_id);
        response.sendRedirect(request.getContextPath() + "/filmlist.action");
    }
}
