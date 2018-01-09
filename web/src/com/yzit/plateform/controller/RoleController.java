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


import com.yzit.plateform.entity.Role;
import com.yzit.plateform.service.RoleService;
 
/**
 *
 * <br>
 * <b>功能:</b>RoleController<br>
 * <b>作者:</b>Administrator<br>
 * <b>日期:</b>Tue Jan 02 10:21:29 CST 2018 <br>
 * <b>版权所有:云优众<br>
 */
@Controller
@RequestMapping("/role") 
public class RoleController extends BaseController{
	
	//private final static Logger log= Logger.getLogger(RoleController.class);
	
	@Autowired
	private RoleService roleService; 
	
	/**
	 * 跳转到列表页面
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/v_list.do") 
	public String  list() throws Exception{
		return "/plateform/role/role_list";
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
	public DataGrid<Role>  datalist(Role  role) throws Exception{
		//设置页面数据
		DataGrid<Role>  roleDateGrid   = new DataGrid<Role>();
		PageModel<Role> pm = roleService.findByPage(role);
		roleDateGrid.setRows(pm.getDataList());
		roleDateGrid.setTotal(pm.getTotalCount());
		return roleDateGrid;
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
		Role  role  =  null;
		if( id  > 0  ){
			role =	roleService.findById(id);
		}
		model.addAttribute("role", role);
		//跳转到页面
		return "/plateform/role/role_form";
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
	public AjaxJson  form( Role  role ) throws Exception{
		boolean flag = true;
		String msg = null;
		try{
			if(role.getId() != null ){
				roleService.update(role);
			}else{
				roleService.save(role);
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
			roleService.delById(id);
		}catch(Exception e){
			flag = false;
			e.printStackTrace();
			msg = "操作失败！错误信息："+e.getMessage();
		}
		return new AjaxJson(flag,msg);
	}
}
