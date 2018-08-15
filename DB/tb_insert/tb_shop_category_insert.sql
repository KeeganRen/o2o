SELECT `tb_shop_category`.`shop_category_id`,
    `tb_shop_category`.`shop_category_name`,
    `tb_shop_category`.`shop_category_desc`,
    `tb_shop_category`.`shop_category_img`,
    `tb_shop_category`.`priority`,
    `tb_shop_category`.`create_time`,
    `tb_shop_category`.`last_edit_time`,
    `tb_shop_category`.`parent_id`
FROM `o2o`.`tb_shop_category`;

INSERT INTO `o2o`.`tb_shop_category` (`shop_category_id`, `shop_category_name`, `shop_category_desc`, `shop_category_img`, `priority`) VALUES ('1', '咖啡奶茶', '咖啡奶茶', 'test', '1');

