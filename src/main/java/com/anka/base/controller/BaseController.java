package com.anka.base.controller;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anka.base.annotation.FCMD;
import com.anka.base.model.BaseModel;
import com.anka.base.model.BaseResult;
import com.anka.base.model.BaseTree;
import com.anka.base.utils.BaseCode;
import com.github.pagehelper.Page;

public class BaseController<T extends BaseModel<T>> {
	
	/**
	 * @Description: 通用页面跳转
	 * @author AnkaRebirth
	 * @param view
	 * @return
	 */
	@RequestMapping("/{view}")
	public ModelAndView getView(T baseModel, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("data",baseModel);
		mv.setViewName(request.getServletPath());
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
			if(data instanceof List){
				r.setData(data);
				r.setCount(((Page) data).getTotal());
			}
		}
		return r;
	}

	public BaseResult<T> success(String msg, Object data) {
		BaseResult<T> r = new BaseResult<T>()
				.setCode(BaseCode.SUCCESS.getCode())
				.setMsg(StringUtils.hasText(msg) ? msg : BaseCode.SUCCESS.getMsg());
		if(data!=null){
			if(data instanceof List){
				r.setData(data);
				r.setCount(((Page) data).getTotal());
			}
		}
		return r;
	}
	
	public BaseResult<BaseTree<?>> successTree(Object data) {
		try {
			List<BaseTree<?>> datas = beforeSuccessTree(data);
			BaseResult<BaseTree<?>> r = new BaseResult<BaseTree<?>>()
					.setCode(BaseCode.SUCCESS.getCode())
					.setMsg(BaseCode.SUCCESS.getMsg())
					.setData(datas);
			return r;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public BaseResult<BaseTree<?>> successTree(String msg, Object data) {
		try {
			List<BaseTree<?>> datas = beforeSuccessTree(data);
			BaseResult<BaseTree<?>> r = new BaseResult<BaseTree<?>>()
					.setCode(BaseCode.SUCCESS.getCode())
					.setMsg(StringUtils.hasText(msg) ? msg : BaseCode.SUCCESS.getMsg())
					.setData(data);
			return r;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
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
	
	public List<BaseTree<?>> beforeSuccessTree(Object data) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		if(data instanceof List){
			List<BaseTree<?>> datas = new ArrayList<BaseTree<?>>();
			List list = (List) data;
			if(list.size()>0){
				for (Object model : list) {
					BaseTree<?> tree = getTree(model);
					datas.add(tree);
				}
			}
			return datas;
		}else{
			return null;
		}
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
	
	@SuppressWarnings({ "rawtypes", "static-access" })
	private BaseTree<?> getTree(Object model){
		BaseTree tree = new BaseTree();
		tree.setCheckArr("0");
		tree.setBasicData(model);
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
						if(val!=null&&StringUtils.hasText(val.toString())){
							tree.setParentId(val.toString());
						}else{
							tree.setParentId("0");
							tree.setLast(false);
						}
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
		return tree;
	}
}
