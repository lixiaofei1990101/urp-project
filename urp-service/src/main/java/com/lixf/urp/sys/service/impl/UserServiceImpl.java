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

package com.lixf.urp.sys.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lixf.urp.common.model.Pagination;
import com.lixf.urp.sys.dao.UserDao;
import com.lixf.urp.sys.model.User;
import com.lixf.urp.sys.service.UserService;

/**
 * @FileName UserServiceImpl.java
 * @Description: 
 *
 * @Date 2016年7月1日 
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
@Service("UserService")
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDao userDao;

	public User queryByName(Map<String, Object> map) {
		return this.userDao.queryByName(map);
	}

	public Pagination queryUserList(Pagination pagination, User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", user.getUserName());
		map.put("phone", user.getPhone());
		map.put("officeId", user.getOfficeId());
		return this.userDao.queryUserList(pagination, map);
	}

}
