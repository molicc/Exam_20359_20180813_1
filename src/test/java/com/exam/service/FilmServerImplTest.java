package com.exam.service;

import com.exam.dao.CustomerMapper;
import com.exam.dao.FilmMapper;
import com.exam.entity.Film;
import com.exam.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by dx on 2018/8/13.
 *
 * @author dx
 */
public class FilmServerImplTest {
    @Test
    public void listFilm() throws Exception {
        SqlSession session = null;
        try {
            session = MyBatisUtil.openSession();
            List<Film> films=session.getMapper(FilmMapper.class).showFilm();
            Iterator it = films.iterator();
            while (it.hasNext()){
                Film film= (Film) it.next();
                System.out.println(film.getLanguage());
            }
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(session);
        }
    }
}
