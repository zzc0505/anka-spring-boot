package com.anka.apps.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.anka.apps.model.CoreMenu;
import com.anka.apps.model.CoreUser;
import com.anka.apps.service.CoreMenuService;
import com.anka.apps.service.CoreUserService;
import com.anka.base.controller.BaseController;
import com.anka.base.model.BaseResult;
import com.anka.base.utils.Constant;

@Controller
public class CoreLoginController extends BaseController<CoreUser>{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CoreUserService coreUserService;
	@Autowired
	private CoreMenuService coreMenuService;

	@RequestMapping("/index")
	public ModelAndView index(){
		List<CoreMenu> top = coreMenuService.getMenus("0");//获取顶部菜单
		List<CoreMenu> left = coreMenuService.getMenus("1");//获取左侧菜单
		List<CoreMenu> leftChild = coreMenuService.getMenus("2");//获取左侧子级菜单
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("top", top);
		map.put("left", left);
		map.put("leftChild", leftChild);
		return super.success(map, "core/index/index");
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
	@ResponseBody
	public BaseResult<CoreUser> postRegister(CoreUser model){
		if(!coreUserService.checkUser(model)){
			coreUserService.userRegister(model);
			return super.success("注册成功！");
		}else{
			return super.fail("注册失败，用户已存在！");
		}
	}
	
	@PostMapping("/postLogin")
	@ResponseBody
	public BaseResult<CoreUser> postLogin(CoreUser model, HttpSession session){
		//获取用户认证信息
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(model.getCrurName(), model.getCrurPassword());
		try {
			subject.login(token);
			CoreUser user = (CoreUser) subject.getPrincipal();
			user.setCrurPassword(null);
			session.setAttribute(Constant.SESSION_KEY_USER, user);
			return success();
		}catch(UnknownAccountException uae){  
            logger.info("对用户[" + model.getCrurName() + "]进行登录验证..验证未通过,未知账户");  
            return fail("未知账户");
        }catch(IncorrectCredentialsException ice){  
            logger.info("对用户[" + model.getCrurName() + "]进行登录验证..验证未通过,错误的凭证");  
            return fail("密码不正确");
        }catch(LockedAccountException lae){  
            logger.info("对用户[" + model.getCrurName() + "]进行登录验证..验证未通过,账户已锁定");  
            return fail("账户已锁定");
        }catch(ExcessiveAttemptsException eae){  
            logger.info("对用户[" + model.getCrurName() + "]进行登录验证..验证未通过,错误次数过多");  
            return fail("用户名或密码错误次数过多");
        }catch(AuthenticationException ae){  
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景  
            logger.info("对用户[" + model.getCrurName() + "]进行登录验证..验证未通过,堆栈轨迹如下");
            ae.printStackTrace();  
            return fail("用户名或密码不正确");
        }
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session){
		Subject subject = SecurityUtils.getSubject();
        subject.logout();
        session.removeAttribute(Constant.SESSION_KEY_USER);
		return "core/login/login";
	}
}
