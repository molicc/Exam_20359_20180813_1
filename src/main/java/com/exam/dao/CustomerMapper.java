package com.exam.dao;

import org.apache.ibatis.annotations.Param;

/**
 * Created by dx on 2018/8/13.
 *
 * @author dx
 */
public interface CustomerMapper {
    String getLastName(@Param("name") String name);
}
