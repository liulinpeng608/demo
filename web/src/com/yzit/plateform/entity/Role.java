package com.yzit.plateform.entity;
import com.yzit.core.base.BaseEntity;
 /**
 * <b>功能:</b>角色实体类<br>
 * <b>作者:</b>Administrator<br>
 * <b>日期:</b>Tue Jan 02 10:21:29 CST 2018 <br>
 * <b>版权所有:云优众<br>
 */
public class Role extends BaseEntity {
   	private static final long serialVersionUID = 1L;
		private Integer id;//编号	private String name;//角色名称	private String enname;//英文名称	private String roleType;//角色类型	private String dataScope;//数据范围	private Integer isSys;//是否系统数据	private Integer useAble;//是否可用	private String delFlag;//删除标记	public Integer getId() {	    return this.id;	}	public void setId(Integer id) {	    this.id=id;	}	public String getName() {	    return this.name;	}	public void setName(String name) {	    this.name=name;	}	public String getEnname() {	    return this.enname;	}	public void setEnname(String enname) {	    this.enname=enname;	}	public String getRoleType() {	    return this.roleType;	}	public void setRoleType(String roleType) {	    this.roleType=roleType;	}	public String getDataScope() {	    return this.dataScope;	}	public void setDataScope(String dataScope) {	    this.dataScope=dataScope;	}	public Integer getIsSys() {	    return this.isSys;	}	public void setIsSys(Integer isSys) {	    this.isSys=isSys;	}	public Integer getUseAble() {	    return this.useAble;	}	public void setUseAble(Integer useAble) {	    this.useAble=useAble;	}	public String getDelFlag() {	    return this.delFlag;	}	public void setDelFlag(String delFlag) {	    this.delFlag=delFlag;	}
}

