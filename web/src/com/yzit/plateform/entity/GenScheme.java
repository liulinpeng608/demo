package com.yzit.plateform.entity;
import com.yzit.core.base.BaseEntity;
 /**
 * <b>功能:</b>数据库实体类<br>
 * <b>作者:</b>Administrator<br>
 * <b>日期:</b>Tue Jan 02 10:21:30 CST 2018 <br>
 * <b>版权所有:云优众<br>
 */
public class GenScheme extends BaseEntity {
   	private static final long serialVersionUID = 1L;
		private Integer id;//编号	private String name;//名称	private String category;//分类	private String packageName;//生成包路径	private String moduleName;//生成模块名	private String subModuleName;//生成子模块名	private String functionName;//生成功能名	private String functionNameSimple;//生成功能名（简写）	private String functionAuthor;//生成功能作者	private String genTableId;//生成表编号	private String remarks;//备注信息	private String delFlag;//删除标记（0：正常；1：删除）	public Integer getId() {	    return this.id;	}	public void setId(Integer id) {	    this.id=id;	}	public String getName() {	    return this.name;	}	public void setName(String name) {	    this.name=name;	}	public String getCategory() {	    return this.category;	}	public void setCategory(String category) {	    this.category=category;	}	public String getPackageName() {	    return this.packageName;	}	public void setPackageName(String packageName) {	    this.packageName=packageName;	}	public String getModuleName() {	    return this.moduleName;	}	public void setModuleName(String moduleName) {	    this.moduleName=moduleName;	}	public String getSubModuleName() {	    return this.subModuleName;	}	public void setSubModuleName(String subModuleName) {	    this.subModuleName=subModuleName;	}	public String getFunctionName() {	    return this.functionName;	}	public void setFunctionName(String functionName) {	    this.functionName=functionName;	}	public String getFunctionNameSimple() {	    return this.functionNameSimple;	}	public void setFunctionNameSimple(String functionNameSimple) {	    this.functionNameSimple=functionNameSimple;	}	public String getFunctionAuthor() {	    return this.functionAuthor;	}	public void setFunctionAuthor(String functionAuthor) {	    this.functionAuthor=functionAuthor;	}	public String getGenTableId() {	    return this.genTableId;	}	public void setGenTableId(String genTableId) {	    this.genTableId=genTableId;	}	public String getRemarks() {	    return this.remarks;	}	public void setRemarks(String remarks) {	    this.remarks=remarks;	}	public String getDelFlag() {	    return this.delFlag;	}	public void setDelFlag(String delFlag) {	    this.delFlag=delFlag;	}
}

