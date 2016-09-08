/*
 * COPYRIGHT. ShenZhen MinSiDa Technology Co., Ltd. 2016.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording, 
 * or otherwise, without the prior written permission of ShenZhen MinSiDa Technology Co., Ltd.
 *
 * Amendment History:
 * 
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2016年7月5日    Li Xiao Fei         Create the class
 */

package com.lixf.urp.sys.shiro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lixf.urp.common.Constants;
import com.lixf.urp.sys.model.Menu;
import com.lixf.urp.sys.model.Role;
import com.lixf.urp.sys.model.User;
import com.lixf.urp.sys.service.MenuService;
import com.lixf.urp.sys.service.UserService;
import com.lixf.urp.sys.unit.StringUnits;

/**
 * @FileName SysRealm.java
 * @Description: 用户的认证和授权
 *
 * @Date 2016年7月5日
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
@Service("SysRealm")
public class SysRealm extends AuthorizingRealm {
	@Autowired
	private UserService userService;
	@Autowired
	private MenuService menuService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		String username = (String)principals.getPrimaryPrincipal(); 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", username);
		//获取当前登录的用户
		User user = this.userService.queryByName(map);
		if(user!=null){
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", user.getId());
			//查询用户的资源信息
			List<Menu> listMenu = this.menuService.queryUserPermission(params);
			Session session = UserUnit.getSession();
			session.setAttribute(Constants.MENU_KEY, listMenu);
			//添加用户资源
			for (Menu menu : listMenu) {
				if (menu.getPermission()!=null) {
					for (String permission : StringUnits.split(menu.getPermission(), ",")) {
						simpleAuthorizationInfo.addStringPermission(permission);
					}
				}
			}
			simpleAuthorizationInfo.addStringPermission("user");
			List<Role> listRole = this.menuService.queryUserRole(params);
			//添加用户角色
			for (Role role : listRole) {
				simpleAuthorizationInfo.addRole(role.getRoleName());
			}
		}
		return simpleAuthorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		CaptchaUsernamePasswordToken token = (CaptchaUsernamePasswordToken) authcToken;
		String username = (String) authcToken.getPrincipal();
		String password = new String((char[]) authcToken.getCredentials());
		String validateCode = token.getCaptcha();
		String captcha = (String) UserUnit.getSession().getAttribute(Constants.VALIDATE_CODE_KEY);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", username);
		User user = this.userService.queryByName(map);
		if (user == null) {
			// 账号不存在
			throw new UnknownAccountException();
		}
		if (Constants.IS_LOCKED.equals(user.getLocked())) {
			// 账号被锁
			throw new LockedAccountException();
		}
		if (!validateCode.toLowerCase().equals(captcha)) {
			// 验证码错误
			throw new VlidateCodeAccountException();
		}
		Session session = UserUnit.getSession();
		session.setAttribute(Constants.USER_KEY, user);
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(), // 用户名
				password, // 密码
				ByteSource.Util.bytes(user.getCredentialsSalt()),// salt=username+salt 用户的私盐=用户名+创建用户时的公盐
				getName() // realm name
		);
		return authenticationInfo;
	}
	
	

}
