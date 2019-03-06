package com.anka.apps.controller;

import com.anka.apps.model.CoreUserRole;
import com.anka.apps.service.CoreUserRoleService;
import com.anka.base.controller.BaseController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
* @Description: 用户角色关联表(CoreUserRoleController)控制层
* @author AnkaRebirth
* @date 2019-03-06 14:12
* @version 1.0.0
*/
@Controller
@RequestMapping("/core/user/role")
public class CoreUserRoleController extends BaseController<CoreUserRole>{

    @Resource
    private CoreUserRoleService coreUserRoleService;

}