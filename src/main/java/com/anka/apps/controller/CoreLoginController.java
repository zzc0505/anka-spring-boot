package com.anka.apps.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anka.apps.model.CoreUser;
import com.anka.apps.service.CoreUserService;
import com.anka.base.utils.Constant;
import com.anka.base.utils.PassSecurity;

@Controller
public class CoreLoginController {
	
	@Autowired
	private CoreUserService coreUserService;

	@RequestMapping("/index")
	public String index(){
		return "core/index/index";
	}
	
	@RequestMapping("/home")
	public String home(){
		return "core/home/home";
	}
	
	@GetMapping("/login")
	public String login(){
		return "core/login/login";
	}
	
	@GetMapping("/register")
	public String register(){
		return "core/login/register";
	}
	
	@PostMapping("/postRegister")
	public @ResponseBody Map<String, Object> postRegister(CoreUser model){
		Map<String, Object> map = new HashMap<String, Object>();
		if(!coreUserService.checkUser(model)){
			coreUserService.userRegister(model);
			map.put("success", true);
			map.put("msg", "注册成功！");
			map.put("data", "");
		}else{
			map.put("success", false);
			map.put("msg", "注册失败，用户已存在！");
			map.put("data", "");
		}
		return map;
	}
	
	@GetMapping("/loginOut")
	public String loginOut(HttpSession session){
		session.removeAttribute(Constant.SESSION_KEY_USER);
		return "redirect:login";
	}
	
	@PostMapping("/postLogin")
	public @ResponseBody Map<String, Object> postLogin(CoreUser model, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		model.setCrurPassword(PassSecurity.getEncode(model.getCrurPassword(), "ANKA"));
		CoreUser user = coreUserService.checkLogin(model);
		if(user!=null){
			session.setAttribute(Constant.SESSION_KEY_USER, user);
			map.put("success", true);
			map.put("msg", "登陆成功！");
			map.put("data", user);
		}else{
			map.put("success", false);
			map.put("msg", "账号密码不正确！");
			map.put("data", "");
		}
		return map;
	}
}
