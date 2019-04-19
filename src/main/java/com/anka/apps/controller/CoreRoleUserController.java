package com.anka.apps.controller;

import com.anka.apps.model.CoreRoleUser;
import com.anka.apps.service.CoreRoleUserService;
import com.anka.base.controller.BaseController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
* @Description: 用户角色关联表(CoreRoleUserController)控制层
* @author AnkaRebirth
* @date 2019-04-19 10:40
* @version 1.0.0
*/
@Controller
@RequestMapping("/core/role/user")
public class CoreRoleUserController extends BaseController<CoreRoleUser>{

    @Resource
    private CoreRoleUserService coreRoleUserService;

}