package com.lxitedu.st1610.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lxitedu.st1610.dao.StaffDao;
import com.lxitedu.st1610.util.JDBCUtils;
import com.lxitedu.st1610.vo.StaffVo;

public class StaffDaoImpl implements StaffDao{

	@Override
	public void insertStaff(StaffVo staffVo) {
		Connection conn  = JDBCUtils.getConnection();

		java.sql.Date sqlDate=new java.sql.Date(staffVo.getStaff_birthdate().getTime());
		java.sql.Date sqlDate1=new java.sql.Date(staffVo.getStaff_enterTime().getTime());
		String sql="insert into staff(staff_num,staff_name,staff_sex,staff_birthdate,staff_branch,staff_position,staff_enterTime,staff_password) values(?,?,?,?,?,?,?,?)";
		PreparedStatement  pstate =null;
		try {
			pstate =conn.prepareStatement(sql);
			pstate.setInt(1, staffVo.getStaff_num());
			pstate.setString(2, staffVo.getStaff_name());
			pstate.setString(3, staffVo.getStaff_sex());
			pstate.setDate(4, sqlDate);
			pstate.setString(5, staffVo.getStaff_branch());
			pstate.setString(6, staffVo.getStaff_position());
			pstate.setDate(7, sqlDate1);
			pstate.setString(8,staffVo.getStaff_password());
			pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pstate, null);
		}
	}

	@Override
	public void deleteStaff(int id) {
		Connection conn  = JDBCUtils.getConnection();
		String sql = "delete from staff where staff_id=?";
		PreparedStatement  pstate =null;
		try {
			pstate =conn.prepareStatement(sql);
			pstate.setInt(1, id);
			pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pstate, null);
		}
		
	}

	@Override
	public ArrayList<StaffVo> queryStaff() {
		Connection conn  = JDBCUtils.getConnection();
		PreparedStatement pre=null;
		ResultSet res=null;
		StaffVo staffVo=null;
		ArrayList<StaffVo> list=new ArrayList<StaffVo>();
		try {
			pre=conn.prepareStatement("select * from staff;");
			res=pre.executeQuery();
			while(res.next()){
				staffVo =new StaffVo();
				staffVo.setStaff_id(res.getInt("staff_id"));
				staffVo.setStaff_num(res.getInt("staff_num"));
				staffVo.setStaff_name(res.getString("staff_name"));
				staffVo.setStaff_sex(res.getString("staff_sex"));
				staffVo.setStaff_birthdate(res.getDate("staff_birthdate"));
				staffVo.setStaff_branch(res.getString("staff_branch"));
				staffVo.setStaff_position(res.getString("staff_position"));
				staffVo.setStaff_enterTime(res.getDate("staff_enterTime"));
				list.add(staffVo);
				staffVo=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pre, res);
		}
		return list;
	}

	@Override
	public void updateStaff(StaffVo staffVo) {
		Connection conn  = JDBCUtils.getConnection()             ;
		java.sql.Date sqlDate=new java.sql.Date(staffVo.getStaff_birthdate().getTime());
		java.sql.Date sqlDate1=new java.sql.Date(staffVo.getStaff_enterTime().getTime());
		String sql = "update staff set staff_num=?,staff_name=?,staff_sex=?,staff_birthdate=?,staff_branch=?,staff_position=?,staff_enterTime=? where staff_id=?";
		PreparedStatement  pstate =null;
		try {
			  pstate =conn.prepareStatement(sql);
				pstate.setInt(1, staffVo.getStaff_num());
				pstate.setString(2, staffVo.getStaff_name());
				pstate.setString(3, staffVo.getStaff_sex());
				pstate.setDate(4,sqlDate);
				pstate.setString(5, staffVo.getStaff_branch());
				pstate.setString(6, staffVo.getStaff_position());
				pstate.setDate(7, sqlDate1);
				pstate.setInt(8,staffVo.getStaff_id());
			    pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pstate, null);
		}		
	}

	@Override
	public StaffVo queryStaffName(int staff_id) {
		Connection conn  = JDBCUtils.getConnection();
		String sql = "select staff_id, staff_num,staff_name,staff_sex,staff_birthdate,staff_branch,staff_position,staff_enterTime from staff where staff_id=?";
		PreparedStatement  pstate =null;
		StaffVo staffVo=new StaffVo();
		try{
			pstate =conn.prepareStatement(sql);
			pstate.setInt(1,staff_id);
			ResultSet res=pstate.executeQuery();
			while(res.next()){
				staffVo.setStaff_id(res.getInt("staff_id"));
				staffVo.setStaff_num(res.getInt("staff_num"));
				staffVo.setStaff_name(res.getString("staff_name"));
				staffVo.setStaff_sex(res.getString("staff_sex"));
				staffVo.setStaff_birthdate(res.getDate("staff_birthdate"));
				staffVo.setStaff_branch(res.getString("staff_branch"));
				staffVo.setStaff_position(res.getString("staff_position"));
				staffVo.setStaff_enterTime(res.getDate("staff_enterTime"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return staffVo;	
	}

	@Override
	public void updateStaffPwd(StaffVo staffVo) {
		Connection conn  = JDBCUtils.getConnection();
		String sql="update staff set staff_password=? where staff_num=?";
		PreparedStatement  pstate =null;
		try {
			  pstate =conn.prepareStatement(sql);
			  pstate.setString(1, staffVo.getStaff_password());
			  pstate.setInt(2, staffVo.getStaff_num());
			  pstate.executeUpdate();
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			 JDBCUtils.closeAll(conn, pstate, null);
		}
	}
	public StaffVo queryStaffVo(int num) {
		Connection conn  = JDBCUtils.getConnection();
		PreparedStatement pre=null;
		ResultSet res=null;
		StaffVo staffVo=null;
		try {
			pre=conn.prepareStatement("select * from staff where staff_num=?;");
			pre.setInt(1, num);
			res=pre.executeQuery();
			while(res.next()){
				staffVo =new StaffVo();
				staffVo.setStaff_id(res.getInt("staff_id"));
				staffVo.setStaff_num(res.getInt("staff_num"));
				staffVo.setStaff_name(res.getString("staff_name"));
				staffVo.setStaff_sex(res.getString("staff_sex"));
				staffVo.setStaff_birthdate(res.getDate("staff_birthdate"));
				staffVo.setStaff_branch(res.getString("staff_branch"));
				staffVo.setStaff_position(res.getString("staff_position"));
				staffVo.setStaff_enterTime(res.getDate("staff_enterTime"));
				staffVo.setStaff_password(res.getString("staff_password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pre, res);
		}
		return staffVo;
	}
	
	
	//ְλ��ѯ
	public ArrayList<StaffVo> queryStaff_position(String staff_position,int pageCount,int pageSize){
		Connection conn  = JDBCUtils.getConnection();
		PreparedStatement pre=null;
		ResultSet res=null;
		StaffVo staffVo=null;
		ArrayList<StaffVo> list=new ArrayList<StaffVo>();
		try {
			pre=conn.prepareStatement("select * from staff where staff_position like ? limit ?,?;");
			pre.setString(1, "%"+staff_position+"%");
			pre.setInt(2,(pageCount-1)*pageSize);
			pre.setInt(3, pageSize);
			res=pre.executeQuery();
			while(res.next()){
				staffVo =new StaffVo();
				staffVo.setStaff_num(res.getInt("staff_num"));
				staffVo.setStaff_name(res.getString("staff_name"));
				staffVo.setStaff_sex(res.getString("staff_sex"));
				staffVo.setStaff_birthdate(res.getDate("staff_birthdate"));
				staffVo.setStaff_branch(res.getString("staff_branch"));
				staffVo.setStaff_enterTime(res.getDate("staff_enterTime"));
				staffVo.setStaff_position(res.getString("staff_position"));
				list.add(staffVo);
				staffVo=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pre, res);
		}
		return list;
	}
	
	//ְλ��ѯ����
	public int queryStaff_position_count(String staff_position){
		Connection conn  = JDBCUtils.getConnection();
		PreparedStatement pre=null;
		ResultSet res=null;
		int count = 0;
		try {
			pre=conn.prepareStatement("select count(staff_id) from staff where staff_position like ?;");
			pre.setString(1, "%"+staff_position+"%");
			res=pre.executeQuery();
			res.next();
			count = res.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pre, res);
		}
		return count;
	}
	
	//��Ų�ѯ
	public ArrayList<StaffVo> queryStaff_num(String staff_num,int pageCount,int pageSize){
		Connection conn  = JDBCUtils.getConnection();
		PreparedStatement pre=null;
		ResultSet res=null;
		StaffVo staffVo=null;
		ArrayList<StaffVo> list=new ArrayList<StaffVo>();
		try {
			pre=conn.prepareStatement("select * from staff where staff_num like ? limit ?,?;");
			pre.setString(1, "%"+staff_num+"%");
			pre.setInt(2,(pageCount-1)*pageSize);
			pre.setInt(3, pageSize);
			res=pre.executeQuery();
			while(res.next()){
				staffVo =new StaffVo();
				staffVo.setStaff_num(res.getInt("staff_num"));
				staffVo.setStaff_name(res.getString("staff_name"));
				staffVo.setStaff_sex(res.getString("staff_sex"));
				staffVo.setStaff_birthdate(res.getDate("staff_birthdate"));
				staffVo.setStaff_branch(res.getString("staff_branch"));
				staffVo.setStaff_enterTime(res.getDate("staff_enterTime"));
				staffVo.setStaff_position(res.getString("staff_position"));
				list.add(staffVo);
				staffVo=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pre, res);
		}
		return list;
	}
	
	public int queryStaff_num_count(String staff_num){
		Connection conn  = JDBCUtils.getConnection();
		PreparedStatement pre=null;
		ResultSet res=null;
		int count = 0;
		try {
			pre=conn.prepareStatement("select count(staff_id) from staff where staff_num like ?;");
			pre.setString(1, "%"+staff_num+"%");
			res=pre.executeQuery();
			res.next();
			count = res.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pre, res);
		}
		return count;
	}
	
	//������ѯ
	public ArrayList<StaffVo> queryStaff_name(String staff_name,int pageCount,int pageSize){
		Connection conn  = JDBCUtils.getConnection();
		PreparedStatement pre=null;
		ResultSet res=null;
		StaffVo staffVo=null;
		ArrayList<StaffVo> list=new ArrayList<StaffVo>();
		try {
			pre=conn.prepareStatement("select * from staff where staff_name like ? limit ?,?;");
			pre.setString(1, "%"+staff_name+"%");
			pre.setInt(2,(pageCount-1)*pageSize);
			pre.setInt(3, pageSize);
			res=pre.executeQuery();
			while(res.next()){
				staffVo =new StaffVo();
				staffVo.setStaff_num(res.getInt("staff_num"));
				staffVo.setStaff_name(res.getString("staff_name"));
				staffVo.setStaff_sex(res.getString("staff_sex"));
				staffVo.setStaff_birthdate(res.getDate("staff_birthdate"));
				staffVo.setStaff_branch(res.getString("staff_branch"));
				staffVo.setStaff_enterTime(res.getDate("staff_enterTime"));
				staffVo.setStaff_position(res.getString("staff_position"));
				list.add(staffVo);
				staffVo=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pre, res);
		}
		return list;
	}
	
	public int queryStaff_name_count(String staff_name){
		Connection conn  = JDBCUtils.getConnection();
		PreparedStatement pre=null;
		ResultSet res=null;
		int count = 0;
		try {
			pre=conn.prepareStatement("select count(staff_id) from staff where staff_name like ?;");
			pre.setString(1, "%"+staff_name+"%");
			res=pre.executeQuery();
			res.next();
			count = res.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pre, res);
		}
		return count;
	}
	
	//�Ա��ѯ
	public ArrayList<StaffVo> queryStaff_sex(String staff_sex,int pageCount,int pageSize){
		Connection conn  = JDBCUtils.getConnection();
		PreparedStatement pre=null;
		ResultSet res=null;
		StaffVo staffVo=null;
		ArrayList<StaffVo> list=new ArrayList<StaffVo>();
		try {
			pre=conn.prepareStatement("select * from staff where staff_sex like ? limit ?,?;");
			pre.setString(1, "%"+staff_sex+"%");
			pre.setInt(2,(pageCount-1)*pageSize);
			pre.setInt(3, pageSize);
			res=pre.executeQuery();
			while(res.next()){
				staffVo =new StaffVo();
				staffVo.setStaff_num(res.getInt("staff_num"));
				staffVo.setStaff_name(res.getString("staff_name"));
				staffVo.setStaff_sex(res.getString("staff_sex"));
				staffVo.setStaff_birthdate(res.getDate("staff_birthdate"));
				staffVo.setStaff_branch(res.getString("staff_branch"));
				staffVo.setStaff_enterTime(res.getDate("staff_enterTime"));
				staffVo.setStaff_position(res.getString("staff_position"));
				list.add(staffVo);
				staffVo=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pre, res);
		}
		return list;
	}
	
	public int queryStaff_sex_count(String staff_sex){
		Connection conn  = JDBCUtils.getConnection();
		PreparedStatement pre=null;
		ResultSet res=null;
		int count = 0;
		try {
			pre=conn.prepareStatement("select count(staff_id) from staff where staff_sex like ?;");
			pre.setString(1, "%"+staff_sex+"%");
			res=pre.executeQuery();
			res.next();
			count = res.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pre, res);
		}
		return count;
	}
	//���Ų�ѯ
	public ArrayList<StaffVo> queryStaff_branch(String staff_branch,int pageCount,int pageSize){
		Connection conn  = JDBCUtils.getConnection();
		PreparedStatement pre=null;
		ResultSet res=null;
		StaffVo staffVo=null;
		ArrayList<StaffVo> list=new ArrayList<StaffVo>();
		try {
			pre=conn.prepareStatement("select * from staff where staff_branch like ? limit ?,?;");
			pre.setString(1, "%"+staff_branch+"%");
			pre.setInt(2,(pageCount-1)*pageSize);
			pre.setInt(3, pageSize);
			res=pre.executeQuery();
			while(res.next()){
				staffVo =new StaffVo();
				staffVo.setStaff_num(res.getInt("staff_num"));
				staffVo.setStaff_name(res.getString("staff_name"));
				staffVo.setStaff_sex(res.getString("staff_sex"));
				staffVo.setStaff_birthdate(res.getDate("staff_birthdate"));
				staffVo.setStaff_branch(res.getString("staff_branch"));
				staffVo.setStaff_enterTime(res.getDate("staff_enterTime"));
				staffVo.setStaff_position(res.getString("staff_position"));
				list.add(staffVo);
				staffVo=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pre, res);
		}
		return list;
	}
	
	public int queryStaff_branch_count(String staff_branch){
		Connection conn  = JDBCUtils.getConnection();
		PreparedStatement pre=null;
		ResultSet res=null;
		int count = 0;
		try {
			pre=conn.prepareStatement("select count(staff_id) from staff where staff_branch like ?;");
			pre.setString(1, "%"+staff_branch+"%");
			res=pre.executeQuery();
			res.next();
			count = res.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pre, res);
		}
		return count;
	}
	
	//�õ�������,���з�ҳ
			public int getPageCount()
			{	
				String sql = "SELECT count(1) from staff  ";
				Connection conn = JDBCUtils.getConnection();
				PreparedStatement pstate = null;
				ResultSet rs = null;
				try {
					pstate=conn.prepareStatement(sql);
					rs= pstate.executeQuery();
					while(rs.next())
					{
						return Integer.parseInt(rs.getString(1));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					JDBCUtils.closeAll(conn, pstate, rs);
				}
				return 0;
			}
	
	public ArrayList<StaffVo> getList(int pageCount,int pageSize)
	{
		ArrayList<StaffVo> list = new ArrayList<StaffVo>();
		String sql = "SELECT * from staff limit ?,? ";
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement pstate = null;
		ResultSet rs = null;
		try {
			pstate=conn.prepareStatement(sql);
			pstate.setInt(1,(pageCount-1)*pageSize);
			pstate.setInt(2, pageSize);
			rs= pstate.executeQuery();
			while(rs.next())
			{  
				StaffVo obj = new StaffVo(rs.getInt("staff_id"),rs.getInt("staff_num"),rs.getString("staff_name"),rs.getString("staff_sex"),rs.getDate("staff_birthdate"),rs.getString("staff_branch"),rs.getString("staff_position"),rs.getDate("staff_enterTime"),rs.getString("staff_password"));
                list.add(obj);
             }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pstate, rs);
		}
		return list;
		
	}

}
