use o2o;

create table `tb_head_line`(
	`line_id` int(100) NOT NULL AUTO_INCREMENT,
    `line_name` varchar(1000) DEFAULT NULL,
    `line_link` varchar(2000) NOT NULL,
    `line_img` varchar(2000) NOT NULL,
    `priority` int(2) DEFAULT NULL,
    `enable_status` int(2) NOT NULL DEFAULT '0',
    `create_time` datetime DEFAULT NULL,
    `last_edit_time` datetime DEFAULT NULL,
    primary key (`line_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
