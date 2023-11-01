package com.notahmed.catsfinder.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

// this is a better approach
// however this takes a RowMapper, but I think there is a way to reference it inside Repository
// Check Custom RowMapper
@Service
public class BreedMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
