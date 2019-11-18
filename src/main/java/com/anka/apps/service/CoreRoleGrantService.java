package com.anka.apps.service;

import java.util.List;

import com.anka.apps.model.CoreRoleGrant;
import com.anka.base.service.CrudBaseService;
/**
* @Description: (CoreRoleGrantService)接口
* @author AnkaRebirth
* @date 2019-11-11 16:27
* @version 1.0.0
*/
public interface CoreRoleGrantService extends CrudBaseService<CoreRoleGrant> {
	
	/**
	 * 根据用户获取所有权限
	 * @param crueCrurUuid
	 * @return
	 */
	public List<String> getGrantsByUserId(String crueCrurUuid);
}
