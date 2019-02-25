package com.anka.base.utils;

public enum BaseCode {

	SUCCESS(0,"操作成功！"),
	
	FAILL(1,"操作失败！"),
	
	NOT_FOUND(404,"未找到页面！"),
	
	SERVER_ERROR(500,"服务器内部错误！");
	
	public Integer code;
	
	public String msg;
	
	BaseCode(Integer code,String msg){
		this.code = code;
		this.msg = msg;
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
