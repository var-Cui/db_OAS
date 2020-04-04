package com.lxitedu.st1610.dao;

import java.util.ArrayList;

import com.lxitedu.st1610.vo.BranchVo;



public interface BranchDao {
	//��������
	public void insertBranch (BranchVo branchVo);
	//ɾ������
	public void deleteBranch(int id);
	//��ѯ����
	public ArrayList queryBranch();
	//�޸Ĳ���
	public void updateBranch(BranchVo branchVo);
	//�������Ʋ�ѯ
	public BranchVo queryBranchName(String name);
	//�������ܲ�ѯ
	public String queryBranchMinister(String name);
}
