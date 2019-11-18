package com.anka.apps.mapper;

import com.anka.base.mapper.CrudBaseMapper;

import java.util.List;

import com.anka.apps.model.CoreRoleGrant;

/**
 * @Description:(CoreRoleGrantMapper)数据持久层接口
 * @author AnkaRebirth
 * @date 2019-11-11 16:27
 * @version 1.0.0
 */
public interface CoreRoleGrantMapper extends CrudBaseMapper<CoreRoleGrant>{
	/**
	 * 根据用户获取所有权限
	 * @param crueCrurUuid
	 * @return
	 */
	public List<String> getGrantsByUserId(String crueCrurUuid);
}
