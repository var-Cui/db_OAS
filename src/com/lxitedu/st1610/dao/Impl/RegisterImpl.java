package com.lxitedu.st1610.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.lxitedu.st1610.dao.RegisterDao;
import com.lxitedu.st1610.util.JDBCUtils;
import com.lxitedu.st1610.vo.PunchVo;
import com.lxitedu.st1610.vo.RegisterVo;

public  class RegisterImpl extends JDBCUtils implements RegisterDao{
	
	@Override
	public void registerAdd(Object obj) {
		// TODO Auto-generated method stub
		RegisterVo registerVo = (RegisterVo)obj;
		Connection con = (Connection) JDBCUtils.getConnection();
		String sql = "insert into register(register_staffNum,register_name,register_branch,register_type,register_reason,register_startTime,register_endTime,register_assentor,register_result)  values(?,?,?,?,?,?,?,?,?);";
		PreparedStatement pre = null;
		ResultSet rs = null;
	
		try {
			pre = (PreparedStatement) con.prepareStatement(sql);
			pre.setInt(1, registerVo.getRegister_staffNum());
			pre.setString(2, registerVo.getRegister_name());
			pre.setString(3, registerVo.getRegister_branch());
			pre.setString(4, registerVo.getRegister_type());
			pre.setString(5, registerVo.getRegister_reason());
			pre.setObject(6,registerVo.getRegister_startTime());
			pre.setObject(7, registerVo.getRegister_endTime());
			pre.setString(8, registerVo.getRegister_assentor());
			pre.setString(9, registerVo.getRegister_result());
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeAll(con, pre, rs);
		}
	}

	@Override
	public void registerDelete(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerUpdate(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerQuery(Object obj) {
		// TODO Auto-generated method stub
		
	}
	
	public Object registerQuery_particular(String sql  ){//详细查询 外出，出差，请假 记录
		Connection con = (Connection)JDBCUtils.getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;
		RegisterVo registerVo = new RegisterVo();
		try {
			pre = (PreparedStatement) con.prepareStatement(sql);
			rs = pre.executeQuery();
			while(rs.next()){
				
				registerVo.setRegister_id(rs.getInt(1));
				registerVo.setRegister_staffNum(rs.getInt(2));
				registerVo.setRegister_name(rs.getString(3));
				registerVo.setRegister_branch(rs.getString(4));
				registerVo.setRegister_type(rs.getString(5));
				registerVo.setRegister_reason(rs.getString(6));
				registerVo.setRegister_startTime(rs.getTimestamp(7));
				registerVo.setRegister_endTime(rs.getTimestamp(8));
				registerVo.setRegister_assentor(rs.getString(9));
				registerVo.setRegister_result(rs.getString(10));
				registerVo.setRegister_note(rs.getString(11));
				registerVo.setRegister_releaseTime(rs.getTimestamp(12));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeAll(con, pre, rs);
		}
		return registerVo;	
	}
	
	public String registerQuery_superior(String str){
		//这个方法用来获取他（她）的上级是谁
		Connection con = (Connection) RegisterImpl.getConnection();
		String sql = "SELECT staff.staff_name FROM staff,branch WHERE  branch.branch_name=? AND branch.branch_minister=staff.staff_name AND staff_position='部长'AND staff_branch=?";
		PreparedStatement pre = null;
		ResultSet rs = null;
		String name = "";
		try {
			pre = (PreparedStatement) con.prepareStatement(sql);
			pre.setString(1,str);
			pre.setString(2,str);
			rs = pre.executeQuery();
			while(rs.next()){
				name = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeAll(con, pre, rs);
		}
		return name;	
	}
	
	public List registerQuery_PersonagePunch(int id ){//打卡个人记录
		Connection con = (Connection) RegisterImpl.getConnection();
		String sql = "SELECT * FROM punch WHERE punch_staffId=?" ;
		PreparedStatement pre = null;
		ResultSet rs = null;
		String name = "";
		List punchVoList = new ArrayList();
		try {
			pre = (PreparedStatement) con.prepareStatement(sql);
			pre.setInt(1,id);
			rs = pre.executeQuery();
			while(rs.next()){
				PunchVo punchVo = new PunchVo();
				punchVo.setPunch_id(rs.getInt(1));
				punchVo.setPunch_staffId(rs.getInt(2));
				punchVo.setPunch_staffName(rs.getString(3));
				punchVo.setPunch_type(rs.getString(4));
				punchVo.setPunch_time(rs.getTimestamp(5));
				punchVo.setPunch_result(rs.getString(6));
				punchVoList.add(punchVo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeAll(con, pre, rs);
		}
		return punchVoList;	
	}
	
	public List registerQuery_Personage(String sql ){//选择查询 外出，出差，请假 记录
		Connection con = (Connection) RegisterImpl.getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;
		String name = "";
		List RegisterVoList = new ArrayList();
		try {
			pre = (PreparedStatement) con.prepareStatement(sql);
			rs = pre.executeQuery();
			while(rs.next()){
				RegisterVo registerVo = new RegisterVo();
				registerVo.setRegister_id(rs.getInt(1));
				registerVo.setRegister_staffNum(rs.getInt(2));
				registerVo.setRegister_name(rs.getString(3));
				registerVo.setRegister_branch(rs.getString(4));
				registerVo.setRegister_type(rs.getString(5));
				registerVo.setRegister_reason(rs.getString(6));
				registerVo.setRegister_startTime(rs.getTimestamp(7));
				registerVo.setRegister_endTime(rs.getTimestamp(8));
				registerVo.setRegister_assentor(rs.getString(9));
				registerVo.setRegister_result(rs.getString(10));
				registerVo.setRegister_note(rs.getString(11));
				registerVo.setRegister_releaseTime(rs.getTimestamp(12));
				RegisterVoList.add(registerVo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeAll(con, pre, rs);
		}
		return RegisterVoList;	
	}
	
	public List<RegisterVo> registerQuery_page(int pageCount,int pageSize,String sql ){//选择查询 外出，出差，请假 记录
		Connection con = (Connection) RegisterImpl.getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;
		List<RegisterVo> RegisterVoList = new ArrayList<RegisterVo>();
		try {
			pre = (PreparedStatement) con.prepareStatement(sql);
			pre.setInt(1,(pageCount-1)*pageSize);
			pre.setInt(2, pageSize);
			rs = pre.executeQuery();
			while(rs.next()){
				RegisterVo registerVo = new RegisterVo();
				registerVo.setRegister_id(rs.getInt(1));
				registerVo.setRegister_staffNum(rs.getInt(2));
				registerVo.setRegister_name(rs.getString(3));
				registerVo.setRegister_branch(rs.getString(4));
				registerVo.setRegister_type(rs.getString(5));
				registerVo.setRegister_reason(rs.getString(6));
				registerVo.setRegister_startTime(rs.getTimestamp(7));
				registerVo.setRegister_endTime(rs.getTimestamp(8));
				registerVo.setRegister_assentor(rs.getString(9));
				registerVo.setRegister_result(rs.getString(10));
				registerVo.setRegister_note(rs.getString(11));
				registerVo.setRegister_releaseTime(rs.getTimestamp(12));
				RegisterVoList.add(registerVo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeAll(con, pre, rs);
		}
		return RegisterVoList;	
	}
	//审核完毕，修改属性类
	public void registerTypeRe(String sql,int register_id){//选择查询 外出，出差，请假 记录
		Connection con = (Connection) RegisterImpl.getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = (PreparedStatement) con.prepareStatement(sql);
			pre.setInt(1,register_id);
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeAll(con, pre, rs);
		}
	}
	

}
