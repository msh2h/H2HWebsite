package com.example.demo.model;

import java.util.UUID;

public class VolunteerGeneral {
    private UUID userId;
    private String name;
    private String status;
    private String roleType;
    private String role;
    private String roleStatus;
    private String email;
    private String phone;

    public VolunteerGeneral(UUID userId, String name, String status, String roleType, String role, String roleStatus, String email, String phone) {
        this.userId = userId;
        this.name = name;
        this.status = status;
        this.roleType = roleType;
        this.role = role;
        this.roleStatus = roleStatus;
        this.email = email;
        this.phone = phone;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(String roleStatus) {
        this.roleStatus = roleStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
