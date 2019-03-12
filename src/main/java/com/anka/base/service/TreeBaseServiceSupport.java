package com.anka.base.service;

import java.util.List;

import org.springframework.util.StringUtils;

import com.anka.base.model.BaseTree;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;


public class TreeBaseServiceSupport<T extends BaseTree<T>> extends CrudBaseServiceSupport<T> implements TreeBaseService<T> {

	@Override
	public List<T> showTree(T model) {
		Example e = new Example(model.getClass());
		Criteria cnd = e.createCriteria();
		if(StringUtils.hasText(model.getParentId())){
			cnd.andEqualTo("parentId", model.getParentId());
		}
		return super.selectByExample(e);
	}

}
