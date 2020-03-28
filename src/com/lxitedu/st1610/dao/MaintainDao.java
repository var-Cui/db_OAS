package com.lxitedu.st1610.dao;

import java.util.ArrayList;

import com.lxitedu.st1610.vo.MaintainVo;

public interface MaintainDao {
		//增加菜单
		public void insertMaintain(MaintainVo maintainVo);
		//删除菜单
		public void deleteMaintain(int id);
		//查询菜单
		public ArrayList<MaintainVo> queryMaintain();
		//修改菜单
		public void updateMaintain(MaintainVo maintainVo);
		//通过ID查询到菜单所有的信息
		public MaintainVo queryInfo(int id);
}
