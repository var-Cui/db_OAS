package com.lxitedu.st1610.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lxitedu.st1610.util.JDBCUtils;
import com.lxitedu.st1610.vo.NoticeTypeVO;
import com.lxitedu.st1610.vo.NoticeVo;

public class NoticeTypeDaoImpl {
	//增加公告类别
	public void insertNoticeType(NoticeTypeVO noticeTypeVo) {
		// TODO Auto-generated method stub
		Connection conn  = JDBCUtils.getConnection();

		String sql="insert into notice_type(type) values(?)";
		PreparedStatement  pstate =null;
		try {
			pstate =conn.prepareStatement(sql);
			pstate.setString(1,noticeTypeVo.getType());
			pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pstate, null);
		}
	}
	//查询公告类别
	public ArrayList<NoticeTypeVO> queryNoticeType() {
		// TODO Auto-generated method stub
		Connection conn  = JDBCUtils.getConnection();
		PreparedStatement pre=null;
		ResultSet res=null;
		NoticeTypeVO noticeTypeVo = null;
		ArrayList<NoticeTypeVO> list=new ArrayList<NoticeTypeVO>();
		try {
			pre=conn.prepareStatement("select * from notice_type;");
			res=pre.executeQuery();
			while(res.next()){
				noticeTypeVo =new NoticeTypeVO();
				noticeTypeVo.setType(res.getString("type"));
				noticeTypeVo.setId(Integer.valueOf(res.getString("id")));
				list.add(noticeTypeVo);
				noticeTypeVo=null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pre, res);
		}
		return list;
	}
	//删除公告类别
	public void deleteNoticeType(int id) {
		// TODO Auto-generated method stub
		Connection con=(Connection)JDBCUtils.getConnection();
		String sql="delete from notice_type where id=? ";
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
	public List<NoticeVo> getType(List<NoticeVo> noticeList,List<NoticeTypeVO>  typeList) {
		Map<Integer,String> map = new HashMap<Integer,String>(); 
		if(typeList != null) {
			for (int i = 0; i < typeList.size(); i++) {
				map.put(typeList.get(i).getId(), typeList.get(i).getType());
			}
		}
		if(noticeList != null) {
			for (int i = 0; i < noticeList.size(); i++) {
				NoticeVo noticeVo = noticeList.get(i);
				if(map.containsKey(noticeVo.getNotice_type())) {
					noticeVo.setType(map.get(noticeVo.getNotice_type()));
				}
			}
		}
		return noticeList;
	}
}
