package com.exam.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by dx on 2018/8/13.
 *
 * @author dx
 */
public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        InputStream is;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            sqlSessionFactory = builder.build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession openSession() {
        return sqlSessionFactory.openSession();
    }

    public static void closeSession(SqlSession sqlSession) {
        if (null != sqlSession) {
            sqlSession.close();
        }
    }

}
