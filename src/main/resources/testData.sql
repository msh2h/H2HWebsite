-- start postgresql, and recreated database before starting spring boot project

psql -U postgres
DROP DATABASE h2hdb;
CREATE DATABASE h2hdb;
\c h2hdb

-- start spring boot project, then tables will be recreated. then insert below test data

insert into h2h_user ('96766bc7-ad13-46fb-a119-f046bfd3ebe8', 'user1@ms.com', 'password1');
insert into h2h_user ('81336373-61e9-46a4-9bbb-630c82352eb8', 'user2@ms.com', 'password2');
insert into h2h_user ('7e7ae8aa-d05e-4d7d-9a73-cb2981473f3c', 'user3@ms.com', 'password3');
insert into h2h_user ('a1bc1553-212e-4912-9ee4-0714d6205974', 'user4@ms.com', 'password4');
insert into h2h_user ('aac834bf-9405-4eb0-8476-0913f5e29b59', 'user5@ms.com', 'password5');
insert into h2h_user ('8288091c-0053-4923-bfb0-26635e78ba58', 'user6@ms.com', 'password6');


select * from h2h_user;


insert into h2h_user_profile values ('96766bc7-ad13-46fb-a119-f046bfd3ebe8', 'one', 'zhao', 'ID1', 'one zhao', 'China', '1111111', null, null,
'street1', 'China', 'Shanghai', '200000', CURRENT_TIMESTAMP, 1, '20200101', '99991231', true, true,
'Web', true, false, '19900101', 'high school', false, true);
insert into h2h_user_profile values ('81336373-61e9-46a4-9bbb-630c82352eb8', 'two', 'qian', 'ID2', 'two qian', 'China', '222222', null, null,
'street2', 'China', 'Shanghai', '200000', CURRENT_TIMESTAMP, 2, '20200201', '99991231', true, false,
'Web', true, true, '19900101', 'high school', true, true);
insert into h2h_user_profile values ('7e7ae8aa-d05e-4d7d-9a73-cb2981473f3c', 'three', 'sun', 'ID3', 'three sun', 'China', '3333333', null, null,
'street3', 'China', 'Shanghai', '200000', CURRENT_TIMESTAMP, 3, '20200301', '99991231', true, false,
'Web', true, true, '19900101', 'high school', true, true);
insert into h2h_user_profile values ('a1bc1553-212e-4912-9ee4-0714d6205974', 'four', 'li', 'ID4', 'four li', 'China', '4444444', null, null,
'street4', 'China', 'Shanghai', '200000', CURRENT_TIMESTAMP, 4, '20200401', '99991231', true, false,
'Web', true, true, '19900101', 'high school', true, true);
insert into h2h_user_profile values ('aac834bf-9405-4eb0-8476-0913f5e29b59', 'five', 'zhou', 'ID5', 'five zhou', 'China', '555555', null, null,
'street5', 'China', 'Shanghai', '200000', CURRENT_TIMESTAMP, 5, '20200501', '99991231', true, false,
'Web', true, true, '19900101', 'high school', true, true);
insert into h2h_user_profile values ('8288091c-0053-4923-bfb0-26635e78ba58', 'six', 'wu', 'ID6', 'six wu', 'China', '666666', null, null,
'street6', 'China', 'Shanghai', '200000', CURRENT_TIMESTAMP, 6, '20200601', '99991231', true, false,
'Web', true, true, '19900101', 'high school', true, true);




