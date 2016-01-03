package com.daumkakao.localcontents.test.websupport.dao;

import model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * UserDao 테스트 JUnit
 * Created by illy on 2016. 1. 4..
 */
public class UserDaoTest {

    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {

        UserDao dao = getUserDao();

        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        User user1 = new User("innoc", "김", "123");
        User user2 = new User("innoc2", "김2", "1234");

        dao.add(user1);
        User userget1 = dao.get(user1.getId());
        assertThat(userget1.getName(), is(user1.getName()));
        assertThat(userget1.getPassword(), is(user1.getPassword()));

        dao.add(user2);
        User userget2 = dao.get(user2.getId());
        assertThat(userget2.getName(), is(user2.getName()));
        assertThat(userget2.getPassword(), is(user2.getPassword()));
    }

    @Test
    public void count() throws SQLException, ClassNotFoundException {
        UserDao dao = getUserDao();
        User user1 = new User("innoc", "김", "123");
        User user2 = new User("innoc2", "김2", "1234");
        User user3 = new User("innoc3", "김3", "1235");
        dao.deleteAll();
        assertThat(dao.getCount(), is(0));
        dao.add(user1);
        assertThat(dao.getCount(), is(1));
        dao.add(user2);
        assertThat(dao.getCount(), is(2));
        dao.add(user3);
        assertThat(dao.getCount(), is(3));
    }

    public static UserDao getUserDao() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        return context.getBean(UserDao.class);
    }
}
