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
 * 2016年7月19日    Li Xiao Fei         Create the class
*/

package com.lixf.urp.sys.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.lixf.urp.sys.model.Menu;
import com.lixf.urp.sys.model.Role;

/**
 * @FileName MenuService.java
 * @Description: 
 *
 * @Date 2016年7月19日 
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
public interface MenuService {
	/**
	 * @Title: queryUserMenu 
	 * @Description:查询用户的菜单
	 * @param map
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年7月19日
	 */
	public List<Menu> queryUserPermission(Map<String, Object> map);
	/**
	 * @Title: queryUserRole 
	 * @Description:查找用户的角色
	 * @param map
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年7月20日
	 */
	public List<Role> queryUserRole(Map<String, Object> map);
	/**
	 * @Title: queryUserMenu 
	 * @Description:查询用户菜单
	 * @param map
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年7月29日
	 */
	public String queryUserMenu(Map<String, Object> map);
	/**
	 * @Title: queryAllResource 
	 * @Description:查询当前用户的所有资源
	 * @param map
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年7月30日
	 */
	public JSONArray queryAllResource(Map<String, Object> map);
}
