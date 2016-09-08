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
 * 2016年9月3日    Li Xiao Fei         Create the class
*/

package com.lixf.urp.sys.dao.impl;

import org.springframework.stereotype.Repository;

import com.lixf.urp.common.dao.MybatisBaseDao;
import com.lixf.urp.common.model.Pagination;
import com.lixf.urp.sys.dao.RoleDao;
import com.lixf.urp.sys.model.Role;

/**
 * @FileName RoleDao.java
 * @Description: 
 *
 * @Date 2016年9月3日 
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
@Repository
public class RoleDaoImpl extends MybatisBaseDao<Role, String> implements RoleDao {

	@Override
	public Pagination queryRoleList(Pagination pagination, Role role) {
		return this.queryByPaging(pagination, "queryRoleList", role);
	}

	@Override
	public String getClassPath() {
		return "com.lixf.urp.sys.dao.RoleDao.";
	}

}
