package com.lxitedu.st1610.service;

import java.util.ArrayList;

import com.lxitedu.st1610.vo.CommentVo;
import com.lxitedu.st1610.vo.PageVo;
import com.lxitedu.st1610.vo.PlanVo;

public interface PlanService {
	public ArrayList<PlanVo> planPersonalList(PageVo p,String sql,String currPageNo);
	public PlanVo planQuery(int plan_id);
	public void planAdd(PlanVo planVo);
	public void planDel(int plan_id);
	public void commentAdd(CommentVo commentVo);
	public ArrayList<CommentVo> commentList(PageVo p,String sql,String currPageNo);
}
