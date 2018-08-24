use o2o;

SELECT * FROM o2o.tb_area;

SELECT area_id, area_name, priority, create_time, last_edit_time
FROM tb_area
ORDER BY priority DESC;
        

INSERT INTO `o2o`.`tb_area`(`area_id`, `area_name`, `priority`, `create_time`, `last_edit_time`) VALUES(2, '东苑', 1, null, null);
INSERT INTO `o2o`.`tb_area`(`area_id`, `area_name`, `priority`, `create_time`, `last_edit_time`) VALUES(3, '西苑', 2, null, null);