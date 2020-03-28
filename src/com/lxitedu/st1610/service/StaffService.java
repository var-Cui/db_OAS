package com.lxitedu.st1610.service;

import java.util.ArrayList;

import com.lxitedu.st1610.vo.StaffVo;

public interface StaffService {
			//员工增加
			public void insertStaff (StaffVo staffVo);
			//删除员工
			public void deleteStaff(int id);
			//查询员工
			public ArrayList queryStaff();
			//修改员工
			public void updateStaff (StaffVo staffVo);
			//员工id查询
			public StaffVo queryStaffName(int id);
			//修改员工密码
			public void updateStaffPwd(StaffVo staffVo);
}
