package com.lxitedu.st1610.vo;



/******************************************************分页VO*******************************************/
public class PageVo {
    
        //总页数
		private int totalPageCount=1;
		//每页大小，即每页显示记录数
		private int pageSize=5;
		//记录总数
		private int totalCount=0;
		//当前页码
		private int currPageNo=1;
		

		
		public int getTotalPageCount() {
			return totalPageCount;
		}
	
		public int getPageSize() {
			return pageSize;
		}
		
		public int getTotalCount() {
			return totalCount;
		}
		
		public void setTotalCount(int totalCount) {
		  if(totalCount>0)
			{
				this.totalCount = totalCount;
				totalPageCount=this.totalCount%pageSize == 0?(this.totalCount/pageSize):this.totalCount/pageSize+1;
			}
			
		}
		@Override
		public String toString() {
			return "PageVo [totalPageCount=" + totalPageCount + ", pageSize="
					+ pageSize + ", totalCount=" + totalCount + ", currPageNo="
					+ currPageNo + "]";
		}
		public int getCurrPageNo() {
			return currPageNo;
		}
		public void setCurrPageNo(int currPageNo) {
			this.currPageNo = currPageNo;
		}
		
	  
	
	
} 
