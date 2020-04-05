package com.lxitedu.st1610.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lxitedu.st1610.dao.MaintainDao;
import com.lxitedu.st1610.util.JDBCUtils;
import com.lxitedu.st1610.vo.BranchVo;
import com.lxitedu.st1610.vo.MaintainVo;

public class MaintainDaoImpl implements MaintainDao{

	@Override
	public void insertMaintain(MaintainVo maintainVo) {
				Connection conn  = JDBCUtils.getConnection();
				java.sql.Date sqlDate=new java.sql.Date(maintainVo.getMaintain_time().getTime());
				String sql="insert into maintain(maintain_model,maintain_menu,maintain_url,maintain_time) values(?,?,?,?)";
				PreparedStatement  pstate =null;
				try {
					pstate =conn.prepareStatement(sql);
					pstate.setInt(1, maintainVo.getMaintain_model());
					pstate.setString(2, maintainVo.getMaintain_menu());
					pstate.setString(3, maintainVo.getMaintain_url());
					pstate.setDate(4, sqlDate);
					pstate.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					JDBCUtils.closeAll(conn, pstate, null);
				}
	}

	@Override
	public void deleteMaintain(int id) {
		Connection conn  = JDBCUtils.getConnection();
		String sql = "delete from maintain where maintain_id=?";
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
	public ArrayList<MaintainVo> queryMaintain() {
		Connection conn  = JDBCUtils.getConnection();
		PreparedStatement pre=null;
		ResultSet res=null;
		MaintainVo maintainVo=null;
		ArrayList<MaintainVo> list=new ArrayList<MaintainVo>();
		try {
			pre=conn.prepareStatement("select * from maintain;");
			res=pre.executeQuery();
			while(res.next()){
				maintainVo =new MaintainVo();
				maintainVo.setMaintain_id(res.getInt("maintain_id"));
				maintainVo.setMaintain_model(res.getInt("maintain_model"));
				maintainVo.setMaintain_menu(res.getString("maintain_menu"));
				maintainVo.setMaintain_url(res.getString("maintain_url"));
				maintainVo.setMaintain_time(res.getDate("maintain_time"));
				list.add(maintainVo);
				maintainVo=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pre, res);
		}
		return list;
	}

	@Override
	public void updateMaintain(MaintainVo maintainVo) {
		Connection conn  = JDBCUtils.getConnection()             ;
		java.sql.Date sqlDate=new java.sql.Date(maintainVo.getMaintain_time().getTime());
		
		String sql = "update maintain set maintain_model=?,maintain_menu=?,maintain_url=?,maintain_time=? where maintain_id=?";
		PreparedStatement  pstate =null;
		try {
			  pstate =conn.prepareStatement(sql);
				
			  	pstate.setInt(1, maintainVo.getMaintain_model());
				pstate.setString(2, maintainVo.getMaintain_menu());
				pstate.setString(3, maintainVo.getMaintain_url());
				pstate.setDate(4,sqlDate);
				pstate.setInt(5,maintainVo.getMaintain_id());
			    pstate.executeUpdate();
			  
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pstate, null);
		}		
	}

