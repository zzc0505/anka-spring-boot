package com.anka.apps.mapper;

import com.anka.base.mapper.CrudBaseMapper;
import com.anka.apps.model.CoreUser;

/**
 * @Description:用户表(CoreUserMapper)数据持久层接口
 * @author AnkaRebirth
 * @date 2019-01-28 17:01
 * @version 1.0.0
 */
public interface CoreUserMapper extends CrudBaseMapper<CoreUser>{
	
	/**
	 * 获取用户（包含用户由拥有的角色）
	 * @param model
	 * @return
	 */
	public CoreUser getCoreUser(CoreUser model);
}
