DROP DATABASE IF EXISTS db_oa;
CREATE DATABASE db_oa;
USE db_oa;


-- 会议管理表  meeting
DROP TABLE IF EXISTS meeting;
CREATE TABLE meeting(
	meeting_id  INT PRIMARY KEY NOT NULL AUTO_INCREMENT,-- 会议ID
	meeting_name VARCHAR(25) NOT NULL,-- 会议名称/标题
	meeting_startTime VARCHAR(25) NOT NULL,-- 会议开始时间	
	meeting_place VARCHAR(25) NOT NULL,-- 会议地点
	meeting_staff VARCHAR(100) NOT NULL,-- 参加会议人员
 	meeting_promulgator VARCHAR(15) NOT NULL,-- 会议发布者
 	meeting_assentor VARCHAR(15) NOT NULL, -- 会议审核者
 	meeting_result VARCHAR(15) NOT NULL,-- 会议审核结果(待审核 未通过 已通过)
 	meeting_note VARCHAR(100) DEFAULT "未标注原因",-- 会议审核结果的原因
 	meeting_releaseTime DATE NOT NULL-- 审核时间/发布时间
 );
 
 -- 公告管理表 notice
 DROP TABLE IF EXISTS notice;
 CREATE TABLE notice(
	notice_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,-- 公告ID
	notice_name VARCHAR(25) NOT NULL,-- 公告名称/标题
	notice_content TEXT NOT NULL,-- 公告内容
	notice_promulgator VARCHAR(15) NOT NULL,-- 公告发布者
	notice_assentor VARCHAR(15) ,-- 公告审核者
	notice_result VARCHAR(15),-- 公告审核结果(待审核 未通过 已通过)
	notice_note VARCHAR(100) DEFAULT "未标注原因",-- 公告审核结果的原因
	notice_releaseTime DATE NOT NULL-- 审核时间/发布时间
 );
 
 -- 考勤管理表 register
DROP TABLE IF EXISTS register;
 CREATE TABLE register(
	register_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,-- 考勤ID
	register_staffNum INT NOT NULL,-- 请假登记者编号
	register_name VARCHAR(15) NOT NULL, -- 请假登记者姓名
	register_branch VARCHAR(15) NOT NULL,-- 请假登记者部门
	register_type VARCHAR(15) NOT NULL,-- 请假登记者类型 (请假  外出  出差)
	register_reason VARCHAR(100) NOT NULL,-- 请假原因
	register_startTime DATETIME NOT NULL,-- 请假开始时间
	register_endTime DATETIME NOT NULL,-- 请假到期时间
	register_assentor VARCHAR(15) NOT NULL, -- 请假审核者
	register_result VARCHAR(15) NOT NULL,-- 考勤审核结果(待审核 未通过 已通过)
	register_note VARCHAR(100) DEFAULT "未标注原因",-- 考勤审核结果的原因
	register_releaseTime DATETIME  -- 审核时间/发布时间
 );
 
 
 


 -- 打卡管理表 punch
 DROP TABLE IF EXISTS punch;
 CREATE TABLE punch(
	punch_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,-- 打卡ID
	punch_staffID INT NOT NULL,-- 打卡者ID
	punch_staffName VARCHAR(15) NOT NULL,-- 打卡者姓名
	punch_type VARCHAR(15) NOT NULL,-- 打卡类型(上班  下班)
	punch_time DATETIME NOT NULL,-- 打卡时间(年月日时分秒)
	punch_result VARCHAR(15) NOT NULL -- 打卡结果(迟到，早退，合格)
 );
 
 
 -- 计划制定表 plan
  DROP TABLE IF EXISTS plan;
 CREATE TABLE plan(
	plan_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,-- 计划ID
	plan_name VARCHAR(25) NOT NULL,-- 计划名称/标题
	plan_content TEXT NOT NULL,-- 计划内容
	plan_type VARCHAR(15) NOT NULL,-- 计划类型 (企业  部门  个人)
	plan_assentor VARCHAR(15),-- 计划审核者
	plan_result VARCHAR(15) NOT NULL,-- 计划审核结果(待审核 未通过 已通过 未提交)
	plan_note VARCHAR(100) DEFAULT "未标注原因",-- 计划审核结果的原因
	plan_promulgator VARCHAR(15) NOT NULL,-- 计划发布者
	plan_promulgatorNum INT NOT NULL,-- 计划发布者编号
	plan_branch VARCHAR(15) NOT NULL,-- 计划发布者部门
	plan_foundTime DATE NOT NULL,-- 计划创建时间
	plan_releaseTime DATE-- 审核时间/发布时间
 );
 
