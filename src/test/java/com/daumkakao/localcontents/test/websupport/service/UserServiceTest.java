package com.daumkakao.localcontents.test.websupport.service;

import com.daumkakao.localcontents.test.websupport.dao.DaoFactory;
import model.Level;
import model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by illy on 2016. 1. 7..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoFactory.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;
    private List<User> users;

    @Test
    public void bean(){
        assertThat(this.userService, is(notNullValue()));
    }

    @Before
    public void setUp(){
        users = Arrays.asList(
                new User("innoc1", "김1", "123", Level.BASIC, 49, 0),
                new User("innoc2", "김2", "1234", Level.BASIC, 50, 10),
                new User("innoc3", "김3", "1234", Level.SILVER, 60, 29),
                new User("innoc4", "김4", "1234", Level.SILVER, 60, 30),
                new User("innoc5", "김5", "1235", Level.GOLD, 100, 100)
        );
    }
}