package com.example.simplecrudapp1.entity.mappers;

import com.example.simplecrudapp1.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return User.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .nickname(rs.getString("nickname"))
                .age(rs.getInt("age"))
                .build();
    }
}
