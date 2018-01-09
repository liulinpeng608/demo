package com.yzit.plateform.entity;
import com.yzit.core.base.BaseEntity;
 /**
 * <b>功能:</b>操作日志实体类<br>
 * <b>作者:</b>Administrator<br>
 * <b>日期:</b>Tue Jan 02 10:21:30 CST 2018 <br>
 * <b>版权所有:云优众<br>
 */
public class Logs extends BaseEntity {
   	private static final long serialVersionUID = 1L;
		private Integer id;//编号	private String types;//日志类型	private String title;//日志标题	private Integer createBy;//创建者	private java.util.Date createDate;//创建时间	private String remoteAddr;//操作IP地址	private String userAgent;//用户代理	private String requestUri;//请求URI	private String method;//操作方式	private java.lang.Object params;//操作提交的数据	private java.lang.Object exceptions;//异常信息	public Integer getId() {	    return this.id;	}	public void setId(Integer id) {	    this.id=id;	}	public String getTypes() {	    return this.types;	}	public void setTypes(String types) {	    this.types=types;	}	public String getTitle() {	    return this.title;	}	public void setTitle(String title) {	    this.title=title;	}	public Integer getCreateBy() {	    return this.createBy;	}	public void setCreateBy(Integer createBy) {	    this.createBy=createBy;	}	public java.util.Date getCreateDate() {	    return this.createDate;	}	public void setCreateDate(java.util.Date createDate) {	    this.createDate=createDate;	}	public String getRemoteAddr() {	    return this.remoteAddr;	}	public void setRemoteAddr(String remoteAddr) {	    this.remoteAddr=remoteAddr;	}	public String getUserAgent() {	    return this.userAgent;	}	public void setUserAgent(String userAgent) {	    this.userAgent=userAgent;	}	public String getRequestUri() {	    return this.requestUri;	}	public void setRequestUri(String requestUri) {	    this.requestUri=requestUri;	}	public String getMethod() {	    return this.method;	}	public void setMethod(String method) {	    this.method=method;	}	public java.lang.Object getParams() {	    return this.params;	}	public void setParams(java.lang.Object params) {	    this.params=params;	}	public java.lang.Object getExceptions() {	    return this.exceptions;	}	public void setExceptions(java.lang.Object exceptions) {	    this.exceptions=exceptions;	}
}

