package com.lxitedu.st1610.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.lxitedu.st1610.dao.StaffDao;
import com.lxitedu.st1610.util.JDBCUtils;
import com.lxitedu.st1610.vo.StaffVo;





public class StaffDaoImpl implements StaffDao{

	@Override
	public void insertStaff(StaffVo staffVo) {
		// TODO Auto-generated method stub
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pstate, null);
		}
	}

	@Override
	public void deleteStaff(int id) {
		// TODO Auto-generated method stub
		Connection conn  = JDBCUtils.getConnection();
		
		String sql = "delete from staff where staff_id=?";
		PreparedStatement  pstate =null;
		try {
			pstate =conn.prepareStatement(sql);
			pstate.setInt(1, id);
			
			pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pstate, null);
		}
		
	}

	@Override
	public ArrayList<StaffVo> queryStaff() {
		// TODO Auto-generated method stub
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pre, res);
		}
		return list;
	}

	@Override
	public void updateStaff(StaffVo staffVo) {
		// TODO Auto-generated method stub
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pstate, null);
		}		
	}

	@Override
	public StaffVo queryStaffName(int staff_id) {
		// TODO Auto-generated method stub
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return staffVo;	
	}

	@Override
	public void updateStaffPwd(StaffVo staffVo) {
		// TODO Auto-generated method stub
		Connection conn  = JDBCUtils.getConnection();
		
		String sql="update staff set staff_password=? where staff_num=?";
		PreparedStatement  pstate =null;
		try {
			  pstate =conn.prepareStatement(sql);
			  pstate.setString(1, staffVo.getStaff_password());
			  pstate.setInt(2, staffVo.getStaff_num());
			  pstate.executeUpdate();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 JDBCUtils.closeAll(conn, pstate, null);
		}
	}
	public StaffVo queryStaffVo(int num) {
		// TODO Auto-generated method stub
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pre, res);
		}
		return staffVo;
	}
	
	
	//职位查询
	public ArrayList<StaffVo> queryStaff_position(String staff_position){
		Connection conn  = JDBCUtils.getConnection();
		PreparedStatement pre=null;
		ResultSet res=null;
		StaffVo staffVo=null;
		ArrayList<StaffVo> list=new ArrayList<StaffVo>();
		try {
			pre=conn.prepareStatement("select * from staff where staff_position=?;");
			pre.setString(1, staff_position);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pre, res);
		}
		return list;
	}
	//编号查询
		public ArrayList<StaffVo> queryStaff_num(int staff_num){
			Connection conn  = JDBCUtils.getConnection();
			PreparedStatement pre=null;
			ResultSet res=null;
			StaffVo staffVo=null;
			ArrayList<StaffVo> list=new ArrayList<StaffVo>();
			try {
				pre=conn.prepareStatement("select * from staff where staff_num=?;");
				pre.setInt(1, staff_num);
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				JDBCUtils.closeAll(conn, pre, res);
			}
			return list;
		}
		//姓名查询
				public ArrayList<StaffVo> queryStaff_name(String staff_name){
					Connection conn  = JDBCUtils.getConnection();
					PreparedStatement pre=null;
					ResultSet res=null;
					StaffVo staffVo=null;
					ArrayList<StaffVo> list=new ArrayList<StaffVo>();
					try {
						pre=conn.prepareStatement("select * from staff where staff_name=?;");
						pre.setString(1, staff_name);
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						JDBCUtils.closeAll(conn, pre, res);
					}
					return list;
				}
				//性别查询
				public ArrayList<StaffVo> queryStaff_sex(String staff_sex){
					Connection conn  = JDBCUtils.getConnection();
					PreparedStatement pre=null;
					ResultSet res=null;
					StaffVo staffVo=null;
					ArrayList<StaffVo> list=new ArrayList<StaffVo>();
					try {
						pre=conn.prepareStatement("select * from staff where staff_sex=?;");
						pre.setString(1, staff_sex);
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						JDBCUtils.closeAll(conn, pre, res);
					}
					return list;
				}
				//部门查询
				public ArrayList<StaffVo> queryStaff_branch(String staff_branch){
					Connection conn  = JDBCUtils.getConnection();
					PreparedStatement pre=null;
					ResultSet res=null;
					StaffVo staffVo=null;
					ArrayList<StaffVo> list=new ArrayList<StaffVo>();
					try {
						pre=conn.prepareStatement("select * from staff where staff_branch=?;");
						pre.setString(1, staff_branch);
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						JDBCUtils.closeAll(conn, pre, res);
					}
					return list;
				}
	
	
	//得到总数据,进行分页
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					JDBCUtils.closeAll(conn, pstate, rs);
				}
				return 0;
			}
	
	public List<StaffVo> getList(int pageCount,int pageSize)
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pstate, rs);
		}
		
		return list;
		
	}

}
