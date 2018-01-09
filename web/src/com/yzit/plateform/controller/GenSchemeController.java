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


import com.yzit.plateform.entity.GenScheme;
import com.yzit.plateform.service.GenSchemeService;
 
/**
 *
 * <br>
 * <b>功能:</b>GenSchemeController<br>
 * <b>作者:</b>Administrator<br>
 * <b>日期:</b>Tue Jan 02 10:21:30 CST 2018 <br>
 * <b>版权所有:云优众<br>
 */
@Controller
@RequestMapping("/genScheme") 
public class GenSchemeController extends BaseController{
	
	//private final static Logger log= Logger.getLogger(GenSchemeController.class);
	
	@Autowired
	private GenSchemeService genSchemeService; 
	
	/**
	 * 跳转到列表页面
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/v_list.do") 
	public String  list() throws Exception{
		return "/plateform/genScheme/genScheme_list";
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
	public DataGrid<GenScheme>  datalist(GenScheme  genScheme) throws Exception{
		//设置页面数据
		DataGrid<GenScheme>  genSchemeDateGrid   = new DataGrid<GenScheme>();
		PageModel<GenScheme> pm = genSchemeService.findByPage(genScheme);
		genSchemeDateGrid.setRows(pm.getDataList());
		genSchemeDateGrid.setTotal(pm.getTotalCount());
		return genSchemeDateGrid;
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
		GenScheme  genScheme  =  null;
		if( id  > 0  ){
			genScheme =	genSchemeService.findById(id);
		}
		model.addAttribute("genScheme", genScheme);
		//跳转到页面
		return "/plateform/genScheme/genScheme_form";
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
	public AjaxJson  form( GenScheme  genScheme ) throws Exception{
		boolean flag = true;
		String msg = null;
		try{
			if(genScheme.getId() != null ){
				genSchemeService.update(genScheme);
			}else{
				genSchemeService.save(genScheme);
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
			genSchemeService.delById(id);
		}catch(Exception e){
			flag = false;
			e.printStackTrace();
			msg = "操作失败！错误信息："+e.getMessage();
		}
		return new AjaxJson(flag,msg);
	}
}
