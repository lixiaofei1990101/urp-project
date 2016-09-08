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
 * 2016年6月1日    Li Xiao Fei         Create the class
 */

package com.lixf.urp.unit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lixf.urp.common.model.TreeNode;
import com.lixf.urp.sys.model.Menu;
import com.lixf.urp.sys.model.Office;

/**
 * @FileName TreeBuilder.java
 * @Description:构建树形结构数据
 *
 * @Date 2016年6月1日
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
public class TreeBuilder {
	StringBuffer json = new StringBuffer();

	/**
	 * @Title: constructorJson 
	 * @Description:构建Json文件
	 * @param list
	 * @param treeNode 
	 * @author Li Xiao Fei
	 * @date 2016年6月2日
	 */
	@SuppressWarnings("rawtypes")
	public void constructorJson(List<TreeNode> list, TreeNode treeNode) {
		if (hasChild(list, treeNode)) {
			json.append("{\"id\":");
			json.append("\"" + treeNode.getId() + "\"");
			json.append(",\"text\":");
			json.append("\"" + treeNode.getText() + "\"");
			json.append(",\"parentId\":");
			json.append("\"" + treeNode.getParentId() + "\"");
			json.append(",\"state\":");
			if("0".equals(treeNode.getId())){
				json.append("\"open\"");
			}else{
				json.append("\"closed\"");
			}
			json.append(",\"iconCls\":");
			json.append("\"" + treeNode.getIconCls() + "\"");
			json.append(",\"url\":");
			json.append("\"" + treeNode.getUrl() + "\"");
			json.append(",\"children\":[");
			List<TreeNode> childList = getChildList(list, treeNode);
			Iterator iterator = childList.iterator();
			while (iterator.hasNext()) {
				TreeNode node = (TreeNode) iterator.next();
				constructorJson(list, node);
			}
			json.append("]},");
		} else {
			json.append("{\"id\":");
			json.append("\"" + treeNode.getId() + "\"");
			json.append(",\"text\":");
			json.append("\"" + treeNode.getText() + "\"");
			json.append(",\"parentId\":");
			json.append("\"" + treeNode.getParentId() + "\"");
			json.append(",\"state\":");
			json.append("\"open\"");
			json.append(",\"iconCls\":");
			json.append("\"" + treeNode.getIconCls() + "\"");
			json.append(",\"url\":");
			json.append("\"" + treeNode.getUrl() + "\"");
			json.append("},");
		}
	}
	/**
	 * @Title: getChildList 
	 * @Description:获得子节点列表信息
	 * @param list
	 * @param node
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年6月2日
	 */
	@SuppressWarnings("rawtypes")
	public List<TreeNode> getChildList(List<TreeNode> list, TreeNode node) { // 得到子节点列表
		List<TreeNode> li = new ArrayList<TreeNode>();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			TreeNode n = (TreeNode) it.next();
			if (node.getId().equals(n.getParentId())) {
				li.add(n);
			}
		}
		return li;
	}

	/**
	 * @Title: hasChild 
	 * @Description:判断是否有子节点
	 * @param list
	 * @param node
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年6月2日
	 */
	public boolean hasChild(List<TreeNode> list, TreeNode node) {
		return getChildList(list, node).size() > 0 ? true : false;
	}
	/**
	 * @Title: getJson 
	 * @Description:json字符串最后处理
	 * @param list
	 * @param node
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年6月2日
	 */
	public String getJson(List<TreeNode> list, TreeNode node) {
		json = new StringBuffer();
		constructorJson(list, node);
		String jsonDate = json.toString();
		return ("[" + jsonDate + "]").replaceAll(",]", "]");

	}
	/**
	 * @Title: createBranch 
	 * @Description:构建菜单数据表格数据
	 * @param list
	 * @param menu
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年9月3日
	 */
	public JSONObject createBranch(List<Menu> list,Menu menu){
		JSONObject currentObj = (JSONObject) JSON.toJSON(menu);
		JSONArray childArray = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			Menu menuObj = list.get(i);
			if(!"".equals(menuObj.getParentId())&&menuObj.getParentId().compareTo(menu.getId())==0){
				JSONObject childObj = createBranch(list, menuObj);
				childObj.put("_parentId", menuObj.getParentId());
				childArray.add(childObj);
			}
		}
		if(!childArray.isEmpty()){
			currentObj.put("children", childArray);
		}
		return currentObj;
	}
	/**
	 * @Title: createBranch 
	 * @Description:构建机构数据表格数据
	 * @param list
	 * @param office
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年9月3日
	 */
	public JSONObject createBranch(List<Office> list,Office office){
		JSONObject currentObj = (JSONObject) JSON.toJSON(office);
		JSONArray childArray = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			Office menuObj = list.get(i);
			if(!"".equals(menuObj.getParent_id())&&menuObj.getParent_id().compareTo(office.getId())==0){
				JSONObject childObj = createBranch(list, menuObj);
				childObj.put("_parentId", menuObj.getParent_id());
				childArray.add(childObj);
			}
		}
		if(!childArray.isEmpty()){
			currentObj.put("children", childArray);
		}
		return currentObj;
	}
}
