package cn.lxitedu.st1610.bean;



import java.util.Date;

public class PunchVo {
	private int punch_id;//打卡自主增长Id
	private int punch_staffId;//打卡者Id
	private String punch_staffName;//打卡者姓�?
	private String punch_type;//打卡类型（上班，下班�?
	private Date punch_time;//打卡时间
	private String punch_result;
	
	public PunchVo() {
		super();
	}
	
	
	public PunchVo(int punch_id, int punch_staffId, String punch_staffName,
			String punch_type, Date punch_time, String punch_result) {
		super();
		this.punch_id = punch_id;
		this.punch_staffId = punch_staffId;
		this.punch_staffName = punch_staffName;
		this.punch_type = punch_type;
		this.punch_time = punch_time;
		this.punch_result = punch_result;
	}

	public int getPunch_id() {
		return punch_id;
	}

	public void setPunch_id(int punch_id) {
		this.punch_id = punch_id;
	}

	public int getPunch_staffId() {
		return punch_staffId;
	}
	public void setPunch_staffId(int punch_staffId) {
		this.punch_staffId = punch_staffId;
	}
	public String getPunch_staffName() {
		return punch_staffName;
	}
	public void setPunch_staffName(String punch_staffName) {
		this.punch_staffName = punch_staffName;
	}
	public String getPunch_type() {
		return punch_type;
	}
	public void setPunch_type(String punch_type) {
		this.punch_type = punch_type;
	}
	public Date getPunch_time() {
		return punch_time;
	}
	public void setPunch_time(Date punch_time) {
		this.punch_time = punch_time;
	}
	public String getPunch_result() {
		return punch_result;
	}
	public void setPunch_result(String punch_result) {
		this.punch_result = punch_result;
	}


	@Override
	public String toString() {
		return "PunchVo [punch_id=" + punch_id + ", punch_staffId="
				+ punch_staffId + ", punch_staffName=" + punch_staffName
				+ ", punch_type=" + punch_type + ", punch_time=" + punch_time
				+ ", punch_result=" + punch_result + "]";
	}
	
	
	
}
