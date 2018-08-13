package com.exam.service;

import com.exam.entity.Film;

import java.util.List;

/**
 * Created by dx on 2018/8/13.
 *
 * @author dx
 */
public interface FilmServer {
    /**
     * 增加新电影
     *
     * @param title
     * @param description
     * @param language_id
     */
    void addFilm(String title, String description, int language_id);

    /**
     * @param film_id
     */
    void deleteFilmById(int film_id);

    /**
     * 编辑电影信息
     * @param film_id
     * @param title
     * @param description
     * @param language
     */
    void editFilm(int film_id, String title, String description, int language_id);

    /**
     * 拉取电影列表
     * @return 电影列表
     */
    List<Film> listFilm();
    Film getFilmById(int film_id);
}
