DROP DATABASE IF EXISTS db_oa;
CREATE DATABASE db_oa;
USE db_oa;


-- ��������  meeting
DROP TABLE IF EXISTS meeting;
CREATE TABLE meeting(
	meeting_id  INT PRIMARY KEY NOT NULL AUTO_INCREMENT,-- ����ID
	meeting_name VARCHAR(25) NOT NULL,-- ��������/����
	meeting_startTime VARCHAR(25) NOT NULL,-- ���鿪ʼʱ��	
	meeting_place VARCHAR(25) NOT NULL,-- ����ص�
	meeting_staff VARCHAR(100) NOT NULL,-- �μӻ�����Ա
 	meeting_promulgator VARCHAR(15) NOT NULL,-- ���鷢����
 	meeting_assentor VARCHAR(15) NOT NULL, -- ���������
 	meeting_result VARCHAR(15) NOT NULL,-- ������˽��(����� δͨ�� ��ͨ��)
 	meeting_note VARCHAR(100) DEFAULT "δ��עԭ��",-- ������˽����ԭ��
 	meeting_releaseTime DATE NOT NULL-- ���ʱ��/����ʱ��
 );
 
 -- �������� notice
 DROP TABLE IF EXISTS notice;
 CREATE TABLE notice(
	notice_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,-- ����ID
	notice_name VARCHAR(25) NOT NULL,-- ��������/����
	notice_content TEXT NOT NULL,-- ��������
	notice_promulgator VARCHAR(15) NOT NULL,-- ���淢����
	notice_assentor VARCHAR(15) ,-- ���������
	notice_result VARCHAR(15),-- ������˽��(����� δͨ�� ��ͨ��)
	notice_note VARCHAR(100) DEFAULT "δ��עԭ��",-- ������˽����ԭ��
	notice_releaseTime DATE NOT NULL-- ���ʱ��/����ʱ��
 );
 
 -- ���ڹ���� register
DROP TABLE IF EXISTS register;
 CREATE TABLE register(
	register_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,-- ����ID
	register_staffNum INT NOT NULL,-- ��ٵǼ��߱��
	register_name VARCHAR(15) NOT NULL, -- ��ٵǼ�������
	register_branch VARCHAR(15) NOT NULL,-- ��ٵǼ��߲���
	register_type VARCHAR(15) NOT NULL,-- ��ٵǼ������� (���  ���  ����)
	register_reason VARCHAR(100) NOT NULL,-- ���ԭ��
	register_startTime DATETIME NOT NULL,-- ��ٿ�ʼʱ��
	register_endTime DATETIME NOT NULL,-- ��ٵ���ʱ��
	register_assentor VARCHAR(15) NOT NULL, -- ��������
	register_result VARCHAR(15) NOT NULL,-- ������˽��(����� δͨ�� ��ͨ��)
	register_note VARCHAR(100) DEFAULT "δ��עԭ��",-- ������˽����ԭ��
	register_releaseTime DATETIME  -- ���ʱ��/����ʱ��
 );
 
 
 


 -- �򿨹���� punch
 DROP TABLE IF EXISTS punch;
 CREATE TABLE punch(
	punch_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,-- ��ID
	punch_staffID INT NOT NULL,-- ����ID
	punch_staffName VARCHAR(15) NOT NULL,-- ��������
	punch_type VARCHAR(15) NOT NULL,-- ������(�ϰ�  �°�)
	punch_time DATETIME NOT NULL,-- ��ʱ��(������ʱ����)
	punch_result VARCHAR(15) NOT NULL -- �򿨽��(�ٵ������ˣ��ϸ�)
 );
 
 
 -- �ƻ��ƶ��� plan
  DROP TABLE IF EXISTS plan;
 CREATE TABLE plan(
	plan_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,-- �ƻ�ID
	plan_name VARCHAR(25) NOT NULL,-- �ƻ�����/����
	plan_content TEXT NOT NULL,-- �ƻ�����
	plan_type VARCHAR(15) NOT NULL,-- �ƻ����� (��ҵ  ����  ����)
	plan_assentor VARCHAR(15),-- �ƻ������
	plan_result VARCHAR(15) NOT NULL,-- �ƻ���˽��(����� δͨ�� ��ͨ�� δ�ύ)
	plan_note VARCHAR(100) DEFAULT "δ��עԭ��",-- �ƻ���˽����ԭ��
	plan_promulgator VARCHAR(15) NOT NULL,-- �ƻ�������
	plan_promulgatorNum INT NOT NULL,-- �ƻ������߱��
	plan_branch VARCHAR(15) NOT NULL,-- �ƻ������߲���
	plan_foundTime DATE NOT NULL,-- �ƻ�����ʱ��
	plan_releaseTime DATE-- ���ʱ��/����ʱ��
 );
 
