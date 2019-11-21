package com.anka.apps.service;

import java.util.List;

import com.anka.apps.model.CoreUser;
import com.anka.base.model.BaseTree;
import com.anka.base.service.CrudBaseService;

/**
* @Description: 用户表(CoreUserService)接口
* @author AnkaRebirth
* @date 2019-01-28 17:01
* @version 1.0.0
*/
public interface CoreUserService extends CrudBaseService<CoreUser> {
	
	/**
	 * 登陆验证，根据用户名密码验证
	 * @param model
	 * @return
	 */
	public CoreUser checkLogin(CoreUser model);
	/**
	 * 根据用户名和手机号检测用户是否存在
	 * @param model
	 * @return
	 */
	public Boolean checkUser(CoreUser model);
	/**
	 * 用户注册
	 * @param model
	 */
	public void userRegister(CoreUser model);
	/**
	 * 锁屏
	 * @param model
	 */
	public Integer locked(CoreUser model);
	/**
	 * 解锁
	 * @param model
	 */
	public Boolean unLocked(CoreUser model);
	/**
	 * 锁屏状态检测
	 * @param model
	 * @return
	 */
	public Boolean lockChecked(CoreUser model);
	/**
	 * 获取数据库用户列表
	 * @param model
	 * @return
	 */
	public List<CoreUser> getList(CoreUser model);
	/**
	 * 根据用户名查询用户
	 * @param model
	 * @return
	 */
	public List<CoreUser> selectUserByname(CoreUser model);
}
