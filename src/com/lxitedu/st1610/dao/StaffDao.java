package com.lxitedu.st1610.dao;

import java.util.ArrayList;

import com.lxitedu.st1610.vo.StaffVo;



public interface StaffDao {
		//Ա������
		public void insertStaff (StaffVo staffVo);
		//ɾ��Ա��
		public void deleteStaff(int id);
		//��ѯԱ��
		public ArrayList queryStaff();
		//�޸�Ա��
		public void updateStaff (StaffVo staffVo);
		//Ա��id��ѯ
		public StaffVo queryStaffName(int id);
		//�޸�Ա������
		public void updateStaffPwd(StaffVo staffVo);
}