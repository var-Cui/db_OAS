package com.lxitedu.st1610.vo;

import java.util.Date;

public class NoticeVo {
	private int notice_id;
	private String notice_name;
	private int notice_type;
	private String notice_content;
	private String notice_promulgator;
	private String notice_assentor;
	private String notice_result;
	private String notice_note;
	private String file_name;
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	private Date notice_releaseTime;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private String type;
	public NoticeVo() {
		super();
	}
	public int getNotice_type() {
		return notice_type;
	}
	public void setNotice_type(int notice_type) {
		this.notice_type = notice_type;
	}
	public int getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}
	public String getNotice_name() {
		return notice_name;
	}
	public void setNotice_name(String notice_name) {
		this.notice_name = notice_name;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public String getNotice_promulgator() {
		return notice_promulgator;
	}
	public void setNotice_promulgator(String notice_promulgator) {
		this.notice_promulgator = notice_promulgator;
	}
	public String getNotice_assentor() {
		return notice_assentor;
	}
	public void setNotice_assentor(String notice_assentor) {
		this.notice_assentor = notice_assentor;
	}
	public String getNotice_result() {
		return notice_result;
	}
	public void setNotice_result(String notice_result) {
		this.notice_result = notice_result;
	}
	public String getNotice_note() {
		return notice_note;
	}
	public void setNotice_note(String notice_note) {
		this.notice_note = notice_note;
	}
	public Date getNotice_releaseTime() {
		return notice_releaseTime;
	}
	public void setNotice_releaseTime(Date notice_releaseTime) {
		this.notice_releaseTime = notice_releaseTime;
	}
	
	
	
}
