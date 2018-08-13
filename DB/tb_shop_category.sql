use o2o;

create table `tb_shop_category`(
	`shop_category_id` int(11) NOT NULL AUTO_INCREMENT,
    `shop_category_name` varchar(100) DEFAULT NULL,
    `shop_category_desc` varchar(1000) NOT NULL,
    `shop_category_img` varchar(2000) NOT NULL,
    `priority` int(2) NOT NULL DEFAULT '0',
    `create_time` datetime DEFAULT NULL,
    `last_edit_time` datetime DEFAULT NULL,
    `parent_id` int(11) DEFAULT NULL,
    primary key (`shop_category_id`),
    constraint `fk_shop_category_self` foreign key(`parent_id`) references `tb_shop_category`(`shop_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
