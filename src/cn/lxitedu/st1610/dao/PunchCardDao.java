package cn.lxitedu.st1610.dao;

import java.util.List;


import cn.lxitedu.st1610.bean.PunchVo;

public interface PunchCardDao {
	boolean punchCard_Add(PunchVo punchvo);
	boolean punchCard_Delete(int punch_id);
	boolean punchCard_Update(PunchVo punchvo);
	List<PunchVo> punchCard_Query();
}
