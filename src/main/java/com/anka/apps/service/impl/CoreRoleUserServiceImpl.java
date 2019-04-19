package com.anka.apps.service.impl;

import com.anka.apps.mapper.CoreRoleUserMapper;
import com.anka.apps.model.CoreRoleUser;
import com.anka.apps.service.CoreRoleUserService;
import com.anka.base.service.CrudBaseServiceSupport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Description: 用户角色关联表(CoreRoleUserService)接口实现类
* @author AnkaRebirth
* @date 2019-04-19 10:40
* @version 1.0.0
*/
@Service
public class CoreRoleUserServiceImpl extends CrudBaseServiceSupport<CoreRoleUser> implements CoreRoleUserService {

    @Resource
    private CoreRoleUserMapper coreRoleUserMapper;
    

}