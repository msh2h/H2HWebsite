CREATE TABLE h2h_comment_on_user (
    userId UUID NOT NULL,
    adminId UUID NOT NULL,
    commentId UUID NOT NULL PRIMARY KEY,
    commentTime TIMESTAMP NOT NULL,
    comment VARCHAR(300) NOT NULL
);