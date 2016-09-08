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
 * 2016年7月7日    Li Xiao Fei         Create the class
*/

package com.lixf.urp.action.sys;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.lixf.urp.action.common.BaseAction;

/**
 * @FileName LogoutAction.java
 * @Description: 
 *
 * @Date 2016年7月7日 
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
@Namespace("/")
@Scope("prototype")
public class LogoutAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;
	
	@Action(value="/logout",results={@Result(name = "login", type = "redirect", location = "/login.jsp")})
	public String execute(){
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			subject.logout();
		}
		return "login";
	}
}
