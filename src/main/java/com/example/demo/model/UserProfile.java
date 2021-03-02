package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UserProfile {

    @Id
    private UUID userId;
    private String givenName;
    private String familyName;
    private String passportId;
    private String passportName;
    private String passportNationality;
    private String mobilePhone;
    private String homePhone;
    //no need of workphone
    private String workPhone;
    //address means street etc
    private String address;
    private String country;
    private String state;
    //no need of zipcode
    private String zipcode;

    private Date lastLogin;
    private long loginCount;
    private Date effectiveFromDate;
    private Date effectiveToDate;
    private boolean isActive;
    private boolean isAdmin;
    //todo: add comment table maybe
    private String knowUsFrom;
    private boolean liveInShanghai;
    private boolean isStudent;
    private Date birth;
    private String school;
    private boolean hasSchoolAccrediation;
    private boolean speakChinese;
    private List<CommentOnUser> comments;
    private List<Volunteer> volunteerRoles;


    public UserProfile(){}

    public UserProfile(@JsonProperty("userId") UUID userId,
                       @JsonProperty("givenName") String givenName,
                       @JsonProperty("familyName") String familyName,
                       @JsonProperty("passportId") String passportId,
                       @JsonProperty("passportName") String passportName,
                       @JsonProperty("passportNationality") String passportNationality,
                       @JsonProperty("mobilePhone") String mobilePhone,
                       @JsonProperty("homePhone") String homePhone,
                       @JsonProperty("workPhone") String workPhone,
                       @JsonProperty("address") String address,
                       @JsonProperty("country") String country,
                       @JsonProperty("state") String state,
                       @JsonProperty("zipcode") String zipcode,
                       @JsonProperty("lastLogin") Date lastLogin,
                       @JsonProperty("loginCount") long loginCount,
                       @JsonProperty("effectiveFromDate") Date effectiveFromDate,
                       @JsonProperty("effectiveToDate") Date effectiveToDate,
                       @JsonProperty("isActive") boolean isActive,
                       @JsonProperty("isAdmin") boolean isAdmin,
                       @JsonProperty("knowUsFrom") String knowUsFrom,
                       @JsonProperty("liveInShanghai") boolean liveInShanghai,
                       @JsonProperty("isStudent") boolean isStudent,
                       @JsonProperty("birth") Date birth,
                       @JsonProperty("school") String school,
                       @JsonProperty("hasSchoolAccrediation") boolean hasSchoolAccrediation,
                       @JsonProperty("speakChinese") boolean speakChinese) {
        this.userId = userId;
        this.givenName = givenName;
        this.familyName = familyName;
        this.passportId = passportId;
        this.passportName = passportName;
        this.passportNationality = passportNationality;
        this.mobilePhone = mobilePhone;
        this.homePhone = homePhone;
        this.workPhone = workPhone;
        this.address = address;
        this.country = country;
        this.state = state;
        this.zipcode = zipcode;
        this.lastLogin = lastLogin;
        this.loginCount = loginCount;
        this.effectiveFromDate = effectiveFromDate;
        this.effectiveToDate = effectiveToDate;
        this.isActive = isActive;
        this.isAdmin = isAdmin;
        this.knowUsFrom = knowUsFrom;
        this.liveInShanghai = liveInShanghai;
        this.isStudent = isStudent;
        this.birth = birth;
        this.school = school;
        this.hasSchoolAccrediation = hasSchoolAccrediation;
        this.speakChinese = speakChinese;
        this.comments = new ArrayList<>();
        this.volunteerRoles = new ArrayList<>();
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public String getPassportName() {
        return passportName;
    }

    public void setPassportName(String passportName) {
        this.passportName = passportName;
    }

    public String getPassportNationality() {
        return passportNationality;
    }

    public void setPassportNationality(String passportNationality) {
        this.passportNationality = passportNationality;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public long getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(long loginCount) {
        this.loginCount = loginCount;
    }

    public Date getEffectiveFromDate() {
        return effectiveFromDate;
    }

    public void setEffectiveFromDate(Date effectiveFromDate) {
        this.effectiveFromDate = effectiveFromDate;
    }

    public Date getEffectiveToDate() {
        return effectiveToDate;
    }

    public void setEffectiveToDate(Date effectiveToDate) {
        this.effectiveToDate = effectiveToDate;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getKnowUsFrom() {
        return knowUsFrom;
    }

    public void setKnowUsFrom(String knowUsFrom) {
        this.knowUsFrom = knowUsFrom;
    }

    public boolean isLiveInShanghai() {
        return liveInShanghai;
    }

    public void setLiveInShanghai(boolean liveInShanghai) {
        this.liveInShanghai = liveInShanghai;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public boolean isHasSchoolAccrediation() {
        return hasSchoolAccrediation;
    }

    public void setHasSchoolAccrediation(boolean hasSchoolAccrediation) {
        this.hasSchoolAccrediation = hasSchoolAccrediation;
    }

    public List<CommentOnUser> getComments() {
        return comments;
    }

    public void setComments(List<CommentOnUser> comments) {
        this.comments = comments;
    }

    public List<Volunteer> getVolunteerRoles() {
        return volunteerRoles;
    }

    public void setVolunteerRoles(List<Volunteer> volunteerRoles) {
        this.volunteerRoles = volunteerRoles;
    }

    public boolean isSpeakChinese() {
        return speakChinese;
    }

    public void setSpeakChinese(boolean speakChinese) {
        this.speakChinese = speakChinese;
    }
}
