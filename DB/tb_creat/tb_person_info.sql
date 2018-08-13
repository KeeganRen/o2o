use o2o;

create table `tb_person_info`(
	`user_id` int(10) NOT NULL AUTO_INCREMENT,
    `name` varchar(32) DEFAULT NULL,
    `profile_img` varchar(1024) DEFAULT NULL,
    `email` varchar(1024) DEFAULT NULL,
    `gender` varchar(2) DEFAULT NULL,
    `enable_status` varchar(2) NOT NULL DEFAULT '0' COMMENT '0:禁止使用本商城, 1:允许使用本商城',
    `user_type` varchar(2) NOT NULL DEFAULT '1' COMMENT '1:顾客, 2:店家, 3:超级管理员',
    `create_time` datetime DEFAULT NULL,
    `last_edit_time` datetime DEFAULT NULL,
    primary key (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
