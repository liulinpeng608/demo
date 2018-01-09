package com.yzit.core.vo;

/**
 * 与ztree整合需要的额转换java类，将java代码与ztree的属性对象转换
 * @author Administrator
 *
 */
public class TreeNode {

	private  Integer id;
	private Integer pId;
	private String name;
	private String icon;//图标
	private boolean checked;//选中
	
	private String url;//链接地址
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
