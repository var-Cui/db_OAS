package com.lxitedu.st1610.dao;

import java.util.ArrayList;

import com.lxitedu.st1610.vo.CommentVo;
import com.lxitedu.st1610.vo.PlanVo;

/**
 * @author ÀîÂ¡»ù
 *
 */
public interface PlanDao {
	public ArrayList<PlanVo> planPersonalList(int pageCount,int pageSize,String sql);
	public PlanVo planQuery(int plan_id);
	public void planAdd(PlanVo planVo);
	public void planDel(int plan_id);
	public void commentAdd(CommentVo commentVo);
	public ArrayList<CommentVo> commentList(int pageCount,int pageSize,String sql);
	public void planTypeRe(String sql,int plan_id);
}
