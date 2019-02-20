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
	 * 
	 * @param view
	 * @return
	 */
	@RequestMapping("/{view}")
	public String view(@PathVariable String view) {
		String path = "";
		try {
			T model = modelClass.newInstance();
			// 得到字节码文件 【只需要更改controller类名】
			try {
				Class<?> clazz = Class
						.forName(model.getClass().getName().replace("model", "controller") + "Controller");
				boolean present = clazz.isAnnotationPresent(RequestMapping.class);
				if (present) {
					// 得到requestMapping注释
					RequestMapping annotation = clazz.getAnnotation(RequestMapping.class);
					// 得到value数组
					String[] value = annotation.value();
					path = value[0] + "/";
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return path + view;
	}
}
