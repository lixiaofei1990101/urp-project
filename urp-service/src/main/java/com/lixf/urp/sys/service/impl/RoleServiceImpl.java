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

package com.lixf.urp.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lixf.urp.common.model.Pagination;
import com.lixf.urp.sys.dao.RoleDao;
import com.lixf.urp.sys.model.Role;
import com.lixf.urp.sys.service.RoleService;

/**
 * @FileName RoleServiceImpl.java
 * @Description: 
 *
 * @Date 2016年9月3日 
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
@Service
public class RoleServiceImpl implements RoleService {
	
	@Resource
	private RoleDao roleDao;

	@Override
	public Pagination queryRoleList(Pagination pagination, Role role) {
		return this.roleDao.queryRoleList(pagination, role);
	}

}
