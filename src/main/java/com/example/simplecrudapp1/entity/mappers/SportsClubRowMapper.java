package com.example.simplecrudapp1.entity.mappers;

import com.example.simplecrudapp1.entity.SportsClub;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SportsClubRowMapper implements RowMapper<SportsClub> {
    @Override
    public SportsClub mapRow(ResultSet rs, int rowNum) throws SQLException {
        return SportsClub.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .city(rs.getString("city"))
                .build();
    }
}
