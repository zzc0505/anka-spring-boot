package com.anka.base.excepiton;

import com.anka.base.utils.BaseCode;

public class BusinessException extends RuntimeException{

	private static final long serialVersionUID = -5585227859128232318L;

	private Integer code;
	
	public BusinessException() {
		
	}
	public BusinessException(Integer code, String msg) {
		super(msg);
		this.code = code;
	}
	
	public BusinessException(BaseCode baseCode) {
		super(baseCode.getMsg());
		this.code = baseCode.getCode();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
}
