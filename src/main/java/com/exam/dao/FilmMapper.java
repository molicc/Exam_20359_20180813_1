package com.exam.dao;

import com.exam.entity.Film;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by dx on 2018/8/13.
 *
 * @author dx
 */
public interface FilmMapper {
    /**
     * 增加新电影
     */
    void saveNewFilm(@Param("title") String title, @Param("description") String description, @Param("language_id") int language_id);

    /**
     * 通过电影id删除电影
     */
    void dropFilm(@Param("film_id") int film_id);

    /**
     * 拉取所有电影
     */
    List<Film> showFilm();

    /**
     * 修改电影信息
     */
    void editFilm(@Param("film_id") int film_id,@Param("title") String title, @Param("description") String description, @Param("language_id") int language_id);
    Film getFilmById(@Param("film_id") int film_id );
}
