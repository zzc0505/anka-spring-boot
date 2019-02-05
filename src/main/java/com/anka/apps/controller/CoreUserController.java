package com.anka.apps.controller;

import com.anka.apps.model.CoreUser;
import com.anka.apps.service.CoreUserService;
import com.anka.base.controller.BaseController;
import com.anka.base.utils.PassSecurity;
import com.github.pagehelper.Page;

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
	public @ResponseBody Map<String, Object> locked(CoreUser model){
		Map<String, Object> map = new HashMap<String, Object>();
		Integer count = coreUserService.locked(model);
		if(count==1){
			map.put("success", true);
			map.put("msg", "锁定成功！");
		}else{
			map.put("success", false);
			map.put("msg", "锁定失败！");
		}
		map.put("data", "");
		return map;
	}
    
    @PostMapping("/unLocked")
	public @ResponseBody Map<String, Object> unLocked(CoreUser model){
		Map<String, Object> map = new HashMap<String, Object>();
		if(coreUserService.unLocked(model)){
			map.put("success", true);
			map.put("msg", "解锁成功！");
		}else{
			map.put("success", false);
			map.put("msg", "解锁失败，密码不正确！");
			
		}
		map.put("data", "");
		return map;
	}
    
    @PostMapping("/lockChecked")
	public @ResponseBody Map<String, Object> lockChecked(CoreUser model){
		Map<String, Object> map = new HashMap<String, Object>();
		if(coreUserService.lockChecked(model)){
			map.put("success", true);
			map.put("msg", "锁定状态！");
		}else{
			map.put("success", false);
			map.put("msg", "未锁状态！");
		}
		map.put("data", "");
		return map;
	}
    
    @RequestMapping("/userInfo")
    public ModelAndView userInfo(CoreUser model){
    	ModelAndView mv = new ModelAndView();
    	model = coreUserService.get(model.getCrurUuid());
    	model.setCrurPassword("");
    	mv.addObject("userInfo", model);
    	mv.setViewName("core/user/userinfo");
    	return mv;
    }
    
    @PostMapping("/userInfoChange")
	public @ResponseBody Map<String, Object> userInfoChange(CoreUser model){
		Map<String, Object> map = new HashMap<String, Object>();
		Integer count = coreUserService.update(model);
		if(count==1){
			map.put("success", true);
			map.put("msg", "操作成功！");
		}else{
			map.put("success", false);
			map.put("msg", "操作失败！");
		}
		map.put("data", "");
		return map;
	}
    
    @RequestMapping("/passWordChange")
    public ModelAndView passWordChange(CoreUser model){
    	ModelAndView mv = new ModelAndView();
    	model = coreUserService.get(model.getCrurUuid());
    	model.setCrurPassword(PassSecurity.getDecode(model.getCrurPassword(), "ANKA"));
    	mv.addObject("userInfo", model);
    	mv.setViewName("core/user/passwordchange");
    	return mv;
    }
    
    @PostMapping("/passChange")
	public @ResponseBody Map<String, Object> passChange(CoreUser model){
		Map<String, Object> map = new HashMap<String, Object>();
		model.setCrurPassword(PassSecurity.getEncode(model.getCrurPassword(), "ANKA"));
		Integer count = coreUserService.update(model);
		if(count==1){
			map.put("success", true);
			map.put("msg", "操作成功！");
		}else{
			map.put("success", false);
			map.put("msg", "操作失败！");
		}
		map.put("data", "");
		return map;
	}
    
    @PostMapping("/getList")
	public @ResponseBody Map<String, Object> getList(CoreUser model){
		Map<String, Object> map = new HashMap<String, Object>();
		List<CoreUser> list = coreUserService.getList(model);
		if(list.size()>0){
			map.put("code", 0);
			map.put("success", true);
			map.put("msg", "");
			map.put("data", list);
			map.put("count",((Page) list).getTotal());
		}else{
			map.put("code", 500);
			map.put("success", false);
			map.put("msg", "操作失败！");
			map.put("data", list);
			map.put("count",0);
		}
		return map;
	}
    
}