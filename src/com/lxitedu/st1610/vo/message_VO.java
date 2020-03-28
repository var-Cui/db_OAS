package com.lxitedu.st1610.vo;


public class message_VO  extends Page_VO {
	private int message_id; //INT NOT NULL AUTO_INCREMENT,--通讯组ID
	private String message_name; //VARCHAR(15) NOT NULL, -- 通讯组名称
	public message_VO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public message_VO(int message_id, String message_name) {
		super();
		this.message_id = message_id;
		this.message_name = message_name;
	}
	public int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	public String getMessage_name() {
		return message_name;
	}
	public void setMessage_name(String message_name) {
		this.message_name = message_name;
	}
	@Override
	public String toString() {
		return "MessageVo [message_id=" + message_id + ", message_name="
				+ message_name + "]";
	}
	
}
