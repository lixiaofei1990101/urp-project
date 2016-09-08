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

package com.lixf.urp.sys.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lixf.urp.common.dao.MybatisBaseDao;
import com.lixf.urp.common.model.TreeNode;
import com.lixf.urp.sys.dao.MenuDao;
import com.lixf.urp.sys.model.Menu;
import com.lixf.urp.sys.model.Role;

/**
 * @FileName UserDaoImpl.java
 * @Description: 
 *
 * @Date 2016年7月1日 
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
@Repository("MenuDao")
public class MenuDaoImpl extends MybatisBaseDao<Menu, String> implements MenuDao{

	@Override
	public String getClassPath() {
		return "com.lixf.urp.sys.dao.MenuDao.";
	}

	@SuppressWarnings("unchecked")
	public List<Menu> queryUserPermission(Map<String, Object> map) {
		return this.queryList("queryUserPermission", map);
	}

	@SuppressWarnings("unchecked")
	public List<Role> queryUserRole(Map<String, Object> map) {
		return this.queryList("queryUserRole", map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TreeNode> queryUserMenu(Map<String, Object> map) {
		return this.queryList("queryUserMenu", map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> queryAllResource(Map<String, Object> map) {
		return this.queryList("queryAllResource", map);
	}

}
