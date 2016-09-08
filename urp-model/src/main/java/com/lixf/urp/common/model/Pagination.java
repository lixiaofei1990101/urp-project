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

package com.lixf.urp.common.model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * @FileName Pagination.java
 * @Description: 分页工具类
 *
 * @Date 2016年7月1日 
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
public class Pagination implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 总记录
	 */
	private Integer totalCount;
	/**
	 * 总页数
	 */
	private Integer totalPage;
	/**
	 * 每页记录,默认每页20条记录.
	 */
	private int pageSize = 20;
	/**
	 * 当前页,从第一页开始
	 */
	private Integer currentPage = 1;
	/**
	 * 返回的查询数据信息
	 */
	private List<?> itemList;
	/**
	 * 排序字段
	 */
	private String orderField;
	/**
	 * 自动排序
	 */
	private String orderDirection = "asc";// 默认升序

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrderDirection() {
		return orderDirection;
	}

	public void setOrderDirection(String orderDirection) {
		if (StringUtils.isNotEmpty(orderDirection) && (orderDirection.equals("asc") || orderDirection.equals("desc"))) {
			this.orderDirection = orderDirection;
		} else {
			this.orderDirection = "asc";
		}
	}

	/**
	 * 默认构造函数
	 */
	public Pagination() {
		this(20);
	}

	/**
	 * 带参数构造函数
	 * 
	 * @param sizePage
	 */
	public Pagination(int pageSize) {
		super();
		this.pageSize = pageSize;
	}

	/**
	 * 带参数构造函数
	 * 
	 * @param pageSize
	 * @param currentPage
	 * @param totalCount
	 */
	public Pagination(int pageSize, int currentPage) {
		this.pageSize = pageSize;
		this.currentPage = currentPage;
	}

	/**
	 * 带参数构造函数
	 * 
	 * @param pageSize
	 * @param currentPage
	 * @param totalCount
	 */
	public Pagination(int pageSize, int currentPage, int totalCount) {
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		adjustcurrentPage();
	}

	/**
	 * 带参数构造函数
	 * 
	 * @param pageSize
	 * @param currentPage
	 * @param totalCount
	 */
	public Pagination(int pageSize, int currentPage, int totalCount, List<Object> itemList) {
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.itemList = itemList;
		adjustcurrentPage();
	}

	/**
	 * 调整页码，使不超过最大页数
	 */
	public void adjustcurrentPage() {
		if (currentPage == 1) {
			return;
		}
		int tp = getTotalPage();
		if (currentPage > tp) {
			currentPage = tp;
		}
	}

	/**
	 * 返回查询数据的总记录
	 */
	public Integer getTotalCount() {
		return totalCount == null ? 0 : totalCount;
	}

	/**
	 * 设置查询总记录
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
		this.totalPage =  ((getTotalCount() % getPageSize() == 0) ? getTotalCount() / getPageSize() : (getTotalCount() / getPageSize()) + 1);
	}

	/**
	 * 返回每页记录,如果没有设置,则默认为每页20条记录
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置每页的记录.
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 当前页数,如果没有设置则是从第一页开始.
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}

	/**
	 * 设置当前页数,页面设置的值如果少于或者等于0时候则赋值 1.
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = ((currentPage == null || "".equals(currentPage)) ? 1 : currentPage);
	}

	/**
	 * 根据页数和每页设置数量获取数据库查询记录开始
	 */
	public int getStartRow() {
		if(getCurrentPage()<=0){
			return 0;
		}else{
			return ((getCurrentPage() - 1) * getPageSize());
		}
	}

	/**
	 * 根据页数和每页设置数量获取数据查询记录结束
	 */
	public int getEndRow() {
		if(getCurrentPage()<=0){
			return getPageSize();
		}else{
			return (getStartRow() + getPageSize());
		}
	}

	/**
	 * 可以根据查询设置<code>setItemList()</code>方法获取数据.
	 */
	public List<?> getItemList() {
		return itemList;
	}

	/**
	 * 可以在dal里面查询设置到该对象集合里面.
	 * 
	 * @param itemList
	 */
	public void setItemList(List<Object> itemList) {
		this.itemList = itemList;
	}

	/**
	 * 判断是否有上页,如果存在上页返回<code>true</code>,否则反之.
	 */
	public boolean getPrePage() {
		return (getCurrentPage() != 1);
	}

	/**
	 * 判断是否有上页,如果存在下页返回<code>true</code>,否则反之.
	 */
	public boolean getNextPage() {
		return currentPage < getTotalPage();
	}

	/**
	 * 获取总页数
	 */
	public int getTotalPage() {
		this.totalPage =  ((getTotalCount() % getPageSize() == 0) ? getTotalCount() / getPageSize() : (getTotalCount() / getPageSize()) + 1);
		return totalPage;
	}
}
