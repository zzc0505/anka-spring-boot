package com.anka.apps.controller;

import com.anka.apps.model.CoreMenu;
import com.anka.apps.service.CoreMenuService;
import com.anka.base.controller.BaseController;
import com.anka.base.model.BaseResult;
import com.anka.base.model.BaseTree;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
* @Description: (CoreMenuController)控制层
* @author AnkaRebirth
* @date 2019-03-12 12:00
* @version 1.0.0
*/
@Controller
@RequestMapping("/core/menu")
public class CoreMenuController extends BaseController<CoreMenu>{

    @Resource
    private CoreMenuService coreMenuService;
    
    @RequestMapping("/menuedit")
    public ModelAndView menuEdit(CoreMenu model){
    	return super.success(coreMenuService.menuEdit(model), "/core/menu/menuedit");
    }
    
    @RequestMapping("/getTreeList")
    @ResponseBody
    public BaseResult<BaseTree<?>> getTreeList(CoreMenu model){
    	return super.successTree(coreMenuService.getTreeList(model));
    }
    
    @PostMapping("/getList")
    @ResponseBody
    public BaseResult<CoreMenu> getList(CoreMenu model){
    	return super.success(coreMenuService.getList(model));
    }
    
    @PostMapping("/doSave")
    @ResponseBody
    public BaseResult<CoreMenu> doSave(CoreMenu model){
    	return super.success(coreMenuService.doSave(model));
    }
    
    @PostMapping("/batchDelete")
    @ResponseBody
    public BaseResult<CoreMenu> batchDelete(CoreMenu model){
    	return super.success(coreMenuService.batchDelete(model));
    }

}