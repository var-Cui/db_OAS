package cn.lxitedu.st1610.bean;

public class CommentVo {
	private int comment_plan_id; //INT NOT NULL,-- 计划ID
	private String comment_staff_name; //VARCHAR(15) NOT NULL,-- 评论者姓名
	private String comment_staff_position; //VARCHAR(15) NOT NULL,-- 评论者职位
	private String comment_text; //TEXT NOT NULL, -- 评论内容、
	
	public CommentVo() {
		super();
	}

	public CommentVo(int comment_plan_id, String comment_staff_name,
			String comment_staff_position, String comment_text) {
		super();
		this.comment_plan_id = comment_plan_id;
		this.comment_staff_name = comment_staff_name;
		this.comment_staff_position = comment_staff_position;
		this.comment_text = comment_text;
	}

	public int getComment_plan_id() {
		return comment_plan_id;
	}

	public void setComment_plan_id(int comment_plan_id) {
		this.comment_plan_id = comment_plan_id;
	}

	public String getComment_staff_name() {
		return comment_staff_name;
	}

	public void setComment_staff_name(String comment_staff_name) {
		this.comment_staff_name = comment_staff_name;
	}

	public String getComment_staff_position() {
		return comment_staff_position;
	}

	public void setComment_staff_position(String comment_staff_position) {
		this.comment_staff_position = comment_staff_position;
	}

	public String getComment_text() {
		return comment_text;
	}

	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}
	
}
