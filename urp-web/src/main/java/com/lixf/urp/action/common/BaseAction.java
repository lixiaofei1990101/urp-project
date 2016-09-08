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

package com.lixf.urp.action.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.lixf.urp.common.model.Pagination;
import com.lixf.urp.common.model.ResultJson;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @FileName BaseAction.java
 * @Description:action基类
 *
 * @Date 2016年7月1日
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
public class BaseAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware, Action {

	private static final long serialVersionUID = 1L;
	
	public Pagination pagination = new Pagination();
	/**
	 * easyui dategrid分页
	 */
	/** 页码 */
	public Integer page;
	/** 每页数 */
	public Integer rows;
	/**排序字段*/
	public String  sort;
	/**升降序*/
	public String  orders;
	
	/** request对象 */
	private HttpServletRequest request;

	/** response对象 */
	private HttpServletResponse response;
	
	/** sessionMap对象 */
	private Map<String, Object> session;

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
	
	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrders() {
		return orders;
	}

	public void setOrders(String orders) {
		this.orders = orders;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setHeader("Pragma", "no-cache");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	
	/**
	 * @Title: getSeesionValue 
	 * @Description:根据键值获取session值
	 * @param key
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	public Object getSeesionValue(String key) {
		return request.getSession().getAttribute(key);
	}
	/**
	 * @Title: setAttribute 
	 * @Description:将对象存在request域
	 * @param key
	 * @param obj 
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
    protected void setAttribute(String key,Object obj){   
        this.getRequest().setAttribute(key, obj);   
    } 
    
	/**
	 * @Title: getParameterForString 
	 * @Description:获取表单提交参数
	 * @param parameterName
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	protected String getParameterForString(String parameterName){   
        return this.getRequest().getParameter(parameterName);   
    } 
	/**
	 * @Title: getRealPath 
	 * @Description:获取物理磁盘路径
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	protected String getRealPath() {
		return request.getSession().getServletContext().getRealPath("");
	}
	/**
	 * @Title: getRootPath 
	 * @Description:获取根目录
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	protected String getRootPath() {
		return request.getContextPath();
	}
	
	/**
	 * @Title: outputJson 
	 * @Description:输入普通json数据
	 * @param object 
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	public void outputJson(Object object) {
		PrintWriter out = null;
		HttpServletResponse httpServletResponse = ServletActionContext
				.getResponse();
		httpServletResponse.setContentType("text/html");
		httpServletResponse.setCharacterEncoding("utf-8");
		String json = null;
		try {
			out = httpServletResponse.getWriter();
			json = com.alibaba.fastjson.JSON.toJSONStringWithDateFormat(object,
					"yyyy-MM-dd HH:mm:ss");
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.print(json);
		out.close();
	}
	
	public void outputJson(Object object, String type) {
		PrintWriter out = null;
		HttpServletResponse httpServletResponse = ServletActionContext
				.getResponse();
		httpServletResponse.setContentType(type);
		httpServletResponse.setCharacterEncoding("utf-8");
		String json = null;
		try {
			out = httpServletResponse.getWriter();
			json = com.alibaba.fastjson.JSON.toJSONStringWithDateFormat(object,
					"yyyy-MM-dd HH:mm:ss");
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.print(json);
		out.close();
	}

	
	public void outputJson(String obj) {
		try {
			ServletActionContext.getResponse().setContentType("text/html");
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().write(obj);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void writeJson(Object obj) {
		try {
			ServletActionContext.getResponse();
			ServletActionContext.getResponse().setContentType("text/html");
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter()
					.write(com.alibaba.fastjson.JSON.toJSONString(obj));
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ResultJson getMessage(boolean flag) {
		ResultJson json = new ResultJson();
		if (flag) {
			json.setStatus(true);
			json.setMessage("数据更新成功！");
		} else {
			json.setMessage("提交失败了！");
		}
		return json;
	}
	
	public PrintWriter out(){
		PrintWriter out = null; 
		try {
			out = this.getResponse().getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out;
	}
}
