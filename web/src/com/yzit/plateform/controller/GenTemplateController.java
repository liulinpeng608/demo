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


import com.yzit.plateform.entity.GenTemplate;
import com.yzit.plateform.service.GenTemplateService;
 
/**
 *
 * <br>
 * <b>功能:</b>GenTemplateController<br>
 * <b>作者:</b>Administrator<br>
 * <b>日期:</b>Tue Jan 02 10:21:31 CST 2018 <br>
 * <b>版权所有:云优众<br>
 */
@Controller
@RequestMapping("/genTemplate") 
public class GenTemplateController extends BaseController{
	
	//private final static Logger log= Logger.getLogger(GenTemplateController.class);
	
	@Autowired
	private GenTemplateService genTemplateService; 
	
	/**
	 * 跳转到列表页面
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/v_list.do") 
	public String  list() throws Exception{
		return "/plateform/genTemplate/genTemplate_list";
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
	public DataGrid<GenTemplate>  datalist(GenTemplate  genTemplate) throws Exception{
		//设置页面数据
		DataGrid<GenTemplate>  genTemplateDateGrid   = new DataGrid<GenTemplate>();
		PageModel<GenTemplate> pm = genTemplateService.findByPage(genTemplate);
		genTemplateDateGrid.setRows(pm.getDataList());
		genTemplateDateGrid.setTotal(pm.getTotalCount());
		return genTemplateDateGrid;
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
		GenTemplate  genTemplate  =  null;
		if( id  > 0  ){
			genTemplate =	genTemplateService.findById(id);
		}
		model.addAttribute("genTemplate", genTemplate);
		//跳转到页面
		return "/plateform/genTemplate/genTemplate_form";
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
	public AjaxJson  form( GenTemplate  genTemplate ) throws Exception{
		boolean flag = true;
		String msg = null;
		try{
			if(genTemplate.getId() != null ){
				genTemplateService.update(genTemplate);
			}else{
				genTemplateService.save(genTemplate);
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
			genTemplateService.delById(id);
		}catch(Exception e){
			flag = false;
			e.printStackTrace();
			msg = "操作失败！错误信息："+e.getMessage();
		}
		return new AjaxJson(flag,msg);
	}
}
