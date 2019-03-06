package com.anka.apps.controller;

import com.anka.apps.model.CoreRole;
import com.anka.apps.service.CoreRoleService;
import com.anka.base.controller.BaseController;
import com.anka.base.model.BaseResult;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import javax.annotation.Resource;

/**
* @Description: 角色表(CoreRoleController)控制层
* @author AnkaRebirth
* @date 2019-03-06 14:11
* @version 1.0.0
*/
@Controller
@RequestMapping("/core/role")
public class CoreRoleController extends BaseController<CoreRole>{

    @Resource
    private CoreRoleService coreRoleService;

    @RequestMapping("/doSave")
    @ResponseBody
    public BaseResult<CoreRole> doSave(CoreRole model){
    	coreRoleService.doSave(model);
    	return super.success();
    }
    
    @RequestMapping("/batchDelete")
    @ResponseBody
    public BaseResult<CoreRole> batchDelete(CoreRole model){
    	coreRoleService.batchDelete(model);
    	return super.success();
    }
    
    @RequestMapping("/getList")
    @ResponseBody
    public BaseResult<CoreRole> getList(CoreRole model){
    	List<CoreRole> list = coreRoleService.getList(model);
    	return super.success(list);
    }
}