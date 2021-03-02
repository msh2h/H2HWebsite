package com.example.demo.service;

import com.example.demo.Dao.UserDao;
import com.example.demo.Dao.UserProfileDao;
import com.example.demo.model.User;
import com.example.demo.repository.RegistrationRepository;
import com.example.demo.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class RegistrationService {

    private final UserDao userDao;

    @Autowired
    public RegistrationService(@Qualifier("postgresUser") UserDao userDao) {
        this.userDao = userDao;
    }

    public User saveUser(User user){
        user.setUserId(UUID.randomUUID());
        return userDao.saveUser(user);
    }

    public User fetchUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public User fetchUserByEmailAndPassword(String email, String password) {
        return userDao.findByEmailAndPassword(email, password);
    }
}
