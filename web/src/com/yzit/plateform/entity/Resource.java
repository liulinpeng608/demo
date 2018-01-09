package com.yzit.plateform.entity;
import com.yzit.core.base.BaseEntity;
 /**
 * <b>功能:</b>系统菜单实体类<br>
 * <b>作者:</b>Administrator<br>
 * <b>日期:</b>Tue Jan 02 10:21:30 CST 2018 <br>
 * <b>版权所有:云优众<br>
 */
public class Resource extends BaseEntity {
   	private static final long serialVersionUID = 1L;
		private Integer id;//编号	private Integer parentId;//父级编号	private String parentIds;//所有父级编号	private String resName;//名称	private Integer sorts;//排序	private String url;//链接	private String target;//目标	private String icon;//图标	private String isShow;//是否在菜单中显示	private String permission;//权限标识	private String remarks;//备注信息	private String delFlag;//删除标记	private Integer resType;//菜单类型：0表示菜单，1标识按钮	public Integer getId() {	    return this.id;	}	public void setId(Integer id) {	    this.id=id;	}	public Integer getParentId() {	    return this.parentId;	}	public void setParentId(Integer parentId) {	    this.parentId=parentId;	}	public String getParentIds() {	    return this.parentIds;	}	public void setParentIds(String parentIds) {	    this.parentIds=parentIds;	}	public String getResName() {	    return this.resName;	}	public void setResName(String resName) {	    this.resName=resName;	}	public Integer getSorts() {	    return this.sorts;	}	public void setSorts(Integer sorts) {	    this.sorts=sorts;	}	public String getUrl() {	    return this.url;	}	public void setUrl(String url) {	    this.url=url;	}	public String getTarget() {	    return this.target;	}	public void setTarget(String target) {	    this.target=target;	}	public String getIcon() {	    return this.icon;	}	public void setIcon(String icon) {	    this.icon=icon;	}	public String getIsShow() {	    return this.isShow;	}	public void setIsShow(String isShow) {	    this.isShow=isShow;	}	public String getPermission() {	    return this.permission;	}	public void setPermission(String permission) {	    this.permission=permission;	}	public String getRemarks() {	    return this.remarks;	}	public void setRemarks(String remarks) {	    this.remarks=remarks;	}	public String getDelFlag() {	    return this.delFlag;	}	public void setDelFlag(String delFlag) {	    this.delFlag=delFlag;	}	public Integer getResType() {	    return this.resType;	}	public void setResType(Integer resType) {	    this.resType=resType;	}
}

