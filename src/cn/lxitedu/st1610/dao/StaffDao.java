package cn.lxitedu.st1610.dao;

import java.util.ArrayList;
import java.util.List;

import cn.lxitedu.st1610.bean.StaffVo;



public interface StaffDao {
		//Ա������
		public boolean insertStaff (StaffVo staffVo);
		//ɾ��Ա��
		public boolean deleteStaff(int id);
		//��ѯԱ��
		public List queryStaff();
		//�޸�Ա��
		public boolean updateStaff (StaffVo staffVo);
		//Ա��id��ѯ
		public StaffVo queryStaffName(int id);
		//�޸�Ա������
		public boolean updateStaffPwd(StaffVo staffVo);
//		//Ա����¼�ж�
//		public StaffVo queryStaffInfo(int num,String pwd);
}
