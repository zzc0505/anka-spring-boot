package com.anka.apps.service;

import java.util.List;

import com.anka.apps.model.CoreMenu;
import com.anka.base.service.TreeBaseService;
/**
* @Description: (CoreMenuService)接口
* @author AnkaRebirth
* @date 2019-03-12 12:00
* @version 1.0.0
*/
public interface CoreMenuService extends TreeBaseService<CoreMenu> {
	/**
	 * 获取菜单树
	 * @param model
	 * @return
	 */
	public List<CoreMenu> getTreeList(CoreMenu model);
	/**
	 * 获取菜单列表
	 * @param model
	 * @return
	 */
	public List<CoreMenu> getList(CoreMenu model);
	/**
	 * 保存或更新
	 * @param model
	 * @return
	 */
	public Integer doSave(CoreMenu model);
	/**
	 * 获取当前登录用户的菜单列表
	 * @return
	 */
	public List<CoreMenu> getMenus(String type);
	
}
