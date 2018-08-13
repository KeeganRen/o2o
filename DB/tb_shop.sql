use o2o;

create table `tb_shop`(
	`shop_id` int(10) NOT NULL AUTO_INCREMENT,
    `owner_id`  int(10) NOT NULL COMMENT '店铺创建人',
    `area_id` int(5) DEFAULT NULL,
    `shop_category_id` int(11) DEFAULT NULL,
    `shop_name` varchar(256) NOT NULL,
    `shop_desc` varchar(1024) DEFAULT NULL,
    `shop_addr` varchar(200) DEFAULT NULL,
    `phone` varchar(128) DEFAULT NULL,
    `shop_img` varchar(1024) DEFAULT NULL,
    `priority` int(3) DEFAULT '0',
    `create_time` datetime DEFAULT NULL,
    `last_edit_time` datetime DEFAULT NULL,
    `enable_status` int(2) NOT NULL DEFAULT '0',
    `advice` varchar(255) DEFAULT NULL,
    primary key (`shop_id`),
    constraint `fk_shop_area` foreign key(`area_id`) references `tb_area`(`area_id`),
    constraint `fk_shop_profile` foreign key(`owner_id`) references `tb_person_info`(`user_id`),
    constraint `fk_shop_shopcate` foreign key(`shop_category_id`) references `tb_shop_category`(`shop_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
