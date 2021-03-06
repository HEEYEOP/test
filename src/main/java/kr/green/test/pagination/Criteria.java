package kr.green.test.pagination;

public class Criteria {
		private int page; 
		private int perPageNum;
		private String search;
		private String type;
		
		
		
		public Criteria() {
			this.page = 1;
			this.perPageNum = 10;
			this.search="";
			this.type="0";
		}
		
		public int getPage() {
			return page;
		}
		public void setPage(int page) {
			if(page <= 0) {
				this.page = 1;
			}
			else
				this.page = page;
		}
		public int getPerPageNum() {
			return perPageNum;
		}
		public void setPerPageNum(int perPageNum) {
			if(perPageNum <=0 || perPageNum > 100) {
				this.perPageNum = 10;
			}
			else
				this.perPageNum = perPageNum;
		}
		public String getSearch() {
			return search;
		}


		public void setSearch(String search) {
			this.search = search;
		}


		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		
//-----------------------------------------------------
		public int getPageStart() {
			return (this.page -1) * perPageNum;
		}


		@Override
		public String toString() {
			return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", search=" + search + ", type=" + type
					+ "]";
		}
		
		

}
