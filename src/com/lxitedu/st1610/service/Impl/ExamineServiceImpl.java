package com.lxitedu.st1610.service.Impl;

import java.util.ArrayList;

import com.lxitedu.st1610.dao.PlanDao;
import com.lxitedu.st1610.dao.Impl.PlanDaoImpl;
import com.lxitedu.st1610.dao.Impl.RegisterImpl;
import com.lxitedu.st1610.service.ExamineService;
import com.lxitedu.st1610.vo.PageVo;
import com.lxitedu.st1610.vo.PlanVo;
import com.lxitedu.st1610.vo.RegisterVo;

public class ExamineServiceImpl implements ExamineService {
	PlanDao planDao=new PlanDaoImpl();
	RegisterImpl registerImpl=new RegisterImpl();
	public ArrayList<?> examinePlanQuery(PageVo p,String currPageNo,String examineType,String  branch){
		//��˲�ѯ
		int no=0;
		  if(null==currPageNo)
		  {
			  no=1;
		  }
		  else{
			no= Integer.parseInt(currPageNo);
		  }
		  p.setCurrPageNo(no);
		  
	  if(("1").equals(examineType)){
			String sql="select * from meeting where meeting_result='�����' limit ?,?;";
		}else if(("2").equals(examineType)){
			String sql="select * from notice where notice_result='�����' limit ?,?;";
		}else if(("3").equals(examineType)){
			String sql="SELECT register_id,register_staffNum,register_name,register_branch,register_type,register_reason,register_startTime,register_endTime,register_assentor,register_result,register_note,register_releaseTime FROM register,staff WHERE staff.staff_branch=register.register_branch AND staff.staff_position='����' AND register_result='�����' AND register_type='���' AND register.register_branch='"+branch+"' LIMIT ?,?;";
			ArrayList<RegisterVo> list=(ArrayList<RegisterVo>) registerImpl.registerQuery_page(no,p.getPageSize(),sql);
			return list;
		}else if(("4").equals(examineType)){
			String sql="SELECT register_id,register_staffNum,register_name,register_branch,register_type,register_reason,register_startTime,register_endTime,register_assentor,register_result,register_note,register_releaseTime FROM register,staff WHERE staff.staff_branch=register.register_branch AND staff.staff_position='����' AND register_result='�����' AND register_type='����' AND register.register_branch='"+branch+"' LIMIT ?,?;";
			ArrayList<RegisterVo> list=(ArrayList<RegisterVo>) registerImpl.registerQuery_page(no,p.getPageSize(),sql);
			return list;
		}else if(("5").equals(examineType)){
			String sql="SELECT register_id,register_staffNum,register_name,register_branch,register_type,register_reason,register_startTime,register_endTime,register_assentor,register_result,register_note,register_releaseTime FROM register,staff WHERE staff.staff_branch=register.register_branch AND staff.staff_position='����' AND register_result='�����' AND register_type='���' AND register.register_branch='"+branch+"' LIMIT ?,?;";
			ArrayList<RegisterVo> list=(ArrayList<RegisterVo>) registerImpl.registerQuery_page(no,p.getPageSize(),sql);
			return list;
		}else if(("6").equals(examineType)){
			String sql="select * from plan where plan_result='�����' and plan_type='��ҵ' limit ?,?;";
			ArrayList<PlanVo> list=planDao.planPersonalList(no, p.getPageSize(),sql);
			return list;
		}else if(("7").equals(examineType)){
			String sql="select * from plan where plan_result='�����' and plan_type='����' limit ?,?;";
			ArrayList<PlanVo> list=planDao.planPersonalList(no, p.getPageSize(),sql);
			return list;
		}		
		return null;
	}
	
	public String examinePageQuery(String examineType,String branch){
		//��˲�ѯ
		String sql=null;
		if(("1").equals(examineType)){
			sql="select count(1) from meeting where meeting_result='�����';";		
		}else if(("2").equals(examineType)){
			sql="select count(1) from notice where notice_result='�����';";
		}else if(("3").equals(examineType)){
			sql="SELECT count(1) FROM register,staff WHERE staff.staff_branch=register.register_branch AND staff.staff_position='����' AND register_result='�����' AND register_type='���' AND register.register_branch='"+branch+"';";
		}else if(("4").equals(examineType)){
			sql="SELECT count(1) FROM register,staff WHERE staff.staff_branch=register.register_branch AND staff.staff_position='����' AND register_result='�����' AND register_type='����' AND register.register_branch='"+branch+"';";
		}else if(("5").equals(examineType)){
			sql="SELECT count(1) FROM register,staff WHERE staff.staff_branch=register.register_branch AND staff.staff_position='����' AND register_result='�����' AND register_type='���' AND register.register_branch='"+branch+"';";
		}else if(("6").equals(examineType)){
			sql="select count(1) from plan where plan_result='�����' and plan_type='��ҵ';";			
		}else if(("7").equals(examineType)){
			sql="select count(1) from plan where plan_result='�����' and plan_type='����';";
		}		
		return sql;
	}
	
	public void planTypeRe(String sql,int plan_id)
	{
		planDao.planTypeRe(sql, plan_id);
	}
	public void registerTypeRe(String sql,int register_id){
		registerImpl.registerTypeRe(sql, register_id);
	}
/*	if(("����").equals(examineType)){
		String sql="select * from meeting where meeting_result='�����' limit ?,?;";
	}else if(("����").equals(examineType)){
		String sql="select * from notice where meeting_result='�����' limit ?,?;";
	}else if(("���").equals(examineType)){
		String sql="select * from register where meeting_result='�����' and register_type='���' limit ?,?;";
	}else if(("����").equals(examineType)){
		String sql="select * from register where meeting_result='�����' and register_type='����' limit ?,?;";
	}else if(("���").equals(examineType)){
		String sql="select * from register where meeting_result='�����' and register_type='���' limit ?,?;";
	}else */
}
