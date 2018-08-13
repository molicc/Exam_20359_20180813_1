package com.exam.service;

import com.exam.dao.CustomerMapper;
import com.exam.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by dx on 2018/8/13.
 *
 * @author dx
 */
public class LoginCheckingImpl implements LoginChecking {
    @Override
    public boolean nameChecking(String loginName) {
        SqlSession session = null;
        try {
            session = MyBatisUtil.openSession();
            String lastName= session.getMapper(CustomerMapper.class).getLastName(loginName);
            session.commit();
            if (lastName!=null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSession(session);
        }
        return false;
    }
}
