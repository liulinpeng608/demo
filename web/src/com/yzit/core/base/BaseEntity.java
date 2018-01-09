package com.yzit.core.base;
import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;

public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	private transient   Integer page = 1;//当前页
	@JsonIgnore
	private transient   Integer rows =10;//页面显示数
	@JsonIgnore
	private transient   String sort;//排序字段
	@JsonIgnore
	private transient   String order;//排序类型
	@JsonIgnore
	private transient   Integer pageNo = 1;//当前页
	@JsonIgnore
	private transient   Integer pageSize =10;//页面显示数
	@JsonIgnore
	private transient   Integer startIndex;//分页获取数据的启始位置
	@JsonIgnore
	private transient   Integer endIndex;//分页获取数据的启始位置
	
	

	
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Integer getStartIndex() {
		startIndex = (this.getPage() - 1) * this.getRows();
		if(startIndex < 1){
			startIndex  =0;
		}
		return startIndex;
	}
	
	public Integer getEndIndex() {
		endIndex = this.getStartIndex() + this.getPageSize();
		return endIndex;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Integer getPage() {
		if(page <1){
			page = 1;
		}
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		if(rows < 1){
			rows  = 10;
		}
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Integer getPageNo() {
		if(pageNo == null){
			pageNo = this.getPage();
		}
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		if(pageSize == null){
			pageSize = this.getRows();
		}
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
