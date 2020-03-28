package cn.lxitedu.st1610.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.lxitedu.st1610.dao.BaseDao;
import cn.lxitedu.st1610.dao.MaintainDao;
import cn.lxitedu.st1610.util.JDBCUtils;
import cn.lxitedu.st1610.bean.BranchVo;
import cn.lxitedu.st1610.bean.MaintainVo;

public class MaintainDaoImpl extends BaseDao implements MaintainDao{

	//���Ӳ˵�
	public boolean insertMaintain(MaintainVo maintainVo) {
		/*// TODO Auto-generated method stub
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
		}*/
		String sql = "insert into maintain(maintain_model,maintain_menu,maintain_url,maintain_time) values(?,?,?,?)";
		Object[] parms = {maintainVo.getMaintain_model(),maintainVo.getMaintain_menu(),maintainVo.getMaintain_url(),maintainVo.getMaintain_time() };
		return this.executeUpdate(sql, parms) > 0;
	}

	//ɾ���˵�
	public boolean deleteMaintain(int id) {
		String sql="delete from maintain where maintain_id=?";
		Object [] parms={id};
		return this.executeUpdate(sql, parms)>0;
	}

	//��ѯ�˵�
	public List<MaintainVo> queryMaintain() {
		// TODO Auto-generated method stub
		/*Connection conn  = JDBCUtils.getConnection();
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
		return list;*/
		List<MaintainVo> list = new ArrayList<>();
		String sql = "select * from maintain;";
		try {
			this.rs = executeQuery(sql, null);
			while (this.rs.next()) {
				MaintainVo maintainVo =new MaintainVo();
				maintainVo.setMaintain_id(rs.getInt("maintain_id"));
				maintainVo.setMaintain_model(rs.getInt("maintain_model"));
				maintainVo.setMaintain_menu(rs.getString("maintain_menu"));
				maintainVo.setMaintain_url(rs.getString("maintain_url"));
				maintainVo.setMaintain_time(rs.getDate("maintain_time"));
				list.add(maintainVo);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}

	//�޸Ĳ˵�
	public boolean updateMaintain(MaintainVo maintainVo) {
		// TODO Auto-generated method stub
		/*Connection conn  = JDBCUtils.getConnection()             ;
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
		}		*/
		String sql="update maintain set maintain_model=?,maintain_menu=?,maintain_url=?,maintain_time=? where maintain_id=?";
		Object[]parms={maintainVo.getMaintain_model(),maintainVo.getMaintain_menu(),maintainVo.getMaintain_url(),maintainVo.getMaintain_time(),maintainVo.getMaintain_id()};
		return this.executeUpdate(sql, parms)>0;
	}
	
	//ͨ��ID��ѯ���˵����е���Ϣ
	public MaintainVo queryInfo(int id) {
		// TODO Auto-generated method stub
		/*Connection conn  = JDBCUtils.getConnection();
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
		return maintainVo;	*/
		MaintainVo maintainVo=null;
		String sql = "select maintain_id,maintain_model,maintain_menu,maintain_url,maintain_time from maintain where maintain_id=?";
		Object[] parms = { id};
			try {
				this.rs = executeQuery(sql, parms);
				if (this.rs.next()) {
					maintainVo=new MaintainVo();
					maintainVo.setMaintain_id(rs.getInt("maintain_id"));
					maintainVo.setMaintain_model(rs.getInt("maintain_model"));
					maintainVo.setMaintain_menu(rs.getString("maintain_menu"));
					maintainVo.setMaintain_url(rs.getString("maintain_url"));
					maintainVo.setMaintain_time(rs.getDate("maintain_time"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				this.closeAll(conn, pstmt, rs);
			}
			return maintainVo;
	}
/*	String sql="";
	Object []parms={};
	return this.executeUpdate(sql, parms)>0; 
	Object []parms={punchvo.getPunch_staffId(),punchvo.getPunch_staffName(),punchvo.getPunch_type(),punchvo.getPunch_time(),punchvo.getPunch_result()}; */
}
