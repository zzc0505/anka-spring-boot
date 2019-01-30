package com.anka.base.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Transient;

public class BaseModel<T extends BaseModel<T>> implements Serializable{
	
	private static final long serialVersionUID = 5627261198432599387L;

	@Transient
	private T model;
	@Transient
	private Map<String, String> strMap;
	@Transient
	private Map<String, Object> objMap;
	@Transient
	private List<String> strList;
	@Transient
	private List<Object> objList;

	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}

	public Map<String, String> getStrMap() {
		return this.strMap = this.strMap == null?new HashMap<String, String>():this.strMap;
	}

	public void setStrMap(Map<String, String> strMap) {
		this.strMap = strMap;
	}

	public Map<String, Object> getObjMap() {
		return this.objMap = this.objMap == null?new HashMap<String, Object>():this.objMap;
	}

	public void setObjMap(Map<String, Object> objMap) {
		this.objMap = objMap;
	}

	public List<String> getStrList() {
		return this.strList = this.strList == null?new ArrayList<String>():this.strList;
	}

	public void setStrList(List<String> strList) {
		this.strList = strList;
	}

	public List<Object> getObjList() {
		return this.objList = this.objList == null?new ArrayList<Object>():this.objList;
	}

	public void setObjList(List<Object> objList) {
		this.objList = objList;
	}
	
}
