use o2o;

create table `tb_wechat_auth`(
	`wechat_auth_id` int(10) NOT NULL AUTO_INCREMENT,
    `user_id` int(10) NOT NULL,
    `open_id` varchar(1024) NOT NULL,
    `create_time` datetime DEFAULT NULL,
    primary key (`wechat_auth_id`),
    constraint `fk_wechatauth_profile` foreign key(`user_id`) references `tb_person_info`(`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

alter table tb_wechat_auth add unique index(open_id);