package com.lxitedu.st1610.vo;

//通讯详细信息
public class me_staff_VO extends Page_VO{
	private int me_staff_id; //INT NOT NULL AUTO_INCREMENT,-- 通讯人员ID
	private String me_staff_name; //VARCHAR(15) NOT NULL,-- 通讯人员名称
	private String me_staff_branch; //VARCHAR(15) NOT NULL,-- 通讯人员部门
	private String me_staff_message; //VARCHAR(15) NOT NULL,-- 通讯人员信息组
	private String me_staff_address; //VARCHAR(30) NOT NULL,-- 通讯人员家庭地址
	private String me_staff_phone; //VARCHAR(12) NOT NULL,--  通讯人员电话号码
	public int getMe_staff_id() {
		return me_staff_id;
	}
	public void setMe_staff_id(int me_staff_id) {
		this.me_staff_id = me_staff_id;
	}
	public String getMe_staff_name() {
		return me_staff_name;
	}
	public void setMe_staff_name(String me_staff_name) {
		this.me_staff_name = me_staff_name;
	}
	public String getMe_staff_branch() {
		return me_staff_branch;
	}
	public void setMe_staff_branch(String me_staff_branch) {
		this.me_staff_branch = me_staff_branch;
	}
	public String getMe_staff_message() {
		return me_staff_message;
	}
	public void setMe_staff_message(String me_staff_message) {
		this.me_staff_message = me_staff_message;
	}
	public String getMe_staff_address() {
		return me_staff_address;
	}
	public void setMe_staff_address(String me_staff_address) {
		this.me_staff_address = me_staff_address;
	}
	public String getMe_staff_phone() {
		return me_staff_phone;
	}
	public void setMe_staff_phone(String me_staff_phone) {
		this.me_staff_phone = me_staff_phone;
	}
	public me_staff_VO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public me_staff_VO(int me_staff_id, String me_staff_name,
			String me_staff_branch, String me_staff_message,
			String me_staff_address, String me_staff_phone) {
		super();
		this.me_staff_id = me_staff_id;
		this.me_staff_name = me_staff_name;
		this.me_staff_branch = me_staff_branch;
		this.me_staff_message = me_staff_message;
		this.me_staff_address = me_staff_address;
		this.me_staff_phone = me_staff_phone;
	}
	@Override
	public String toString() {
		return "me_staff_VO [me_staff_id=" + me_staff_id + ", me_staff_name="
				+ me_staff_name + ", me_staff_branch=" + me_staff_branch
				+ ", me_staff_message=" + me_staff_message
				+ ", me_staff_address=" + me_staff_address
				+ ", me_staff_phone=" + me_staff_phone + "]";
	}
	
}
