package com.notahmed.catsfinder.repository.template;

import com.notahmed.catsfinder.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserJdbcTemplate {

    private final JdbcTemplate userJdbcTemplate;


    public UserJdbcTemplate(JdbcTemplate userJdbcTemplate) {
        this.userJdbcTemplate = userJdbcTemplate;
    }


    private static User mapRow(ResultSet rs, int rowNum) throws SQLException{
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("mobile"),
                rs.getString("gender").charAt(0),
                rs.getDate("birth_date"),
                rs.getTimestamp("details_updated").toLocalDateTime(),
                rs.getString("user_role").charAt(0),
                rs.getString("profile_image")

        );
    }


    public List<User> findAllUsers(){
        String sql = """
        SELECT *
        FROM "User"
        """;

        List<User> users = userJdbcTemplate.query(sql, UserJdbcTemplate::mapRow);

        return users;
    }
}
