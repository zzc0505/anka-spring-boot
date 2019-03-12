package com.anka.base.service;

import java.util.List;

import com.anka.base.model.BaseTree;


public interface TreeBaseService<T extends BaseTree<T>> extends CrudBaseService<T>{

	/**
	 * 根据条件展示树，增量查询
	 * @param model
	 * @return
	 */
	public List<T> showTree(T model);
}
