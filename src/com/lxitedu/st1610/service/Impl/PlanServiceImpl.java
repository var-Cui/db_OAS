package com.lxitedu.st1610.service.Impl;

import java.util.ArrayList;

import com.lxitedu.st1610.dao.PlanDao;
import com.lxitedu.st1610.dao.Impl.PlanDaoImpl;
import com.lxitedu.st1610.service.PlanService;
import com.lxitedu.st1610.vo.CommentVo;
import com.lxitedu.st1610.vo.PageVo;
import com.lxitedu.st1610.vo.PlanVo;

public class PlanServiceImpl implements PlanService {
		PlanDao planDao=new PlanDaoImpl();
	@Override
	public ArrayList<PlanVo> planPersonalList(PageVo p,String sql,String currPageNo) {
		// TODO Auto-generated method stub
		int no=0;
		  if(null==currPageNo)
		  {
			  no=1;
		  }
		  else{
			no= Integer.parseInt(currPageNo);
		  }
		  p.setCurrPageNo(no);
		  ArrayList<PlanVo> list=planDao.planPersonalList(no,p.getPageSize(),sql);
		return list;
	}

	@Override
	public PlanVo planQuery(int plan_id) {
		// TODO Auto-generated method stub
		return planDao.planQuery(plan_id);
	}

	@Override
	public void planAdd(PlanVo planVo) {
		// TODO Auto-generated method stub
		planDao.planAdd(planVo);
	}

	@Override
	public void planDel(int plan_id) {
		// TODO Auto-generated method stub	
		planDao.planDel(plan_id);
	}

	@Override
	public void commentAdd(CommentVo commentVo) {
		// TODO Auto-generated method stub
		planDao.commentAdd(commentVo);
	}

	@Override
	public ArrayList<CommentVo> commentList(PageVo p,String sql,String currPageNo) {
		// TODO Auto-generated method stub
		int no=0;
		  if(null==currPageNo)
		  {
			  no=1;
		  }
		  else{
			no= Integer.parseInt(currPageNo);
		  }
		  p.setCurrPageNo(no);
		  ArrayList<CommentVo> list=planDao.commentList(no, p.getPageSize(),sql);
		return list;
	}
	
}
