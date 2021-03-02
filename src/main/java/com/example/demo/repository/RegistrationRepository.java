package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RegistrationRepository  {
    //extends JpaRepository<User, UUID>
    public User findByEmail(String email);
    public User findByEmailAndPassword(String email, String password);
}
