/*
Navicat MySQL Data Transfer

Source Server         : maxin
Source Server Version : 50542
Source Host           : localhost:3306
Source Database       : booksystem

Target Server Type    : MYSQL
Target Server Version : 50542
File Encoding         : 65001

Date: 2017-10-25 21:52:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `books`
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `booksid` varchar(100) COLLATE utf8_bin NOT NULL,
  `booksname` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `booksprice` double DEFAULT NULL,
  `bookscategory` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `booksnum` int(11) DEFAULT NULL,
  `booksimgurl` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `booksstate` int(11) DEFAULT NULL COMMENT '图书状态',
  PRIMARY KEY (`booksid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('482b5255-741d-4466-8596-26b68db91dbb', '斗破苍穹', '100', '玄幻', '200200', 'images/screen1.jpg', '玄幻修仙类小说', '1');
INSERT INTO `books` VALUES ('bfa6d99f-ad8e-4304-acde-7eed55520b5f', '激荡三十年', '200', '历史', '300300', 'images/screen2.jpg', '中国企业发展史', '1');
INSERT INTO `books` VALUES ('fbdb8f38-c2f1-4025-a562-544cc83ad1be', '向着光亮那方', '300', '青春励志', '400400', 'images/screen3.jpg', '青春励志类小说', '1');
INSERT INTO `books` VALUES ('fca76bb3-73f3-456b-8a9d-6607cd4a09a1', '茶馆', '25', '现在文学', '200210', 'images/screen4.jpg', '现代文学类小说', '1');
INSERT INTO `books` VALUES ('fca76bb3-73f3-456b-8a9d-6607cd4aasdf', 'ddwwdafs', '212', '企业管理', '200220', 'images/screen5.jpg', '企业', '1');

-- ----------------------------
-- Table structure for `orderitem`
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `order_id` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '',
  `books_id` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '',
  `lendnum` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`,`books_id`),
  KEY `books_id` (`books_id`),
  CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `orderitem_ibfk_2` FOREIGN KEY (`books_id`) REFERENCES `books` (`booksid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of orderitem
-- ----------------------------

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` varchar(100) COLLATE utf8_bin NOT NULL,
  `money` double DEFAULT NULL,
  `receiverinfo` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `paystate` int(11) DEFAULT NULL,
  `ordertime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role` varchar(100) NOT NULL,
  PRIMARY KEY (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('admin');
INSERT INTO `role` VALUES ('user');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `nickname` varchar(40) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `role` varchar(100) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `activecode` varchar(100) DEFAULT NULL,
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `role` (`role`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`role`) REFERENCES `role` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'duhong', '202cb962ac59075b964b07152d234b70', 'fox', '22597927@qq.com', 'admin', '1', '12481b35-5f08-42c5-8e68-bcf66f02f64d', '2014-09-29 21:39:28');
INSERT INTO `users` VALUES ('2', 'tom', '202cb962ac59075b964b07152d234b70', '小汤哥', '22597927@qq.com', 'user', '1', 'c6d9850f-3c53-43c4-b389-2da93307a14f', '2014-09-28 14:16:46');
INSERT INTO `users` VALUES ('4', '李四', '81dc9bdb52d04dc20036dbd8313ed055', '小李', '22597927@qq.com', 'user', '1', 'b3ccad7d-ac17-4a05-be2d-0a5bd026c6ff', '2014-09-28 18:54:57');
INSERT INTO `users` VALUES ('5', '王五', '81dc9bdb52d04dc20036dbd8313ed055', '小五', '22597927@qq.com', 'user', '1', 'c4328ef9-bd51-45a0-863a-9301fc4e2b8b', '2014-09-28 20:03:32');
INSERT INTO `users` VALUES ('7', 'test1', '96e79218965eb72c92a549dd5a330112', '??1', '1212379@qq.com', 'user', '1', '8e3a371a-42ec-4b6a-abc1-4a27e18d757a', '2017-10-22 23:36:29');
INSERT INTO `users` VALUES ('8', 'test2', '96e79218965eb72c92a549dd5a330112', '??2', '293847@qq.com', 'user', '1', 'd1f9c55f-df49-46b6-ad6b-f9be33fb8096', '2017-10-22 23:47:27');
