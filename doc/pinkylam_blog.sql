/*
Navicat MySQL Data Transfer

Source Server         : vipsnacks
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : pinkylam_blog

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-07-18 16:33:04
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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='文章表';

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', 'java多线程详解', 'this is test！！', '## java多线程\n:smile::relaxed:\n', '1', '0', '1', '2017-07-17 09:19:44', null);
INSERT INTO `article` VALUES ('17', '这是一个测试案例', '哈哈哈哈哈哈', '[TOC]\n\n#### Disabled options\n\n- TeX (Based on KaTeX);\n- Emoji;\n- Task lists;\n- HTML tags decode;\n- Flowchart and Sequence Diagram;\n\n#### Editor.md directory\n\n    editor.md/\n            lib/\n            css/\n            scss/\n            tests/\n            fonts/\n            images/\n            plugins/\n            examples/\n            languages/     \n            editormd.js\n            ...\n\n```html\n<!-- English -->\n<script src=\"../dist/js/languages/en.js\"></script>\n\n<!-- 繁體中文 -->\n<script src=\"../dist/js/languages/zh-tw.js\"></script>\n```\n', '1', '0', '1', '2017-07-17 16:21:45', null);

-- ----------------------------
-- Table structure for article_cate_label
-- ----------------------------
DROP TABLE IF EXISTS `article_cate_label`;
CREATE TABLE `article_cate_label` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ARTICLE_ID` bigint(20) DEFAULT NULL,
  `CATE_LABEL_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='文章类别标签关系表';

-- ----------------------------
-- Records of article_cate_label
-- ----------------------------
INSERT INTO `article_cate_label` VALUES ('7', '17', '1');
INSERT INTO `article_cate_label` VALUES ('8', '17', '25');

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
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='类别标签表';

-- ----------------------------
-- Records of cate_label
-- ----------------------------
INSERT INTO `cate_label` VALUES ('1', 'java', '1', '');
INSERT INTO `cate_label` VALUES ('4', 'spring', '1', '');
INSERT INTO `cate_label` VALUES ('5', 'ajax', '1', '');
INSERT INTO `cate_label` VALUES ('6', 'mysql', '1', '');
INSERT INTO `cate_label` VALUES ('21', '前台', '2', '');
INSERT INTO `cate_label` VALUES ('22', '后台', '2', '');
INSERT INTO `cate_label` VALUES ('23', 'test', '2', '');
INSERT INTO `cate_label` VALUES ('24', 'handx', '2', '');
INSERT INTO `cate_label` VALUES ('25', '测试', '2', '');
INSERT INTO `cate_label` VALUES ('26', '胜多负少', '2', '');
INSERT INTO `cate_label` VALUES ('27', 'a打算', '2', '');
INSERT INTO `cate_label` VALUES ('28', '发送到', '2', '');

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
