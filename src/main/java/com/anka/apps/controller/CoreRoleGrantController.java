package com.anka.apps.controller;

import com.anka.apps.model.CoreRoleGrant;
import com.anka.apps.service.CoreRoleGrantService;
import com.anka.base.controller.BaseController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
* @Description: (CoreRoleGrantController)控制层
* @author AnkaRebirth
* @date 2019-11-11 16:27
* @version 1.0.0
*/
@Controller
@RequestMapping("/core/role/grant")
public class CoreRoleGrantController extends BaseController<CoreRoleGrant>{

    @Resource
    private CoreRoleGrantService coreRoleGrantService;

}