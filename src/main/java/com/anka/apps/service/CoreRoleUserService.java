package com.anka.apps.service;

import java.util.List;

import com.anka.apps.model.CoreRoleUser;
import com.anka.base.service.CrudBaseService;
/**
* @Description: 用户角色关联表(CoreRoleUserService)接口
* @author AnkaRebirth
* @date 2019-04-19 10:40
* @version 1.0.0
*/
public interface CoreRoleUserService extends CrudBaseService<CoreRoleUser> {
	
	/**
	 * 获取用户所有角色
	 * @param crueCrurUuid
	 * @return
	 */
	public List<String> getRolesByUserId(String crueCrurUuid);
}