insert into h2h_volunteer_info values ('96766bc7-ad13-46fb-a119-f046bfd3ebe8', uuid_generate_v4(), 'Hospital visitor', 'weekend', 'active');
insert into h2h_volunteer_info values ('96766bc7-ad13-46fb-a119-f046bfd3ebe8', uuid_generate_v4(), 'Hospital visitor', 'weekday', 'inactive');
insert into h2h_volunteer_info values ('96766bc7-ad13-46fb-a119-f046bfd3ebe8', uuid_generate_v4(), 'Helping Hand', 'weekend', 'pending');
insert into h2h_volunteer_info values ('96766bc7-ad13-46fb-a119-f046bfd3ebe8', uuid_generate_v4(), 'Helping Hand', 'weekend', 'rejected');
insert into h2h_volunteer_info values ('81336373-61e9-46a4-9bbb-630c82352eb8', uuid_generate_v4(), 'Hospital visitor', 'weekend', 'active');
insert into h2h_volunteer_info values ('81336373-61e9-46a4-9bbb-630c82352eb8', uuid_generate_v4(), 'Hospital visitor', 'weekday', 'inactive');
insert into h2h_volunteer_info values ('81336373-61e9-46a4-9bbb-630c82352eb8', uuid_generate_v4(), 'Helping Hand', 'weekend', 'inactive');
insert into h2h_volunteer_info values ('81336373-61e9-46a4-9bbb-630c82352eb8', uuid_generate_v4(), 'Helping Hand', 'weekend', 'pending');
insert into h2h_volunteer_info values ('7e7ae8aa-d05e-4d7d-9a73-cb2981473f3c', uuid_generate_v4(), 'Hospital visitor', 'weekend', 'inactive');
insert into h2h_volunteer_info values ('7e7ae8aa-d05e-4d7d-9a73-cb2981473f3c', uuid_generate_v4(), 'Hospital visitor', 'weekday', 'active');
insert into h2h_volunteer_info values ('7e7ae8aa-d05e-4d7d-9a73-cb2981473f3c', uuid_generate_v4(), 'Helping Hand', 'weekend', 'pending');
insert into h2h_volunteer_info values ('7e7ae8aa-d05e-4d7d-9a73-cb2981473f3c', uuid_generate_v4(), 'Helping Hand', 'weekend', 'active');
insert into h2h_volunteer_info values ('a1bc1553-212e-4912-9ee4-0714d6205974', uuid_generate_v4(), 'Hospital visitor', 'weekend', 'active');
insert into h2h_volunteer_info values ('a1bc1553-212e-4912-9ee4-0714d6205974', uuid_generate_v4(), 'Hospital visitor', 'weekday', 'inactive');
insert into h2h_volunteer_info values ('a1bc1553-212e-4912-9ee4-0714d6205974', uuid_generate_v4(), 'Helping Hand', 'weekend', 'rejected');
insert into h2h_volunteer_info values ('a1bc1553-212e-4912-9ee4-0714d6205974', uuid_generate_v4(), 'Helping Hand', 'weekend', 'pending');
insert into h2h_volunteer_info values ('aac834bf-9405-4eb0-8476-0913f5e29b59', uuid_generate_v4(), 'Hospital visitor', 'weekend', 'active');
insert into h2h_volunteer_info values ('aac834bf-9405-4eb0-8476-0913f5e29b59', uuid_generate_v4(), 'Hospital visitor', 'weekday', 'active');
insert into h2h_volunteer_info values ('aac834bf-9405-4eb0-8476-0913f5e29b59', uuid_generate_v4(), 'Helping Hand', 'weekend', 'active');
insert into h2h_volunteer_info values ('aac834bf-9405-4eb0-8476-0913f5e29b59', uuid_generate_v4(), 'Helping Hand', 'weekend', 'inactive');
insert into h2h_volunteer_info values ('8288091c-0053-4923-bfb0-26635e78ba58', uuid_generate_v4(), 'Hospital visitor', 'weekend', 'active');
insert into h2h_volunteer_info values ('8288091c-0053-4923-bfb0-26635e78ba58', uuid_generate_v4(), 'Hospital visitor', 'weekday', 'active');
insert into h2h_volunteer_info values ('8288091c-0053-4923-bfb0-26635e78ba58', uuid_generate_v4(), 'Helping Hand', 'weekend', 'rejected');
insert into h2h_volunteer_info values ('8288091c-0053-4923-bfb0-26635e78ba58', uuid_generate_v4(), 'Helping Hand', 'weekend', 'rejected');


insert into h2h_comment_on_user values ('81336373-61e9-46a4-9bbb-630c82352eb8', '96766bc7-ad13-46fb-a119-f046bfd3ebe8', uuid_generate_v4(), CURRENT_TIMESTAMP, 'activated');
insert into h2h_comment_on_user values ('81336373-61e9-46a4-9bbb-630c82352eb8', '96766bc7-ad13-46fb-a119-f046bfd3ebe8', uuid_generate_v4(), CURRENT_TIMESTAMP, 'good');
insert into h2h_comment_on_user values ('81336373-61e9-46a4-9bbb-630c82352eb8', '96766bc7-ad13-46fb-a119-f046bfd3ebe8', uuid_generate_v4(), CURRENT_TIMESTAMP, 'hello world');
insert into h2h_comment_on_user values ('7e7ae8aa-d05e-4d7d-9a73-cb2981473f3c', '96766bc7-ad13-46fb-a119-f046bfd3ebe8', uuid_generate_v4(), CURRENT_TIMESTAMP, 'hello user3');
