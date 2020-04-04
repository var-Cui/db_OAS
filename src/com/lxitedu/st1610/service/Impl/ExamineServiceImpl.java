package com.lxitedu.st1610.service.Impl;

import java.util.ArrayList;

import com.lxitedu.st1610.dao.PlanDao;
import com.lxitedu.st1610.dao.Impl.MeetingDaoImpl;
import com.lxitedu.st1610.dao.Impl.NoticeDaoImpl;
import com.lxitedu.st1610.dao.Impl.PlanDaoImpl;
import com.lxitedu.st1610.dao.Impl.RegisterImpl;
import com.lxitedu.st1610.service.ExamineService;
import com.lxitedu.st1610.vo.NoticeVo;
import com.lxitedu.st1610.vo.PageVo;
import com.lxitedu.st1610.vo.PlanVo;
import com.lxitedu.st1610.vo.RegisterVo;

import cn.lxitedu.st1610.bean.MeetingVo;

public class ExamineServiceImpl implements ExamineService {
	PlanDao planDao=new PlanDaoImpl();
	NoticeDaoImpl noticeDaoImpl = new NoticeDaoImpl();
	RegisterImpl registerImpl=new RegisterImpl();
	MeetingDaoImpl meetingDaoImpl = new MeetingDaoImpl();
	public ArrayList<?> examinePlanQuery(PageVo p,String currPageNo,String examineType,String  branch,String name){
		//…Û∫À≤È—Ø
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
			String sql="select * from meeting where meeting_result='¥˝…Û∫À' and meeting_assentor = '"+name+ "' limit ?,?;";
			ArrayList<MeetingVo> list = meetingDaoImpl.meetingQuery_page(no,p.getPageSize(), sql);
			return list;
		}else if(("2").equals(examineType)){
			String sql="select * from notice where notice_result='¥˝…Û∫À' and notice_assentor = '"+name+ "' limit ?,?;";
			ArrayList<NoticeVo> list = noticeDaoImpl.noticeQuery_page(no,p.getPageSize(), sql);
			return list;
		}else if(("3").equals(examineType)){
			String sql = "SELECT * FROM register WHERE register_result = '¥˝…Û∫À' and register_type = '«ÎºŸ'  and register_assentor = '"+name+ "' limit ?,?;";
			ArrayList<RegisterVo> list=(ArrayList<RegisterVo>) registerImpl.registerQuery_page(no,p.getPageSize(),sql);
			return list;
		}else if(("4").equals(examineType)){
			String sql= "SELECT * FROM register WHERE register_result = '¥˝…Û∫À' and register_type = '≥ˆ≤Ó'  and register_assentor = '"+name+ "' limit ?,?;";
			ArrayList<RegisterVo> list=(ArrayList<RegisterVo>) registerImpl.registerQuery_page(no,p.getPageSize(),sql);
			return list;
		}else if(("5").equals(examineType)){
			String sql= "SELECT * FROM register WHERE register_result = '¥˝…Û∫À' and register_type = 'Õ‚≥ˆ'  and register_assentor = '"+name+ "' limit ?,?;";
			ArrayList<RegisterVo> list=(ArrayList<RegisterVo>) registerImpl.registerQuery_page(no,p.getPageSize(),sql);
			return list;
		}else if(("6").equals(examineType)){
			String sql="select * from plan where plan_result='¥˝…Û∫À' and plan_type='∆Û“µ' limit ?,?;";
			ArrayList<PlanVo> list=planDao.planPersonalList(no, p.getPageSize(),sql);
			return list;
		}else if(("7").equals(examineType)){
			String sql="select * from plan where plan_result='¥˝…Û∫À' and plan_type='≤ø√≈' limit ?,?;";
			ArrayList<PlanVo> list=planDao.planPersonalList(no, p.getPageSize(),sql);
			return list;
		}else if(("8").equals(examineType)){
			String sql="select * from plan where plan_result='¥˝…Û∫À' and plan_type = '∏ˆ»À' and plan_assentor = '"+name+ "' limit ?,?;";
			ArrayList<PlanVo> list=planDao.planPersonalList(no, p.getPageSize(),sql);
			return list;
		}		
		return null;
	}
	
	public String examinePageQuery(String examineType,String branch,String name){
		//…Û∫À≤È—Ø
		String sql=null;
		if(("1").equals(examineType)){
			sql="select count(1) from meeting where meeting_result='¥˝…Û∫À' and meeting_assentor = '"+name+"';";		
		}else if(("2").equals(examineType)){
			sql="select count(1) from notice where notice_result='¥˝…Û∫À'and notice_assentor = '"+name+"';";
		}else if(("3").equals(examineType)){
			sql="SELECT count(1) FROM register WHERE register_result = '¥˝…Û∫À' and register_type = '«ÎºŸ'  and register_assentor = '"+name+ "';";
		}else if(("4").equals(examineType)){
			sql="SELECT count(1) FROM register WHERE register_result = '¥˝…Û∫À' and register_type = '≥ˆ≤Ó'  and register_assentor = '"+name+ "';";
		}else if(("5").equals(examineType)){
			sql="SELECT count(1) FROM register WHERE register_result = '¥˝…Û∫À' and register_type = 'Õ‚≥ˆ'  and register_assentor = '"+name+ "';";
		}else if(("6").equals(examineType)){
			sql="select count(1) from plan where plan_result='¥˝…Û∫À' and plan_type='∆Û“µ';";			
		}else if(("7").equals(examineType)){
			sql="select count(1) from plan where plan_result='¥˝…Û∫À' and plan_type='≤ø√≈';";
		}else if(("8").equals(examineType)){
			sql="select count(1) from plan where plan_result='¥˝…Û∫À' and plan_type = '∏ˆ»À' and plan_assentor = '"+name+ "';";
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
	
	public void audit(String sql){
		registerImpl.audit(sql);
	}
}
