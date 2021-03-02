package com.example.demo.Dao;

import com.example.demo.model.User;
import com.example.demo.model.Volunteer;
import com.example.demo.model.VolunteerGeneral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("postgresVolunteer")
public class PostgresVolunteerDao implements VolunteerDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostgresVolunteerDao (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<VolunteerGeneral> getAllVolunteerGeneral() {
        final String sql = "select p.userId, trim(p.givenName) as givenName, trim(p.familyName) as familyName, p.isActive, p.mobilePhone, v.roleType, v.role, v.roleStatus, u.email from h2h_volunteer_info v inner join h2h_user_profile p on v.userId=p.userId inner join h2h_user u on v.userId=u.userId";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID userId = UUID.fromString(resultSet.getString("userId"));
            String givenName = resultSet.getString("givenName");
            String familyName = resultSet.getString("familyName");
            String status = (true==resultSet.getBoolean("isActive")) ? "Active" : "Inactive";
            String roleType = resultSet.getString("roleType");
            String role = resultSet.getString("role");
            String roleStatus = resultSet.getString("roleStatus");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("mobilePhone");
            return new VolunteerGeneral(userId, givenName+" "+familyName, status, roleType, role, roleStatus, email, phone);
        });
    }

    @Override
    public Volunteer saveVolunteer(Volunteer volunteer) {
        final String sql = "insert into h2h_volunteer_info (userid, roleType, role, status) values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, volunteer.getUserId(), volunteer.getRoleType(), volunteer.getRole(), volunteer.getStatus());
        return volunteer;
    }
}