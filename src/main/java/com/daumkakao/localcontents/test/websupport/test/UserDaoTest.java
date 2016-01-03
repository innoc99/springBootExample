package com.daumkakao.localcontents.test.websupport.test;

import com.daumkakao.localcontents.test.websupport.dao.DaoFactory;
import com.daumkakao.localcontents.test.websupport.dao.UserDao;
import model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

/**
 * Created by illy on 2016. 1. 4..
 */
public class UserDaoTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        UserDao dao = getUserDao();
        User user = new User();
        user.setId("illy.kim");
        user.setName("김종원");
        user.setPassword("illy");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());
        System.out.println(user2.getId() + " 조회 성공");

        dao.del(user.getId());
    }

    public static void singletonTest(){
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        DaoFactory factory = new DaoFactory();
        UserDao dao1 = factory.userDao();
        UserDao dao2 = factory.userDao();
        System.out.println(dao1);
        System.out.println(dao2);

        dao1 = context.getBean(UserDao.class);
        dao2 = context.getBean(UserDao.class);
        System.out.println(dao1);
        System.out.println(dao2);
    }

    public static UserDao getUserDao() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        return context.getBean(UserDao.class);
    }

}
