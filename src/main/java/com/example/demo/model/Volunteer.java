package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@IdClass(VolunteerId.class)
public class Volunteer {


    //todo: add role id
    @Id
    private UUID userId;
    private UUID roleId;
    @Id
    private String roleType;
    @Id
    private String role;

    private String status;


    public Volunteer(){}

    public Volunteer(UUID userId, UUID roleId, String roleType, String role, String status) {
        this.userId = userId;
        this.roleId = roleId;
        this.roleType = roleType;
        this.role = role;
        this.status = status;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}