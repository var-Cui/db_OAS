package com.lxitedu.st1610.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lxitedu.st1610.dao.me_staff_Dao;
import com.lxitedu.st1610.util.JDBCUtils;
import com.lxitedu.st1610.vo.me_staff_VO;

public class me_staff_Dao_Impl implements me_staff_Dao {

	@Override
	public void Me_staff_add(Object obj) {
		// TODO Auto-generated method stub
		me_staff_VO mv = (me_staff_VO)obj;
		System.out.println("me_staff_VO:"+mv.toString());
		String sql="insert into me_staff values(?,?,?,?,?,?)";
		Connection con =(Connection)JDBCUtils.getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;
		try{
			pre=(PreparedStatement)con.prepareStatement(sql);
			pre.setInt(1, mv.getMe_staff_id());
			pre.setString(2, mv.getMe_staff_name());
			pre.setString(3, mv.getMe_staff_branch());
			pre.setString(4, mv.getMe_staff_message());
			pre.setString(5, mv.getMe_staff_address());
			pre.setString(6, mv.getMe_staff_phone());
			pre.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(con, pre, rs);
		}
		
	}

	public void Me_staff_del(Object obj) {
		String id = (String)obj;
		Connection con = (Connection) JDBCUtils.getConnection();
		String sql = "delete from me_staff where me_staff_name=?;";
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = (PreparedStatement) con.prepareStatement(sql);
			pre.setString(1, id);
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeAll(con, pre, rs);
		}
	}

	@Override
	public void Me_staff_query(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Me_staff_update(Object obj) {
		// TODO Auto-generated method stub
		me_staff_VO mv = (me_staff_VO) obj;
		Connection con = (Connection) JDBCUtils.getConnection();
		String sql="update me_staff set me_staff_name=?,me_staff_branch=?,me_staff_message=?,me_staff_address=?,me_staff_phone=? where me_staff_id=?";
		PreparedStatement pre = null;
		ResultSet rs = null;
		try{
			pre=(PreparedStatement)con.prepareStatement(sql);
			pre.setString(1, mv.getMe_staff_name());
			pre.setString(2, mv.getMe_staff_branch());
			pre.setString(3, mv.getMe_staff_message());
			pre.setString(4, mv.getMe_staff_address());
			pre.setString(5, mv.getMe_staff_phone());
			pre.setInt(6, mv.getMe_staff_id());
			pre.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(con, pre, rs);
		}
	}
	

	public Object all_Query() {
		Connection con = (Connection)JDBCUtils.getConnection();
		String sql = "select * from me_staff ";
		PreparedStatement pre = null;
		ResultSet rs = null;
		ArrayList<me_staff_VO> ms = new ArrayList<me_staff_VO>();
		try{
			pre=(PreparedStatement)con.prepareStatement(sql);
			rs = pre.executeQuery();
			while(rs.next()){
				me_staff_VO mv = new me_staff_VO();
				mv.setMe_staff_id(rs.getInt(1));
				mv.setMe_staff_name(rs.getString(2));
				mv.setMe_staff_branch(rs.getString(3));
				mv.setMe_staff_message(rs.getString(4));
				mv.setMe_staff_address(rs.getString(5));
				mv.setMe_staff_phone(rs.getString(6));
				ms.add(mv);
			}
			return ms;
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JDBCUtils.closeAll(con, pre, rs);
		}
		return ms;
	}
	public Object me_staff_Query(String name) {
		// TODO Auto-generated method stub
		Connection con = (Connection)JDBCUtils.getConnection();
		String sql = "select * from me_staff where me_staff_name LIKE '%"+name+"%'";
		PreparedStatement pre = null;
		ResultSet rs = null;
		ArrayList<me_staff_VO> ms = new ArrayList<me_staff_VO>();
		try{
			pre=(PreparedStatement)con.prepareStatement(sql);
			rs = pre.executeQuery();
			while(rs.next()){
				me_staff_VO mv = new me_staff_VO();
				mv.setMe_staff_id(rs.getInt(1));
				mv.setMe_staff_name(rs.getString(2));
				mv.setMe_staff_branch(rs.getString(3));
				mv.setMe_staff_message(rs.getString(4));
				mv.setMe_staff_address(rs.getString(5));
				mv.setMe_staff_phone(rs.getString(6));
				ms.add(mv);
			}
			return ms;
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JDBCUtils.closeAll(con, pre, rs);
		}
		return ms;
		
	}
	public Object query_sole(String id ){//判断Id唯一
		Connection con = (Connection) JDBCUtils.getConnection();
		String sql = "select * from me_staff where me_staff_id=? ";
		PreparedStatement pre = null;
		ResultSet rs = null;
		me_staff_VO mv = new me_staff_VO();
		try {
			pre = (PreparedStatement) con.prepareStatement(sql);
			pre.setString(1, id);
			rs = pre.executeQuery();
			while(rs.next()){
				mv.setMe_staff_id(rs.getInt(1));
				mv.setMe_staff_name(rs.getString(2));
				mv.setMe_staff_branch(rs.getString(3));
				mv.setMe_staff_message(rs.getString(4));
				mv.setMe_staff_address(rs.getString(5));
				mv.setMe_staff_phone(rs.getString(6));
			}
			return mv;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeAll(con, pre, rs);
		}
		return mv;
	}

}
