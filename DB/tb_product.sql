use o2o;

create table `tb_product`(
	`product_id` int(100) NOT NULL AUTO_INCREMENT,
    `product_name` varchar(100) NOT NULL,
	`product_desc` varchar(2000) DEFAULT NULL,
    `img_addr` varchar(2000) DEFAULT '',
    `normal_price` varchar(100) DEFAULT NULL,
    `promotion_price` varchar(100) DEFAULT NULL,
	`priority` int(2) NOT NULL DEFAULT '0',
    `create_time` datetime DEFAULT NULL,
	`last_edit_time` datetime DEFAULT NULL,
    `enable_status` int(2) NOT NULL DEFAULT '0',
    `product_category_id` int(11) DEFAULT NULL,
    `shop_id` int(20) NOT NULL DEFAULT '0',
    primary key (`product_id`),
    constraint `fk_product_procate` foreign key(`product_category_id`) references `tb_product_category`(`product_category_id`),
    constraint `fk_product_product` foreign key(`shop_id`) references `tb_shop`(`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
