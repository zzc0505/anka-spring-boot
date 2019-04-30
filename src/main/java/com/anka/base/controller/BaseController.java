package com.anka.base.controller;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anka.base.annotation.FCMD;
import com.anka.base.model.BaseModel;
import com.anka.base.model.BaseResult;
import com.anka.base.model.BaseTree;
import com.anka.base.utils.BaseCode;
import com.github.pagehelper.Page;

public class BaseController<T extends BaseModel<T>> {
	
	protected final String OBJECT_FORMAT = "object_format";
	protected final String TREE_FORMAT = "tree_format";
	private String resultType = OBJECT_FORMAT;

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	/**
	 * @Description: 通用页面跳转
	 * @author AnkaRebirth
	 * @param view
	 * @return
	 */
	@RequestMapping("/{view}")
	public ModelAndView getView(@PathVariable String view, T baseModel, HttpServletRequest request) {
		String path = "";
		Map<String, String[]> map = request.getParameterMap();
		Field[] filed = baseModel.getClass().getDeclaredFields();
		ModelAndView mv = new ModelAndView();
		for (Field f : filed) {
			f.setAccessible(true);
			for (Map.Entry<String, String[]> entry : map.entrySet()) {
				if (f.getName().equals(entry.getKey())) {
					mv.addObject(entry.getKey(), entry.getValue()[0]);
				}
			}
		}
		if (baseModel.getClass().getSuperclass() != null) {
			filed = baseModel.getClass().getSuperclass().getDeclaredFields();
			for (Field f : filed) {
				for (Map.Entry<String, String[]> entry : map.entrySet()) {
					if (entry.getKey().startsWith("str")) {
						if (entry.getKey().startsWith(f.getName()) && entry.getKey().indexOf(".") != -1) {
							Map<String, Object> m = new HashMap<String, Object>();
							m.put(entry.getKey().substring(entry.getKey().indexOf(".") + 1, entry.getKey().length()),
									entry.getValue()[0]);
							mv.addObject(f.getName(), m);
						}
						if (f.getName().equals(entry.getKey())) {
							mv.addObject(entry.getKey(), entry.getValue()[0]);
						}
					}
				}
			}
		}
		try {
			Class<?> clazz = Class
					.forName(baseModel.getClass().getName().replace("model", "controller") + "Controller");
			boolean present = clazz.isAnnotationPresent(RequestMapping.class);
			if (present) {
				RequestMapping annotation = clazz.getAnnotation(RequestMapping.class);
				String[] value = annotation.value();
				path = value[0] + "/";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		mv.setViewName(path + view);
		return mv;
	}

	public BaseResult<T> success() {
		return new BaseResult<T>().setCode(BaseCode.SUCCESS.getCode()).setMsg(BaseCode.SUCCESS.getMsg());
	}

	public BaseResult<T> success(String msg) {
		return new BaseResult<T>().setCode(BaseCode.SUCCESS.getCode())
				.setMsg(StringUtils.hasText(msg) ? msg : BaseCode.SUCCESS.getMsg());
	}

	public BaseResult<T> success(Object data) {
		BaseResult<T> r = new BaseResult<T>()
				.setCode(BaseCode.SUCCESS.getCode())
				.setMsg(BaseCode.SUCCESS.getMsg());
		if(data!=null){
			if(resultType.equals(OBJECT_FORMAT)&&data instanceof List){
				r.setData(data);
				r.setCount(((Page) data).getTotal());
			}
			if(resultType.equals(TREE_FORMAT)){
				r.setData(treeFormat(data));
			}
		}
		return r;
	}

	public BaseResult<T> success(String msg, Object data) {
		BaseResult<T> r = new BaseResult<T>()
				.setCode(BaseCode.SUCCESS.getCode())
				.setMsg(StringUtils.hasText(msg) ? msg : BaseCode.SUCCESS.getMsg());
		if(data!=null){
			if(resultType.equals(OBJECT_FORMAT)&&data instanceof List){
				r.setData(data);
				r.setCount(((Page) data).getTotal());
			}
			if(resultType.equals(TREE_FORMAT)){
				r.setData(treeFormat(data));
			}
		}
		return r;
	}
	
	public BaseResult<BaseTree<?>> successTree(Object data) {
		BaseResult<BaseTree<?>> r = new BaseResult<BaseTree<?>>()
				.setCode(BaseCode.SUCCESS.getCode())
				.setMsg(BaseCode.SUCCESS.getMsg())
				.setData(data);
		return r;
	}
	
	public BaseResult<BaseTree<?>> successTree(String msg, Object data) {
		BaseResult<BaseTree<?>> r = new BaseResult<BaseTree<?>>()
				.setCode(BaseCode.SUCCESS.getCode())
				.setMsg(StringUtils.hasText(msg) ? msg : BaseCode.SUCCESS.getMsg())
				.setData(data);
		return r;
	}

	public ModelAndView success(Object data, String uri) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", data);
		mv.addObject("code", BaseCode.SUCCESS.getCode());
		mv.addObject("msg", BaseCode.SUCCESS.getMsg());
		mv.setViewName(uri);
		return mv;
	}

	public ModelAndView success(Object data, String uri, String msg) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", data);
		mv.addObject("code", BaseCode.SUCCESS.getCode());
		mv.addObject("msg", StringUtils.hasText(msg) ? msg : BaseCode.SUCCESS.getMsg());
		mv.setViewName(uri);
		return mv;
	}

