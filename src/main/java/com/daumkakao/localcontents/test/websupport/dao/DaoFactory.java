package com.daumkakao.localcontents.test.websupport.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

/**
 * Dao 생성용 Factory
 * Created by illy on 2016. 1. 4..
 */
@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao() {
        UserDao userDao = new UserDao();
        userDao.setDataSource(dataSource());
        return userDao;
    }

    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUrl("jdbc:mysql://localhost/test");
        dataSource.setUsername("root");
        dataSource.setPassword("fhemqb21");
        return dataSource;
    }

    @Bean
    JdbcContext jdbcContext(){
        JdbcContext jdbcContext = new JdbcContext();
        return jdbcContext;
    }
}
