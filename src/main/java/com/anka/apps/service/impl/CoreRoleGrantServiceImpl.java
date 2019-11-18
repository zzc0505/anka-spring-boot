package com.anka.apps.service.impl;

import com.anka.apps.mapper.CoreRoleGrantMapper;
import com.anka.apps.model.CoreRoleGrant;
import com.anka.apps.service.CoreRoleGrantService;
import com.anka.base.service.CrudBaseServiceSupport;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

/**
* @Description: (CoreRoleGrantService)接口实现类
* @author AnkaRebirth
* @date 2019-11-11 16:27
* @version 1.0.0
*/
@Service
public class CoreRoleGrantServiceImpl extends CrudBaseServiceSupport<CoreRoleGrant> implements CoreRoleGrantService {

    @Resource
    private CoreRoleGrantMapper coreRoleGrantMapper;

	@Override
	public List<String> getGrantsByUserId(String crueCrurUuid) {
		return coreRoleGrantMapper.getGrantsByUserId(crueCrurUuid);
	}

}