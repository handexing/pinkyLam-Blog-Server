/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : pinkylam_blog

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-09-05 16:18:48
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
  `WRITING_TIME` int(11) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='文章表';

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('24', '基于node webkit 开发的桌面笔记管理应用。', '基于node-webkit 开发的桌面笔记管理应用。前端涉及MDUI框架、nwjs、layui、editor、redis、nodejs等。数据同步定时同步到服务器端，本地自带缓存数据功能。后端采用springboot框架开发。', '## 描述\n基于node-webkit 开发的桌面笔记管理应用。前端涉及MDUI框架、nwjs、layui、editor、redis、nodejs等。数据同步定时同步到服务器端，本地自带缓存数据功能。后端采用springboot框架开发。\n\n## 项目地址\n[服务端项目](https://github.com/handexing/pinkyLam-Blog-Server)\n[PC端项目](https://github.com/handexing/PinkyLam-blog)\n## 项目预览\n### 登录界面\n\n![登录界面](https://github.com/handexing/PinkyLam-blog/raw/master/preview/login.png)\n\n### 首页预览\n\n#### 仪表盘\n\n![仪表盘](https://github.com/handexing/PinkyLam-blog/raw/master/preview/index.png)\n\n#### 仪表盘 -文章\n\n![文章](https://github.com/handexing/PinkyLam-blog/raw/master/preview/article.png)\n\n#### 仪表盘 -日历提醒\n\n![日历提醒](https://github.com/handexing/PinkyLam-blog/raw/master/preview/m_calendar.png)\n\n### 文章管理\n\n#### 文章列表\n\n![文章管理](https://github.com/handexing/PinkyLam-blog/raw/master/preview/articlelist.png)\n\n#### 添加文章\n\n![添加文章](https://github.com/handexing/PinkyLam-blog/raw/master/preview/addArticle.png)\n\n### 分类、标签\n\n![分类标签](https://github.com/handexing/PinkyLam-blog/raw/master/preview/catesLabel.png)\n\n### 文件管理\n\n![文件管理](https://github.com/handexing/PinkyLam-blog/raw/master/preview/filePage.png)\n\n## 结尾\n\n> 觉得不错的朋友可以点下star,watch,fork也算是对我的鼓励了。目前已经开发大半功能了。还有一部分在撸。有兴趣的伙伴可以一起来撸。(￣▽￣)~*', '1', '0', '1', '2017-08-01 10:59:36', '2017-08-01 15:44:07', '373');
INSERT INTO `article` VALUES ('25', '常用Java开发技术，持续更新！', '闲着没事集成了一些常用的开发技术，使用spring、springmvc、spring data jpa等等...，项目会一直持续集成下去，有兴趣的欢迎一起来。', '## 项目介绍\n闲着没事集成了一些常用的开发技术，使用spring、springmvc、spring data jpa等等...项目会一直持续集成下去，有兴趣的欢迎一起来。 :laughing:\n\n## 项目功能\n#### 系统管理\n- 用户管理（添加导出用户资料功能）\n- 菜单管理\n- 角色管理\n#### 文章管理，zxing二维码\n- 使用bootstarp markdown插件实现文章管理,[Bootstrap markdown官网](http://www.codingdrama.com/bootstrap-markdown/)\n- 使用谷歌开源项目zxing实现二维码在线生成功能[zxing github](https://github.com/zxing/zxing)\n#### 任务调度\n- 整合spring+quartz完成基础定时任务，详情移驾[spring,quartz整合（一）](https://handexing.github.io/2017/05/04/spring+quartz(%E4%B8%80)/)\n- 动态任务调度[spring,quartz整合code](https://github.com/handexing/frameworkAggregate)，配置详情：[spring,quartz整合（二）](https://handexing.github.io/2017/05/08/spring+quartz(%E4%BA%8C)/)\n\n#### JSOUP爬虫学习\n- 移到别的地方了[jsoup项目](https://github.com/handexing/frameworkAggregate)\n- 爬虫实战 [京东爬虫](https://github.com/handexing/JdBee)\n#### Activiti工作流引擎使用\n- 流程列表（部署流程、查看流程、删除流程）\n- 历史流程列表\n- 正在运行的流程列表\n- 请假列表（新增请假条）\n\n#### 商品比价\n- 根据phantomjs爬取数据，jsoup解析数据\n- 使用定时任务每天定时爬取数据，使用echarts展示数据变化\n\n## 效果预览\n\n### 用户管理\n\n![用户管理](https://github.com/handexing/wish/raw/master/img/user.png)\n\n### 菜单管理\n\n![菜单管理](https://github.com/handexing/wish/raw/master/img/menu.png)\n\n### 角色管理\n\n![角色管理](https://github.com/handexing/wish/raw/master/img/role.png)\n\n### 文章管理\n\n![文章管理](https://github.com/handexing/wish/raw/master/img/article.png)\n\n###　功能杂项管理\n\n![二维码](https://github.com/handexing/wish/raw/master/img/code.png)\n\n### 工作流管理\n\n- 流程列表\n\n![流程列表](https://github.com/handexing/wish/raw/master/img/processtask.png)\n\n- 任务管理\n\n![流程详细](https://github.com/handexing/wish/raw/master/img/processlist.png)\n\n\n### 动态任务管理\n\n![任务调度](https://github.com/handexing/wish/raw/master/img/tasklist.png)\n\n### 商品比价\n\n#### 准备爬取的数据\n\n![资源路径](https://github.com/handexing/wish/raw/master/img/skusrc.png)\n\n#### 已经爬取的数据\n\n![已爬数据](https://github.com/handexing/wish/raw/master/img/skuinfo.png)\n\n#### 商品价格趋势图\n\n> 还在爬取数据验证....\n\n## 结语\n\n> 觉得不错的朋友可以点下star,watch,fork也算是对我的鼓励了。', '1', '0', '1', '2017-08-01 15:13:48', '2017-08-01 15:23:18', '236');
INSERT INTO `article` VALUES ('26', '笔记杂项（各种小记）', '编程中随处遇到的各种问题小记', '#### maven镜像库\n\n- **阿里**&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`http://maven.aliyun.com/nexus/content/groups/public/`\n\n- **开源中国** `http://maven.oschina.net/content/groups/public/`\n', '1', '0', '1', '2017-08-15 14:37:50', '2017-08-15 14:39:46', '329');

