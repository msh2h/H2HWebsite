package com.example.demo.Dao;

import com.example.demo.model.User;
import com.example.demo.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Repository("postgresUser")
public class PostgresUserDao implements UserDao{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostgresUserDao (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User findByUserId(UUID userId){
        final String sql = "select * from h2h_user where userid = ?";

        User user = null;

        try{
            user = jdbcTemplate.queryForObject(sql, new Object[]{userId}, (rs, rowNum) ->
                    new User(
                            UUID.fromString(rs.getString("userId")),
                            rs.getString("email"),
                            rs.getString("password")
                    ));
        } catch (EmptyResultDataAccessException e){
            //todo: log
            System.out.println("no users found");
        }
        return user;
    }

    @Override
    public User findByEmail(String email){
        final String sql = "select * from h2h_user where email = ?";

        User user = null;

        try{
            user = jdbcTemplate.queryForObject(sql, new Object[]{email}, (rs, rowNum) ->
                    new User(
                            UUID.fromString(rs.getString("userId")),
                            rs.getString("email"),
                            rs.getString("password")
                    ));
        } catch (EmptyResultDataAccessException e){
            //todo: log
            System.out.println("no users found");
        }
        return user;
    }

    @Override
    public User findByEmailAndPassword(String email, String password){
        final String sql = "select * from h2h_user where email = ? and password = ?";

        User user = null;

        try{
            user = jdbcTemplate.queryForObject(sql, new Object[]{email, password}, (rs, rowNum) ->
                    new User(
                            UUID.fromString(rs.getString("userId")),
                            rs.getString("email"),
                            rs.getString("password")
                    ));
        } catch (EmptyResultDataAccessException e){
            //todo: log
            System.out.println("=======no users found=======");
            System.out.println("=======email: "+email+"=======");
            System.out.println("=======password: "+password+"=======");
        }
        return user;
    }

    @Override
    public User saveUser(User user){
        final String sql = "insert into h2h_user (userid, email, password) values (?, ?, ?)";
        jdbcTemplate.update(sql, user.getUserId(), user.getEmail(), user.getPassword());
        return user;
    }
}
