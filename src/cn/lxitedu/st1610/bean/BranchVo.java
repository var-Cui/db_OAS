package cn.lxitedu.st1610.bean;

import java.util.Date;

public class BranchVo {
	private int branch_id;
	private String branch_name;
	private String branch_minister;
	private String branch_summarize;
	private Date branch_time;
	public BranchVo() {
		super();
	}
	public int getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public String getBranch_minister() {
		return branch_minister;
	}
	public void setBranch_minister(String branch_minister) {
		this.branch_minister = branch_minister;
	}
	public String getBranch_summarize() {
		return branch_summarize;
	}
	public void setBranch_summarize(String branch_summarize) {
		this.branch_summarize = branch_summarize;
	}
	public Date getBranch_time() {
		return branch_time;
	}
	public void setBranch_time(Date branch_time) {
		this.branch_time = branch_time;
	}
	
}
