package com.anka.apps.mapper;

import com.anka.base.mapper.CrudBaseMapper;

import java.util.List;

import com.anka.apps.model.CoreRoleUser;

/**
 * @Description:用户角色关联表(CoreRoleUserMapper)数据持久层接口
 * @author AnkaRebirth
 * @date 2019-04-19 10:40
 * @version 1.0.0
 */
public interface CoreRoleUserMapper extends CrudBaseMapper<CoreRoleUser>{
	/**
	 * 获取用户所有角色
	 * @param crueCrurUuid
	 * @return
	 */
	public List<String> getRolesByUserId(String crueCrurUuid);
}
