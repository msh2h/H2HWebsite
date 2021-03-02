CREATE TABLE h2h_volunteer_info (
    userId UUID NOT NULL,
    roleId UUID NOT NULL PRIMARY KEY,
    roleType VARCHAR(50) NOT NULL,
    role VARCHAR(50) NOT NULL,
    roleStatus VARCHAR(20) NOT NULL
);