/*
Navicat MySQL Data Transfer

Source Server         : 202.117.16.35
Source Server Version : 50716
Source Host           : 202.117.16.35:3306
Source Database       : together

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-09-29 22:45:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activities
-- ----------------------------
DROP TABLE IF EXISTS `activities`;
CREATE TABLE `activities` (
  `club_id` bigint(20) DEFAULT NULL,
  `activity_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `organizer_id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `close_time` datetime DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`activity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activities
-- ----------------------------
INSERT INTO `activities` VALUES ('1', '1', '1', null, '编码活动1', null, '2017-09-26 19:51:04', '2017-09-30 19:51:10', '2017-10-01 19:51:17', null);
INSERT INTO `activities` VALUES ('1', '2', '1', null, '编码活动2', null, '2017-09-26 20:15:52', '2017-09-27 20:15:59', '2017-09-29 20:16:02', null);
INSERT INTO `activities` VALUES ('1', '3', '1', null, '编码活动3', null, '2017-09-01 20:58:54', '2017-09-02 20:58:59', '2017-09-03 20:59:05', null);
INSERT INTO `activities` VALUES ('1', '4', '1', '', '编码活动4', '', '2017-09-01 20:58:54', '2017-09-01 20:58:59', '2017-09-03 20:59:05', null);

-- ----------------------------
-- Table structure for activity2type
-- ----------------------------
DROP TABLE IF EXISTS `activity2type`;
CREATE TABLE `activity2type` (
  `activity_id` bigint(20) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity2type
-- ----------------------------

-- ----------------------------
-- Table structure for activity_types
-- ----------------------------
DROP TABLE IF EXISTS `activity_types`;
CREATE TABLE `activity_types` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity_types
-- ----------------------------
INSERT INTO `activity_types` VALUES ('1', '比赛');
INSERT INTO `activity_types` VALUES ('2', '集训');
INSERT INTO `activity_types` VALUES ('3', '日常');
INSERT INTO `activity_types` VALUES ('5', '聚会');
INSERT INTO `activity_types` VALUES ('6', '旅行');
INSERT INTO `activity_types` VALUES ('7', '讲座');
INSERT INTO `activity_types` VALUES ('8', '晚会');

-- ----------------------------
-- Table structure for club2type
-- ----------------------------
DROP TABLE IF EXISTS `club2type`;
CREATE TABLE `club2type` (
  `club_id` bigint(20) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of club2type
-- ----------------------------
INSERT INTO `club2type` VALUES ('1', '16');

-- ----------------------------
-- Table structure for clubs
-- ----------------------------
DROP TABLE IF EXISTS `clubs`;
CREATE TABLE `clubs` (
  `club_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `chief_id` bigint(20) DEFAULT NULL,
  `favicon` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `slogan` varchar(255) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `callnumber` varchar(20) DEFAULT NULL,
  `size` bigint(20) DEFAULT NULL,
  `upper_size` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`club_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clubs
-- ----------------------------
INSERT INTO `clubs` VALUES ('1', '1', null, null, '代码俱乐部', null, null, null, null, null);
INSERT INTO `clubs` VALUES ('14', '1', null, null, 'postman', null, null, null, '0', '0');

-- ----------------------------
-- Table structure for club_types
-- ----------------------------
DROP TABLE IF EXISTS `club_types`;
CREATE TABLE `club_types` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `order` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of club_types
-- ----------------------------
INSERT INTO `club_types` VALUES ('1', '轮滑', '2');
INSERT INTO `club_types` VALUES ('2', '滑板', '2');
INSERT INTO `club_types` VALUES ('3', '街舞', '2');
INSERT INTO `club_types` VALUES ('4', '台球', '4');
INSERT INTO `club_types` VALUES ('5', '篮球', '1');
INSERT INTO `club_types` VALUES ('6', '羽毛球', '1');
INSERT INTO `club_types` VALUES ('7', '骑行', '3');
INSERT INTO `club_types` VALUES ('8', '足球', '1');
INSERT INTO `club_types` VALUES ('10', '乒乓球', '1');
INSERT INTO `club_types` VALUES ('11', '辅导班', '5');
INSERT INTO `club_types` VALUES ('12', '乐队', '5');
INSERT INTO `club_types` VALUES ('13', '徒步', '3');
INSERT INTO `club_types` VALUES ('14', '游泳', '1');
INSERT INTO `club_types` VALUES ('15', '文学', '4');
INSERT INTO `club_types` VALUES ('16', '编程', '4');
INSERT INTO `club_types` VALUES ('17', '自驾', '3');
INSERT INTO `club_types` VALUES ('18', '老乡会', '5');
INSERT INTO `club_types` VALUES ('19', '摄影', '4');
INSERT INTO `club_types` VALUES ('20', '家教', '5');
INSERT INTO `club_types` VALUES ('21', '交谊舞', '2');
INSERT INTO `club_types` VALUES ('22', '游戏', '4');
INSERT INTO `club_types` VALUES ('23', '棋社', '4');
INSERT INTO `club_types` VALUES ('24', '桌游社', '4');
INSERT INTO `club_types` VALUES ('25', '跑步', '1');
INSERT INTO `club_types` VALUES ('26', '健身', '1');
INSERT INTO `club_types` VALUES ('27', '钓鱼', '3');
INSERT INTO `club_types` VALUES ('28', '登山', '3');
INSERT INTO `club_types` VALUES ('29', '野营', '3');

-- ----------------------------
-- Table structure for membership
-- ----------------------------
DROP TABLE IF EXISTS `membership`;
CREATE TABLE `membership` (
  `user_id` bigint(20) DEFAULT NULL,
  `club_id` bigint(20) DEFAULT NULL,
  `level` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of membership
-- ----------------------------
INSERT INTO `membership` VALUES ('2', '1', '1');
INSERT INTO `membership` VALUES ('2', '14', '2');
INSERT INTO `membership` VALUES ('3', '1', '3');

-- ----------------------------
-- Table structure for participate
-- ----------------------------
DROP TABLE IF EXISTS `participate`;
CREATE TABLE `participate` (
  `user_id` bigint(20) NOT NULL,
  `activity_id` bigint(20) NOT NULL,
  `state` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of participate
-- ----------------------------
INSERT INTO `participate` VALUES ('1', '1', '1');
INSERT INTO `participate` VALUES ('1', '2', null);
INSERT INTO `participate` VALUES ('1', '3', null);
INSERT INTO `participate` VALUES ('1', '4', null);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(40) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `favicon` varchar(255) DEFAULT NULL,
  `sex` tinyint(4) DEFAULT NULL,
  `age` tinyint(4) DEFAULT NULL,
  `e_mail` varchar(40) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `register_time` datetime DEFAULT NULL,
  `is_seo` tinyint(4) DEFAULT NULL,
  `is_chief` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '123', '蔚文达', null, null, null, '994184916@qq.com', '18706793622', null, null, '0', '0');
INSERT INTO `users` VALUES ('2', null, '参加者1', null, null, null, null, null, null, null, null, null);
INSERT INTO `users` VALUES ('3', null, '参加者2', null, null, null, null, null, null, null, null, null);
