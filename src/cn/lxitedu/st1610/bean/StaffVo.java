package cn.lxitedu.st1610.bean;

import java.util.Date;

/**
 * @author eleven
 * @version 2017-7-21 21:35:50
 */
public class StaffVo {
	@Override
	public String toString() {
		return "StaffVo [staff_id=" + staff_id + ", staff_num=" + staff_num
				+ ", staff_name=" + staff_name + ", staff_sex=" + staff_sex
				+ ", staff_birthdate=" + staff_birthdate + ", staff_branch="
				+ staff_branch + ", staff_position=" + staff_position
				+ ", staff_enterTime=" + staff_enterTime + ", staff_password="
				+ staff_password + "]";
	}

	private int staff_id;
	private int staff_num;
	private String staff_name;
	private String staff_sex;
	private Date staff_birthdate;
	private String staff_branch;
	private String staff_position;
	private Date staff_enterTime;
	private String staff_password;
	
	public StaffVo() {
		super();
	}
	

	public StaffVo(int staff_id, int staff_num, String staff_name,
			String staff_sex, Date staff_birthdate, String staff_branch,
			String staff_position, Date staff_enterTime, String staff_password) {
		super();
		this.staff_id = staff_id;
		this.staff_num = staff_num;
		this.staff_name = staff_name;
		this.staff_sex = staff_sex;
		this.staff_birthdate = staff_birthdate;
		this.staff_branch = staff_branch;
		this.staff_position = staff_position;
		this.staff_enterTime = staff_enterTime;
		this.staff_password = staff_password;
	}



	public int getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}

	public int getStaff_num() {
		return staff_num;
	}

	public void setStaff_num(int staff_num) {
		this.staff_num = staff_num;
	}

	public String getStaff_name() {
		return staff_name;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	public String getStaff_sex() {
		return staff_sex;
	}

	public void setStaff_sex(String staff_sex) {
		this.staff_sex = staff_sex;
	}

	public Date getStaff_birthdate() {
		return staff_birthdate;
	}

	public void setStaff_birthdate(Date staff_birthdate) {
		this.staff_birthdate = staff_birthdate;
	}

	public String getStaff_branch() {
		return staff_branch;
	}

	public void setStaff_branch(String staff_branch) {
		this.staff_branch = staff_branch;
	}

	public String getStaff_position() {
		return staff_position;
	}

	public void setStaff_position(String staff_position) {
		this.staff_position = staff_position;
	}

	public Date getStaff_enterTime() {
		return staff_enterTime;
	}

	public void setStaff_enterTime(Date staff_enterTime) {
		this.staff_enterTime = staff_enterTime;
	}

	public String getStaff_password() {
		return staff_password;
	}

	public void setStaff_password(String staff_password) {
		this.staff_password = staff_password;
	}
	
	
	
}
