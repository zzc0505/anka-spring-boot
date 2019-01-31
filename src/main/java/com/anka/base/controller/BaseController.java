package com.anka.base.controller;

import java.lang.reflect.ParameterizedType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anka.base.model.BaseModel;

public class BaseController<T extends BaseModel<T>> {
	
	private Class<T> modelClass;
	
	@SuppressWarnings("unchecked")
	public BaseController() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
    	modelClass = (Class<T>) pt.getActualTypeArguments()[0];
	}
	/**
	 * 通用页面跳转
	 * @param view
	 * @return
	 */
	@RequestMapping("/{view}")
	public String view(@PathVariable String view){
		String path = "";
		try {
			T model = modelClass.newInstance();
			String modelName = model.getClass().getName().substring(
					model.getClass().getName().lastIndexOf(".")+1, model.getClass().getName().length());
			String[] temp = modelName.replaceAll("[A-Z]", " $0").trim().split(" ");
			for (String t : temp) {
				path+=t.toLowerCase()+"/";
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return path+view;
	}
}
