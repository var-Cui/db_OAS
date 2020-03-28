package com.lxitedu.st1610.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lxitedu.st1610.dao.PunchCardDao;
import com.lxitedu.st1610.util.JDBCUtils;
import com.lxitedu.st1610.vo.PunchVo;

public class PunchCardImpl extends JDBCUtils implements PunchCardDao {
	@Override
	public void punchCard_Add(Object obj) {
		// TODO Auto-generated method stub
		PunchVo punchVo =(PunchVo)obj;
		Connection con = (Connection) JDBCUtils.getConnection();
		String sql = "insert into punch(punch_staffID,punch_staffName,punch_type,punch_time,punch_result)  values(?,?,?,?,?);";
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = (PreparedStatement) con.prepareStatement(sql);
			pre.setInt(1, punchVo.getPunch_staffId());
			pre.setString(2, punchVo.getPunch_staffName());
			pre.setString(3, punchVo.getPunch_type());
			pre.setObject(4, punchVo.getPunch_time());
			pre.setString(5, punchVo.getPunch_result());
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeAll(con, pre, rs);
		}
	}

	@Override
	public void punchCard_Delete(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void punchCard_Update(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object punchCard_Query() {
		// TODO Auto-generated method stub
		Connection con = (Connection) JDBCUtils.getConnection();
		String sql = "SELECT * FROM punch";
		PreparedStatement pre = null;
		ResultSet rs = null;
		List punchVoList = new ArrayList();
		try {
			pre = (PreparedStatement) con.prepareStatement(sql);
			rs = pre.executeQuery();
			int count = 0;
			
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
	
	public Object punchCard_QuerySelect(String str) {
		// TODO Auto-generated method stub
		Connection con = (Connection) JDBCUtils.getConnection();
		
		PreparedStatement pre = null;
		ResultSet rs = null;
		List punchVoList = new ArrayList();
		try {
			pre = (PreparedStatement) con.prepareStatement(str);
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
	
	public String punchCard_date(int id,String type,String date){
		Connection con = (Connection) JDBCUtils.getConnection();
		System.out.println(""+type);
		String sql = "SELECT punch_staffID FROM punch WHERE punch_staffID=? AND punch_type=? AND punch_time > ?;";
		PreparedStatement pre = null;
		ResultSet rs = null;
		String str = "";
		try {
			pre = (PreparedStatement) con.prepareStatement(sql);
			pre.setInt(1,id);
			pre.setString(2, type);
			pre.setString(3, date);
			rs = pre.executeQuery();
			int count = 0;
			while(rs.next()){
				count++;
			}
			if(count!=0){
				str = "今日"+type+"已打卡"; 	
			}else{
				str = "今日"+type+"未打卡";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeAll(con, pre, rs);
		}
		return str;	
	}
}
