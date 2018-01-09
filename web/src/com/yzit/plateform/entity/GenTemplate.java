package com.yzit.plateform.entity;
import com.yzit.core.base.BaseEntity;
 /**
 * <b>功能:</b>模板表实体类<br>
 * <b>作者:</b>Administrator<br>
 * <b>日期:</b>Tue Jan 02 10:21:31 CST 2018 <br>
 * <b>版权所有:云优众<br>
 */
public class GenTemplate extends BaseEntity {
   	private static final long serialVersionUID = 1L;
		private Integer id;//编号	private String name;//名称	private String category;//分类	private String filePath;//生成文件路径	private String fileName;//生成文件名	private java.lang.Object content;//内容	private String remarks;//备注信息	private String delFlag;//删除标记（0：正常；1：删除）	public Integer getId() {	    return this.id;	}	public void setId(Integer id) {	    this.id=id;	}	public String getName() {	    return this.name;	}	public void setName(String name) {	    this.name=name;	}	public String getCategory() {	    return this.category;	}	public void setCategory(String category) {	    this.category=category;	}	public String getFilePath() {	    return this.filePath;	}	public void setFilePath(String filePath) {	    this.filePath=filePath;	}	public String getFileName() {	    return this.fileName;	}	public void setFileName(String fileName) {	    this.fileName=fileName;	}	public java.lang.Object getContent() {	    return this.content;	}	public void setContent(java.lang.Object content) {	    this.content=content;	}	public String getRemarks() {	    return this.remarks;	}	public void setRemarks(String remarks) {	    this.remarks=remarks;	}	public String getDelFlag() {	    return this.delFlag;	}	public void setDelFlag(String delFlag) {	    this.delFlag=delFlag;	}
}

