package com.example.demo.controller;

import com.example.demo.model.UserProfile;
import com.example.demo.model.Volunteer;
import com.example.demo.model.VolunteerGeneral;
import com.example.demo.service.VolunteerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/volunteer")
@RestController
@CrossOrigin
public class VolunteerManagementController {

    @Autowired
    private VolunteerManagementService volunteerManagementService;

    @PostMapping("/addVolunteerRole")
    public Volunteer addVolunteerRole(@RequestBody Volunteer volunteer) throws Exception{
        System.out.println("volunteer controller saving user " + volunteer.getUserId() + " for role type " + volunteer.getRoleType());
        Volunteer savedVolunteer = volunteerManagementService.saveVolunteer(volunteer);
        System.out.println("volunteer controller saved volunteer: " + savedVolunteer);
        return savedVolunteer;
    }

    @GetMapping("/getAllVolunteerGeneral")
    public List<VolunteerGeneral> getAllVolunteerGeneral(){
        return volunteerManagementService.getAllVolunteerGeneral();
    }
}
