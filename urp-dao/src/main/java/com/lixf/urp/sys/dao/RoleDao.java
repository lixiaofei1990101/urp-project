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

package com.lixf.urp.sys.dao;

import com.lixf.urp.common.dao.BaseDao;
import com.lixf.urp.common.model.Pagination;
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
public interface RoleDao extends BaseDao<Role, String>{
	/**
	 * @Title: queryRoleList 
	 * @Description:查询角色列表
	 * @param pagination
	 * @param map
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年9月3日
	 */
	public Pagination queryRoleList(Pagination pagination,Role role);
}
