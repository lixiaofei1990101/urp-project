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

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lixf.urp.common.model.TreeNode;
import com.lixf.urp.sys.dao.OfficeDao;
import com.lixf.urp.sys.model.Office;
import com.lixf.urp.sys.service.OfficeService;
import com.lixf.urp.unit.TreeBuilder;

/**
 * @FileName OfficeServiceImpl.java
 * @Description: 
 *
 * @Date 2016年9月3日 
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
@Service
public class OfficeServiceImpl implements OfficeService{
	
	@Resource
	private OfficeDao officeDao;

	@Override
	public List<Office> queryListOffice(Map<String, Object> map) {
		return this.officeDao.queryListOffice(map);
	}

	@Override
	public String queryTreeOffice(Map<String, Object> map) {
		List<TreeNode> listOffice = this.officeDao.queryTreeOffice(map);
		String json = "";
		for (TreeNode treeNode : listOffice) {
			if ("".equals(treeNode.getParentId())) {
				json = new TreeBuilder().getJson(listOffice, treeNode);
			}
		}
		return json;
	}

}
