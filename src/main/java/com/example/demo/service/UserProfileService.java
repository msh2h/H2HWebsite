package com.example.demo.service;

import com.example.demo.Dao.UserDao;
import com.example.demo.Dao.UserProfileDao;
import com.example.demo.model.CommentOnUser;
import com.example.demo.model.User;
import com.example.demo.model.UserProfile;
import com.example.demo.model.Volunteer;
import com.example.demo.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserProfileService {

    private final UserProfileDao userProfileDao;
    private final UserDao userDao;

    @Autowired
    public UserProfileService(@Qualifier("postgresUserProfile") UserProfileDao userProfileDao, @Qualifier("postgresUser") UserDao userDao) {
        this.userProfileDao = userProfileDao;
        this.userDao = userDao;
    }

    public int saveUserProfile(UserProfile userProfile){
        return userProfileDao.saveUserProfile(userProfile);
    }

    public List<UserProfile> getAllUsers(){
        return userProfileDao.getAllUsers();
    }

    public UserProfile getUserProfile(UUID userId){
        UserProfile userProfile = userProfileDao.getUserProfile(userId);
        User user = userDao.findByUserId(userId);
        if(userProfile!=null){
            userProfile.setComments(userProfileDao.getCommentsForUser(userId));
            userProfile.setVolunteerRoles(userProfileDao.getVolunteerRolesForUser(userId));
            if(user!=null){
                userProfile.setEmail(user.getEmail());
            }
        }
        return userProfile;
    }

    public int addUserProfile(UserProfile userProfile) throws Exception{
        userProfile.setLastLogin(new Date());
        userProfile.setLoginCount(0L);
        userProfile.setEffectiveFromDate(new Date());
        userProfile.setEffectiveToDate(new SimpleDateFormat("yyyyMMdd").parse("99991231"));
        userProfile.setActive(false);
        userProfile.setAdmin(false);
        return userProfileDao.addUserProfile(userProfile);
    }
}