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
 * 2016年7月30日    Li Xiao Fei         Create the class
*/

package com.lixf.urp.action.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.context.annotation.Scope;

import com.alibaba.fastjson.JSONArray;
import com.lixf.urp.action.common.BaseAction;
import com.lixf.urp.common.Constants;
import com.lixf.urp.sys.model.Menu;
import com.lixf.urp.sys.model.User;
import com.lixf.urp.sys.service.MenuService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @FileName MenuAction.java
 * @Description: 
 *
 * @Date 2016年7月30日 
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
@Namespace("/menu")
@Scope("prototype")
@Action("menuAction")
public class MenuAction extends BaseAction implements ModelDriven<Menu>{
	
	private static final long serialVersionUID = 1L;
	private Menu menu;
	@Resource
	private MenuService menuService;
	
	public void queryUserMenu(){
		User user = (User) this.getRequest().getSession().getAttribute(Constants.USER_KEY);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", user.getId());
		String menuJson = this.menuService.queryUserMenu(map);
		@SuppressWarnings("rawtypes")
		List<Map> jsonArray = JSONArray.parseArray(menuJson, Map.class);
		outputJson(jsonArray);
	}
	
	public void queryAllResource(){
		User user = (User) this.getRequest().getSession().getAttribute(Constants.USER_KEY);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", user.getId());
		JSONArray jsonArray = this.menuService.queryAllResource(map);
		outputJson(jsonArray);
	}
	
	@Override
	public Menu getModel() {
		if(menu==null){
			menu = new Menu();
		}
		return menu;
	}

}
