package com.yzit.plateform.controller;

import javax.servlet.http.HttpSession;

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

import com.yzit.plateform.entity.User;
import com.yzit.plateform.service.UserService;

/**
 * 
 * <br>
 * <b>功能:</b>UserController<br>
 * <b>作者:</b>Administrator<br>
 * <b>日期:</b>Tue Jan 02 10:21:30 CST 2018 <br>
 * <b>版权所有:云优众<br>
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	// private final static Logger log= Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping("/v_info.do")
	public String v_info(HttpSession session){
		
		return "/plateform/user/user_info";
	}
	/**
	 * 跳转到列表页面
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/v_list.do")
	public String list() throws Exception {
		return "/plateform/user/user_list";
	}

	/**
	 * 列表数据
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/v_dataList.do")
	@ResponseBody
	public DataGrid<User> datalist(User user) throws Exception {
		// 设置页面数据
		DataGrid<User> userDateGrid = new DataGrid<User>();
		PageModel<User> pm = userService.findByPage(user);
		userDateGrid.setRows(pm.getDataList());
		userDateGrid.setTotal(pm.getTotalCount());
		return userDateGrid;
	}

	/**
	 * 进入-添加或修改数据
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/v_form.do")
	public String form(Model model,@RequestParam(value = "id", defaultValue = "0")Integer id) throws Exception {
		User user = null;
		if (id > 0) {
			user = userService.findById(id);
		}
		model.addAttribute("user", user);
		// 跳转到页面
		return "/plateform/user/user_form";
	}

	/**
	 * 添加或修改数据
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/o_save.do")
	@ResponseBody
	public AjaxJson form(User user) throws Exception {
		boolean flag = true;
		String msg = null;
		try {
			if (user.getId() != null) {
				userService.update(user);
			} else {
				userService.save(user);
			}
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
			msg = "操作失败！错误信息：" + e.getMessage();
		}
		return new AjaxJson(flag, msg);
	}

	/**
	 * 删除数据
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/o_del.do")
	@ResponseBody
	public AjaxJson del(@RequestParam(value = "id")
	Integer id) throws Exception {
		boolean flag = true;
		String msg = null;
		try {
			userService.delById(id);
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
			msg = "操作失败！错误信息：" + e.getMessage();
		}
		return new AjaxJson(flag, msg);
	}
}
