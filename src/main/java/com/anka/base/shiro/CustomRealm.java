package com.anka.base.shiro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.security.auth.login.AccountException;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import com.anka.apps.model.CoreUser;
import com.anka.apps.service.CoreRoleGrantService;
import com.anka.apps.service.CoreRoleUserService;
import com.anka.apps.service.CoreUserService;

public class CustomRealm extends AuthorizingRealm{
	/**
	 * 设置密码加密方式
	 */
	{
		//设置用于匹配密码的CredentialsMatcher
        HashedCredentialsMatcher hashMatcher = new HashedCredentialsMatcher();
        hashMatcher.setHashAlgorithmName("md5");
        hashMatcher.setStoredCredentialsHexEncoded(true);
        //加密的次数
        hashMatcher.setHashIterations(1024);
        this.setCredentialsMatcher(hashMatcher);
	}
	
	/**
	 * 使用@Lazy是延迟Realm实现中Service对象的初始化时间，
	 * 这样就可以保证Service实际初始化的时候会被BeanPostProcessor拦截，
	 * 从而创建具有事务功能的代理对象
	 */
	@Autowired
	@Lazy
	private CoreUserService coreUserService;
	@Autowired
	@Lazy
	private CoreRoleGrantService coreRoleGrantService;
	@Autowired
	@Lazy
	private CoreRoleUserService coreRoleUserService;
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String userName = upToken.getUsername();
		if(userName == null){
			try {
				throw new AccountException("用户名不能为空！");
			} catch (AccountException e) {
				e.printStackTrace();
			}
		}
		CoreUser user = new CoreUser();
		user.setCrurName(userName);
		user = coreUserService.selectUserByname(user).size()>0?coreUserService.selectUserByname(user).get(0):null;
		if(user==null){
			throw new UnknownAccountException("用户不存在！");
		}
		List<String> roleList = coreRoleUserService.getRolesByUserId(user.getCrurUuid());
		List<String> permList = coreRoleGrantService.getGrantsByUserId(user.getCrurUuid());
		Set<String> roles = new HashSet(roleList);
        Set<String> perms = new HashSet(permList);
        user.setCoreRole(roles);
        user.setCoreGrant(perms);
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getCrurPassword(), getName());
		info.setCredentialsSalt(ByteSource.Util.bytes("ANKA"));
		return info;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		if(principals == null){
			throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
		}
		CoreUser user = (CoreUser) super.getAvailablePrincipal(principals);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setRoles(user.getCoreRole());
		info.setStringPermissions(user.getCoreGrant());
		return info;
	}

}
