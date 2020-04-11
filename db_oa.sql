/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50715
 Source Host           : localhost:3306
 Source Schema         : db_oa

 Target Server Type    : MySQL
 Target Server Version : 50715
 File Encoding         : 65001

 Date: 05/04/2020 18:40:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for branch
-- ----------------------------
DROP TABLE IF EXISTS `branch`;
CREATE TABLE `branch`  (
  `branch_id` int(11) NOT NULL AUTO_INCREMENT,
  `branch_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `branch_minister` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `branch_summarize` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `branch_time` date NOT NULL,
  PRIMARY KEY (`branch_id`) USING BTREE,
  UNIQUE INDEX `branch_name`(`branch_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of branch
-- ----------------------------
INSERT INTO `branch` VALUES (1, 'zuidaima', '张三', 'zuidaima.com123', '2018-05-18');
INSERT INTO `branch` VALUES (2, '审计部', '李四', 'sa', '2018-05-18');
INSERT INTO `branch` VALUES (3, '销售部', 'zuidaima', '销售', '2020-04-02');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_plan_id` int(11) NOT NULL,
  `comment_staff_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comment_staff_position` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comment_text` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  INDEX `comment_plan_id`(`comment_plan_id`) USING BTREE,
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`comment_plan_id`) REFERENCES `plan` (`plan_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for maintain
-- ----------------------------
DROP TABLE IF EXISTS `maintain`;
CREATE TABLE `maintain`  (
  `maintain_id` int(11) NOT NULL AUTO_INCREMENT,
  `maintain_model` int(11) NULL DEFAULT NULL,
  `maintain_menu` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `maintain_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `maintain_time` date NOT NULL,
  PRIMARY KEY (`maintain_id`) USING BTREE,
  INDEX `maintain_model`(`maintain_model`) USING BTREE,
  CONSTRAINT `maintain_ibfk_1` FOREIGN KEY (`maintain_model`) REFERENCES `model` (`maintain_model`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of maintain
-- ----------------------------
INSERT INTO `maintain` VALUES (1, 2, '网站公告', 'noticeServlet?action=query', '2018-05-04');
INSERT INTO `maintain` VALUES (2, 2, '会议管理', 'MeetingServlet?action=query', '2018-05-04');
INSERT INTO `maintain` VALUES (3, 3, '上，下班登记', 'punchcard.jsp', '2018-05-04');
INSERT INTO `maintain` VALUES (4, 3, '外出登记', 'register_outercome.jsp', '2018-05-04');
INSERT INTO `maintain` VALUES (5, 3, '请假登记', 'register_leave.jsp', '2018-05-04');
INSERT INTO `maintain` VALUES (6, 3, '出差登记', 'register_evection.jsp', '2018-05-04');
INSERT INTO `maintain` VALUES (7, 3, '考勤记录', 'registerTwoServlet?select=punch', '2018-05-04');
INSERT INTO `maintain` VALUES (8, 3, '其他记录', 'registerTwoServlet?select=register', '2018-05-04');
INSERT INTO `maintain` VALUES (9, 4, '企业计划', 'planServlet?action=planBusinesslist', '2018-05-04');
INSERT INTO `maintain` VALUES (10, 4, '部门计划', 'planServlet?action=planPersonalList', '2018-05-04');
INSERT INTO `maintain` VALUES (11, 4, '个人计划', 'planServlet?action=planPersonalList', '2018-05-04');
INSERT INTO `maintain` VALUES (12, 5, '审核操作', 'examineServlet?action=examineQuery&examineType=1', '2018-05-04');
INSERT INTO `maintain` VALUES (13, 6, '员工管理', 'staffServlet?action=sss', '2018-05-04');
INSERT INTO `maintain` VALUES (14, 6, '部门管理', 'branchServlet?action=query', '2018-05-04');
INSERT INTO `maintain` VALUES (16, 7, '网站维护', 'maintainServlet?action=query', '2018-05-04');
INSERT INTO `maintain` VALUES (17, 7, '退出登录', 'logout.jsp', '2018-05-04');
INSERT INTO `maintain` VALUES (18, 3, '考勤统计', 'ChartServlet?type=0', '2018-05-04');

-- ----------------------------
-- Table structure for me_staff
-- ----------------------------
DROP TABLE IF EXISTS `me_staff`;
CREATE TABLE `me_staff`  (
  `me_staff_id` int(11) NOT NULL AUTO_INCREMENT,
  `me_staff_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `me_staff_branch` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `me_staff_message` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `me_staff_address` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `me_staff_phone` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`me_staff_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for meeting
-- ----------------------------
DROP TABLE IF EXISTS `meeting`;
CREATE TABLE `meeting`  (
  `meeting_id` int(11) NOT NULL AUTO_INCREMENT,
  `branch_id` int(11) NOT NULL,
  `meeting_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `meeting_startTime` datetime(0) NULL DEFAULT NULL,
  `meeting_place` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `meeting_staff` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `meeting_promulgator` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_open` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `meeting_assentor` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `meeting_result` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `meeting_note` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `meeting_releaseTime` date NULL DEFAULT NULL,
  PRIMARY KEY (`meeting_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `message_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`message_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, 'zuidaima');

-- ----------------------------
-- Table structure for model
-- ----------------------------
DROP TABLE IF EXISTS `model`;
CREATE TABLE `model`  (
  `maintain_model` int(11) NOT NULL AUTO_INCREMENT,
  `maintain_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`maintain_model`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of model
-- ----------------------------
INSERT INTO `model` VALUES (1, '今日看板');
INSERT INTO `model` VALUES (2, '日常管理');
INSERT INTO `model` VALUES (3, '考勤管理');
INSERT INTO `model` VALUES (4, '计划制定');
INSERT INTO `model` VALUES (5, '审核管理');
INSERT INTO `model` VALUES (6, '人事管理');
INSERT INTO `model` VALUES (7, '系统管理');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `notice_id` int(11) NOT NULL AUTO_INCREMENT,
  `notice_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `notice_type` int(11) NULL DEFAULT NULL COMMENT '公告类别id',
  `notice_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `notice_promulgator` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `notice_assentor` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `notice_result` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `notice_note` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `notice_releaseTime` date NOT NULL,
  `file_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for notice_type
-- ----------------------------
DROP TABLE IF EXISTS `notice_type`;
CREATE TABLE `notice_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公告类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pl_type
-- ----------------------------
DROP TABLE IF EXISTS `pl_type`;
CREATE TABLE `pl_type`  (
  `pl_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `pl_type_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`pl_type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for plan
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan`  (
  `plan_id` int(11) NOT NULL AUTO_INCREMENT,
  `plan_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `plan_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `plan_type` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `plan_assentor` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `plan_result` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `plan_note` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `plan_promulgator` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `plan_promulgatorNum` int(11) NOT NULL,
  `plan_branch` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `plan_foundTime` date NOT NULL,
  `plan_releaseTime` date NULL DEFAULT NULL,
  PRIMARY KEY (`plan_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for po_power
-- ----------------------------
DROP TABLE IF EXISTS `po_power`;
CREATE TABLE `po_power`  (
  `po_power_id` int(11) NOT NULL AUTO_INCREMENT,
  `po_power_position` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `po_power_rank` int(11) NOT NULL,
  PRIMARY KEY (`po_power_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for punch
-- ----------------------------
DROP TABLE IF EXISTS `punch`;
CREATE TABLE `punch`  (
  `punch_id` int(11) NOT NULL AUTO_INCREMENT,
  `punch_staffID` int(11) NOT NULL,
  `punch_staffName` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `punch_type` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `punch_time` datetime(0) NOT NULL,
  `punch_result` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`punch_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for register
-- ----------------------------
DROP TABLE IF EXISTS `register`;
CREATE TABLE `register`  (
  `register_id` int(11) NOT NULL AUTO_INCREMENT,
  `register_staffNum` int(11) NOT NULL,
  `register_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `register_branch` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `register_type` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `register_reason` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `register_startTime` datetime(0) NOT NULL,
  `register_endTime` datetime(0) NOT NULL,
  `register_assentor` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `register_result` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `register_note` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `register_releaseTime` date NULL DEFAULT NULL,
  PRIMARY KEY (`register_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`  (
  `staff_id` int(11) NOT NULL AUTO_INCREMENT,
  `staff_num` int(11) NOT NULL,
  `staff_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `staff_sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `staff_birthdate` date NOT NULL,
  `staff_branch` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `staff_position` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `staff_enterTime` date NOT NULL,
  `staff_password` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`staff_id`) USING BTREE,
  UNIQUE INDEX `staff_num`(`staff_num`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES (1, 1610, '张三', '男', '2018-05-04', 'zuidaima', '部门主管', '2018-05-04', '123456');
INSERT INTO `staff` VALUES (2, 144, 'zuidaima', '男', '2018-05-25', 'zuidaima', '普通员工', '2018-05-17', '111111');
INSERT INTO `staff` VALUES (3, 123, '李四', '男', '2018-05-25', 'zuidaima', '普通员工', '2018-05-17', '111111');
INSERT INTO `staff` VALUES (4, 345, '赵六', '男', '2018-05-25', 'zuidaima', '普通员工', '2018-05-17', '111111');
INSERT INTO `staff` VALUES (5, 124, '王五', '男', '2018-05-25', 'zuidaima', '普通员工', '2018-05-17', '111111');
INSERT INTO `staff` VALUES (6, 125, '钱七', '男', '2018-05-25', 'zuidaima', '普通员工', '2018-05-17', '111111');
INSERT INTO `staff` VALUES (7, 126, '网吧', '男', '2018-05-25', 'zuidaima', '人事', '2018-05-17', '111111');

SET FOREIGN_KEY_CHECKS = 1;
