package com.myspring.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(String name, String password){
        String sql = "insert into spring(username, password) values(?, ?);";
        int update = jdbcTemplate.update(sql, name, password);
        System.out.println(update + " record has changed.");
    }

}
