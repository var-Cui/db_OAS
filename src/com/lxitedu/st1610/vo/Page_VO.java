package com.lxitedu.st1610.vo;

import java.util.List;

public class Page_VO {
	private int toatlPages;
	
	private int pageMaxCount=5;
	
	private int totalRecords;
	
	private int currentPage;
	
	private List reseltList;
	
	public Page_VO() {
		super();
	}

	public Page_VO(int currentPage, int pageMaxCount, int totalRecords,
			int toatlPages, List reseltList) {
		super();
		this.currentPage = currentPage;
		this.pageMaxCount = pageMaxCount;
		this.totalRecords = totalRecords;
		this.toatlPages = toatlPages;
		this.reseltList = reseltList;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		if(currentPage > 0){
			this.currentPage = currentPage;
			currentPage = this.currentPage%pageMaxCount==0?
					(this.currentPage/pageMaxCount):this.currentPage/pageMaxCount+1;
		}
	}

	public int getPageMaxCount() {
		return pageMaxCount;
	}

	public void setPageMaxCount(int pageMaxCount) {
		this.pageMaxCount = pageMaxCount;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getToatlPages() {
		return toatlPages;
	}

	public void setToatlPages(int toatlPages) {
		this.toatlPages = toatlPages;
	}

	public List getReseltList() {
		return reseltList;
	}

	public void setReseltList(List reseltList) {
		this.reseltList = reseltList;
	}
	
	
	
	
	
	
	
}
