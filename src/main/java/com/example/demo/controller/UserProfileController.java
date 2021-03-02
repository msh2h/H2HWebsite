package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.UserProfile;
import com.example.demo.service.RegistrationService;
import com.example.demo.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@RequestMapping("api/user")
@RestController
@CrossOrigin
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    //todo: examine below
    @PostMapping("/editUserProfile")
    public int editUserProfile(@RequestBody UserProfile userProfile) throws Exception{
        UUID userId = userProfile.getUserId();
        if(userId == null || "".equals(userId)) {
            throw new Exception("user id does not exist");
        }
        UserProfile tempUserProfile = userProfileService.getUserProfile(userId);
        if(tempUserProfile == null){
            throw new Exception("user of id" + userId + " does not exist");
        }
        return userProfileService.saveUserProfile(userProfile);
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to H2H";
    }

    @GetMapping("/getAllUserProfile")
    public List<UserProfile> getAllUsers() {
        //will not fetch comments and volunteer roles
        return userProfileService.getAllUsers();
    }

    @PostMapping("/addUserProfile")
    public int addUserProfile(@RequestBody UserProfile userProfile) throws Exception{
        UUID userId = userProfile.getUserId();
        if(userId == null) {
            throw new Exception("user id does not exist");
        }
        return userProfileService.addUserProfile(userProfile);
    }

    @GetMapping("/getUserProfile")
    public UserProfile getUserProfile(@RequestParam String userId) throws Exception{
        return userProfileService.getUserProfile(UUID.fromString(userId));
    }
}