-- ----------------------------
-- Table structure for article_cate_label
-- ----------------------------
DROP TABLE IF EXISTS `article_cate_label`;
CREATE TABLE `article_cate_label` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ARTICLE_ID` bigint(20) DEFAULT NULL,
  `CATE_LABEL_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8 COMMENT='文章类别标签关系表';

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
INSERT INTO `article_cate_label` VALUES ('46', '21', '1');
INSERT INTO `article_cate_label` VALUES ('47', '21', '37');
INSERT INTO `article_cate_label` VALUES ('48', '22', '1');
INSERT INTO `article_cate_label` VALUES ('49', '22', '38');
INSERT INTO `article_cate_label` VALUES ('59', '25', '41');
INSERT INTO `article_cate_label` VALUES ('64', '23', '39');
INSERT INTO `article_cate_label` VALUES ('65', '24', '42');
INSERT INTO `article_cate_label` VALUES ('69', '26', '43');

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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='附件表';

-- ----------------------------
-- Records of attach
-- ----------------------------
INSERT INTO `attach` VALUES ('17', 'HBuilder.lnk', 'file', '1502782036234.lnk', '1', '2017-08-15 15:27:16');

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
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COMMENT='类别标签表';

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
INSERT INTO `cate_label` VALUES ('37', '订单', '2', null);
INSERT INTO `cate_label` VALUES ('38', '爬虫', '2', null);
INSERT INTO `cate_label` VALUES ('39', 'afd', '2', null);
INSERT INTO `cate_label` VALUES ('40', '过的', '2', null);
INSERT INTO `cate_label` VALUES ('41', 'java', '2', null);
INSERT INTO `cate_label` VALUES ('42', 'nodejs', '2', null);
INSERT INTO `cate_label` VALUES ('43', '杂项', '2', null);

-- ----------------------------
-- Table structure for memo_remind
-- ----------------------------
DROP TABLE IF EXISTS `memo_remind`;
CREATE TABLE `memo_remind` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `AUTHOR_ID` bigint(20) DEFAULT NULL,
  `REMIND_DESCRIBE` varchar(255) DEFAULT NULL COMMENT '提醒描述',
  `REMIND_TIME` varchar(255) DEFAULT NULL COMMENT '提醒时间',
  `CREATE_TIME` datetime DEFAULT NULL,
  `STATUS` int(1) DEFAULT '0' COMMENT '状态：0.正常 1.隐藏',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='备忘提醒';

-- ----------------------------
-- Records of memo_remind
-- ----------------------------
INSERT INTO `memo_remind` VALUES ('1', '1', '学习Java多线程', '2017-08-27 15:41', '2017-08-08 15:26:39', '0');
INSERT INTO `memo_remind` VALUES ('2', '1', '精选丹麦活性菌', '2017-08-15 16:18', '2017-08-15 16:19:16', '0');
INSERT INTO `memo_remind` VALUES ('3', '1', '补充体内乳酸菌', '2017-08-15 16:21', '2017-08-15 16:22:07', '0');

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