	@Override
	public MaintainVo queryInfo(int id) {
		Connection conn  = JDBCUtils.getConnection();
		String sql = "select maintain_id,maintain_model,maintain_menu,maintain_url,maintain_time from maintain where maintain_id=?";
		PreparedStatement  pstate =null;
		MaintainVo maintainVo=new MaintainVo();
		try{
			pstate =conn.prepareStatement(sql);
			pstate.setInt(1,id);
			ResultSet res=pstate.executeQuery();
			while(res.next()){
				maintainVo.setMaintain_id(res.getInt("maintain_id"));
				maintainVo.setMaintain_model(res.getInt("maintain_model"));
				maintainVo.setMaintain_menu(res.getString("maintain_menu"));
				maintainVo.setMaintain_url(res.getString("maintain_url"));
				maintainVo.setMaintain_time(res.getDate("maintain_time"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return maintainVo;	
	}

	public List<MaintainVo> getList(String name) {
		Connection conn  = JDBCUtils.getConnection();
		String sql ="";
		PreparedStatement  pstate =null;
		MaintainVo maintainVo = null;
		List<MaintainVo> list=new ArrayList<MaintainVo>();
		Date date = new Date();
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String time = sdf.format(date);
			sql = " SELECT '会议' AS 'type',meeting_promulgator AS people FROM meeting  "
			    + " WHERE meeting_assentor = '"+ name +"'  AND meeting_result = '待审核' AND meeting_releaseTime = '" +time
				+ "' UNION ALL SELECT '公告',notice_promulgator FROM notice"
				+ " WHERE notice_assentor = '"+ name +"'  AND notice_result = '待审核' AND notice_releaseTime = '" + time
				+ "' UNION ALL SELECT register_type,register_name FROM register " 
				+ " WHERE register_assentor = '"+ name +"'AND register_result = '待审核' AND register_releaseTime = '" + time
				+ "' UNION ALL SELECT plan_type,plan_promulgator FROM plan "
				+ " WHERE plan_assentor = '"+ name +"'  AND plan_type = '个人' AND plan_releaseTime = '" + time + "';";
			pstate =conn.prepareStatement(sql);
			ResultSet res=pstate.executeQuery();
			while(res.next()){
				maintainVo = new MaintainVo();
				maintainVo.setMaintain_url(res.getString("type"));
				maintainVo.setMaintain_menu(res.getString("people"));
				list.add(maintainVo);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<BranchVo>  getAuditList(String name){
		Connection conn  = JDBCUtils.getConnection();
		String sql ="";
		PreparedStatement  pstate =null;
		BranchVo branchVo = null;
		List<BranchVo> list=new ArrayList<BranchVo>();
		Date date = new Date();
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String time = sdf.format(date);
			sql = " SELECT '公告审批通过' AS result ,notice_id AS id,'1' as type FROM notice "
				+ " WHERE notice_promulgator = '"+ name +"' AND notice_result = '已通过' AND notice_releaseTime = '" +time
				+ " 'UNION ALL SELECT '公告审批未通过' AS result ,notice_id AS id,'1' as type FROM notice "
				+ " WHERE notice_promulgator = '"+ name +"' AND notice_result = '未通过' AND notice_releaseTime = '" +time
				+ " 'UNION ALL SELECT '会议审批通过',meeting_id AS id,'2' FROM meeting "
				+ " WHERE meeting_promulgator = '"+ name +"' AND meeting_result = '已通过' AND meeting_releaseTime = '" +time
				+ " 'UNION ALL SELECT '会议审批未通过',meeting_id AS id,'2' FROM meeting "
				+ " WHERE meeting_promulgator = '"+ name +"' AND meeting_result = '未通过' AND meeting_releaseTime = '" +time
				+ " 'UNION ALL SELECT CONCAT(register_type,'申请审批通过') ,register_id, '3'  FROM register "
				+ " WHERE register_name = '"+ name +"' AND register_result = '已通过' AND register_releaseTime = '" +time
				+ " 'UNION ALL SELECT CONCAT(register_type,'申请审批未通过') ,register_id, '3'  FROM register "
				+ " WHERE register_name = '"+ name +"' AND register_result = '未通过' AND register_releaseTime = '" +time
				+ " 'UNION ALL SELECT  '个人计划审批通过',plan_id,'4' FROM plan "
				+ " WHERE plan_promulgator = '"+ name +"' AND plan_type = '个人' AND plan_result = '已通过' AND plan_releaseTime = '" +time
				+ " 'UNION ALL SELECT  '个人计划审批未通过',plan_id,'4' FROM plan "
				+ " WHERE plan_promulgator = '"+ name +"' AND plan_type = '个人' AND plan_result = '未通过' AND plan_releaseTime = '" +time + "';";
			pstate =conn.prepareStatement(sql);
			ResultSet res=pstate.executeQuery();
			while(res.next()){
				branchVo = new BranchVo();
				branchVo.setBranch_summarize(res.getString("result"));
				branchVo.setBranch_minister(res.getString("id"));
				branchVo.setBranch_name(res.getString("type"));
				list.add(branchVo);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<BranchVo>  getAuditList(){
		Connection conn  = JDBCUtils.getConnection();
		String sql ="";
		PreparedStatement  pstate =null;
		BranchVo branchVo = null;
		List<BranchVo> list=new ArrayList<BranchVo>();
		Date date = new Date();
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String time = sdf.format(date);
			sql = " SELECT '公告审批通过' AS result ,notice_id AS id,'1' as type FROM notice "
				+ " WHERE  notice_result = '已通过' AND notice_releaseTime = '" +time
				+ " 'UNION ALL SELECT '公告审批未通过' AS result ,notice_id AS id,'1' as type FROM notice "
				+ " WHERE  notice_result = '未通过' AND notice_releaseTime = '" +time
				+ " 'UNION ALL SELECT '会议审批通过',meeting_id AS id,'2' FROM meeting "
				+ " WHERE  meeting_result = '已通过' AND meeting_releaseTime = '" +time
				+ " 'UNION ALL SELECT '会议审批未通过',meeting_id AS id,'2' FROM meeting "
				+ " WHERE  meeting_result = '未通过' AND meeting_releaseTime = '" +time
				+ " 'UNION ALL SELECT CONCAT(register_type,'申请审批通过') ,register_id, '3'  FROM register "
				+ " WHERE  register_result = '已通过' AND register_releaseTime = '" +time
				+ " 'UNION ALL SELECT CONCAT(register_type,'申请审批未通过') ,register_id, '3'  FROM register "
				+ " WHERE  register_result = '未通过' AND register_releaseTime = '" +time
				+ " 'UNION ALL SELECT  '个人计划审批通过',plan_id,'4' FROM plan "
				+ " WHERE  plan_type = '个人' AND plan_result = '已通过' AND plan_releaseTime = '" +time
				+ " 'UNION ALL SELECT  '个人计划审批未通过',plan_id,'4' FROM plan "
				+ " WHERE  plan_type = '个人' AND plan_result = '未通过' AND plan_releaseTime = '" +time + "';";
			pstate =conn.prepareStatement(sql);
			ResultSet res=pstate.executeQuery();
			while(res.next()){
				branchVo = new BranchVo();
				branchVo.setBranch_summarize(res.getString("result"));
				branchVo.setBranch_minister(res.getString("id"));
				branchVo.setBranch_name(res.getString("type"));
				list.add(branchVo);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
