package cn.lxitedu.st1610.dao;

import java.util.ArrayList;
import java.util.List;

import cn.lxitedu.st1610.bean.CommentVo;
import cn.lxitedu.st1610.bean.PlanVo;

/**
 * @author ÀîÂ¡»ù
 *
 */
public interface PlanDao {
	public ArrayList<PlanVo> planPersonalList(int pageCount,int pageSize,String sql);
	public PlanVo planQuery(int plan_id);
	public boolean planAdd(PlanVo planVo);
	public boolean planDel(int plan_id);
	public int getPageCount(String sql);
	public boolean commentAdd(CommentVo commentVo);
	public List<CommentVo> commentList(int pageCount,int pageSize,String sql);
	public void planTypeRe(String sql,int plan_id);
}
