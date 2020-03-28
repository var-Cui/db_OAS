package com.lxitedu.st1610.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lxitedu.st1610.dao.BranchDao;
import com.lxitedu.st1610.util.JDBCUtils;
import com.lxitedu.st1610.vo.BranchVo;


public class BranchDaoImpl implements BranchDao{

	@Override
	public void insertBranch(BranchVo branchVo) {
		// TODO Auto-generated method stub
		Connection conn  = JDBCUtils.getConnection();

		java.sql.Date sqlDate=new java.sql.Date(branchVo.getBranch_time().getTime());
		
		String sql="insert into branch(branch_name,branch_minister,branch_summarize,branch_time) values(?,?,?,?)";
		PreparedStatement  pstate =null;
		try {
			pstate =conn.prepareStatement(sql);
			pstate.setString(1, branchVo.getBranch_name());
			pstate.setString(2, branchVo.getBranch_minister());
			pstate.setString(3, branchVo.getBranch_summarize());
			pstate.setDate(4, sqlDate);
			
			pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pstate, null);
		}
	}

	@Override
	public void deleteBranch(int id) {
		// TODO Auto-generated method stub
		Connection conn  = JDBCUtils.getConnection();
		
		String sql = "delete from branch where branch_id=?";
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
	public ArrayList<BranchVo> queryBranch() {
		// TODO Auto-generated method stub
		Connection conn  = JDBCUtils.getConnection();
		PreparedStatement pre=null;
		ResultSet res=null;
		BranchVo branchVo=null;
		ArrayList<BranchVo> list=new ArrayList<BranchVo>();
		try {
			pre=conn.prepareStatement("select * from branch;");
			res=pre.executeQuery();
			while(res.next()){
				branchVo =new BranchVo();
				branchVo.setBranch_id(res.getInt("branch_id"));
				branchVo.setBranch_name(res.getString("branch_name"));
				branchVo.setBranch_minister(res.getString("branch_minister"));
				branchVo.setBranch_summarize(res.getString("branch_summarize"));
				branchVo.setBranch_time(res.getDate("branch_time"));
				list.add(branchVo);
				branchVo=null;
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
	public void updateBranch(BranchVo branchVo) {
		// TODO Auto-generated method stub
		Connection conn  = JDBCUtils.getConnection()             ;
		java.sql.Date sqlDate=new java.sql.Date(branchVo.getBranch_time().getTime());
		
		String sql = "update branch set branch_name=?,branch_minister=?,branch_summarize=?,branch_time=? where branch_id=?";
		PreparedStatement  pstate =null;
		try {
			  pstate =conn.prepareStatement(sql);
				
				pstate.setString(1, branchVo.getBranch_name());
				pstate.setString(2, branchVo.getBranch_minister());
				pstate.setString(3, branchVo.getBranch_summarize());
				pstate.setDate(4,sqlDate);
				pstate.setInt(5,branchVo.getBranch_id());
			    pstate.executeUpdate();
			  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pstate, null);
		}		
		
	}

	@Override
	public BranchVo queryBranchName(String name) {
		// TODO Auto-generated method stub
		Connection conn  = JDBCUtils.getConnection();
		String sql = "select branch_id, branch_name,branch_minister,branch_summarize,branch_time from branch where branch_name=?";
		PreparedStatement  pstate =null;
		BranchVo branchVo=new BranchVo();
		try{
			pstate =conn.prepareStatement(sql);
			pstate.setString(1,name);
			ResultSet res=pstate.executeQuery();
			while(res.next()){
				branchVo.setBranch_id(res.getInt("branch_id"));
				branchVo.setBranch_name(res.getString("branch_name"));
				branchVo.setBranch_minister(res.getString("branch_minister"));
				branchVo.setBranch_summarize(res.getString("branch_summarize"));
				branchVo.setBranch_time(res.getDate("branch_time"));
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return branchVo;	
	}

}
