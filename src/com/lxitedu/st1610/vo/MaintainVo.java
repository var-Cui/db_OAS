package com.lxitedu.st1610.vo;

import java.util.Date;

public class MaintainVo {
	private int maintain_id;
	private int maintain_model;
	private String maintain_menu;
	private String maintain_url;
	private Date maintain_time;
	public MaintainVo() {
		super();
	}
	public int getMaintain_id() {
		return maintain_id;
	}
	public void setMaintain_id(int maintain_id) {
		this.maintain_id = maintain_id;
	}
	public int getMaintain_model() {
		return maintain_model;
	}
	public void setMaintain_model(int maintain_model) {
		this.maintain_model = maintain_model;
	}
	public String getMaintain_menu() {
		return maintain_menu;
	}
	public void setMaintain_menu(String maintain_menu) {
		this.maintain_menu = maintain_menu;
	}
	public String getMaintain_url() {
		return maintain_url;
	}
	public void setMaintain_url(String maintain_url) {
		this.maintain_url = maintain_url;
	}
	public Date getMaintain_time() {
		return maintain_time;
	}
	public void setMaintain_time(Date maintain_time) {
		this.maintain_time = maintain_time;
	}
	
	
}
