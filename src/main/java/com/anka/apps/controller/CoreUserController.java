package com.anka.apps.controller;

import com.anka.apps.model.CoreUser;
import com.anka.apps.service.CoreUserService;
import com.anka.base.controller.BaseController;
import com.anka.base.model.BaseResult;
import com.anka.base.model.BaseTree;
import com.anka.base.utils.BaseCode;
import com.anka.base.utils.PassSecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

/**
* @Description: 用户表(CoreUserController)控制层
* @author AnkaRebirth
* @date 2019-01-28 17:01
* @version 1.0.0
*/
@Controller
@RequestMapping("/core/user")
public class CoreUserController extends BaseController<CoreUser>{

    @Resource
    private CoreUserService coreUserService;
    
    @PostMapping("/locked")
    @ResponseBody
	public BaseResult<CoreUser> locked(CoreUser model){
		coreUserService.locked(model);
		return super.success();
	}
    
    @PostMapping("/unLocked")
    @ResponseBody
	public BaseResult<CoreUser> unLocked(CoreUser model){
		if(coreUserService.unLocked(model)){
			return super.success();
		}else{
			return super.fail("解锁失败，密码不正确！");
		}
	}
    
    @PostMapping("/lockChecked")
    @ResponseBody
	public BaseResult<CoreUser> lockChecked(CoreUser model){
		if(coreUserService.lockChecked(model)){
			return super.success();
		}else{
			return super.fail();
		}
	}
    
    @RequestMapping("/userInfo")
    public ModelAndView userInfo(CoreUser model){
    	model = coreUserService.getCoreUser(model);
    	model.setCrurPassword("");
    	return super.success(model,"core/user/userinfo");
    }
    
    @PostMapping("/userInfoChange")
    @ResponseBody
	public BaseResult<CoreUser> userInfoChange(CoreUser model){
		coreUserService.update(model);
		return super.success();
	}
    
    @RequestMapping("/passWordChange")
    public ModelAndView passWordChange(CoreUser model){
    	model = coreUserService.get(model.getCrurUuid());
    	model.setCrurPassword(PassSecurity.getDecode(model.getCrurPassword(), "ANKA"));
    	return super.success(model,"core/user/passwordchange");
    }
    
    @PostMapping("/passChange")
    @ResponseBody
	public BaseResult<CoreUser> passChange(CoreUser model){
    	model.setCrurPassword(PassSecurity.getEncode(model.getCrurPassword(), "ANKA"));
		coreUserService.update(model);
		return super.success();
	}
    
    @PostMapping("/getList")
    @ResponseBody
	public BaseResult<CoreUser> getList(CoreUser model){
		List<CoreUser> list = coreUserService.getList(model);
		return super.success(list);
	}
    
    @RequestMapping("/treeList")
    @ResponseBody
	public BaseResult<BaseTree<?>> treeList(CoreUser model){
    	return super.successTree(coreUserService.treeList(model));
	}
}