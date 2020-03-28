/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50509
Source Host           : localhost:3306
Source Database       : db_oa

Target Server Type    : MYSQL
Target Server Version : 50509
File Encoding         : 65001

Date: 2018-05-04 15:24:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `branch`
-- ----------------------------
DROP TABLE IF EXISTS `branch`;
CREATE TABLE `branch` (
  `branch_id` int(11) NOT NULL AUTO_INCREMENT,
  `branch_name` varchar(15) NOT NULL,
  `branch_minister` varchar(15) NOT NULL,
  `branch_summarize` text,
  `branch_time` date NOT NULL,
  PRIMARY KEY (`branch_id`),
  UNIQUE KEY `branch_name` (`branch_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of branch
-- ----------------------------
INSERT INTO `branch` VALUES ('1', 'zuidaima', '张三', 'zuidaima.com', '2018-05-18');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_plan_id` int(11) NOT NULL,
  `comment_staff_name` varchar(15) NOT NULL,
  `comment_staff_position` varchar(15) NOT NULL,
  `comment_text` text NOT NULL,
  KEY `comment_plan_id` (`comment_plan_id`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`comment_plan_id`) REFERENCES `plan` (`plan_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `maintain`
-- ----------------------------
DROP TABLE IF EXISTS `maintain`;
CREATE TABLE `maintain` (
  `maintain_id` int(11) NOT NULL AUTO_INCREMENT,
  `maintain_model` int(11) DEFAULT NULL,
  `maintain_menu` varchar(20) NOT NULL,
  `maintain_url` varchar(100) NOT NULL,
  `maintain_time` date NOT NULL,
  PRIMARY KEY (`maintain_id`),
  KEY `maintain_model` (`maintain_model`),
  CONSTRAINT `maintain_ibfk_1` FOREIGN KEY (`maintain_model`) REFERENCES `model` (`maintain_model`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of maintain
-- ----------------------------
INSERT INTO `maintain` VALUES ('1', '1', '最代码网站公告', 'noticeServlet?action=query', '2018-05-04');
INSERT INTO `maintain` VALUES ('2', '1', '会议管理', 'meeting_list.jsp', '2018-05-04');
INSERT INTO `maintain` VALUES ('3', '2', '上，下班登记', 'punchcard.jsp', '2018-05-04');
INSERT INTO `maintain` VALUES ('4', '2', '外出登记', 'register_outercome.jsp', '2018-05-04');
INSERT INTO `maintain` VALUES ('5', '2', '请假登记', 'register_leave.jsp', '2018-05-04');
INSERT INTO `maintain` VALUES ('6', '2', '出差登记', 'register_evection.jsp', '2018-05-04');
INSERT INTO `maintain` VALUES ('7', '2', '考勤记录', 'registerTwoServlet?select=punch', '2018-05-04');
INSERT INTO `maintain` VALUES ('8', '2', '其他记录', 'registerTwoServlet?select=register', '2018-05-04');
INSERT INTO `maintain` VALUES ('9', '3', '企业计划', 'planServlet?action=planBusinesslist', '2018-05-04');
INSERT INTO `maintain` VALUES ('10', '3', '部门计划', 'planServlet?action=planPersonalList', '2018-05-04');
INSERT INTO `maintain` VALUES ('11', '3', '个人计划', 'planServlet?action=planPersonalList', '2018-05-04');
INSERT INTO `maintain` VALUES ('12', '4', '审核操作', 'examine.jsp', '2018-05-04');
INSERT INTO `maintain` VALUES ('13', '5', '公司员工', 'limitServlet?action=staffVo', '2018-05-04');
INSERT INTO `maintain` VALUES ('14', '5', '部门管理', 'branchServlet?action=query', '2018-05-04');
INSERT INTO `maintain` VALUES ('15', '6', '通讯组管理', 'message_list.jsp', '2018-05-04');
INSERT INTO `maintain` VALUES ('16', '7', '网站维护', 'maintainServlet?action=query', '2018-05-04');
INSERT INTO `maintain` VALUES ('17', '7', '退出登录', 'logout.jsp', '2018-05-04');

-- ----------------------------
-- Table structure for `meeting`
-- ----------------------------
DROP TABLE IF EXISTS `meeting`;
CREATE TABLE `meeting` (
  `meeting_id` int(11) NOT NULL AUTO_INCREMENT,
  `meeting_name` varchar(25) NOT NULL,
  `meeting_startTime` varchar(25) NOT NULL,
  `meeting_place` varchar(25) NOT NULL,
  `meeting_staff` varchar(100) NOT NULL,
  `meeting_promulgator` varchar(15) NOT NULL,
  `meeting_assentor` varchar(15) NOT NULL,
  `meeting_result` varchar(15) NOT NULL,
  `meeting_note` varchar(100) DEFAULT '未标注原因',
  `meeting_releaseTime` date NOT NULL,
  PRIMARY KEY (`meeting_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of meeting
-- ----------------------------

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `message_name` varchar(15) NOT NULL,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', 'zuidaima');

-- ----------------------------
-- Table structure for `me_staff`
-- ----------------------------
DROP TABLE IF EXISTS `me_staff`;
CREATE TABLE `me_staff` (
  `me_staff_id` int(11) NOT NULL AUTO_INCREMENT,
  `me_staff_name` varchar(15) NOT NULL,
  `me_staff_branch` varchar(15) NOT NULL,
  `me_staff_message` varchar(15) NOT NULL,
  `me_staff_address` varchar(30) NOT NULL,
  `me_staff_phone` varchar(12) NOT NULL,
  PRIMARY KEY (`me_staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of me_staff
-- ----------------------------

-- ----------------------------
-- Table structure for `model`
-- ----------------------------
DROP TABLE IF EXISTS `model`;
CREATE TABLE `model` (
  `maintain_model` int(11) NOT NULL AUTO_INCREMENT,
  `maintain_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`maintain_model`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of model
-- ----------------------------
INSERT INTO `model` VALUES ('1', '日常管理');
INSERT INTO `model` VALUES ('2', '考勤管理');
INSERT INTO `model` VALUES ('3', '计划制定');
INSERT INTO `model` VALUES ('4', '审核管理');
INSERT INTO `model` VALUES ('5', '人事管理');
INSERT INTO `model` VALUES ('6', '通讯管理');
INSERT INTO `model` VALUES ('7', '系统管理');

-- ----------------------------
-- Table structure for `notice`
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `notice_id` int(11) NOT NULL AUTO_INCREMENT,
  `notice_name` varchar(25) NOT NULL,
  `notice_content` text NOT NULL,
  `notice_promulgator` varchar(15) NOT NULL,
  `notice_assentor` varchar(15) DEFAULT NULL,
  `notice_result` varchar(15) DEFAULT NULL,
  `notice_note` varchar(100) DEFAULT '未标注原因',
  `notice_releaseTime` date NOT NULL,
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', 'zuidaima.com', 'zuidaima.com', 'zuidaima', null, null, '未标注原因', '2018-05-04');

-- ----------------------------
-- Table structure for `plan`
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `plan_id` int(11) NOT NULL AUTO_INCREMENT,
  `plan_name` varchar(25) NOT NULL,
  `plan_content` text NOT NULL,
  `plan_type` varchar(15) NOT NULL,
  `plan_assentor` varchar(15) DEFAULT NULL,
  `plan_result` varchar(15) NOT NULL,
  `plan_note` varchar(100) DEFAULT '未标注原因',
  `plan_promulgator` varchar(15) NOT NULL,
  `plan_promulgatorNum` int(11) NOT NULL,
  `plan_branch` varchar(15) NOT NULL,
  `plan_foundTime` date NOT NULL,
  `plan_releaseTime` date DEFAULT NULL,
  PRIMARY KEY (`plan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plan
-- ----------------------------
INSERT INTO `plan` VALUES ('1', 'zuidaima.com', 'zuidaima.com 分享你的代码释放他的价值', '企业', null, '待审核', '未标注原因', '张三', '1610', '专属部门', '2018-05-04', null);

-- ----------------------------
-- Table structure for `pl_type`
-- ----------------------------
DROP TABLE IF EXISTS `pl_type`;
CREATE TABLE `pl_type` (
  `pl_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `pl_type_name` varchar(15) NOT NULL,
  PRIMARY KEY (`pl_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pl_type
-- ----------------------------

-- ----------------------------
-- Table structure for `po_power`
-- ----------------------------
DROP TABLE IF EXISTS `po_power`;
CREATE TABLE `po_power` (
  `po_power_id` int(11) NOT NULL AUTO_INCREMENT,
  `po_power_position` varchar(15) NOT NULL,
  `po_power_rank` int(11) NOT NULL,
  PRIMARY KEY (`po_power_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of po_power
-- ----------------------------

-- ----------------------------
-- Table structure for `punch`
-- ----------------------------
DROP TABLE IF EXISTS `punch`;
CREATE TABLE `punch` (
  `punch_id` int(11) NOT NULL AUTO_INCREMENT,
  `punch_staffID` int(11) NOT NULL,
  `punch_staffName` varchar(15) NOT NULL,
  `punch_type` varchar(15) NOT NULL,
  `punch_time` datetime NOT NULL,
  `punch_result` varchar(15) NOT NULL,
  PRIMARY KEY (`punch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of punch
-- ----------------------------
INSERT INTO `punch` VALUES ('1', '1610', '张三', '上班', '2018-05-04 15:15:41', '迟到');

-- ----------------------------
-- Table structure for `register`
-- ----------------------------
DROP TABLE IF EXISTS `register`;
CREATE TABLE `register` (
  `register_id` int(11) NOT NULL AUTO_INCREMENT,
  `register_staffNum` int(11) NOT NULL,
  `register_name` varchar(15) NOT NULL,
  `register_branch` varchar(15) NOT NULL,
  `register_type` varchar(15) NOT NULL,
  `register_reason` varchar(100) NOT NULL,
  `register_startTime` datetime NOT NULL,
  `register_endTime` datetime NOT NULL,
  `register_assentor` varchar(15) NOT NULL,
  `register_result` varchar(15) NOT NULL,
  `register_note` varchar(100) DEFAULT '未标注原因',
  `register_releaseTime` datetime DEFAULT NULL,
  PRIMARY KEY (`register_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of register
-- ----------------------------
INSERT INTO `register` VALUES ('1', '1610', '最代码', 'zuidaima', '外出', 'zuidaima.com', '2018-06-07 15:14:07', '2018-06-08 15:14:13', '', '待审核', '未标注原因', null);

-- ----------------------------
-- Table structure for `staff`
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `staff_id` int(11) NOT NULL AUTO_INCREMENT,
  `staff_num` int(11) NOT NULL,
  `staff_name` varchar(15) NOT NULL,
  `staff_sex` varchar(10) NOT NULL,
  `staff_birthdate` date NOT NULL,
  `staff_branch` varchar(15) NOT NULL,
  `staff_position` varchar(15) NOT NULL,
  `staff_enterTime` date NOT NULL,
  `staff_password` varchar(15) NOT NULL,
  PRIMARY KEY (`staff_id`),
  UNIQUE KEY `staff_num` (`staff_num`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('1', '1610', '张三', '男', '2018-05-04', '专属部门', '董事长', '2018-05-04', '123456');
INSERT INTO `staff` VALUES ('2', '144', 'zuidaima', '男', '2018-05-25', 'zuidaima', '普通员工', '2018-05-17', '111111');
