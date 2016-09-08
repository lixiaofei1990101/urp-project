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

package com.lixf.urp.action.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.context.annotation.Scope;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lixf.urp.action.common.BaseAction;
import com.lixf.urp.common.Constants;
import com.lixf.urp.sys.model.Office;
import com.lixf.urp.sys.model.User;
import com.lixf.urp.sys.service.OfficeService;
import com.lixf.urp.unit.TreeBuilder;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @FileName OfficeAction.java
 * @Description:
 *
 * @Date 2016年9月3日
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
@Namespace("/office")
@Scope("prototype")
@Action("officeAction")
public class OfficeAction extends BaseAction implements ModelDriven<Office> {

	private static final long serialVersionUID = 1L;
	private Office office;
	@Resource
	private OfficeService officeService;

	/**
	 * @Title: queryListOffice
	 * @Description: 查询结构列表
	 * @author Li Xiao Fei
	 * @date 2016年9月3日
	 */
	public void queryListOffice() {
		User user = (User) this.getRequest().getSession().getAttribute(Constants.USER_KEY);
		String officeId = user.getOfficeId();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", officeId);
		List<Office> list = this.officeService.queryListOffice(map);
		JSONArray jsonArray = new JSONArray();
		for (Office office : list) {
			if ("".equals(office.getParent_id())) {
				JSONObject rootObj = new TreeBuilder().createBranch(list, office);
				jsonArray.add(rootObj);
			}
		}
		outputJson(jsonArray);
	}
	/**
	 * @Title: queryTreeOffice 
	 * @Description: 查询结构的树形结构数据
	 * @author Li Xiao Fei
	 * @date 2016年9月3日
	 */
	public void queryTreeOffice(){
		User user = (User) this.getRequest().getSession().getAttribute(Constants.USER_KEY);
		String officeId = user.getOfficeId();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", officeId);
		String jsonOffice = this.officeService.queryTreeOffice(map);
		outputJson(JSONArray.parseArray(jsonOffice));
	}

	@Override
	public Office getModel() {
		if (office == null) {
			office = new Office();
		}
		return office;
	}

}
