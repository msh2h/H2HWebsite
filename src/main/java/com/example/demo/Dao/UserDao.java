package com.example.demo.Dao;

import com.example.demo.model.User;

import java.util.UUID;

public interface UserDao {
    public User findByEmail(String email);
    public User findByUserId(UUID userId);
    public User findByEmailAndPassword(String email, String password);
    public User saveUser(User user);
}
