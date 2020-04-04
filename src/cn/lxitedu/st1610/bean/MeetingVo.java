package cn.lxitedu.st1610.bean;

import java.util.Date;

public class MeetingVo {
	private int meeting_id;
	private String meeting_name;
	private Date meeting_startTime;
	private String meeting_place;
	private String meeting_staff;
	private String meeting_promulgator;
	private String meeting_assentor;
	public int getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}
	private String meeting_result;
	private String is_open;
	private int branch_id;
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	private Date meeting_releaseTime;
	private String branch_name;
	
	public MeetingVo() {
		super();
	}
	public int getMeeting_id() {
		return meeting_id;
	}
	public void setMeeting_id(int meeting_id) {
		this.meeting_id = meeting_id;
	}
	public String getMeeting_name() {
		return meeting_name;
	}
	public void setMeeting_name(String meeting_name) {
		this.meeting_name = meeting_name;
	}
	public Date getMeeting_startTime() {
		return meeting_startTime;
	}
	public void setMeeting_startTime(Date meeting_startTime) {
		this.meeting_startTime = meeting_startTime;
	}
	public String getMeeting_place() {
		return meeting_place;
	}
	public void setMeeting_place(String meeting_place) {
		this.meeting_place = meeting_place;
	}
	public String getMeeting_staff() {
		return meeting_staff;
	}
	public void setMeeting_staff(String meeting_staff) {
		this.meeting_staff = meeting_staff;
	}
	public String getMeeting_promulgator() {
		return meeting_promulgator;
	}
	public void setMeeting_promulgator(String meeting_promulgator) {
		this.meeting_promulgator = meeting_promulgator;
	}
	public String getMeeting_assentor() {
		return meeting_assentor;
	}
	public void setMeeting_assentor(String meeting_assentor) {
		this.meeting_assentor = meeting_assentor;
	}
	public String getIs_open() {
		return is_open;
	}
	public void setIs_open(String is_open) {
		this.is_open = is_open;
	}
	public String getMeeting_result() {
		return meeting_result;
	}
	public void setMeeting_result(String meeting_result) {
		this.meeting_result = meeting_result;
	}
	public Date getMeeting_releaseTime() {
		return meeting_releaseTime;
	}
	public void setMeeting_releaseTime(Date meeting_releaseTime) {
		this.meeting_releaseTime = meeting_releaseTime;
	}
}
