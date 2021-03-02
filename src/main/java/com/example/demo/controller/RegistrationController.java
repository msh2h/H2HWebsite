package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("api/login")
@RestController
@CrossOrigin
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/registeruser")
    public User registerUser(@RequestBody User user) throws Exception{
        String tempEmail = user.getEmail();
        if(tempEmail != null && !"".equals(tempEmail)) {
            User userObj = registrationService.fetchUserByEmail(tempEmail);
            if(userObj != null){
                throw new Exception("user with " + tempEmail + " already exists");
            }
        }
        User userObj = null;
        userObj = registrationService.saveUser(user);
        return userObj;
    }

    @PostMapping("/login")
    public User loginUser (@RequestBody User user) throws Exception {
        //todo: save lastLogIn and loginCount if userProfile exists
        String tempEmail = user.getEmail();
        String tempPassword = user.getPassword();
        User userObj = null;
        if(tempEmail != null && tempPassword != null) {
            userObj = registrationService.fetchUserByEmailAndPassword(tempEmail, tempPassword);
        }
        if(userObj == null) {
            throw new Exception("bad credentials");
        }
        return userObj;
    }

}
