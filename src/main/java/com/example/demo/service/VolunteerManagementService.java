package com.example.demo.service;

import com.example.demo.Dao.VolunteerDao;
import com.example.demo.model.Volunteer;
import com.example.demo.model.VolunteerGeneral;
import com.example.demo.repository.VolunteerRepository;
import javafx.scene.shape.VLineTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class VolunteerManagementService {

    private final VolunteerDao volunteerDao;

    @Autowired
    public VolunteerManagementService(@Qualifier("postgresVolunteer") VolunteerDao volunteerDao) {
        this.volunteerDao = volunteerDao;
    }

    public Volunteer saveVolunteer(Volunteer volunteer){
        //todo: log
        System.out.println("volunteer service saving volunteer with user id " + volunteer.getUserId());
        volunteer.setRoleId(UUID.randomUUID());
        return volunteerDao.saveVolunteer(volunteer);
    }

    //volunteer role status: pending, active, inactive, rejected
    //user status: active, inactive
    public List<VolunteerGeneral> getAllVolunteerGeneral(){
        List<VolunteerGeneral> volunteers = volunteerDao.getAllVolunteerGeneral();
        return volunteers;
    }
}

/*
private UUID userId;
    private String name;
    private String status;
    private String roleType;
    private String role;
    private String roleStatus;
    private String email;
    private String phone;
 */