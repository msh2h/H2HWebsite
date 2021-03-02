package com.example.demo.Dao;

import com.example.demo.model.User;
import com.example.demo.model.Volunteer;
import com.example.demo.model.VolunteerGeneral;

import java.util.List;

public interface VolunteerDao {
    public List<VolunteerGeneral> getAllVolunteerGeneral();
    public Volunteer saveVolunteer(Volunteer volunteer);
}
