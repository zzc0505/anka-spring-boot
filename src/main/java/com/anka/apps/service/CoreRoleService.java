package com.anka.apps.service;

import java.util.List;

import com.anka.apps.model.CoreRole;
import com.anka.base.service.CrudBaseService;

/**
* @Description: 角色表(CoreRoleService)接口
* @author AnkaRebirth
* @date 2019-03-06 14:11
* @version 1.0.0
*/
public interface CoreRoleService extends CrudBaseService<CoreRole> {
	/**
	 * 编辑角色
	 * @param model
	 * @return
	 */
	public CoreRole roleEdit(CoreRole model);
	
	/**
	 * 保存或更新
	 * @param model
	 * @return
	 */
	public Integer doSave(CoreRole model);
	
	/**
	 * 角色列表
	 * @param model
	 * @return
	 */
	public List<CoreRole> getList(CoreRole model);
}
