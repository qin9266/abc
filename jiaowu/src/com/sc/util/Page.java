package com.sc.util;

import java.util.List;

public class Page {
	private List<?> recordList;//要显示的对象列表
	private int currentPageNum;//当前页码
	private int pageSize=8;//每页显示的记录条数
	private int totalRecords;//总记录条数
	private int totalPage;//总页数
	private int startIndex;//每页开始的索引
	
	private String url;
	
	public Page(int pageNum,int totalRecords){
		this.currentPageNum=pageNum;
		//总记录数
		this.totalRecords=totalRecords;
		//求总页数
		int num=totalRecords%pageSize;
		int count=totalRecords/pageSize;
		totalPage=num==0?count:count+1;
		if(pageNum>totalPage){
			pageNum=totalPage;
			currentPageNum=pageNum;
		}
		//计算每页开始的索引
		startIndex=(pageNum-1)*pageSize;
	}

	public List<?> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<?> recordList) {
		this.recordList = recordList;
	}

	public int getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Page [recordList=" + recordList + ", currentPageNum="
				+ currentPageNum + ", pageSize=" + pageSize + ", totalRecords="
				+ totalRecords + ", totalPage=" + totalPage + ", startIndex="
				+ startIndex + ", url=" + url + "]";
	}
}