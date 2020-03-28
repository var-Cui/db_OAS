package cn.lxitedu.st1610.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.lxitedu.st1610.dao.BaseDao;
import cn.lxitedu.st1610.dao.BranchDao;
import cn.lxitedu.st1610.util.JDBCUtils;


import cn.lxitedu.st1610.bean.BranchVo;


public class BranchDaoImpl extends BaseDao implements BranchDao{

	@Override
	public boolean insertBranch(BranchVo branchVo) {
		String sql = "insert into branch(branch_name,branch_minister,branch_summarize,branch_time) values(?,?,?,?)";
		Object[] parms = {branchVo.getBranch_name(),branchVo.getBranch_minister(),branchVo.getBranch_summarize(),branchVo.getBranch_time() };
		return this.executeUpdate(sql, parms) > 0;
	}

	@Override
	public boolean deleteBranch(int id) {
		String sql = "delete from branch where branch_id=?";
		Object[] parms = { id };
		return this.executeUpdate(sql, parms) > 0;
	}

	@Override
	public List<BranchVo> queryBranch() {

		List<BranchVo> list = new ArrayList<>();
		String sql = "select * from branch;";
		try {
			this.rs = executeQuery(sql, null);
			while (this.rs.next()) {
				BranchVo branchVo =new BranchVo();
				branchVo.setBranch_id(rs.getInt("branch_id"));
				branchVo.setBranch_name(rs.getString("branch_name"));
				branchVo.setBranch_minister(rs.getString("branch_minister"));
				branchVo.setBranch_summarize(rs.getString("branch_summarize"));
				branchVo.setBranch_time(rs.getDate("branch_time"));
				list.add(branchVo);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}

	@Override
	public boolean updateBranch(BranchVo branchVo) {
		String sql = "update branch set branch_name=?,branch_minister=?,branch_summarize=?,branch_time=? where branch_id=?";
		Object[] parms = { branchVo.getBranch_name(),branchVo.getBranch_minister(),branchVo.getBranch_summarize(),branchVo.getBranch_time(),branchVo.getBranch_id()};
		return this.executeUpdate(sql, parms) > 0;
		
	}

	@Override
	public BranchVo queryBranchName(String name) {
		BranchVo branchVo=null;
		String sql = "select branch_id, branch_name,branch_minister,branch_summarize,branch_time from branch where branch_name=?";
		Object[] parms = { name};
			try {
				this.rs = executeQuery(sql, parms);
				if (this.rs.next()) {
				    branchVo=new BranchVo();
					branchVo.setBranch_id(rs.getInt("branch_id"));
					branchVo.setBranch_name(rs.getString("branch_name"));
					branchVo.setBranch_minister(rs.getString("branch_minister"));
					branchVo.setBranch_summarize(rs.getString("branch_summarize"));
					branchVo.setBranch_time(rs.getDate("branch_time"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				this.closeAll(conn, pstmt, rs);
			}
			return branchVo;
	}

}
