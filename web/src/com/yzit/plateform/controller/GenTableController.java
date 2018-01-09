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


import com.yzit.plateform.entity.GenTable;
import com.yzit.plateform.service.GenTableService;
 
/**
 *
 * <br>
 * <b>功能:</b>GenTableController<br>
 * <b>作者:</b>Administrator<br>
 * <b>日期:</b>Tue Jan 02 10:21:30 CST 2018 <br>
 * <b>版权所有:云优众<br>
 */
@Controller
@RequestMapping("/genTable") 
public class GenTableController extends BaseController{
	
	//private final static Logger log= Logger.getLogger(GenTableController.class);
	
	@Autowired
	private GenTableService genTableService; 
	
	/**
	 * 跳转到列表页面
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/v_list.do") 
	public String  list() throws Exception{
		return "/plateform/genTable/genTable_list";
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
	public DataGrid<GenTable>  datalist(GenTable  genTable) throws Exception{
		//设置页面数据
		DataGrid<GenTable>  genTableDateGrid   = new DataGrid<GenTable>();
		PageModel<GenTable> pm = genTableService.findByPage(genTable);
		genTableDateGrid.setRows(pm.getDataList());
		genTableDateGrid.setTotal(pm.getTotalCount());
		return genTableDateGrid;
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
		GenTable  genTable  =  null;
		if( id  > 0  ){
			genTable =	genTableService.findById(id);
		}
		model.addAttribute("genTable", genTable);
		//跳转到页面
		return "/plateform/genTable/genTable_form";
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
	public AjaxJson  form( GenTable  genTable ) throws Exception{
		boolean flag = true;
		String msg = null;
		try{
			if(genTable.getId() != null ){
				genTableService.update(genTable);
			}else{
				genTableService.save(genTable);
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
			genTableService.delById(id);
		}catch(Exception e){
			flag = false;
			e.printStackTrace();
			msg = "操作失败！错误信息："+e.getMessage();
		}
		return new AjaxJson(flag,msg);
	}
}
