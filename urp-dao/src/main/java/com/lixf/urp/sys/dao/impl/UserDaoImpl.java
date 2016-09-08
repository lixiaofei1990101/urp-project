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

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lixf.urp.common.dao.MybatisBaseDao;
import com.lixf.urp.common.model.Pagination;
import com.lixf.urp.sys.dao.UserDao;
import com.lixf.urp.sys.model.User;

/**
 * @FileName UserDaoImpl.java
 * @Description: 
 *
 * @Date 2016年7月1日 
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
@Repository("UserDao")
public class UserDaoImpl extends MybatisBaseDao<User, String> implements UserDao{

	public User queryByName(Map<String, Object> map) {
		return (User)this.queryUniqueResult("querySysUserByName", map);
	}

	@Override
	public String getClassPath() {
		return "com.lixf.urp.sys.dao.UserDao.";
	}

	public Pagination queryUserList(Pagination pagination, Map<String, Object> map) {
		return this.queryByPaging(pagination, "queryUserList", map);
	}

}
