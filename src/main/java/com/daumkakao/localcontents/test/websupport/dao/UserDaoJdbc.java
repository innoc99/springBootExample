package com.daumkakao.localcontents.test.websupport.dao;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by illy on 2016. 1. 6..
 */
public class UserDaoJdbc implements UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    DataSource dataSource;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public void add(User user) {
        jdbcTemplate.update("INSERT INTO users(id, name, password) VALUES (?, ?, ?)"
                , user.getId(), user.getName(), user.getPassword());
    }

    public void del(String id) {
        jdbcTemplate.update("DELETE FROM users WHERE id=?", id);
    }

    public void deleteAll() {
        jdbcTemplate.update("DELETE FROM users");
    }

    public User get(String id) {
        return jdbcTemplate.queryForObject("SELECT id, name, password FROM users WHERE id = ?",  new BeanPropertyRowMapper<>(User.class), id);
    }

    public int getCount() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM users", Integer.class);
    }

    public List<User> getAll() {
        return jdbcTemplate.query("SELECT id, name, password FROM users ORDER BY id"
                , new BeanPropertyRowMapper(User.class));
    }
}
