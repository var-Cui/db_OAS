package com.lxitedu.st1610.vo;

import java.util.Date;

public class PlanVo {
	private int plan_id; //INT PRIMARY KEY NOT NULL AUTO_INCREMENT,-- 计划ID
	private String plan_name; //VARCHAR(25) NOT NULL,-- 计划名称/标题
	private String plan_content;// TEXT NOT NULL,-- 计划内容
	private String plan_type;// VARCHAR(15) NOT NULL,-- 计划类型 (企业  部门  个人)
	private String plan_assentor; //VARCHAR(15) NOT NULL,-- 计划审核者
	private String plan_result; //VARCHAR(15) NOT NULL,-- 计划审核结果(待审核 未通过 已通过 未提交)
	private String plan_note;// VARCHAR(100) DEFAULT "未标注原因",-- 计划审核结果的原因
	private String plan_promulgator;// VARCHAR(15) NOT NULL,-- 计划发布者
	private int plan_promulgatorNum; //INT NOT NULL,-- 计划发布者编号
	private String plan_branch; //VARCHAR(15) NOT NULL,-- 计划发布者部门
	private Date plan_foundTime;// DATE NOT NULL,-- 计划创建时间
	private Date plan_releaseTime;// DATE-- 审核时间/发布时间
	public PlanVo() {
		super();
	}
	
	public PlanVo(String plan_name, String plan_content, String plan_type,
			String plan_result, String plan_promulgator,
			int plan_promulgatorNum, String plan_branch,String plan_assentor) {
		super();
		this.plan_name = plan_name;
		this.plan_content = plan_content;
		this.plan_type = plan_type;
		this.plan_result = plan_result;
		this.plan_promulgator = plan_promulgator;
		this.plan_promulgatorNum = plan_promulgatorNum;
		this.plan_branch = plan_branch;
		this.plan_assentor = plan_assentor;
	}

	public PlanVo(int plan_id, String plan_name, String plan_content,
			String plan_type, String plan_assentor, String plan_result,
			String plan_note, String plan_promulgator, int plan_promulgatorNum,
			String plan_branch, Date plan_foundTime, Date plan_releaseTime) {
		super();
		this.plan_id = plan_id;
		this.plan_name = plan_name;
		this.plan_content = plan_content;
		this.plan_type = plan_type;
		this.plan_assentor = plan_assentor;
		this.plan_result = plan_result;
		this.plan_note = plan_note;
		this.plan_promulgator = plan_promulgator;
		this.plan_promulgatorNum = plan_promulgatorNum;
		this.plan_branch = plan_branch;
		this.plan_foundTime = plan_foundTime;
		this.plan_releaseTime = plan_releaseTime;
	}
	public int getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}
	public String getPlan_name() {
		return plan_name;
	}
	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}
	public String getPlan_content() {
		return plan_content;
	}
	public void setPlan_content(String plan_content) {
		this.plan_content = plan_content;
	}
	public String getPlan_type() {
		return plan_type;
	}
	public void setPlan_type(String plan_type) {
		this.plan_type = plan_type;
	}
	public String getPlan_assentor() {
		return plan_assentor;
	}
	public void setPlan_assentor(String plan_assentor) {
		this.plan_assentor = plan_assentor;
	}
	public String getPlan_result() {
		return plan_result;
	}
	public void setPlan_result(String plan_result) {
		this.plan_result = plan_result;
	}
	public String getPlan_note() {
		return plan_note;
	}
	public void setPlan_note(String plan_note) {
		this.plan_note = plan_note;
	}
	public String getPlan_promulgator() {
		return plan_promulgator;
	}
	public void setPlan_promulgator(String plan_promulgator) {
		this.plan_promulgator = plan_promulgator;
	}
	public int getPlan_promulgatorNum() {
		return plan_promulgatorNum;
	}
	public void setPlan_promulgatorNum(int plan_promulgatorNum) {
		this.plan_promulgatorNum = plan_promulgatorNum;
	}
	public String getPlan_branch() {
		return plan_branch;
	}
	public void setPlan_branch(String plan_branch) {
		this.plan_branch = plan_branch;
	}
	public Date getPlan_foundTime() {
		return plan_foundTime;
	}
	public void setPlan_foundTime(Date plan_foundTime) {
		this.plan_foundTime = plan_foundTime;
	}
	public Date getPlan_releaseTime() {
		return plan_releaseTime;
	}
	public void setPlan_releaseTime(Date plan_releaseTime) {
		this.plan_releaseTime = plan_releaseTime;
	}
	@Override
	public String toString() {
		return "PlanVo [plan_id=" + plan_id + ", plan_name=" + plan_name
				+ ", plan_content=" + plan_content + ", plan_type=" + plan_type
				+ ", plan_assentor=" + plan_assentor + ", plan_result="
				+ plan_result + ", plan_note=" + plan_note
				+ ", plan_promulgator=" + plan_promulgator
				+ ", plan_promulgatorNum=" + plan_promulgatorNum
				+ ", plan_branch=" + plan_branch + ", plan_foundTime="
				+ plan_foundTime + ", plan_releaseTime=" + plan_releaseTime
				+ "]";
	}
	
}