-- 计划类型表  pl_type;
DROP TABLE IF EXISTS pl_type;
CREATE TABLE pl_type(
	pl_type_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,-- 计划类型ID
	pl_type_name VARCHAR(15) NOT NULL-- 计划类型（企业 部门 个人）
); 
-- 评论表
DROP TABLE IF EXISTS COMMENT;
CREATE TABLE COMMENT(
	comment_plan_id INT NOT NULL,-- 计划ID
	comment_staff_name VARCHAR(15) NOT NULL,-- 评论者姓名
	comment_staff_position VARCHAR(15) NOT NULL,-- 评论者职位
	comment_text TEXT NOT NULL, -- 评论内容、
	FOREIGN KEY(comment_plan_id) REFERENCES plan(plan_id) ON UPDATE CASCADE ON DELETE CASCADE
);
 
 
 -- 员工信息表 staff 
 DROP TABLE IF EXISTS staff;
 CREATE TABLE staff(
	staff_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,-- 员工ID
	staff_num INT NOT NULL UNIQUE,-- 员工编号
	staff_name VARCHAR(15) NOT NULL,-- 员工名字
	staff_sex VARCHAR(10) NOT NULL,-- 员工性别
	staff_birthdate DATE NOT NULL,-- 员工出生日期
	staff_branch VARCHAR(15) NOT NULL,-- 员工部门
	staff_position VARCHAR(15) NOT NULL,-- 员工职位(董事长 总经理  部长  组长  员工)
	staff_enterTime DATE NOT NULL,-- 员工入职时间
	staff_password VARCHAR(15) NOT NULL-- 登录密码	
 );


-- 职位权限表 po_power
DROP TABLE IF EXISTS po_power;
CREATE TABLE po_power(
	po_power_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,-- 职位权限ID
	po_power_position VARCHAR(15) NOT NULL,-- 员工职位(管理员 董事长 总经理  部长  组长 员工)
	po_power_rank INT NOT NULL -- 权限级别(管理员0 董事长1 总经理2  部长3  组长4 员工5)
);




-- 部门表  branch
DROP TABLE IF EXISTS branch;
CREATE TABLE branch(
	branch_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,-- 部门ID
	branch_name VARCHAR(15) UNIQUE NOT NULL, -- 部门名字,唯一
	branch_minister VARCHAR(15) NOT NULL,-- 部门部长名字
	branch_summarize TEXT,-- 部门的描述
	branch_time DATE NOT NULL -- 部门建立时间
);


-- 通讯信息组 message
DROP TABLE IF EXISTS message;
CREATE TABLE message(
	message_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,-- 通讯信息组ID
	message_name VARCHAR(15) NOT NULL -- 通讯信息组名称
);


-- 通讯详细信息 me_staff
DROP TABLE IF EXISTS me_staff;
CREATE TABLE me_staff(
	me_staff_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,-- 通讯人员ID
	me_staff_name VARCHAR(15) NOT NULL,-- 通讯人员名称
	me_staff_branch VARCHAR(15) NOT NULL,-- 通讯人员部门
	me_staff_message VARCHAR(15) NOT NULL,-- 通讯人员信息组
	me_staff_address VARCHAR(30) NOT NULL,-- 通讯人员家庭地址
	me_staff_phone VARCHAR(12) NOT NULL--  通讯人员电话号码
	
);-- 设置外键  删除通讯信息组，即删除通信信息组里面的所有通讯人员


-- 网页维护
DROP table IF EXISTS maintain;
CREATE TABLE maintain(
	maintain_id int PRIMARY KEY not null AUTO_INCREMENT,-- 网页ID
	maintain_model int,-- 模块表 
	maintain_menu VARCHAR(20) NOT NULL,-- 菜单
	maintain_url VARCHAR(100) NOT NULL,-- url
	maintain_time Date not null,
  CONSTRAINT FOREIGN KEY (maintain_model) REFERENCES model(maintain_model)ON UPDATE CASCADE ON DELETE CASCADE
)

-- 模块表

DROP table IF EXISTS model;
CREATE TABLE model(
 maintain_model int PRIMARY KEY not null AUTO_INCREMENT,
 maintain_name VARCHAR(20)
)