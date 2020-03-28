package cn.lxitedu.st1610.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.lxitedu.st1610.dao.BaseDao;
import cn.lxitedu.st1610.dao.PlanDao;
import cn.lxitedu.st1610.util.JDBCUtils;
import cn.lxitedu.st1610.bean.CommentVo;
import cn.lxitedu.st1610.bean.MaintainVo;
import cn.lxitedu.st1610.bean.PlanVo;

public class PlanDaoImpl extends BaseDao implements PlanDao {	
	//ͨ��ID�õ������list
	public PlanVo planQuery(int plan_id){
		/*Connection conn=JDBCUtils.getConnection();
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
		return pInfo;	*/
		PlanVo pInfo=null;
		String sql = "select * from plan where plan_id=?;";
		Object[] parms = { plan_id};
			try {
				this.rs = executeQuery(sql, parms);
				if (this.rs.next()) {
					pInfo =new PlanVo();
					pInfo.setPlan_id(rs.getInt("plan_id"));
					pInfo.setPlan_name(rs.getString("plan_name"));
					pInfo.setPlan_content(rs.getString("plan_content"));
					pInfo.setPlan_type(rs.getString("plan_type"));
					pInfo.setPlan_assentor(rs.getString("plan_assentor"));
					pInfo.setPlan_result(rs.getString("plan_result"));
					pInfo.setPlan_note(rs.getString("plan_note"));
					pInfo.setPlan_promulgator(rs.getString("plan_promulgator"));
					pInfo.setPlan_promulgatorNum(rs.getInt("plan_promulgatorNum"));
					pInfo.setPlan_branch(rs.getString("plan_branch"));
					pInfo.setPlan_foundTime(rs.getDate("plan_foundTime"));
					pInfo.setPlan_releaseTime(rs.getDate("plan_releaseTime"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				this.closeAll(conn, pstmt, rs);
			}
			return pInfo;
	}
	//���˼ƻ�����
	public boolean planAdd(PlanVo planVo){
		/*Connection conn=JDBCUtils.getConnection();
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
		}	*/
		String sql="insert into plan(plan_name,plan_content,plan_type,plan_result,plan_promulgator,plan_promulgatorNum,plan_branch,plan_foundTime) values(?,?,?,?,?,?,?,sysdate());";
		Object []parms={planVo.getPlan_name(),planVo.getPlan_content(),planVo.getPlan_type(),planVo.getPlan_result(),planVo.getPlan_promulgator(),planVo.getPlan_promulgatorNum(),planVo.getPlan_branch(),planVo.getPlan_foundTime()};
		return this.executeUpdate(sql, parms)>0;
	}
	//ͨ��IDɾ�������ֵ
	public boolean planDel(int plan_id){
		/*Connection conn=JDBCUtils.getConnection();
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
		}	*/
		String sql="delete from plan where plan_id=?;";
		Object []parms={plan_id};
		return this.executeUpdate(sql, parms)>0;
	}
	//�������ۼ�¼
	public boolean commentAdd(CommentVo commentVo){
		/*Connection conn=JDBCUtils.getConnection();
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
		}	*/
		String sql="insert into COMMENT values(?,?,?,?);";
		Object []parms={commentVo.getComment_plan_id(),commentVo.getComment_staff_name(),commentVo.getComment_staff_position(),commentVo.getComment_text()};
		return this.executeUpdate(sql, parms)>0;
	}
	//�õ�������
	public int getPageCount(String sql)
	{	
		
		/*Connection conn = JDBCUtils.getConnection();
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
		return 0;*/
		try {
			this.rs = executeQuery(sql, null);
			if (this.rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return 0;
	}
	//�ƻ�����list
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
	//���۲�ѯ
	public List<CommentVo> commentList(int pageCount,int pageSize,String sql)
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
	//�������޸�����
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
