package cn.lxitedu.st1610.dao;

import java.util.ArrayList;
import java.util.List;

import cn.lxitedu.st1610.bean.MaintainVo;

public interface MaintainDao {
	boolean insertMaintain(MaintainVo maintainVo);
	boolean deleteMaintain(int id);
	boolean updateMaintain(MaintainVo maintainVo);
	List<MaintainVo> queryMaintain();
	MaintainVo queryInfo(int id); 
}
