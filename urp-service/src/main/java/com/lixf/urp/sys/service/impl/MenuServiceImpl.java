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
 * 2016年7月20日    Li Xiao Fei         Create the class
*/

package com.lixf.urp.sys.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lixf.urp.common.model.TreeNode;
import com.lixf.urp.sys.dao.MenuDao;
import com.lixf.urp.sys.model.Menu;
import com.lixf.urp.sys.model.Role;
import com.lixf.urp.sys.service.MenuService;
import com.lixf.urp.unit.TreeBuilder;

/**
 * @FileName MenuServiceImpl.java
 * @Description: 
 *
 * @Date 2016年7月20日 
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
@Service("MenuService")
public class MenuServiceImpl implements MenuService{
	
	@Resource
	private MenuDao menuDao;

	public List<Menu> queryUserPermission(Map<String, Object> map) {
		return this.menuDao.queryUserPermission(map);
	}

	public List<Role> queryUserRole(Map<String, Object> map) {
		return this.menuDao.queryUserRole(map);
	}

	@Override
	public String queryUserMenu(Map<String, Object> map) {
		List<TreeNode> listMenu = this.menuDao.queryUserMenu(map);
		String json = "";
		for (TreeNode treeNode : listMenu) {
			if("".equals(treeNode.getParentId())){
				json = new TreeBuilder().getJson(listMenu, treeNode);
			}
		}
		return json;
	}

	@Override
	public JSONArray queryAllResource(Map<String, Object> map) {
		List<Menu> list = this.menuDao.queryAllResource(map);
		JSONArray rootArray = new JSONArray();
		for (Menu menu : list) {
			if("".equals(menu.getParentId())){
				JSONObject rootObj = new TreeBuilder().createBranch(list, menu);
				rootArray.add(rootObj);
			}
		}
		return rootArray;
	}
}
