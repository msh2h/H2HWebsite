package com.example.demo.Dao;

import com.example.demo.model.CommentOnUser;
import com.example.demo.model.UserProfile;
import com.example.demo.model.Volunteer;

import java.util.List;
import java.util.UUID;

public interface UserProfileDao {
    public List<UserProfile> getAllUsers();
    int addUserProfile(UserProfile userProfile);
    public UserProfile getUserProfile(UUID userId);
    public List<CommentOnUser> getCommentsForUser(UUID userId);
    public List<Volunteer> getVolunteerRolesForUser(UUID userId);
    int saveUserProfile(UserProfile userProfile);
}
