package com.lxitedu.st1610.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lxitedu.st1610.dao.MaintainDao;
import com.lxitedu.st1610.util.JDBCUtils;
import com.lxitedu.st1610.vo.MaintainVo;

public class MaintainDaoImpl implements MaintainDao{

	@Override
	public void insertMaintain(MaintainVo maintainVo) {
		// TODO Auto-generated method stub
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					JDBCUtils.closeAll(conn, pstate, null);
				}
	}

	@Override
	public void deleteMaintain(int id) {
		// TODO Auto-generated method stub
		Connection conn  = JDBCUtils.getConnection();
		
		String sql = "delete from maintain where maintain_id=?";
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
	public ArrayList<MaintainVo> queryMaintain() {
		// TODO Auto-generated method stub
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pre, res);
		}
		return list;
	}

	@Override
	public void updateMaintain(MaintainVo maintainVo) {
		// TODO Auto-generated method stub
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.closeAll(conn, pstate, null);
		}		
	}

	@Override
	public MaintainVo queryInfo(int id) {
		// TODO Auto-generated method stub
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maintainVo;	
	}

	
}
