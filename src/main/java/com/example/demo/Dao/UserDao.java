package com.example.demo.Dao;

import com.example.demo.model.User;

public interface UserDao {
    public User findByEmail(String email);
    public User findByEmailAndPassword(String email, String password);
    public User saveUser(User user);
}
