package com.yzit.plateform.entity;
import com.yzit.core.base.BaseEntity;
 /**
 * <b>功能:</b>字典实体类<br>
 * <b>作者:</b>Administrator<br>
 * <b>日期:</b>Tue Jan 02 10:21:30 CST 2018 <br>
 * <b>版权所有:云优众<br>
 */
public class Dict extends BaseEntity {
   	private static final long serialVersionUID = 1L;
		private Integer id;//编号	private String value;//数据值	private String label;//标签名	private String type;//类型	private String description;//描述	private Integer sorts;//排序（升序）	private Integer parentId;//父级编号	private String remarks;//备注信息	private String delFlag;//删除标记	public Integer getId() {	    return this.id;	}	public void setId(Integer id) {	    this.id=id;	}	public String getValue() {	    return this.value;	}	public void setValue(String value) {	    this.value=value;	}	public String getLabel() {	    return this.label;	}	public void setLabel(String label) {	    this.label=label;	}	public String getType() {	    return this.type;	}	public void setType(String type) {	    this.type=type;	}	public String getDescription() {	    return this.description;	}	public void setDescription(String description) {	    this.description=description;	}	public Integer getSorts() {	    return this.sorts;	}	public void setSorts(Integer sorts) {	    this.sorts=sorts;	}	public Integer getParentId() {	    return this.parentId;	}	public void setParentId(Integer parentId) {	    this.parentId=parentId;	}	public String getRemarks() {	    return this.remarks;	}	public void setRemarks(String remarks) {	    this.remarks=remarks;	}	public String getDelFlag() {	    return this.delFlag;	}	public void setDelFlag(String delFlag) {	    this.delFlag=delFlag;	}
}

