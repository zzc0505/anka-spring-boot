package com.anka.base.aspect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.anka.base.annotation.FCMD;
import com.anka.base.model.BaseTree;

@Component
@Aspect
public class MethodAspect {

	@Pointcut("execution(* com.anka.base.mapper.CrudBaseMapper.insert*(*))")
	public void doSave() {
	};

	@Pointcut("execution(* com.anka.base.mapper.CrudBaseMapper.update*(*))")
	public void doUpdate() {
	};
	
	@Pointcut("execution(* com.anka.base.model.BaseResult.setData(*))")
	public void doSetData() {
	};
	
	@SuppressWarnings("static-access")
	@Before("doSave()")
	public void beforeDoSave(JoinPoint joinPoint) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Object args = joinPoint.getArgs()[0];
		Field[] fields = args.getClass().getDeclaredFields();
		for (Field f : fields) {
			FCMD fCmd = f.getAnnotation(FCMD.class);
			if (fCmd != null&&StringUtils.hasText(fCmd.fieldName())) {
				String filedName = fCmd.fieldName();
				Method getMethod = getMd(args, filedName, "get");
				Object val = getMethod.invoke(args, new Object[] {});
				if(fCmd.type()==fCmd.type().UUID){
					String s = java.util.UUID.randomUUID().toString();
					s = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23)
							+ s.substring(24);
					if (val == null) {
						Method setMethod = getMd(args, filedName, "set", String.class);
						setMethod.invoke(args, s.toUpperCase());
					}
				}
				if(fCmd.type()==fCmd.type().CDATE||fCmd.type()==fCmd.type().UDATE){
					if (val == null) {
						Method setMethod = getMd(args, filedName, "set", Date.class);
						setMethod.invoke(args, new Date());
					}
				}
			}
		}
	}
	
	@SuppressWarnings("static-access")
	@Before("doUpdate()")
	public void beforeDoUpdate(JoinPoint joinPoint){
		Object args = joinPoint.getArgs()[0];
		Field[] fields = args.getClass().getDeclaredFields();
		for (Field f : fields) {
			FCMD fCmd = f.getAnnotation(FCMD.class);
			if (fCmd != null&&StringUtils.hasText(fCmd.fieldName())) {
				String filedName = fCmd.fieldName();
				if(fCmd.type()==fCmd.type().UDATE){
					Method setMethod = getMd(args, filedName, "set", Date.class);
					try {
						setMethod.invoke(args, new Date());
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	@SuppressWarnings({ "rawtypes", "static-access" })
	@Before("doSetData()")
	public void beforeDoSetData(JoinPoint joinPoint) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Object args = joinPoint.getArgs()[0];
		Class<?> superClass = args.getClass().getSuperclass();
		System.out.println(superClass.getSimpleName());
		if(superClass!=null&&superClass.getSimpleName().equals("BaseTree")){
			BaseTree tree = new BaseTree();
			tree.setBasicData(args);
			Field[] fields = args.getClass().getDeclaredFields();
			for (Field f : fields) {
				FCMD fCmd = f.getAnnotation(FCMD.class);
				if(fCmd != null&&StringUtils.hasText(fCmd.fieldName())){
					Method getMethod = getMd(args, fCmd.fieldName(), "get");
					Object val = getMethod.invoke(args, new Object[] {});
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
				}
			}
			BeanUtils.copyProperties(tree, args);
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
}
