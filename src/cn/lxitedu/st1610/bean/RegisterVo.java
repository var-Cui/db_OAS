package cn.lxitedu.st1610.bean;

import java.util.Date;

public class RegisterVo {
	private int register_id;//考勤ID
	private int register_staffNum;//请假登记者编�?
	private String register_name;//请假登记者姓�?
	private String register_branch;//请假者登记部�?
	private String register_type;//请假登记类型
	private String register_reason;//请假原因
	private Date register_startTime;//请假�?始时�?
	private Date register_endTime;//请假到期时间
	private String register_assentor;//请假审核�?
	private String register_result;//审核结果（待审核  未�?�过 已�?�过�?
	private String register_note;//审核结果的原�?
	private Date register_releaseTime;//审核结果时间
	public RegisterVo() {
		super();
	}
	public RegisterVo(int register_id, int register_staffNum,
			String register_name, String register_branch, String register_type,
			String register_reason, Date register_startTime,
			Date register_endTime, String register_assentor,
			String register_result, String register_note,
			Date register_releaseTime) {
		super();
		this.register_id = register_id;
		this.register_staffNum = register_staffNum;
		this.register_name = register_name;
		this.register_branch = register_branch;
		this.register_type = register_type;
		this.register_reason = register_reason;
		this.register_startTime = register_startTime;
		this.register_endTime = register_endTime;
		this.register_assentor = register_assentor;
		this.register_result = register_result;
		this.register_note = register_note;
		this.register_releaseTime = register_releaseTime;
	}
	public int getRegister_id() {
		return register_id;
	}
	public void setRegister_id(int register_id) {
		this.register_id = register_id;
	}
	public int getRegister_staffNum() {
		return register_staffNum;
	}
	public void setRegister_staffNum(int register_staffNum) {
		this.register_staffNum = register_staffNum;
	}
	public String getRegister_name() {
		return register_name;
	}
	public void setRegister_name(String register_name) {
		this.register_name = register_name;
	}
	public String getRegister_branch() {
		return register_branch;
	}
	public void setRegister_branch(String register_branch) {
		this.register_branch = register_branch;
	}
	public String getRegister_type() {
		return register_type;
	}
	public void setRegister_type(String register_type) {
		this.register_type = register_type;
	}
	public String getRegister_reason() {
		return register_reason;
	}
	public void setRegister_reason(String register_reason) {
		this.register_reason = register_reason;
	}
	public Date getRegister_startTime() {
		return register_startTime;
	}
	public void setRegister_startTime(Date register_startTime) {
		this.register_startTime = register_startTime;
	}
	public Date getRegister_endTime() {
		return register_endTime;
	}
	public void setRegister_endTime(Date register_endTime) {
		this.register_endTime = register_endTime;
	}
	public String getRegister_assentor() {
		return register_assentor;
	}
	public void setRegister_assentor(String register_assentor) {
		this.register_assentor = register_assentor;
	}
	public String getRegister_result() {
		return register_result;
	}
	public void setRegister_result(String register_result) {
		this.register_result = register_result;
	}
	public String getRegister_note() {
		return register_note;
	}
	public void setRegister_note(String register_note) {
		this.register_note = register_note;
	}
	public Date getRegister_releaseTime() {
		return register_releaseTime;
	}
	public void setRegister_releaseTime(Date register_releaseTime) {
		this.register_releaseTime = register_releaseTime;
	}
	@Override
	public String toString() {
		return "RegisterVo [register_id=" + register_id
				+ ", register_staffNum=" + register_staffNum
				+ ", register_name=" + register_name + ", register_branch="
				+ register_branch + ", register_type=" + register_type
				+ ", register_reason=" + register_reason
				+ ", register_startTime=" + register_startTime
				+ ", register_endTime=" + register_endTime
				+ ", register_assentor=" + register_assentor
				+ ", register_result=" + register_result + ", register_note="
				+ register_note + ", register_releaseTime="
				+ register_releaseTime + "]";
	}		
}
