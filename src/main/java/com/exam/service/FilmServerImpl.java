package com.exam.service;

import com.exam.dao.FilmMapper;
import com.exam.entity.Film;
import com.exam.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by dx on 2018/8/13.
 *
 * @author dx
 */
public class FilmServerImpl implements FilmServer {
    @Override
    public void addFilm(String title, String description, int language_id) {
        SqlSession session = null;
        try {
            session = MyBatisUtil.openSession();
            session.getMapper(FilmMapper.class).saveNewFilm(title, description, language_id);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(session);
        }
    }

    @Override
    public void deleteFilmById(int film_id) {
        SqlSession session = null;
        try {
            session = MyBatisUtil.openSession();
            session.getMapper(FilmMapper.class).dropFilm(film_id);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(session);
        }
    }

    @Override
    public void editFilm(int film_id, String title, String description, int language_id) {
        SqlSession session = null;
        try {
            session = MyBatisUtil.openSession();
            session.getMapper(FilmMapper.class).editFilm(film_id, title, description, language_id);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(session);
        }
    }

    @Override
    public List<Film> listFilm() {
        SqlSession session = null;
        List<Film> films = null;
        try {
            session = MyBatisUtil.openSession();
            films = session.getMapper(FilmMapper.class).showFilm();
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(session);
        }
        return films;
    }

    @Override
    public Film getFilmById(int film_id) {
        SqlSession session =null;
        Film film = null;
        try {
            session =MyBatisUtil.openSession();
            film = session.getMapper(FilmMapper.class).getFilmById(film_id);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSession(session);
        }
        return film;
    }
}
