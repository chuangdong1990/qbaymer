package com.optimus.common;

import java.util.List;



public class PageModel<T> {

	public static final String ORDER_ASC = "asc";
	public static final String ORDER_DESC = "desc";
	
	// 总记录数
	private int total;
	// 当前页的记录集
	private List<T> datas;
	// 每页多少条数据
	private int pageSize =10;
	// 第几页
	private int pageNo =1;
	// 第几行开始
	private int start = 0;
	private int end;
	
	private String begindate;
	private String enddate;
	// 查询条件对象
	private Object condition;

	private String sort; //排序字段
	private String order; //排序规则

	private String ordersql ;
	
	private List<String> list;
	
	private String[] ids;
	
	private int denominator=2;
	private int mod=0;

	public PageModel() {

	}

	

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	public int getMod() {
		return mod;
	}

	public void setMod(int mod) {
		this.mod = mod;
	}
	

	public void setStart(int start) {
		this.start = start;
	}
	
	public PageModel(int pageNo, int pageSize) {

		this.pageNo = pageNo;
		this.pageSize = pageSize;
		
		start = getStart();
		end = getEnd();
		
		//System.out.println("start 条数：" + start);
		//System.out.println("end 条数：" + end);
	}

	/**
	 * 结束条数
	 * @return
	 */
	public int getEnd() {
		this.end = this.start +  this.pageSize;
		return this.end;
	}

	/**
	 * 开始条数
	 * @return
	 */
	public int getStart() {
		this.start = (this.pageNo - 1) * this.pageSize;
		return this.start;
	}
	
	// 求总页数
	public int getTotalPages() {
		return (this.total + pageSize - 1) / pageSize;
	}

	/**
	 * 获取到总数 然后加载获取查询的开始记录数 和结束记录数
	 * @param total
	 */
	public void setTotal(int total) {
		this.total = total;
		start = getStart();
		end = getEnd();
	
	}
	


	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
		getStart();
	}

	public int getTotal() {
		return total;
	}

	public String getBegindate() {
		return begindate;
	}

	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public Object getCondition() {
		return condition;
	}

	public void setCondition(Object condition) {
		this.condition = condition;
	}
	
	public void setEnd(int end) {
		this.end = end;
	}
	
	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public int getNextPage() {
		if (this.pageNo >= this.getTotalPages()) {
			return (this.getTotalPages() == 0 ? 1 : this.getTotalPages());
		}
		return pageNo + 1;
	}
	
	
	public int getUpPage() {
		if (this.pageNo <= 1) {
			return 1;
		}
		return this.pageNo - 1;
	}
	public int getBottomPage() {
		return this.getTotalPages() == 0 ? 1 : this.getTotalPages();
	}
	
	public int getTopPage() {
		return 1;
	}
	
	
	public PageModel(int pageNo, int pageSize,int total) {

		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.total = total;
	}
	
	
	public int getEnd(int page,int total) {
		int totalPage = (int) getTotalPages();// 总页数
		if (page > totalPage)
			page = totalPage;

		int result = 0;
		int start = getStart();// 开始时0
		int end = 0;
		end = start + pageSize;
		if (end > total) {
			result = total;
		} else {
			result = end;
		}
		//System.out.println("end 条数：" + result);
		return result;
	}

	public int getStart(int page) {
		this.start = (this.pageNo - 1) * this.pageSize;
		//System.out.println("开始条数：" + start);
		return this.start;
	}


	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}


	public String getOrdersql() {
		return ordersql;
	}

	public void setOrdersql(String ordersql) {
		this.ordersql = ordersql;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

}
