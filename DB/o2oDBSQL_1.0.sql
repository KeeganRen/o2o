-- mysql  Ver 14.14 Distrib 5.7.23, for Linux (x86_64) using  EditLine wrapper
--
-- Host: localhost    Database: o2odb
-- ------------------------------------------------------
-- Server version	5.7.23-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_area`
--

DROP TABLE IF EXISTS `tb_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
create table `tb_area`(
	`area_id` int(2) NOT NULL AUTO_INCREMENT,
    `area_name` varchar(200) NOT NULL,
    `priority` int(2) NOT NULL DEFAULT '0',
    `create_time` datetime DEFAULT NULL,
    `last_edit_time` datetime DEFAULT NULL,
    primary key (`area_id`),
    unique key `UK_AREA`(`area_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_area`
--

LOCK TABLES `tb_area` WRITE;
/*!40000 ALTER TABLE `tb_area` DISABLE KEYS */;
INSERT INTO `o2o`.`tb_area`(`area_id`, `area_name`, `priority`, `create_time`, `last_edit_time`) VALUES(2, '东苑', 1, null, null);
INSERT INTO `o2o`.`tb_area`(`area_id`, `area_name`, `priority`, `create_time`, `last_edit_time`) VALUES(3, '西苑', 2, null, null);
/*!40000 ALTER TABLE `tb_area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_head_line`
--

DROP TABLE IF EXISTS `tb_head_line`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_local_auth`
--

DROP TABLE IF EXISTS `tb_local_auth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_local_auth` (
  `local_auth_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL,
  `user_name` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  PRIMARY KEY (`local_auth_id`),
  UNIQUE KEY `uk_local_profile` (`user_name`),
  KEY `fk_local_profile` (`user_id`),
  CONSTRAINT `fk_local_profile` FOREIGN KEY (`user_id`) REFERENCES `tb_person_info` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_person_info`
--

DROP TABLE IF EXISTS `tb_person_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_person_info`
--

LOCK TABLES `tb_person_info` WRITE;
/*!40000 ALTER TABLE `tb_person_info` DISABLE KEYS */;
INSERT INTO `o2o`.`tb_person_info` (`name`, `profile_img`, `email`, `gender`, `enable_status`, `user_type`) VALUES ('测试', 'test', 'test', '1', '1', '2');
INSERT INTO `o2o`.`tb_person_info` (`name`, `profile_img`, `email`, `gender`, `enable_status`, `user_type`) VALUES ('测试2', 'test', 'test', '1', '1', '2');
INSERT INTO `o2o`.`tb_person_info` (`name`, `profile_img`, `email`, `gender`, `enable_status`, `user_type`) VALUES ('任亲虎', 'img', 'renqinhu@gmail.com', '1', '1', '2');

/*!40000 ALTER TABLE `tb_person_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_product`
--

DROP TABLE IF EXISTS `tb_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_product_category`
--

DROP TABLE IF EXISTS `tb_product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
create table `tb_product_category`(
	`product_category_id` int(11) NOT NULL AUTO_INCREMENT,
    `product_category_name` varchar(100) NOT NULL,
	`priority` int(2) DEFAULT '0',
    `create_time` datetime DEFAULT NULL,
    `shop_id` int(20) NOT NULL DEFAULT '0',
    primary key (`product_category_id`),
    constraint `fk_procate_shop` foreign key(`shop_id`) references `tb_shop`(`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_product_category`
--

LOCK TABLES `tb_product_category` WRITE;
/*!40000 ALTER TABLE `tb_product_category` DISABLE KEYS */;
INSERT INTO `o2o`.`tb_product_category` (`product_category_id`, `product_category_name`, `priority`, `shop_id`) VALUES ('1', '面条', '0', '1');
INSERT INTO `o2o`.`tb_product_category` (`product_category_id`, `product_category_name`, `priority`, `shop_id`) VALUES ('2', '米饭', '20', '1');
INSERT INTO `o2o`.`tb_product_category` (`product_category_id`, `product_category_name`, `priority`, `shop_id`) VALUES ('3', '粥', '2', '1');
INSERT INTO `o2o`.`tb_product_category` (`product_category_id`, `product_category_name`, `priority`, `shop_id`) VALUES ('4', '炒饭', '5', '2');
/*!40000 ALTER TABLE `tb_product_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_product_img`
--

DROP TABLE IF EXISTS `tb_product_img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
create table `tb_product_img`(
	`product_img_id` int(20) NOT NULL AUTO_INCREMENT,
    `img_addr` varchar(2000) NOT NULL,
    `img_desc` varchar(2000) NOT NULL,
	`priority` int(2) DEFAULT '0',
    `create_time` datetime DEFAULT NULL,
    `product_id` int(20) DEFAULT NULL,
    primary key (`product_img_id`),
    constraint `fk_proimg_product` foreign key(`product_id`) references `tb_product`(`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_shop`
--

DROP TABLE IF EXISTS `tb_shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_shop_category`
--

DROP TABLE IF EXISTS `tb_shop_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_shop_category`
--

LOCK TABLES `tb_shop_category` WRITE;
/*!40000 ALTER TABLE `tb_shop_category` DISABLE KEYS */;
LOCK TABLES `tb_shop_category` WRITE;
/*!40000 ALTER TABLE `tb_shop_category` DISABLE KEYS */;
INSERT INTO `tb_shop_category` VALUES 
(10,'二手市场','二手商品交易','/upload/item/shopcategory/2017061223272255687.png',100,'2017-06-04 20:10:58','2017-06-12 23:27:22',NULL),
(11,'美容美发','美容美发','/upload/item/shopcategory/2017061223273314635.png',99,'2017-06-04 20:12:57','2017-06-12 23:27:33',NULL),
(12,'美食饮品','美食饮品','/upload/item/shopcategory/2017061223274213433.png',98,'2017-06-04 20:15:21','2017-06-12 23:27:42',NULL),
(13,'休闲娱乐','休闲娱乐','/upload/item/shopcategory/2017061223275121460.png',97,'2017-06-04 20:19:29','2017-06-12 23:27:51',NULL),
(14,'旧车','旧车','/upload/item/shopcategory/2017060420315183203.png',80,'2017-06-04 20:31:51','2017-06-04 20:31:51',10),
(15,'二手书籍','二手书籍','/upload/item/shopcategory/2017060420322333745.png',79,'2017-06-04 20:32:23','2017-06-04 20:32:23',10),
(17,'护理','护理','/upload/item/shopcategory/2017060420372391702.png',76,'2017-06-04 20:37:23','2017-06-04 20:37:23',11),
(18,'理发','理发','/upload/item/shopcategory/2017060420374775350.png',74,'2017-06-04 20:37:47','2017-06-04 20:37:47',11),
(20,'大排档','大排档','/upload/item/shopcategory/2017060420460491494.png',59,'2017-06-04 20:46:04','2017-06-04 20:46:04',12),
(22,'奶茶店','奶茶店','/upload/item/shopcategory/2017060420464594520.png',58,'2017-06-04 20:46:45','2017-06-04 20:46:45',12),
(24,'密室逃生','密室逃生','/upload/item/shopcategory/2017060420500783376.png',56,'2017-06-04 20:50:07','2017-06-04 21:45:53',13),
(25,'KTV','KTV','/upload/item/shopcategory/2017060420505834244.png',57,'2017-06-04 20:50:58','2017-06-04 20:51:14',13),
(27,'培训教育','培训教育','/upload/item/shopcategory/2017061223280082147.png',96,'2017-06-04 21:51:36','2017-06-12 23:28:00',NULL),
(28,'租赁市场','租赁市场','/upload/item/shopcategory/2017061223281361578.png',95,'2017-06-04 21:53:52','2017-06-12 23:28:13',NULL),
(29,'程序设计','程序设计','/upload/item/shopcategory/2017060421593496807.png',50,'2017-06-04 21:59:34','2017-06-04 21:59:34',27),
(30,'声乐舞蹈','声乐舞蹈','/upload/item/shopcategory/2017060421595843693.png',49,'2017-06-04 21:59:58','2017-06-04 21:59:58',27),
(31,'演出道具','演出道具','/upload/item/shopcategory/2017060422114076152.png',45,'2017-06-04 22:11:40','2017-06-04 22:11:40',28),
(32,'交通工具','交通工具','/upload/item/shopcategory/2017060422121144586.png',44,'2017-06-04 22:12:11','2017-06-04 22:12:11',28);
/*!40000 ALTER TABLE `tb_shop_category` ENABLE KEYS */;
UNLOCK TABLES;/*!40000 ALTER TABLE `tb_shop_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_wechat_auth`
--

DROP TABLE IF EXISTS `tb_wechat_auth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
create table `tb_wechat_auth`(
	`wechat_auth_id` int(10) NOT NULL AUTO_INCREMENT,
    `user_id` int(10) NOT NULL,
    `open_id` varchar(1024) NOT NULL,
    `create_time` datetime DEFAULT NULL,
    primary key (`wechat_auth_id`),
    constraint `fk_wechatauth_profile` foreign key(`user_id`) references `tb_person_info`(`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
alter table tb_wechat_auth add unique index(open_id);
/*!40101 SET character_set_client = @saved_cs_client */;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-07 23:06:03
