package com.yzit.core.vo;


/**
 * 针对ajax提供的json转换类
 * @author 康伟
 *
 */
public class AjaxJson implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private boolean success = false;

	private String msg = "";

	private Object obj = null;
	private int  code  = 0;//状态码 303已经登录了   404  505
	

	public AjaxJson(boolean success) {
		super();
		this.success = success;
	}

	public AjaxJson(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}
	
	public AjaxJson(boolean success, String msg, Object obj) {
		super();
		this.success = success;
		this.msg = msg;
		this.obj = obj;
	}
	public AjaxJson(boolean success, String msg, int code,Object obj) {
		super();
		this.success = success;
		this.msg = msg;
		this.obj = obj;
		this.code = code;
	}
	public AjaxJson(boolean success, String msg, int code) {
		super();
		this.success = success;
		this.msg = msg;
		this.code = code;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}