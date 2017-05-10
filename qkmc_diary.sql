/*
Navicat MySQL Data Transfer

Source Server         : school
Source Server Version : 50629
Source Host           : 10.255.251.34:3306
Source Database       : qkmc_diary

Target Server Type    : MYSQL
Target Server Version : 50629
File Encoding         : 65001

Date: 2017-05-10 20:14:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for diary
-- ----------------------------
DROP TABLE IF EXISTS `diary`;
CREATE TABLE `diary` (
  `diary_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `year` int(4) NOT NULL,
  `month` int(2) NOT NULL,
  `day` int(2) NOT NULL,
  `week` int(1) NOT NULL,
  `weather` varchar(8) NOT NULL,
  `content` text,
  `content_type` varchar(5) NOT NULL,
  PRIMARY KEY (`diary_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for friend_req
-- ----------------------------
DROP TABLE IF EXISTS `friend_req`;
CREATE TABLE `friend_req` (
  `req_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `req_from` int(11) NOT NULL,
  PRIMARY KEY (`req_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) DEFAULT NULL,
  `user_account` varchar(16) NOT NULL DEFAULT '',
  `user_password` varchar(32) NOT NULL,
  `user_sex` varchar(8) DEFAULT NULL,
  `user_age` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for user_friend
-- ----------------------------
DROP TABLE IF EXISTS `user_friend`;
CREATE TABLE `user_friend` (
  `user_frined_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `friend_id` int(11) NOT NULL,
  `friend_type` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`user_frined_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;
