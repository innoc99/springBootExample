package com.daumkakao.localcontents.test.websupport.dao;

import model.Level;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by illy on 2016. 1. 6..
 */
public class UserDaoJdbc implements UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    DataSource dataSource;

    private RowMapper<User> userMapper = (rs, rowNum) -> new User(rs.getString("id"), rs.getString("name"), rs.getString("password"),
            Level.valueOf(rs.getInt("level")), rs.getInt("login"), rs.getInt("recommend"));

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public void add(User user) {
        jdbcTemplate.update("INSERT INTO users(id, name, password, level, login, recommend) VALUES (?, ?, ?, ?, ?, ?)"
                , user.getId(), user.getName(), user.getPassword(), user.getLevel().intValue(), user.getLogin(), user.getRecommend());
    }

    public void del(String id) {
        jdbcTemplate.update("DELETE FROM users WHERE id=?", id);
    }

    public void deleteAll() {
        jdbcTemplate.update("DELETE FROM users");
    }

    public User get(String id) {
        return jdbcTemplate.queryForObject("SELECT id, name, password, level, login, recommend FROM users WHERE id = ?",  userMapper, id);
    }

    public int getCount() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM users", Integer.class);
    }

    public List<User> getAll() {
        return jdbcTemplate.query("SELECT id, name, password, level, login, recommend FROM users ORDER BY id"
                , userMapper);
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update("UPDATE users SET name=?, password=?, level=?, login=?, recommend=? WHERE id=?"
                , user.getName(), user.getPassword(), user.getLevel().intValue(), user.getLogin(), user.getRecommend(), user.getId());
    }
}
