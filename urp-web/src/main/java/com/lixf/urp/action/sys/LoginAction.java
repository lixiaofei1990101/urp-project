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
 * 2016年7月1日    Li Xiao Fei         Create the class
*/

package com.lixf.urp.action.sys;

import javax.annotation.Resource;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.lixf.urp.action.common.BaseAction;
import com.lixf.urp.sys.model.User;
import com.lixf.urp.sys.service.UserService;
import com.lixf.urp.sys.shiro.VlidateCodeAccountException;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @FileName LoginAction.java
 * @Description: 
 *
 * @Date 2016年7月1日 
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
@Namespace("/")
@Scope("prototype")
public class LoginAction extends BaseAction implements ModelDriven<User>{
	
	private static final long serialVersionUID = 1L;
	private User user;
	
	@Resource
	private UserService userService;
	
	@Action(value="/login",results={@Result(name = "login", location = "/login.jsp")})
	public String execute(){
		String exceptionClassName = (String)this.getRequest().getAttribute("shiroLoginFailure");
        String error = "";
        if(UnknownAccountException.class.getName().equals(exceptionClassName)||
        		IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名或密码错误";
        } else if(VlidateCodeAccountException.class.getName().equals(exceptionClassName)){
        	error = "验证码错误";
        } else if(LockedAccountException.class.getName().equals(exceptionClassName)){
        	error = "账号被锁定";
        }else if(exceptionClassName != null) {
            error = "系统异常";
        }
        this.getRequest().setAttribute("error", error);
        return "login";
	}
	@Action(value="/index",results={@Result(name = "index",type = "redirect", location = "/index.jsp")})
	public String queryUserMenu(){
		return "index";
	}
	
	public User getModel() {
		if(user==null){
			user = new User();
		}
		return user;
	}
}
