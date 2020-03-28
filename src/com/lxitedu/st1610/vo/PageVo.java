package com.lxitedu.st1610.vo;



/******************************************************��ҳVO*******************************************/
public class PageVo {
    
        //��ҳ��
		private int totalPageCount=1;
		//ÿҳ��С����ÿҳ��ʾ��¼��
		private int pageSize=5;
		//��¼����
		private int totalCount=0;
		//��ǰҳ��
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
