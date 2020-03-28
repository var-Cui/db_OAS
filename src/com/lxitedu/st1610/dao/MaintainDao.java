package com.lxitedu.st1610.dao;

import java.util.ArrayList;

import com.lxitedu.st1610.vo.MaintainVo;

public interface MaintainDao {
		//���Ӳ˵�
		public void insertMaintain(MaintainVo maintainVo);
		//ɾ���˵�
		public void deleteMaintain(int id);
		//��ѯ�˵�
		public ArrayList<MaintainVo> queryMaintain();
		//�޸Ĳ˵�
		public void updateMaintain(MaintainVo maintainVo);
		//ͨ��ID��ѯ���˵����е���Ϣ
		public MaintainVo queryInfo(int id);
}
