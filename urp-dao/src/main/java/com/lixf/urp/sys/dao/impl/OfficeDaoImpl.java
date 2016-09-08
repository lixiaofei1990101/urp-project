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

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lixf.urp.common.dao.MybatisBaseDao;
import com.lixf.urp.common.model.TreeNode;
import com.lixf.urp.sys.dao.OfficeDao;
import com.lixf.urp.sys.model.Office;

/**
 * @FileName OfficeDaoImpl.java
 * @Description: 
 *
 * @Date 2016年9月3日 
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
@Repository
public class OfficeDaoImpl extends MybatisBaseDao<Office, String> implements OfficeDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Office> queryListOffice(Map<String, Object> map) {
		return this.queryList("queryListOffice", map);
	}

	@Override
	public String getClassPath() {
		return "com.lixf.urp.sys.dao.OfficeDao.";
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TreeNode> queryTreeOffice(Map<String, Object> map) {
		return this.queryList("queryTreeOffice", map);
	}

}
