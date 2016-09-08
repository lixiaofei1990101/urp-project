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

package com.lixf.urp.sys.dao;

import java.util.Map;

import com.lixf.urp.common.dao.BaseDao;
import com.lixf.urp.common.model.Pagination;
import com.lixf.urp.sys.model.User;

/**
 * @FileName UserDao.java
 * @Description: 
 *
 * @Date 2016年7月1日 
 * @author Li Xiao Fei
 * @version 1.0
 * 	
 */
public interface UserDao extends BaseDao<User, String>{
	/**
	 * @Title: loginQuery 
	 * @Description:登陆查询
	 * @param map
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年7月6日
	 */
	public User queryByName(Map<String, Object> map);
	/**
	 * @Title: queryUserList 
	 * @Description:查询用户列表
	 * @param pagination
	 * @param map
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年7月16日
	 */
	public Pagination queryUserList(Pagination pagination,Map<String, Object> map);
}
