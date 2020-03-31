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
import com.lxitedu.st1610.vo.BranchVo;

import cn.lxitedu.st1610.bean.MeetingVo;

public class MeetingDaoImpl {
	//增加会议
	public void insertMeeting(MeetingVo meetingVo) {
		Connection conn  = JDBCUtils.getConnection();

		String sql="insert into meeting(meeting_name,meeting_releaseTime,is_open,meeting_staff,branch_id,meeting_place) values(?,?,?,?,?,?)";
		PreparedStatement  pstate =null;
		try {
			pstate =conn.prepareStatement(sql);
			pstate.setString(1,meetingVo.getMeeting_name());
			pstate.setTimestamp(2,new java.sql.Timestamp( meetingVo.getMeeting_releaseTime().getTime()));
			pstate.setString(3,meetingVo.getIs_open());
			pstate.setString(4,meetingVo.getMeeting_staff());
			pstate.setInt(5,meetingVo.getBranch_id());
			pstate.setString(6,meetingVo.getMeeting_place());
			pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pstate, null);
		}
	}
	//查询会议
	public ArrayList<MeetingVo> queryMeeting() {
		Connection conn  = JDBCUtils.getConnection();
		PreparedStatement pre=null;
		ResultSet res=null;
		MeetingVo meetingVo = null;
		ArrayList<MeetingVo> list = new ArrayList<MeetingVo>();
		try {
			pre=conn.prepareStatement("select meeting_id,meeting_name,branch_id,meeting_staff,meeting_place,meeting_releaseTime from meeting;");
			res=pre.executeQuery();
			while(res.next()){
				meetingVo =new MeetingVo();
				meetingVo.setMeeting_id(res.getInt(1));
				meetingVo.setBranch_id(res.getInt(3));
				meetingVo.setMeeting_name(res.getString(2));
				meetingVo.setMeeting_releaseTime(res.getTimestamp(6));
				meetingVo.setMeeting_place(res.getString(5));
				meetingVo.setMeeting_staff(res.getString(4));
				list.add(meetingVo);
				meetingVo=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pre, res);
		}
		return list;
	}
	public MeetingVo queryMeetingOne(String id) {
		Connection conn  = JDBCUtils.getConnection();
		PreparedStatement pre=null;
		ResultSet res=null;
		MeetingVo meetingVo = null;
		try {
			pre=conn.prepareStatement("select * from meeting where meeting_id = ?;");
			pre.setString(1,id);
			res=pre.executeQuery();
			while(res.next()){
				meetingVo =new MeetingVo();
				meetingVo.setMeeting_id(res.getInt("meeting_id"));
				meetingVo.setBranch_id(res.getInt("branch_id"));
				meetingVo.setMeeting_name(res.getString("meeting_name"));
				meetingVo.setMeeting_place(res.getString("meeting_place"));
				meetingVo.setMeeting_releaseTime(res.getTimestamp("meeting_releaseTime"));
				meetingVo.setMeeting_staff(res.getString("meeting_staff"));
				meetingVo.setIs_open(res.getString("is_open"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pre, res);
		}
		return meetingVo;
	}
	public void updateMeeting(MeetingVo meetingVo) {
		Connection conn  = JDBCUtils.getConnection();
		String sql = "update meeting set meeting_name=?,branch_id=?,is_open=?,meeting_place=?,meeting_releaseTime=?,meeting_staff=? where meeting_id=?";
		PreparedStatement  pstate =null;
		try {
			pstate =conn.prepareStatement(sql);
			pstate.setString(1, meetingVo.getMeeting_name());
			pstate.setInt(2,meetingVo.getBranch_id());
			pstate.setString(3,meetingVo.getIs_open());
			pstate.setString(4,meetingVo.getMeeting_place());
			pstate.setTimestamp(5,new java.sql.Timestamp( meetingVo.getMeeting_releaseTime().getTime()));
			pstate.setString(6,meetingVo.getMeeting_staff());
			pstate.setInt(7, meetingVo.getMeeting_id());
			pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pstate, null);
		}
	}
	//删除会议
	public void deleteMeeting(int id) {
		Connection con=(Connection)JDBCUtils.getConnection();
		String sql="delete from meeting where meeting_id=? ";
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
	public ArrayList<MeetingVo> getBranchName(ArrayList<MeetingVo> meetingList,List<BranchVo> branchList) {
		Map<Integer,String> map = new HashMap<Integer,String>(); 
		if(branchList != null) {
			for (int i = 0; i < branchList.size(); i++) {
				map.put(branchList.get(i).getBranch_id(), branchList.get(i).getBranch_name());
			}
		}
		if(meetingList != null) {
			for (int i = 0; i < meetingList.size(); i++) {
				MeetingVo meetingVo = meetingList.get(i);
				if(map.containsKey(meetingVo.getBranch_id())) {
					meetingVo.setBranch_name(map.get(meetingVo.getBranch_id()));
				}
			}
		}
		return meetingList;
	}
}
