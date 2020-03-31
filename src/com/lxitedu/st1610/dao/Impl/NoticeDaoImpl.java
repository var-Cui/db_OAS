package com.lxitedu.st1610.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lxitedu.st1610.util.JDBCUtils;
import com.lxitedu.st1610.vo.NoticeVo;

public class NoticeDaoImpl {
	//增加公告
	public void insertNotice(NoticeVo noticeVo) {
		Connection conn  = JDBCUtils.getConnection();
		java.sql.Date sqlDate=new java.sql.Date(noticeVo.getNotice_releaseTime().getTime());
		String sql="insert into notice(notice_name,notice_type,notice_promulgator,notice_releaseTime,notice_content) values(?,?,?,?,?)";
		PreparedStatement  pstate =null;
		try {
			pstate =conn.prepareStatement(sql);
			pstate.setString(1, noticeVo.getNotice_name());
			pstate.setInt(2, noticeVo.getNotice_type());
			pstate.setString(3, noticeVo.getNotice_promulgator());
			pstate.setDate(4, sqlDate);
			pstate.setString(5, noticeVo.getNotice_content());
			pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pstate, null);
		}
	}
	//修改公告
	public void updateNotice(NoticeVo noticeVo) {
		Connection conn  = JDBCUtils.getConnection();
		java.sql.Date sqlDate=new java.sql.Date(noticeVo.getNotice_releaseTime().getTime());
		String sql = "update notice set notice_name=?,notice_type=?,notice_promulgator=?,notice_releaseTime=?,notice_content=? where notice_id=?";
		PreparedStatement  pstate =null;
		try {
			pstate =conn.prepareStatement(sql);
			pstate.setString(1, noticeVo.getNotice_name());
			pstate.setInt(2, noticeVo.getNotice_type());
			pstate.setString(3, noticeVo.getNotice_promulgator());
			pstate.setDate(4, sqlDate);
			pstate.setString(5, noticeVo.getNotice_content());
			pstate.setInt(6, noticeVo.getNotice_id());
			pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pstate, null);
		}
	}
	//查询公告
	public List<NoticeVo> queryStaff() {
		Connection conn  = JDBCUtils.getConnection();
		PreparedStatement pre=null;
		ResultSet res=null;
		NoticeVo noticeVo=null;
		ArrayList<NoticeVo> list=new ArrayList<NoticeVo>();
		try {
			pre=conn.prepareStatement("select * from notice;");
			res=pre.executeQuery();
			while(res.next()){
				noticeVo =new NoticeVo();
				noticeVo.setNotice_id(Integer.valueOf(res.getString("notice_id")));
				noticeVo.setNotice_name(res.getString("notice_name"));
				noticeVo.setNotice_type(Integer.valueOf(res.getString("notice_type")));
				noticeVo.setNotice_promulgator(res.getString("notice_promulgator"));
				noticeVo.setNotice_releaseTime(res.getDate("notice_releaseTime"));
				noticeVo.setNotice_content(res.getString("notice_content"));
				list.add(noticeVo);
				noticeVo=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pre, res);
		}
		return list;
	}
	//按id查询公告类别
	public NoticeVo queryNoticeTypeOne(String id) {
		Connection conn  = JDBCUtils.getConnection();
		PreparedStatement pre=null;
		ResultSet res=null;
		NoticeVo noticeVo = null;
		try {
			pre=conn.prepareStatement("select * from notice where notice_id = ?;");
			pre.setString(1,id);
			res=pre.executeQuery();
			while(res.next()){
				noticeVo =new NoticeVo();
				noticeVo.setNotice_id(Integer.valueOf(res.getString("notice_id")));
				noticeVo.setNotice_name(res.getString("notice_name"));
				noticeVo.setNotice_type(Integer.valueOf(res.getString("notice_type")));
				noticeVo.setNotice_promulgator(res.getString("notice_promulgator"));
				noticeVo.setNotice_releaseTime(res.getDate("notice_releaseTime"));
				noticeVo.setNotice_content(res.getString("notice_content"));
				noticeVo.setNotice_assentor(res.getString("notice_assentor"));
				noticeVo.setNotice_result(res.getString("notice_result"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pre, res);
		}
		return noticeVo;
	}
	//按公告类别查询公告
	public ArrayList<NoticeVo> queryStaff(String type) {
		Connection conn  = JDBCUtils.getConnection();
		PreparedStatement pre=null;
		ResultSet res=null;
		NoticeVo noticeVo=null;
		ArrayList<NoticeVo> list=new ArrayList<NoticeVo>();
		try {
			pre=conn.prepareStatement("select * from notice where notice_type = ?");
			pre.setString(1,type);
			res=pre.executeQuery();
			while(res.next()){
				noticeVo =new NoticeVo();
				noticeVo.setNotice_id(Integer.valueOf(res.getString("notice_id")));
				noticeVo.setNotice_name(res.getString("notice_name"));
				noticeVo.setNotice_type(Integer.valueOf(res.getString("notice_type")));
				noticeVo.setNotice_promulgator(res.getString("notice_promulgator"));
				noticeVo.setNotice_releaseTime(res.getDate("notice_releaseTime"));
				noticeVo.setNotice_content(res.getString("notice_content"));
				list.add(noticeVo);
				noticeVo=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pre, res);
		}
		return list;
	}
	//删除公告
	public void deleteNotice(int id) {
		Connection con=(Connection)JDBCUtils.getConnection();
		String sql="delete from notice where notice_id=? ";
		PreparedStatement pre = null;
		try{
			pre=(PreparedStatement)con.prepareStatement(sql);
			pre.setInt(1, id);
			pre.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace(); 
		}finally {
			JDBCUtils.closeAll(con, pre, null);
		}
	}
}
