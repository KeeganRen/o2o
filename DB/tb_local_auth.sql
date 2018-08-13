use o2o;

create table `tb_local_auth`(
	`local_auth_id` int(10) NOT NULL AUTO_INCREMENT,
    `user_id` int(10) NOT NULL,
    `username` varchar(128) NOT NULL,
	`password` varchar(128) NOT NULL,
    `create_time` datetime DEFAULT NULL,
    `last_edit_time` datetime DEFAULT NULL,
    primary key (`local_auth_id`),
    unique key `uk_local_profile`(`username`),
    constraint `fk_localauth_profile` foreign key(`user_id`) references `tb_person_info`(`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
