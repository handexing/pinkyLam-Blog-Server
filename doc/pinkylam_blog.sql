/*
Navicat MySQL Data Transfer

Source Server         : vipsnacks
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : pinkylam_blog

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-07-22 15:06:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(255) DEFAULT NULL,
  `SUBTITLE` varchar(255) DEFAULT NULL,
  `CONTENT` longtext,
  `STATUS` int(1) DEFAULT NULL,
  `HITS` int(11) DEFAULT NULL,
  `AUTHOR_ID` bigint(20) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='文章表';

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', 'java多线程详解', 'this is test！！', '## java多线程\n:smile::relaxed:\n', '1', '0', '1', '2017-07-17 09:19:44', '2017-07-19 11:21:24');
INSERT INTO `article` VALUES ('17', '这是一个测试案例', '哈哈哈哈哈哈', ':satisfied:', '1', '0', '1', '2017-07-19 09:49:49', '2017-07-19 11:02:20');
INSERT INTO `article` VALUES ('18', '哈哈哈哈', '发的说法是', '啊发生大发是大帝', '1', '0', '1', '2017-07-19 11:22:51', '2017-07-19 13:15:17');
INSERT INTO `article` VALUES ('19', '哟哟哟哟哟哟哟', '哟哟哟哟哟哟哟', '好人坏人:triumph::weary:', '1', '0', '1', '2017-07-19 13:47:31', '2017-07-19 14:19:18');
INSERT INTO `article` VALUES ('20', '法撒旦法', '案发大发', '啊发生大发', '1', '0', '1', '2017-07-19 14:19:52', '2017-07-19 14:20:03');

-- ----------------------------
-- Table structure for article_cate_label
-- ----------------------------
DROP TABLE IF EXISTS `article_cate_label`;
CREATE TABLE `article_cate_label` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ARTICLE_ID` bigint(20) DEFAULT NULL,
  `CATE_LABEL_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COMMENT='文章类别标签关系表';

-- ----------------------------
-- Records of article_cate_label
-- ----------------------------
INSERT INTO `article_cate_label` VALUES ('7', '17', '1');
INSERT INTO `article_cate_label` VALUES ('8', '17', '25');
INSERT INTO `article_cate_label` VALUES ('11', '17', '29');
INSERT INTO `article_cate_label` VALUES ('12', '17', '30');
INSERT INTO `article_cate_label` VALUES ('13', '17', '31');
INSERT INTO `article_cate_label` VALUES ('23', '17', '32');
INSERT INTO `article_cate_label` VALUES ('25', '18', '30');
INSERT INTO `article_cate_label` VALUES ('38', '19', '34');
INSERT INTO `article_cate_label` VALUES ('39', '19', '35');
INSERT INTO `article_cate_label` VALUES ('44', '20', '36');
INSERT INTO `article_cate_label` VALUES ('45', '20', '36');

-- ----------------------------
-- Table structure for attach
-- ----------------------------
DROP TABLE IF EXISTS `attach`;
CREATE TABLE `attach` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL COMMENT '文件名',
  `TYPE` varchar(255) DEFAULT NULL COMMENT '文件类型',
  `URL` varchar(255) DEFAULT NULL COMMENT '文件路径',
  `AUTHOR_ID` bigint(20) DEFAULT NULL COMMENT '作者',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='附件表';

-- ----------------------------
-- Records of attach
-- ----------------------------
INSERT INTO `attach` VALUES ('1', '0b8adabd52d119f02e59db082ceba36a_r.jpeg', 'image', 'upload/20170722/1500706846201.jpeg', '1', '2017-07-22 15:00:46');

-- ----------------------------
-- Table structure for cate_label
-- ----------------------------
DROP TABLE IF EXISTS `cate_label`;
CREATE TABLE `cate_label` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL COMMENT '名称',
  `TYPE` int(1) DEFAULT NULL COMMENT '类型1：类别 2：标签',
  `REMARK` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='类别标签表';

-- ----------------------------
-- Records of cate_label
-- ----------------------------
INSERT INTO `cate_label` VALUES ('1', 'java', '1', '');
INSERT INTO `cate_label` VALUES ('4', 'spring', '1', '');
INSERT INTO `cate_label` VALUES ('5', 'ajax', '1', '');
INSERT INTO `cate_label` VALUES ('6', 'mysql', '1', '');
INSERT INTO `cate_label` VALUES ('25', '测试', '2', '');
INSERT INTO `cate_label` VALUES ('29', '嘻嘻', '2', '');
INSERT INTO `cate_label` VALUES ('30', '哈哈', '2', '');
INSERT INTO `cate_label` VALUES ('31', '嘿嘿', '2', '');
INSERT INTO `cate_label` VALUES ('32', '呵呵', '2', null);
INSERT INTO `cate_label` VALUES ('34', 'yoyo', '2', null);
INSERT INTO `cate_label` VALUES ('35', '好人坏人', '2', null);
INSERT INTO `cate_label` VALUES ('36', '阿发', '2', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NICK` varchar(255) DEFAULT NULL COMMENT '昵称',
  `NAME` varchar(255) DEFAULT NULL COMMENT '登录名',
  `PSW` varchar(255) DEFAULT NULL COMMENT '密码',
  `EMAIL` varchar(255) DEFAULT NULL COMMENT 'email',
  `STATUS` int(1) DEFAULT NULL COMMENT '状态',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'pinkylam', 'admin', '123456', '908716835@qq.com', '0', '2017-07-10 11:38:32', '2017-07-14 10:49:16');
