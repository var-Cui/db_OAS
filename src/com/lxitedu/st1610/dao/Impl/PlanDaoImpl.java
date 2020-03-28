package com.lxitedu.st1610.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lxitedu.st1610.dao.PlanDao;
import com.lxitedu.st1610.util.JDBCUtils;
import com.lxitedu.st1610.vo.CommentVo;
import com.lxitedu.st1610.vo.PlanVo;

public class PlanDaoImpl implements PlanDao {	
	//通过ID得到具体的list
	public PlanVo planQuery(int plan_id){
		Connection conn=JDBCUtils.getConnection();
		PreparedStatement pre=null;
		ResultSet res=null;
		PlanVo pInfo=null;
		try {
			pre=conn.prepareStatement("select * from plan where plan_id=?;");
			pre.setInt(1,plan_id);
			res=pre.executeQuery();
			while(res.next()){
				pInfo =new PlanVo();
				pInfo.setPlan_id(res.getInt("plan_id"));
				pInfo.setPlan_name(res.getString("plan_name"));
				pInfo.setPlan_content(res.getString("plan_content"));
				pInfo.setPlan_type(res.getString("plan_type"));
				pInfo.setPlan_assentor(res.getString("plan_assentor"));
				pInfo.setPlan_result(res.getString("plan_result"));
				pInfo.setPlan_note(res.getString("plan_note"));
				pInfo.setPlan_promulgator(res.getString("plan_promulgator"));
				pInfo.setPlan_promulgatorNum(res.getInt("plan_promulgatorNum"));
				pInfo.setPlan_branch(res.getString("plan_branch"));
				pInfo.setPlan_foundTime(res.getDate("plan_foundTime"));
				pInfo.setPlan_releaseTime(res.getDate("plan_releaseTime"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pre, res);
		}
		return pInfo;	
	}
	//个人计划增加
	public void planAdd(PlanVo planVo){
		Connection conn=JDBCUtils.getConnection();
		PreparedStatement pre=null;
		ResultSet res=null;
		try {
			pre=conn.prepareStatement("insert into plan(plan_name,plan_content,plan_type,plan_result,plan_promulgator,plan_promulgatorNum,plan_branch,plan_foundTime) values(?,?,?,?,?,?,?,sysdate());");
			pre.setString(1,planVo.getPlan_name());
			pre.setString(2,planVo.getPlan_content());
			pre.setString(3,planVo.getPlan_type());
			pre.setString(4,planVo.getPlan_result());
			pre.setString(5,planVo.getPlan_promulgator());
			pre.setInt(6,planVo.getPlan_promulgatorNum());
			pre.setString(7,planVo.getPlan_branch());
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pre, res);
		}	
	}
	//通过ID删除具体的值
	public void planDel(int plan_id){
		Connection conn=JDBCUtils.getConnection();
		PreparedStatement pre=null;
		ResultSet res=null;
		try {
			pre=conn.prepareStatement("delete from plan where plan_id=?;");
			pre.setInt(1,plan_id);
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pre, res);
		}	
	}
	//增加评论记录
	public void commentAdd(CommentVo commentVo){
		Connection conn=JDBCUtils.getConnection();
		PreparedStatement pre=null;
		ResultSet res=null;
		try {
			pre=conn.prepareStatement("insert into COMMENT values(?,?,?,?);");
			pre.setInt(1,commentVo.getComment_plan_id());
			pre.setString(2,commentVo.getComment_staff_name());
			pre.setString(3,commentVo.getComment_staff_position());
			pre.setString(4,commentVo.getComment_text());
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pre, res);
		}	
	}
	//得到总数据
	public int getPageCount(String sql)
	{	
		
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
	//计划迭代list
	public ArrayList<PlanVo> planPersonalList(int pageCount,int pageSize,String sql)
	{
		
	ArrayList<PlanVo> list = new ArrayList<PlanVo>();
	Connection conn = JDBCUtils.getConnection();
	PreparedStatement pstate = null;
	ResultSet res = null;
	PlanVo pInfo=null;
	try {
		pstate=conn.prepareStatement(sql);
		pstate.setInt(1,(pageCount-1)*pageSize);
		pstate.setInt(2, pageSize);
		res= pstate.executeQuery();
		while(res.next())
		{  
			pInfo =new PlanVo();
			pInfo.setPlan_id(res.getInt("plan_id"));
			pInfo.setPlan_name(res.getString("plan_name"));
			pInfo.setPlan_content(res.getString("plan_content"));
			pInfo.setPlan_type(res.getString("plan_type"));
			pInfo.setPlan_assentor(res.getString("plan_assentor"));
			pInfo.setPlan_result(res.getString("plan_result"));
			pInfo.setPlan_note(res.getString("plan_note"));
			pInfo.setPlan_promulgator(res.getString("plan_promulgator"));
			pInfo.setPlan_promulgatorNum(res.getInt("plan_promulgatorNum"));
			pInfo.setPlan_branch(res.getString("plan_branch"));
			pInfo.setPlan_foundTime(res.getDate("plan_foundTime"));
			pInfo.setPlan_releaseTime(res.getDate("plan_releaseTime"));
			list.add(pInfo);
			pInfo=null;
	     }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		JDBCUtils.closeAll(conn, pstate, res);
	}	
	return list;	
	}
	//评论查询
	public ArrayList<CommentVo> commentList(int pageCount,int pageSize,String sql)
	{		
	ArrayList<CommentVo> list = new ArrayList<CommentVo>();
	Connection conn = JDBCUtils.getConnection();
	PreparedStatement pstate = null;
	ResultSet res = null;
	CommentVo cInfo=null;
	try {
		pstate=conn.prepareStatement(sql);
		pstate.setInt(1,(pageCount-1)*pageSize);
		pstate.setInt(2, pageSize);
		res= pstate.executeQuery();
		while(res.next())
		{  
			cInfo =new CommentVo();
			cInfo.setComment_plan_id(res.getInt("comment_plan_id"));
			cInfo.setComment_staff_name(res.getString("comment_staff_name"));
			cInfo.setComment_staff_position(res.getString("comment_staff_position"));
			cInfo.setComment_text(res.getString("comment_text"));
			list.add(cInfo);
			cInfo=null;
	     }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		JDBCUtils.closeAll(conn, pstate, res);
	}	
	return list;	
	}
	//审核完成修改属性
	public void planTypeRe(String sql,int plan_id)
	{
	Connection conn = JDBCUtils.getConnection();
	PreparedStatement pstate = null;
	ResultSet res = null;
	try {
		pstate=conn.prepareStatement(sql);
		pstate.setInt(1,plan_id);
		pstate.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		JDBCUtils.closeAll(conn, pstate, res);
	}		
	}
}
