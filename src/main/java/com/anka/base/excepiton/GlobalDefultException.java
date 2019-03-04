package com.anka.base.excepiton;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anka.base.model.BaseResult;
import com.anka.base.utils.BaseCode;

@ControllerAdvice
public class GlobalDefultException {
	
	private final Logger logger = LoggerFactory.getLogger(GlobalDefultException.class);
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public <T> BaseResult<T> defultExcepiton(HttpServletRequest request,Exception e){
		e.printStackTrace();
		if(e instanceof BusinessException){
			logger.error("业务异常："+e.getMessage(),this.getClass());
			BusinessException businessException  = (BusinessException) e;
			return new BaseResult<T>().setCode(businessException.getCode()).setMsg(businessException.getMessage());
		}
		//未知错误
		return new BaseResult<T>().setCode(BaseCode.SERVER_ERROR.getCode()).setMsg("系统异常：\\n"+e);
	}
}