	public BaseResult<T> fail() {
		return new BaseResult<T>().setCode(BaseCode.FAILL.getCode()).setMsg(BaseCode.FAILL.getMsg());
	}

	public BaseResult<T> fail(String msg) {
		return new BaseResult<T>().setCode(BaseCode.FAILL.getCode())
				.setMsg(StringUtils.hasText(msg) ? msg : BaseCode.FAILL.getMsg());
	}

	public BaseResult<T> fail(Object data) {
		BaseResult<T> r = new BaseResult<T>()
				.setCode(BaseCode.FAILL.getCode())
				.setMsg(BaseCode.FAILL.getMsg())
				.setData(data);
		if(data  instanceof List){
			r.setCount(((Page) data).getTotal());
		}
		return r;
	}

	public BaseResult<T> fail(String msg, Object data) {
		BaseResult<T> r = new BaseResult<T>()
				.setCode(BaseCode.FAILL.getCode())
				.setMsg(StringUtils.hasText(msg) ? msg : BaseCode.FAILL.getMsg())
				.setData(data);
		if(data  instanceof List){
			r.setCount(((Page) data).getTotal());
		}
		return r;
	}

	public ModelAndView fail(Object data, String uri) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", data);
		mv.addObject("code", BaseCode.FAILL.getCode());
		mv.addObject("msg", BaseCode.FAILL.getMsg());
		mv.setViewName(uri);
		return mv;
	}

	public ModelAndView fail(Object data, String uri, String msg) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", data);
		mv.addObject("code", BaseCode.FAILL.getCode());
		mv.addObject("msg", StringUtils.hasText(msg) ? msg : BaseCode.FAILL.getMsg());
		mv.setViewName(uri);
		return mv;
	}
	
	public BaseResult<BaseTree<?>> failTree(Object data) {
		BaseResult<BaseTree<?>> r = new BaseResult<BaseTree<?>>()
				.setCode(BaseCode.FAILL.getCode())
				.setMsg(BaseCode.FAILL.getMsg())
				.setData(data);
		return r;
	}
	
	public BaseResult<BaseTree<?>> failTree(String msg, Object data) {
		BaseResult<BaseTree<?>> r = new BaseResult<BaseTree<?>>()
				.setCode(BaseCode.FAILL.getCode())
				.setMsg(StringUtils.hasText(msg) ? msg : BaseCode.FAILL.getMsg())
				.setData(data);
		return r;
	}
	
	private List<Object> treeFormat(Object data){
		List<Object> datas = new ArrayList<Object>();
		if(data instanceof List){
			List list = (List) data;
			if(list.size()>0){
				for (Object model : list) {
					Class<?> superClass = model.getClass().getSuperclass();
					System.out.println(superClass.getSimpleName());
					if(superClass!=null&&superClass.getSimpleName().equals("BaseTree")){
						BaseTree tree = new BaseTree();
						//tree.setBasicData(model);
						Field[] fields = model.getClass().getDeclaredFields();
						for (Field f : fields) {
							FCMD fCmd = f.getAnnotation(FCMD.class);
							if(fCmd != null&&StringUtils.hasText(fCmd.fieldName())){
								Method getMethod = getMd(model, fCmd.fieldName(), "get");
								try {
									Object val = getMethod.invoke(model, new Object[] {});
									if(fCmd.type()==fCmd.type().UUID){
										tree.setId(String.valueOf(val));
									}
									if(fCmd.type()==fCmd.type().TEXT){
										tree.setTitle(String.valueOf(val));;
									}
									if(fCmd.type()==fCmd.type().PID){
										tree.setParentId(String.valueOf(val));
									}
									if(fCmd.type()==fCmd.type().ICON){
										tree.setIconClass(String.valueOf(val));
									}
								} catch (IllegalAccessException e) {
									e.printStackTrace();
								} catch (IllegalArgumentException e) {
									e.printStackTrace();
								} catch (InvocationTargetException e) {
									e.printStackTrace();
								}
							}
						}
						BeanUtils.copyProperties(tree, model);
						datas.add(model);
						this.resultType = OBJECT_FORMAT;
					}
				}
			}
		}
		return datas;
	}
	/**
	 * 根据对象，字段名，类型获取get set方法
	 * @param obj class对象
	 * @param filedName 字段名
	 * @param type get/set
	 * @return
	 */
	private Method getMd(Object obj, String filedName, String type,Class<?>... cal){
		try {
			Method method = null;
			if(type.equals("set")){
				method = obj.getClass().getMethod(
						type + filedName.substring(0, 1).toUpperCase() + filedName.substring(1), cal[0]);
			}
			if(type.equals("get")){
				method = obj.getClass().getMethod(
						type + filedName.substring(0, 1).toUpperCase() + filedName.substring(1));
			}
			return method;
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			return null;
		} catch (SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}
}
