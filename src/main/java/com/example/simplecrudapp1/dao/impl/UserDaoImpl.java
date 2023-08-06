package com.example.simplecrudapp1.dao.impl;

import com.example.simplecrudapp1.dao.UserDao;
import com.example.simplecrudapp1.entity.User;
import com.example.simplecrudapp1.entity.mappers.UserRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Slf4j
@Repository
@Transactional
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public boolean isExistsNickname(String nickname) {
        return jdbcTemplate.queryForObject("SELECT EXISTS (SELECT * FROM simple_db.user WHERE nickname = ?);",
                Integer.class, nickname) !=0;
    }

    @Override
    public void insertNewUser(User user) {
        jdbcTemplate.update("INSERT INTO simple_db.user(name, nickname, age) VALUES (?,?,?);",
                user.getName(), user.getNickname(), user.getAge());
        log.info("User was inserted.");
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList = jdbcTemplate.query(
                "SELECT * FROM simple_db.user ORDER BY id;",
                new UserRowMapper());
        log.info("Users List showing.");
        return userList;
    }
}
