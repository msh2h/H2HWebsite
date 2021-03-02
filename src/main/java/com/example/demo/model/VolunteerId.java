package com.example.demo.model;

import java.io.Serializable;
import java.util.UUID;

public class VolunteerId implements Serializable {
    private UUID userId;
    private String roleType;
    private String role;

    /*
    public VolunteerId(){}

    public VolunteerId(UUID userId, String roleType, String role) {
        this.userId = userId;
        this.roleType = roleType;
        this.role = role;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
     */
}
