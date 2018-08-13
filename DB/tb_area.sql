use o2o;

create table `tb_area`(
	`area_id` int(2) NOT NULL AUTO_INCREMENT,
    `area_name` varchar(200) NOT NULL,
    `priority` int(2) NOT NULL DEFAULT '0',
    `create_time` datetime DEFAULT NULL,
    `last_edit_time` datetime DEFAULT NULL,
    primary key (`area_id`),
    unique key `UK_AREA`(`area_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
