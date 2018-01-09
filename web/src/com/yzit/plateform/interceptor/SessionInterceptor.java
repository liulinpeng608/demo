package com.yzit.plateform.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yzit.plateform.entity.User;

/**
 * 配置登陆拦截器
 * @author Administrator
 *
 */
public class SessionInterceptor  extends HandlerInterceptorAdapter{
	
	private List<String> noCheckUrl;
	
	
	
	public void setNoCheckUrl(List<String> noCheckUrl) {
		this.noCheckUrl = noCheckUrl;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//用户请求的url地址
		String uri = request.getRequestURI();
		//login.do不需要拦截
//		if(uri.contains("login.do") || uri.contains("doLogin.do")){
//			return true;
//		}
		for(String urlll   : noCheckUrl){
			if(uri.contains(urlll)){
				return true;
			}
		}
		
		User user =(User) request.getSession().getAttribute("SESSION_USER");
		if(user == null){
//			request.getRequestDispatcher("/login.do").forward(request, response);
			response.sendRedirect(request.getContextPath() +"/login.do");
			return false;
		}
		
		System.out.println("----SessionInterceptor-----------preHandle----------11111-------");
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("----SessionInterceptor-----------preHandle----------222222-------");
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("----SessionInterceptor-----------afterCompletion----------33333-------");
		super.afterCompletion(request, response, handler, ex);
	}
}
