package com.yzit.plateform.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzit.core.vo.AjaxJson;
import com.yzit.plateform.entity.User;
import com.yzit.plateform.service.UserService;


/**
 * 实现后台的登陆与注销功能
 * @author Administrator
 *
 */
@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	/**
	 * 跳转到登录页面
	 * @return
	 */
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String login(){
		System.out.println("-----------LoginController-------login-------9999999---------");
		return "login";
	}
	/**
	 * 登录功能
	 * @return
	 */
	
	@RequestMapping("/doLogin.do")
	@ResponseBody
	public AjaxJson doLogin(User user,HttpSession session){
		String msg = "用户名或密码错误？？？";
		boolean success = false;
		
		user = userService.login(user);
		if(user != null){
			session.setAttribute("SESSION_USER", user);
			success = true;
		}
		return new AjaxJson(success,msg);
	}

	/**
	 * 退出功能
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/logout.do",method=RequestMethod.GET)
	public String logout(HttpSession session){
		session.invalidate();
		return "login";
	}
	
	@RequestMapping(value="/index.do",method=RequestMethod.GET)
	public String index(){
		System.out.println("-----------LoginController-------index-------9999999---------");
		return "index";
	}
}
