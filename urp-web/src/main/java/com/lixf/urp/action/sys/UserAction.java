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
 * 2016年7月16日    Li Xiao Fei         Create the class
*/

package com.lixf.urp.action.sys;


import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.context.annotation.Scope;

import com.lixf.urp.action.common.BaseAction;
import com.lixf.urp.common.model.GridModel;
import com.lixf.urp.sys.model.User;
import com.lixf.urp.sys.service.UserService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @FileName UserAction.java
 * @Description: 
 *
 * @Date 2016年7月16日 
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
@Namespace("/user")
@Scope("prototype")
@Action("userAction")
public class UserAction extends BaseAction implements ModelDriven<User>{
	
	private static final long serialVersionUID = 1L;
	private User user;
	@Resource
	private UserService userService;
	
	/**
	 * @Title: queryUserList 
	 * @Description: 查询用户列表
	 * @author Li Xiao Fei
	 * @date 2016年7月18日
	 */
	public void queryUserList(){
		pagination = this.userService.queryUserList(pagination, user);
		GridModel gridModel = new GridModel();
		gridModel.setRows(pagination.getItemList());
		gridModel.setTotal(pagination.getTotalCount());
		outputJson(gridModel);
	}

	public User getModel() {
		if(user==null){
			user = new User();
		}
		return user;
	}

}