-- �ƻ����ͱ�  pl_type;
DROP TABLE IF EXISTS pl_type;
CREATE TABLE pl_type(
	pl_type_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,-- �ƻ�����ID
	pl_type_name VARCHAR(15) NOT NULL-- �ƻ����ͣ���ҵ ���� ���ˣ�
); 
-- ���۱�
DROP TABLE IF EXISTS COMMENT;
CREATE TABLE COMMENT(
	comment_plan_id INT NOT NULL,-- �ƻ�ID
	comment_staff_name VARCHAR(15) NOT NULL,-- ����������
	comment_staff_position VARCHAR(15) NOT NULL,-- ������ְλ
	comment_text TEXT NOT NULL, -- �������ݡ�
	FOREIGN KEY(comment_plan_id) REFERENCES plan(plan_id) ON UPDATE CASCADE ON DELETE CASCADE
);
 
 
 -- Ա����Ϣ�� staff 
 DROP TABLE IF EXISTS staff;
 CREATE TABLE staff(
	staff_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,-- Ա��ID
	staff_num INT NOT NULL UNIQUE,-- Ա�����
	staff_name VARCHAR(15) NOT NULL,-- Ա������
	staff_sex VARCHAR(10) NOT NULL,-- Ա���Ա�
	staff_birthdate DATE NOT NULL,-- Ա����������
	staff_branch VARCHAR(15) NOT NULL,-- Ա������
	staff_position VARCHAR(15) NOT NULL,-- Ա��ְλ(���³� �ܾ���  ����  �鳤  Ա��)
	staff_enterTime DATE NOT NULL,-- Ա����ְʱ��
	staff_password VARCHAR(15) NOT NULL-- ��¼����	
 );


-- ְλȨ�ޱ� po_power
DROP TABLE IF EXISTS po_power;
CREATE TABLE po_power(
	po_power_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,-- ְλȨ��ID
	po_power_position VARCHAR(15) NOT NULL,-- Ա��ְλ(����Ա ���³� �ܾ���  ����  �鳤 Ա��)
	po_power_rank INT NOT NULL -- Ȩ�޼���(����Ա0 ���³�1 �ܾ���2  ����3  �鳤4 Ա��5)
);




-- ���ű�  branch
DROP TABLE IF EXISTS branch;
CREATE TABLE branch(
	branch_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,-- ����ID
	branch_name VARCHAR(15) UNIQUE NOT NULL, -- ��������,Ψһ
	branch_minister VARCHAR(15) NOT NULL,-- ���Ų�������
	branch_summarize TEXT,-- ���ŵ�����
	branch_time DATE NOT NULL -- ���Ž���ʱ��
);


-- ͨѶ��Ϣ�� message
DROP TABLE IF EXISTS message;
CREATE TABLE message(
	message_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,-- ͨѶ��Ϣ��ID
	message_name VARCHAR(15) NOT NULL -- ͨѶ��Ϣ������
);


-- ͨѶ��ϸ��Ϣ me_staff
DROP TABLE IF EXISTS me_staff;
CREATE TABLE me_staff(
	me_staff_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,-- ͨѶ��ԱID
	me_staff_name VARCHAR(15) NOT NULL,-- ͨѶ��Ա����
	me_staff_branch VARCHAR(15) NOT NULL,-- ͨѶ��Ա����
	me_staff_message VARCHAR(15) NOT NULL,-- ͨѶ��Ա��Ϣ��
	me_staff_address VARCHAR(30) NOT NULL,-- ͨѶ��Ա��ͥ��ַ
	me_staff_phone VARCHAR(12) NOT NULL--  ͨѶ��Ա�绰����
	
);-- �������  ɾ��ͨѶ��Ϣ�飬��ɾ��ͨ����Ϣ�����������ͨѶ��Ա


-- ��ҳά��
DROP table IF EXISTS maintain;
CREATE TABLE maintain(
	maintain_id int PRIMARY KEY not null AUTO_INCREMENT,-- ��ҳID
	maintain_model int,-- ģ��� 
	maintain_menu VARCHAR(20) NOT NULL,-- �˵�
	maintain_url VARCHAR(100) NOT NULL,-- url
	maintain_time Date not null,
  CONSTRAINT FOREIGN KEY (maintain_model) REFERENCES model(maintain_model)ON UPDATE CASCADE ON DELETE CASCADE
)

-- ģ���

DROP table IF EXISTS model;
CREATE TABLE model(
 maintain_model int PRIMARY KEY not null AUTO_INCREMENT,
 maintain_name VARCHAR(20)
)