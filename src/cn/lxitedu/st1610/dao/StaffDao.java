package cn.lxitedu.st1610.dao;

import java.util.ArrayList;
import java.util.List;

import cn.lxitedu.st1610.bean.StaffVo;



public interface StaffDao {
		//员工增加
		public boolean insertStaff (StaffVo staffVo);
		//删除员工
		public boolean deleteStaff(int id);
		//查询员工
		public List queryStaff();
		//修改员工
		public boolean updateStaff (StaffVo staffVo);
		//员工id查询
		public StaffVo queryStaffName(int id);
		//修改员工密码
		public boolean updateStaffPwd(StaffVo staffVo);
//		//员工登录判断
//		public StaffVo queryStaffInfo(int num,String pwd);
}
