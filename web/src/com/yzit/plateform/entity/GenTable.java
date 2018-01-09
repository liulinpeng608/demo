package com.yzit.plateform.entity;
import com.yzit.core.base.BaseEntity;
 /**
 * <b>功能:</b>数据库表实体类<br>
 * <b>作者:</b>Administrator<br>
 * <b>日期:</b>Tue Jan 02 10:21:30 CST 2018 <br>
 * <b>版权所有:云优众<br>
 */
public class GenTable extends BaseEntity {
   	private static final long serialVersionUID = 1L;
		private Integer id;//编号	private String name;//名称	private String comments;//描述	private String className;//实体类名称	private String parentTable;//关联父表	private String parentTableFk;//关联父表外键	private String remarks;//备注信息	private String delFlag;//删除标记（0：正常；1：删除）	public Integer getId() {	    return this.id;	}	public void setId(Integer id) {	    this.id=id;	}	public String getName() {	    return this.name;	}	public void setName(String name) {	    this.name=name;	}	public String getComments() {	    return this.comments;	}	public void setComments(String comments) {	    this.comments=comments;	}	public String getClassName() {	    return this.className;	}	public void setClassName(String className) {	    this.className=className;	}	public String getParentTable() {	    return this.parentTable;	}	public void setParentTable(String parentTable) {	    this.parentTable=parentTable;	}	public String getParentTableFk() {	    return this.parentTableFk;	}	public void setParentTableFk(String parentTableFk) {	    this.parentTableFk=parentTableFk;	}	public String getRemarks() {	    return this.remarks;	}	public void setRemarks(String remarks) {	    this.remarks=remarks;	}	public String getDelFlag() {	    return this.delFlag;	}	public void setDelFlag(String delFlag) {	    this.delFlag=delFlag;	}
}

