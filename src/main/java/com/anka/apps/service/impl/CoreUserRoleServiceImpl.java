package com.anka.apps.service.impl;

import com.anka.apps.mapper.CoreUserRoleMapper;
import com.anka.apps.model.CoreUserRole;
import com.anka.apps.service.CoreUserRoleService;
import com.anka.base.service.CrudBaseServiceSupport;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Description: 用户角色关联表(CoreUserRoleService)接口实现类
* @author AnkaRebirth
* @date 2019-03-06 14:12
* @version 1.0.0
*/
@Service
public class CoreUserRoleServiceImpl extends CrudBaseServiceSupport<CoreUserRole> implements CoreUserRoleService {

    @Resource
    private CoreUserRoleMapper coreUserRoleMapper;
    

}