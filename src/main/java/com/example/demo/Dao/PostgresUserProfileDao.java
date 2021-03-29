package com.example.demo.Dao;

import com.example.demo.model.CommentOnUser;
import com.example.demo.model.User;
import com.example.demo.model.UserProfile;
import com.example.demo.model.Volunteer;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository("postgresUserProfile")
public class PostgresUserProfileDao implements UserProfileDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostgresUserProfileDao (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<UserProfile> getAllUsers() {
        final String sql = "select * from h2h_user_profile";
        return jdbcTemplate.query(sql, (resultSet, i) ->{
            UUID userId = UUID.fromString(resultSet.getString("userId"));
            String givenName = resultSet.getString("givenName");
            String familyName = resultSet.getString("familyName");
            String passportId = resultSet.getString("passportId");
            String passportName = resultSet.getString("passportName");
            String passportNationality = resultSet.getString("passportNationality");
            String mobilePhone = resultSet.getString("mobilePhone");
            String homePhone = resultSet.getString("homePhone");
            String workPhone = resultSet.getString("workPhone");
            String address = resultSet.getString("address");
            String country = resultSet.getString("country");
            String state = resultSet.getString("state");
            String zipcode = resultSet.getString("zipcode");
            Timestamp lastLoginTime = resultSet.getTimestamp("lastLogin");
            Date lastLogin = lastLoginTime==null ? null : new Date(lastLoginTime.getTime());
            Long loginCount = resultSet.getLong("loginCount");
            Timestamp effectiveFromTime = resultSet.getTimestamp("effectiveFromDate");
            Date effectiveFromDate = effectiveFromTime==null ? null : new Date(effectiveFromTime.getTime());
            Timestamp effectiveToTime = resultSet.getTimestamp("effectiveToDate");
            Date effectiveToDate = effectiveToTime==null ? null : new Date(effectiveToTime.getTime());
            boolean isActive = resultSet.getBoolean("isActive");
            boolean isAdmin = resultSet.getBoolean("isAdmin");
            String knowUsFrom = resultSet.getString("knowUsFrom");
            boolean liveInShanghai = resultSet.getBoolean("liveInShanghai");
            boolean isStudent = resultSet.getBoolean("isStudent");
            Timestamp birthTime = resultSet.getTimestamp("birth");
            Date birth = birthTime==null ? null : new Date(birthTime.getTime());
            String school = resultSet.getString("school");
            boolean hasSchoolAccrediation = resultSet.getBoolean("hasSchoolAccrediation");
            boolean speakChinese = resultSet.getBoolean("speakChinese");

            return new UserProfile(userId, givenName, familyName, passportId, passportName, passportNationality,
                    null, mobilePhone, homePhone, workPhone, address, country, state, zipcode, lastLogin, loginCount,
                    effectiveFromDate, effectiveToDate, isActive, isAdmin, knowUsFrom, liveInShanghai, isStudent,
                    birth, school, hasSchoolAccrediation, speakChinese);
        });
    }

    @Override
    public int addUserProfile(UserProfile userProfile) {
        final String sql = "insert into h2h_user_profile values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, userProfile.getUserId(), userProfile.getGivenName(), userProfile.getFamilyName(),
                userProfile.getPassportId(), userProfile.getPassportName(), userProfile.getPassportNationality(),
                userProfile.getMobilePhone(), userProfile.getHomePhone(), userProfile.getWorkPhone(),
                userProfile.getAddress(), userProfile.getCountry(), userProfile.getState(), userProfile.getZipcode(),
                userProfile.getLastLogin(), userProfile.getLoginCount(),
                userProfile.getEffectiveFromDate(), userProfile.getEffectiveToDate(),
                userProfile.isActive(),userProfile.isAdmin(),
                userProfile.getKnowUsFrom(), userProfile.isLiveInShanghai(),
                userProfile.isStudent(), userProfile.getBirth(), userProfile.getSchool(),
                userProfile.isHasSchoolAccrediation(), userProfile.isSpeakChinese());
        return 1;
    }

    @Override
    public int saveUserProfile(UserProfile userProfile) {
        final String sql = "";
        return 0;
    }

    @Override
    public UserProfile getUserProfile(UUID userId) {
        final String sql = "select * from h2h_user_profile where userId = ?";
        UserProfile userProfile = null;
        try{
            userProfile = jdbcTemplate.queryForObject(sql, new Object[]{userId}, (rs, rowNum) -> {
                Timestamp lastLoginTime = rs.getTimestamp("lastLogin");
                Date lastLogin = lastLoginTime==null ? null : new Date(lastLoginTime.getTime());
                Timestamp effectiveFromTime = rs.getTimestamp("effectiveFromDate");
                Date effectiveFromDate = effectiveFromTime==null ? null : new Date(effectiveFromTime.getTime());
                Timestamp effectiveToTime = rs.getTimestamp("effectiveToDate");
                Date effectiveToDate = effectiveToTime==null ? null : new Date(effectiveToTime.getTime());
                Timestamp birthTime = rs.getTimestamp("birth");
                Date birth = birthTime==null ? null : new Date(birthTime.getTime());
                return new UserProfile(
                        UUID.fromString(rs.getString("userId")),
                        rs.getString("givenName"),
                        rs.getString("familyName"),
                        rs.getString("passportId"),
                        rs.getString("passportName"),
                        rs.getString("passportNationality"),
                        null,
                        rs.getString("mobilePhone"),
                        rs.getString("homePhone"),
                        rs.getString("workPhone"),
                        rs.getString("address"),
                        rs.getString("country"),
                        rs.getString("state"),
                        rs.getString("zipCode"),
                        lastLogin,
                        rs.getLong("loginCount"),
                        effectiveFromDate,
                        effectiveToDate,
                        rs.getBoolean("isActive"),
                        rs.getBoolean("isAdmin"),
                        rs.getString("knowUsFrom"),
                        rs.getBoolean("liveInShanghai"),
                        rs.getBoolean("isStudent"),
                        birth,
                        rs.getString("school"),
                        rs.getBoolean("hasSchoolAccrediation"),
                        rs.getBoolean("speakChinese")
                        );
            });
        } catch (EmptyResultDataAccessException e){
            //todo: log
            System.out.println("no user profile found");
        }
        return userProfile;
    }

    @Override
    public List<CommentOnUser> getCommentsForUser(UUID userId) {
        final String sql = "select * from h2h_comment_on_user where userId = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, (resultSet, i) ->{
            UUID adminId = UUID.fromString(resultSet.getString("adminId"));
            UUID commentId = UUID.fromString(resultSet.getString("commentId"));
            String comment = resultSet.getString("comment");
            Timestamp commentTime = resultSet.getTimestamp("commentTime");
            Date timeOfComment = commentTime==null ? null : new Date(commentTime.getTime());
            return new CommentOnUser(userId, adminId, comment, timeOfComment, commentId);
        });
    }

    @Override
    public List<Volunteer> getVolunteerRolesForUser(UUID userId) {
        final String sql = "select * from h2h_volunteer_info where userId = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, (resultSet, i) ->{
            return new Volunteer(userId,
                    UUID.fromString(resultSet.getString("roleId")),
                    resultSet.getString("roleType"),
                    resultSet.getString("role"),
                    resultSet.getString("roleStatus"));
        });
    }
}