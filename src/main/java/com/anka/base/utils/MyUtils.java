package com.anka.base.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.springframework.util.StringUtils;

public class MyUtils {

	/**
	 * 获取集合中特定属性的集合
	 * @param collection 集合
	 * @param field 字段名
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> getProperties(Collection<?> collection, String field){
		if(StringUtils.hasText(field)){
			List<T> list = new ArrayList<T>(collection.size());
			Iterator<?> it = collection.iterator();
			while (it.hasNext()) {
				Object object = it.next();
				MetaObject mo = MetaObject.forObject(object, new DefaultObjectFactory(), 
						new DefaultObjectWrapperFactory(), new DefaultReflectorFactory());
				T v = (T) mo.getValue(field);
				if(v!=null && StringUtils.hasText(v.toString())){
					list.add(v);
				}
			}
			return list;
		}
		return null;
	}
	
	/**
	 * 去除重复元素
	 * @param list
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List removeDuplicate(List<?> list) {
	    HashSet h = new HashSet(list);
	    list.clear();   
	    list.addAll(h);   
	    return list;   
	}
	
}
