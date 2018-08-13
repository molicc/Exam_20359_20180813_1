package com.exam.service;

import com.exam.dao.CustomerMapper;
import com.exam.dao.FilmMapper;
import com.exam.entity.Customer;
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
public class LoginCheckingImplTest {
    @Test
    public void nameChecking() throws Exception {
        SqlSession session = null;
        try {
            session = MyBatisUtil.openSession();
            String s= session.getMapper(CustomerMapper.class).getLastName("mary");
            System.out.println(s);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(session);
        }

    }
}