package com.anka.apps.controller;

import com.anka.apps.model.CoreGrant;
import com.anka.apps.service.CoreGrantService;
import com.anka.base.controller.BaseController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
* @Description: (CoreGrantController)控制层
* @author AnkaRebirth
* @date 2019-11-11 16:05
* @version 1.0.0
*/
@Controller
@RequestMapping("/core/grant")
public class CoreGrantController extends BaseController<CoreGrant>{

    @Resource
    private CoreGrantService coreGrantService;

}