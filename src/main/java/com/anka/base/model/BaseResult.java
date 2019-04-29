package com.anka.base.model;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public class BaseResult<T> implements Serializable{

	private static final long serialVersionUID = -5871175188050886767L;
	
	private Integer code;
	
	private String msg;
	
	private Object data;
	
	private Long count;

	public Integer getCode() {
		return code;
	}

	public BaseResult<T> setCode(Integer code) {
		this.code = code;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public BaseResult<T> setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public Object getData() {
		return data;
	}

	public BaseResult<T> setData(Object data) {
		this.data = data;
		return this;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
