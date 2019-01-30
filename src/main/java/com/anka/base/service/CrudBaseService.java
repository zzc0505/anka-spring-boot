package com.anka.base.service;

import java.util.List;

import com.anka.base.model.BaseModel;

import tk.mybatis.mapper.entity.Example;

public interface CrudBaseService<T extends BaseModel<T>> {
	/**
	 * 保存，null的属性不会保存，会使用数据库默认值
	 * @param model
	 * @return Integer
	 */
	public Integer save(T model);
	/**
	 * 批量增加，需要objList有要保存的对象
	 * @param model.objList
	 * @return
	 */
	public Integer batchSave(T model);
	/**
	 * 删除，通过注释为@id的字段删除
	 * @param model
	 * @return Integer
	 */
	public Integer delete(T model);
	/**
	 * 批量删除，需要strList有注释为@id的字段的值
	 * @param model.strList
	 * @return Integer
	 */
	public Integer batchDelete(T model);
	/**
	 * 更新，根据主键更新属性不为null的值
	 * @param model
	 * @return Integer
	 */
	public Integer update(T model);
	/**
	 * 批量更新，需要strList有注释为@id的字段的值
	 * @param model.strList
	 * @return Integer
	 */
	public Integer batchUpdate(T model);
	/**
	 * 获取对象，通过注释为@id的字段获取，要求字段符合unique约束
	 * @param model
	 * @return List<T>
	 */
	public T get(String id);
	/**
	 * 查询列表，通过Model中某个成员变量名称（非数据表中column的名称）查找
	 * @param model
	 * @return List<T>
	 */
	public List<T> selectModelList(T model);
	/**
	 * 查询列表，通过Model的strList有注释为@id的字段的值查找
	 * @param model
	 * @return List<T>
	 */
	public List<T> selectModelListByIds(T model);
	/**
	 * 查询列表，根据条件查找
     * @param example
     * @Reutrn List<T>
     */
    public List<T> selectByExample(Example example);
    /**
     * 获取所有列表
     * @return List<T>
     */
    public List<T> selectAll();
}
