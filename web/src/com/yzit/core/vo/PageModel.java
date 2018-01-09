package com.yzit.core.vo;

/**
 * 方便的分页模型工具
 */
import java.io.Serializable;
import java.util.List;
/**
 * 分页模型，主要用于存储查询到的数据的分页信息。 <br>
 * 以及从 dao -> service -> controler 传递硬加载入的数据。 br 可以存储json，html等数据，便于从dao获取数据，
 * 在service进行处理返回到 controler直接呈现，避免在controler进行过多的业务处理。
 */
public class PageModel<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	// 每页的最多记录数
    public static final int TOPIC_PAGE_SIZE = 8;
    // 最多连接数
    public static final int PAGE_NUMBER_SIZE = 3;
    // 前面3个
    public static final int CURRENT_PAGE_PLACE = 3;
	
	public PageModel() {
	}
	
	public PageModel(List<T> dataList) {
		this.setDataList(dataList);
	}
	
	public PageModel(List<T> dataList, int totalCount) {
		this.setDataList(dataList);
		this.setTotalCount(totalCount);
	}
	public PageModel(List<T> dataList, int totalCount,int pageNo,int pageSize) {
		this.setDataList(dataList);
		this.setTotalCount(totalCount);
		this.setPageNo(pageNo);
		this.setPageSize(pageSize);
	}
	
	/******************************数字分页的相关方法与参数*************************************/
	/*	计算第一个要显示的页码数，如：[2][3][4]5[6][7][8]
	页码头就应该是2，而页码尾就是8了。计算页码头这个值需要知道在一般情况下当
	前页码的位置(Constants.CURRENT_PAGE_PLACE的值为3)、第多可以显示多少页码
	(Constants.PAGE_NUMBER_SIZE值为7)。
	*/
	public int getTop() {
		// 当前页 - 3 + 1。例如[2][3][4]5[6][7][8]第前页为4(当前页从0开始)，而计算出来的页码从1开始。
		int top = this.pageNo - CURRENT_PAGE_PLACE + 1;
	
		// 如果当前页 - 3小于或等于0，说明不是一般情况，例如：
		// [1]2[3][4][5][6][7]
		if(this.pageNo - CURRENT_PAGE_PLACE <= 0) {
			top = 1;
		} 
		// 如果总页数小于或等于7(要显示的最大页码数)，例如：
		// [1]2[3][4]
		if(this.pageNo <= PAGE_NUMBER_SIZE) {
			top = 1;
		  // 如果最大数为19。而当前页为18。[13][14][15][16][17]18[19]
		  // 这时就不能在用15为页码头了。计算方法为19 - 17 如果小于 7 - 3(看看在18)
		  // 后面是否还有4个位置，如果没有4个位置了，那就只显示最后7个。
		} else if(this.totalPage - this.pageNo < PAGE_NUMBER_SIZE 
						- CURRENT_PAGE_PLACE) {
			top = this.totalPage - PAGE_NUMBER_SIZE + 1;
		}				
		return top;
	}
	//计算末尾页面
	public int getBottom() {
		int bottom = 0 ;
		bottom = getTop() + PAGE_NUMBER_SIZE - 1;
		if(this.getTotalPage() < bottom){
			bottom = this.getTotalPage();
		}
		return bottom;
	}
	
	
	
	/*******************************************************************/
	
	// 存储数据记录
	private List<T> dataList;
	
	// 针对 oracle 等查询数据库时，记录开始的索引位置。如果set 该值，会算出pageNo
	private int startIndex;
	
	// 当前页号，第几页，如果 set 该值，则自动算出 startIndex 值。
	private int pageNo;
	
	// 页面大小,limit
	private int pageSize = 5;
	
	// 总记录数
	private int totalCount;
	
	// 总页数
	private int totalPage;
	
	// 前一页
	private int prevPage;
	
	// 后一页
	private int nextPage;
	
	// 最后一页
	private int lastPage;
	
	// 首页
	private int firstPage;
	
	// 单独对象。
	private Object object;
	
	// 记录 已经做好的 JSON 字符串数据
	private String dataJson;
	
	// 记录 已经做好的 html 字符串数据
	private String dataHtml;
	
	// 记录 已经做好的 json 数据集。
	private List<String> jsonList;
	
	// 其他需要存放的数据
	private List<Object> otherData;
	
	
	
	
	public static int[] getStartEnd(int pageNo, int pageSize) {
		int start = (pageNo - 1) * pageSize;
		int end = start + pageSize - 1;
		return new int[] { start, end };
	}
	
	public int getPageNo() {
		if (pageNo <= 0) {
			return 1;
		}
		if(pageNo > this.getTotalPage()){
			pageNo = this.getTotalPage();
		}
		
//		if (pageNo <= 0) {
//			if (this.startIndex >= 0) {
//				this.pageNo = this.startIndex / this.pageSize + 1;
//			} else {
//				pageNo = 1;
//			}
//		}
		
//		System.out.println();
//		if (pageNo >= this.totalPage) {
//			pageNo = this.totalPage;
//		}
		return pageNo;
	}
	
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public List<T> getDataList() {
		return dataList;
	}
	
	public int getStartIndex() {
		if (this.startIndex >= this.totalCount) {
			this.startIndex = this.totalCount - this.pageSize;
		}
		if (this.startIndex <= 0) {
			this.startIndex = 0;
		}
		return startIndex;
	}
	
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	
	public int getPrevPage() {
		prevPage = this.getPageNo() - 1;
		if (prevPage < 1) {
			prevPage = 1;
		}
		if (prevPage > getTotalPage()) {
			prevPage = getTotalPage();
		}
		return prevPage;
	}
	
	public int getNextPage() {
		nextPage = this.getPageNo() + 1;
		if (nextPage > getTotalPage()) {
			nextPage = getTotalPage();
		}
		if (nextPage < 1) {
			nextPage = 1;
		}
		return nextPage;
	}
	
	public int getLastPage() {
		lastPage = getTotalPage();
		return lastPage;
	}
	
	public int getFirstPage() {
		firstPage = 1;
		return firstPage;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public int getTotalPage() {
		if (pageSize == 0) {
			return 0;
		}
		totalPage = (totalCount + pageSize - 1) / pageSize;
		return totalPage;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public Object getObject() {
		return object;
	}
	
	public void setObject(Object object) {
		this.object = object;
	}
	
	public List<String> getJsonList() {
		return jsonList;
	}
	
	public void setJsonList(List<String> jsonList) {
		this.jsonList = jsonList;
	}
	
	public List<Object> getOtherData() {
		return otherData;
	}
	
	public void setOtherData(List<Object> otherData) {
		this.otherData = otherData;
	}
	
	public String getDataJson() {
		return dataJson;
	}
	
	public void setDataJson(String dataJson) {
		this.dataJson = dataJson;
	}
	
	public String getDataHtml() {
		return dataHtml;
	}
	
	public void setDataHtml(String dataHtml) {
		this.dataHtml = dataHtml;
	}
	
}


