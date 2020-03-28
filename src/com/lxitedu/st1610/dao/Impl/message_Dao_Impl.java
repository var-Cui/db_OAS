package com.lxitedu.st1610.dao.Impl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lxitedu.st1610.dao.message_Dao;
import com.lxitedu.st1610.util.JDBCUtils;
import com.lxitedu.st1610.vo.Page_VO;
import com.lxitedu.st1610.vo.message_VO;

public  class message_Dao_Impl implements message_Dao {

	@Override
	public void Message_add(Object obj) {
		// TODO Auto-generated method stub
		message_VO mv = (message_VO)obj;
		System.out.println("message_VO:"+mv.toString());
		Connection con=(Connection)JDBCUtils.getConnection();
		String sql = "insert into message  values(?,?);";
		PreparedStatement pre = null;
		ResultSet rs = null;
		try{
			pre=(PreparedStatement)con.prepareStatement(sql);
			pre.setInt(1, mv.getMessage_id());
			pre.setString(2, mv.getMessage_name());
			pre.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JDBCUtils.closeAll(con, pre, rs);
		}
	}

	@Override
	public void Message_del(Object obj) {
		// TODO Auto-generated method stub
		Connection con=(Connection)JDBCUtils.getConnection();
		String id = (String)obj;
		String sql="delete from message where message_id=? ";
		PreparedStatement pre = null;
		ResultSet rs = null;
		try{
			pre=(PreparedStatement)con.prepareStatement(sql);
			pre.setString(1, id);
			pre.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace(); 
		}finally {
			JDBCUtils.closeAll(con, pre, rs);
		}
		
	}
	public Object Query(){
		Connection con = (Connection)JDBCUtils.getConnection();
		String sql = "select * from message ";
		PreparedStatement pre = null;
		ResultSet rs = null;
		ArrayList<message_VO> ms = new ArrayList<message_VO>();
		try{
			pre=(PreparedStatement)con.prepareStatement(sql);
			rs = pre.executeQuery();
			while(rs.next()){
				message_VO mv = new message_VO();
				mv.setMessage_id(rs.getInt(1));
				mv.setMessage_name(rs.getString(2));
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
	@Override
	public void Message_update(Object obj) {
		// TODO Auto-generated method stub
		message_VO mv = (message_VO)obj;
		Connection con = (Connection) JDBCUtils.getConnection();
		String sql="update message set message_name=? where message_id=? ";
		PreparedStatement pre = null;
		ResultSet rs = null;
		try{
			pre=(PreparedStatement)con.prepareStatement(sql);
			pre.setString(1, mv.getMessage_name());
			pre.setInt(2, mv.getMessage_id());
			pre.executeUpdate();		
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(con, pre, rs);
		}
		
	}

	@Override
	public Object all_Query(Object obj) {
		// TODO Auto-generated method stub
		Connection con = (Connection)JDBCUtils.getConnection();
		String sql="select * from message";
		PreparedStatement pre = null;
		ResultSet rs = null;
		ArrayList<message_VO> message = new ArrayList<message_VO>();
		try{
			pre=(PreparedStatement)con.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next()){
				message_VO mv = new message_VO();
				mv.setMessage_id(rs.getInt(1));
				mv.setMessage_name(rs.getString(2));
				message.add(mv);
			}
			return message;
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JDBCUtils.closeAll(con, pre, rs);
		}
		return message;
	}
	
	public message_VO message_Query(String message_id) {
		// TODO Auto-generated method stub
		Connection con = (Connection)JDBCUtils.getConnection();
		String sql="select * from  message where message_id=?";
		PreparedStatement pre = null;
		ResultSet rs = null;
		message_VO mv = new message_VO();
		try{
			pre=(PreparedStatement)con.prepareStatement(sql);
			pre.setString(1, message_id);
			rs = pre.executeQuery();
			while(rs.next()){
				mv.setMessage_id(rs.getInt(1));
				mv.setMessage_name(rs.getString(2));
			}
			return mv;
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JDBCUtils.closeAll(con, pre, rs);
		}
		return null;
		
	}
	
	public Object message_Query_two(String message_name){
		Connection con = (Connection)JDBCUtils.getConnection();
		String sql="select * from message where message_name LIKE '%"+message_name+"%'";
		PreparedStatement pre = null;
		ResultSet rs = null;
		ArrayList<message_VO> message = new ArrayList<message_VO>();
		try{
			pre=(PreparedStatement)con.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next()){
				message_VO mv = new message_VO();
				mv.setMessage_id(rs.getInt(1));
				mv.setMessage_name(rs.getString(2));
				message.add(mv);
			}
			return message;
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JDBCUtils.closeAll(con, pre, rs);
		}
		return message;
	}

	
	public Object page_Query(Page_VO page){
		Connection con=(Connection)JDBCUtils.getConnection();
		String sql = "select * from message limit ?,?";
		String sql1 = "select count(message)from me_staff ";
		PreparedStatement pre = null;
		ResultSet rs = null;
		/*ArrayList<message_VO> message = new ArrayList<message_VO>();*/
		ArrayList<message_VO> message = new ArrayList<message_VO>();
		try{
			pre=(PreparedStatement)con.prepareStatement(sql);
			pre.setInt(1,page.getCurrentPage());
			pre.setInt(2, page.getPageMaxCount());
			rs=pre.executeQuery();
			while(rs.next()){
				message_VO mv = new message_VO();
				/*mv.setMessage_id(rs.getInt(1));
				mv.setMessage_name(rs.getString(2));*/
				mv.setMessage_id(rs.getInt(1));
				mv.setMessage_name(rs.getString(2));
				message.add(mv);
			}
			page.setReseltList(message);
			int count = 3;
			page.setToatlPages(count);
			if(count%page.getPageMaxCount()==0){
				page.setToatlPages(count/page.getPageMaxCount());
			}else{
				int totalPage = (int) count/page.getPageMaxCount();
				page.setToatlPages(totalPage+1);
			}
			return page;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(con, pre, rs);
		}
		return message;
	}
	
}
