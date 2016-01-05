package com.daumkakao.localcontents.test.websupport.dao;

import model.User;

import java.util.List;

/**
 * User테이블 access용 DAO
 * Created by illy on 2015. 10. 25..
 */
public interface UserDao {
    void add(User user);
    User get(String id);
    List<User> getAll();
    void deleteAll();
    int getCount();
}
