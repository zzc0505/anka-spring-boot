package com.anka.base.controller;

import java.lang.reflect.ParameterizedType;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anka.base.model.BaseModel;
import com.anka.base.model.BaseResult;
import com.anka.base.utils.BaseCode;

public class BaseController<T extends BaseModel<T>> {

	private Class<T> modelClass;

	@SuppressWarnings("unchecked")
	public BaseController() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		modelClass = (Class<T>) pt.getActualTypeArguments()[0];
	}

	/**
	 * @Description: 通用页面跳转
	 * @author AnkaRebirth
	 * @param view
	 * @return
	 */
	@RequestMapping("/{view}")
	public String getView(@PathVariable String view) {
		String path = "";
		try {
			T model = modelClass.newInstance();
			try {
				Class<?> clazz = Class
						.forName(model.getClass().getName().replace("model", "controller") + "Controller");
				boolean present = clazz.isAnnotationPresent(RequestMapping.class);
				if (present) {
					RequestMapping annotation = clazz.getAnnotation(RequestMapping.class);
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

	public BaseResult<T> success() {
		return new BaseResult<T>().setCode(BaseCode.SUCCESS.getCode()).setMsg(BaseCode.SUCCESS.getMsg());
	}

	public BaseResult<T> success(Object data) {
		return new BaseResult<T>().setCode(BaseCode.SUCCESS.getCode()).setMsg(BaseCode.SUCCESS.getMsg()).setData(data);
	}

	public BaseResult<T> success(String msg, Object data) {
		return new BaseResult<T>().setCode(BaseCode.SUCCESS.getCode())
				.setMsg(StringUtils.hasText(msg) ? msg : BaseCode.SUCCESS.getMsg()).setData(data);
	}

	public BaseResult<T> fail() {
		return new BaseResult<T>().setCode(BaseCode.FAILL.getCode()).setMsg(BaseCode.FAILL.getMsg());
	}

	public BaseResult<T> fail(T data) {
		return new BaseResult<T>().setCode(BaseCode.FAILL.getCode()).setMsg(BaseCode.FAILL.getMsg()).setData(data);
	}

	public BaseResult<T> fail(String msg, T data) {
		return new BaseResult<T>().setCode(BaseCode.FAILL.getCode())
				.setMsg(StringUtils.hasText(msg) ? msg : BaseCode.FAILL.getMsg()).setData(data);
	}
}
