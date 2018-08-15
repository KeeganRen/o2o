INSERT INTO `o2o`.`tb_person_info` (`name`, `profile_img`, `email`, `gender`, `enable_status`, `user_type`) VALUES ('测试', 'test', 'test', '1', '1', '2');
INSERT INTO `o2o`.`tb_person_info` (`name`, `profile_img`, `email`, `gender`, `enable_status`, `user_type`) VALUES ('测试2', 'test', 'test', '1', '1', '2');
INSERT INTO `o2o`.`tb_person_info` (`name`, `profile_img`, `email`, `gender`, `enable_status`, `user_type`) VALUES ('任亲虎', 'img', 'renqinhu@gmail.com', '1', '1', '2');

SELECT `tb_person_info`.`user_id`,
    `tb_person_info`.`name`,
    `tb_person_info`.`profile_img`,
    `tb_person_info`.`email`,
    `tb_person_info`.`gender`,
    `tb_person_info`.`enable_status`,
    `tb_person_info`.`user_type`,
    `tb_person_info`.`create_time`,
    `tb_person_info`.`last_edit_time`
FROM `o2o`.`tb_person_info`;
