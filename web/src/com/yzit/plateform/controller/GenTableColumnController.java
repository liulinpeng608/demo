package com.yzit.plateform.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzit.core.vo.DataGrid;
import com.yzit.core.vo.PageModel;
import com.yzit.core.vo.AjaxJson;
import com.yzit.core.base.BaseController;


import com.yzit.plateform.entity.GenTableColumn;
import com.yzit.plateform.service.GenTableColumnService;
 
/**
 *
 * <br>
 * <b>功能:</b>GenTableColumnController<br>
 * <b>作者:</b>Administrator<br>
 * <b>日期:</b>Tue Jan 02 10:21:31 CST 2018 <br>
 * <b>版权所有:云优众<br>
 */
@Controller
@RequestMapping("/genTableColumn") 
public class GenTableColumnController extends BaseController{
	
	//private final static Logger log= Logger.getLogger(GenTableColumnController.class);
	
	@Autowired
	private GenTableColumnService genTableColumnService; 
	
	/**
	 * 跳转到列表页面
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/v_list.do") 
	public String  list() throws Exception{
		return "/plateform/genTableColumn/genTableColumn_list";
	}
	
	
	/**
	 * 列表数据
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/v_dataList.do")
	@ResponseBody
	public DataGrid<GenTableColumn>  datalist(GenTableColumn  genTableColumn) throws Exception{
		//设置页面数据
		DataGrid<GenTableColumn>  genTableColumnDateGrid   = new DataGrid<GenTableColumn>();
		PageModel<GenTableColumn> pm = genTableColumnService.findByPage(genTableColumn);
		genTableColumnDateGrid.setRows(pm.getDataList());
		genTableColumnDateGrid.setTotal(pm.getTotalCount());
		return genTableColumnDateGrid;
	}
	
	/**
	 * 进入-添加或修改数据
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/v_form.do")
	public String  form(Model model,@RequestParam(value="id",defaultValue="0") Integer id) throws Exception{
		GenTableColumn  genTableColumn  =  null;
		if( id  > 0  ){
			genTableColumn =	genTableColumnService.findById(id);
		}
		model.addAttribute("genTableColumn", genTableColumn);
		//跳转到页面
		return "/plateform/genTableColumn/genTableColumn_form";
	}
	/**
	 * 添加或修改数据
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/o_save.do")
	@ResponseBody
	public AjaxJson  form( GenTableColumn  genTableColumn ) throws Exception{
		boolean flag = true;
		String msg = null;
		try{
			if(genTableColumn.getId() != null ){
				genTableColumnService.update(genTableColumn);
			}else{
				genTableColumnService.save(genTableColumn);
			}
		}catch(Exception e){
			flag = false;
			e.printStackTrace();
			msg = "操作失败！错误信息："+e.getMessage();
		}
		return new AjaxJson(flag,msg);
	}
	/**
	 * 删除数据
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/o_del.do")
	@ResponseBody
	public AjaxJson  del( @RequestParam(value="id") Integer id ) throws Exception{
		boolean flag = true;
		String msg = null;
		try{
			genTableColumnService.delById(id);
		}catch(Exception e){
			flag = false;
			e.printStackTrace();
			msg = "操作失败！错误信息："+e.getMessage();
		}
		return new AjaxJson(flag,msg);
	}
}
