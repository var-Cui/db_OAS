package cn.lxitedu.st1610.dao;

import java.util.ArrayList;
import java.util.List;

import cn.lxitedu.st1610.bean.BranchVo;



public interface BranchDao {
	//��������
	public boolean insertBranch (BranchVo branchVo);
	//ɾ������
	public boolean deleteBranch(int id);
	//��ѯ����
	public List queryBranch();
	//�޸Ĳ���
	public boolean updateBranch(BranchVo branchVo);
	//�������Ʋ�ѯ
	public BranchVo queryBranchName(String name);
}
