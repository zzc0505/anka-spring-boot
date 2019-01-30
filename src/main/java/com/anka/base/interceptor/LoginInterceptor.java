package com.anka.base.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.anka.apps.AppsApplication;
import com.anka.apps.model.CoreUser;
import com.anka.base.utils.Constant;

public class LoginInterceptor implements HandlerInterceptor{

	private final Logger logger = LoggerFactory.getLogger(AppsApplication.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("========================登陆拦截器调用========================");
		CoreUser user = (CoreUser) request.getSession().getAttribute(Constant.SESSION_KEY_USER);
		if(user == null || StringUtils.isEmpty(user)){
			 //用户为空，重新登录
			response.sendRedirect(request.getContextPath()+"/login");
            return false;
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
