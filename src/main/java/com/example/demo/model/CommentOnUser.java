package com.example.demo.model;

import java.util.Date;
import java.util.UUID;

public class CommentOnUser {
    private UUID userId;
    private UUID adminId;
    private UUID commentId;
    private String comment;
    private Date commentTime;

    public CommentOnUser(){}

    public CommentOnUser(UUID userId, UUID adminId, String comment, Date commentTime, UUID commentId) {
        this.userId = userId;
        this.adminId = adminId;
        this.comment = comment;
        this.commentTime = commentTime;
        this.commentId = commentId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getAdminId() {
        return adminId;
    }

    public void setAdminId(UUID adminId) {
        this.adminId = adminId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCommentTIme() {
        return commentTime;
    }

    public void setCommentTIme(Date commentTIme) {
        this.commentTime = commentTime;
    }

    public UUID getCommentId() {
        return commentId;
    }

    public void setCommentId(UUID commentId) {
        this.commentId = commentId;
    }
}
