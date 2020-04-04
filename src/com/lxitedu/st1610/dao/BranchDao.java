package com.lxitedu.st1610.dao;

import java.util.ArrayList;

import com.lxitedu.st1610.vo.BranchVo;



public interface BranchDao {
	//部门增加
	public void insertBranch (BranchVo branchVo);
	//删除部门
	public void deleteBranch(int id);
	//查询部门
	public ArrayList queryBranch();
	//修改部门
	public void updateBranch(BranchVo branchVo);
	//部门名称查询
	public BranchVo queryBranchName(String name);
	//部门主管查询
	public String queryBranchMinister(String name);
}
