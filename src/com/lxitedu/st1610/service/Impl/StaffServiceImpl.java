package com.lxitedu.st1610.service.Impl;

import java.util.ArrayList;

import com.lxitedu.st1610.dao.StaffDao;
import com.lxitedu.st1610.dao.Impl.StaffDaoImpl;
import com.lxitedu.st1610.service.StaffService;
import com.lxitedu.st1610.vo.StaffVo;

public class StaffServiceImpl implements StaffService{
    StaffDao staffDao=new StaffDaoImpl();
	@Override
	public void insertStaff(StaffVo staffVo) {
		// TODO Auto-generated method stub
		//return staffDao.insertStaff(staffVo);
	}

	@Override
	public void deleteStaff(int id) {
		// TODO Auto-generated method stub
		//return staffDao.
	}

	@Override
	public ArrayList queryStaff() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStaff(StaffVo staffVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StaffVo queryStaffName(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStaffPwd(StaffVo staffVo) {
		// TODO Auto-generated method stub
		
	}

}
