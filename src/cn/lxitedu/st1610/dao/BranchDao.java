package cn.lxitedu.st1610.dao;

import java.util.ArrayList;
import java.util.List;

import cn.lxitedu.st1610.bean.BranchVo;



public interface BranchDao {
	//部门增加
	public boolean insertBranch (BranchVo branchVo);
	//删除部门
	public boolean deleteBranch(int id);
	//查询部门
	public List queryBranch();
	//修改部门
	public boolean updateBranch(BranchVo branchVo);
	//部门名称查询
	public BranchVo queryBranchName(String name);
}
