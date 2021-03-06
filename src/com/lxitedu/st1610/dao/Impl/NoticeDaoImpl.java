package com.lxitedu.st1610.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lxitedu.st1610.util.JDBCUtils;
import com.lxitedu.st1610.vo.NoticeVo;
import com.mysql.jdbc.Statement;

public class NoticeDaoImpl {
	//增加公告
	public int insertNotice(NoticeVo noticeVo) {
		Connection conn  = JDBCUtils.getConnection();
		java.sql.Date sqlDate=new java.sql.Date(noticeVo.getNotice_releaseTime().getTime());
		String sql="insert into notice(notice_name,notice_type,notice_promulgator,notice_releaseTime,notice_content,file_name,notice_assentor,notice_result) values(?,?,?,?,?,?,?,?)";
		PreparedStatement  pstate =null;
		int idNo = 0;
		try {
			pstate=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstate.setString(1, noticeVo.getNotice_name());
			pstate.setInt(2, noticeVo.getNotice_type());
			pstate.setString(3, noticeVo.getNotice_promulgator());
			pstate.setDate(4, sqlDate);
			pstate.setString(5, noticeVo.getNotice_content());
			pstate.setString(6, noticeVo.getFile_name());
			pstate.setString(7, noticeVo.getNotice_assentor());
			pstate.setString(8, noticeVo.getNotice_result());
			if(pstate.executeUpdate() > 0 ){
				ResultSet rs = pstate.getGeneratedKeys();
				if(rs.next()){
					idNo = rs.getInt(1);
				}
				rs.close();//释放资源
			}
			return idNo;
		} catch (SQLException e) {
			e.printStackTrace();
			return idNo;
		}finally{
			JDBCUtils.closeAll(conn, pstate, null);
		}
	}
	//修改公告
	public void updateNotice(NoticeVo noticeVo) {
		Connection conn  = JDBCUtils.getConnection();
		java.sql.Date sqlDate=new java.sql.Date(noticeVo.getNotice_releaseTime().getTime());
		String sql = "update notice set notice_name=?,notice_type=?,notice_promulgator=?,notice_releaseTime=?,notice_content=?,file_name =? where notice_id=?";
		PreparedStatement  pstate =null;
		try {
			pstate =conn.prepareStatement(sql);
			pstate.setString(1, noticeVo.getNotice_name());
			pstate.setInt(2, noticeVo.getNotice_type());
			pstate.setString(3, noticeVo.getNotice_promulgator());
			pstate.setDate(4, sqlDate);
			pstate.setString(5, noticeVo.getNotice_content());
			if(noticeVo.getFile_name() != null && (!"".equals(noticeVo.getFile_name()))) {
				pstate.setString(6, noticeVo.getFile_name());
			} else {
				pstate.setString(6, noticeVo.getOldFileName());
			}
			pstate.setInt(7, noticeVo.getNotice_id());
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
				noticeVo.setFile_name(res.getString("file_name"));
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
	public ArrayList<NoticeVo> noticeQuery_page(int pageCount,int pageSize,String sql ){
		Connection con = (Connection) RegisterImpl.getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;
		ArrayList<NoticeVo> noticeVoList = new ArrayList<NoticeVo>();
		try {
			pre = (PreparedStatement) con.prepareStatement(sql);
			pre.setInt(1,(pageCount-1)*pageSize);
			pre.setInt(2, pageSize);
			rs = pre.executeQuery();
			while(rs.next()){
				NoticeVo noticeVo = new NoticeVo();
				noticeVo.setNotice_id(Integer.valueOf(rs.getString("notice_id")));
				noticeVo.setNotice_name(rs.getString("notice_name"));
				noticeVo.setNotice_type(Integer.valueOf(rs.getString("notice_type")));
				noticeVo.setNotice_promulgator(rs.getString("notice_promulgator"));
				noticeVo.setNotice_releaseTime(rs.getDate("notice_releaseTime"));
				noticeVo.setNotice_content(rs.getString("notice_content"));
				noticeVo.setNotice_assentor(rs.getString("notice_assentor"));
				noticeVoList.add(noticeVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeAll(con, pre, rs);
		}
		return noticeVoList;	
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
				noticeVo.setFile_name(res.getString("file_name"));
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
	//查询今日公告
	public List<NoticeVo> queryTodayNotice() {
		Connection conn  = JDBCUtils.getConnection();
		PreparedStatement pre=null;
		ResultSet res=null;
		NoticeVo noticeVo=null;
		List<NoticeVo> list=new ArrayList<NoticeVo>();
		try {
			pre=conn.prepareStatement("select * from notice where notice_releaseTime = ?");
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			pre.setString(1,sdf.format(date));
			res=pre.executeQuery();
			while(res.next()){
				noticeVo =new NoticeVo();
				noticeVo.setNotice_id(Integer.valueOf(res.getString("notice_id")));
				noticeVo.setNotice_name(res.getString("notice_name"));
				noticeVo.setNotice_releaseTime(res.getDate("notice_releaseTime"));
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
