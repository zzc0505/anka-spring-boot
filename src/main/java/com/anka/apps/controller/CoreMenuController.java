package com.anka.apps.controller;

import com.anka.apps.model.CoreMenu;
import com.anka.apps.service.CoreMenuService;
import com.anka.base.controller.BaseController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}