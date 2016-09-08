/*
 * COPYRIGHT. ShenZhen MinSiDa Technology Co., Ltd. 2015.
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
 * 2015年5月25日    djei         Create the class
*/

package com.lixf.urp.unit;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

import com.lixf.urp.common.model.Pagination;

/**
 * @FileName Bootstrap3Pagination.java
 * @Description: 
 *
 * @Date 2015年5月25日 
 * @author TianJun
 * @version 1.0
 * 
 */
public class PageTag implements Tag {
	private PageContext pageContext;
	 //当前页
    private Integer pageNum;
    //每页的数量
    private Integer pageSize;
    //总记录数
    private Integer total;
    //总页数
    private int pages;
    private String seachForm;
    private String paramEncoding = "UTF-8";
    private String pageBeanName;

	public String getPageBeanName() {
		return pageBeanName;
	}

	public void setPageBeanName(String pageBeanName) {
		this.pageBeanName = pageBeanName;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public String getSeachForm() {
		return seachForm;
	}

	public void setSeachForm(String seachForm) {
		this.seachForm = seachForm;
	}

	public String getParamEncoding() {
		return paramEncoding;
	}

	public void setParamEncoding(String paramEncoding) {
		this.paramEncoding = paramEncoding;
	}


	
	public void setPageContext(PageContext pc) {
		pageContext = pc;
	}

	
	
	public void setParent(Tag t) {
	}

	
	public Tag getParent() {
		return null;
	}

	
	public void release() {
		
	}

	
	public int doStartTag() throws JspException {
		if(pageBeanName==null)
			pageBeanName="pagination";
		
		Pagination pagination=(Pagination) pageContext.getRequest().getAttribute(pageBeanName);
		if(pagination!=null){
				pageNum = pagination.getCurrentPage();
				pages = pagination.getTotalPage();
				total = pagination.getTotalCount();
				pageSize = pagination.getPageSize();
		}else{
			pageNum=0;
			pages=0;
			total=0;
			pageSize=0;
		}
		return 0;
	}
	private String buildPage(){
		int start = 1,end = 10;
		StringBuilder sb = new StringBuilder();
		sb.append("<div class=\"panel panel-default\" >");
		sb.append("<div class=\"panel-heading\" style='height: 50px'>");
		if (total == 0) {
			return "";
		}else{
			sb.append("<div style='float:left'>");
			sb.append("<select id=\"pagesize\" calss=\"form-control input-sm\" style='height: 30px' name=\"pagesize\" onchange=\"pageDown(1);\">");
			if(pageSize==50) {
				sb.append("<option value='50' selected='selected'>50</option>");
				sb.append("<option value='100'>100</option>");
				sb.append("<option value='500'>500</option>");
			}else if(pageSize==100) {
				sb.append("<option value='50'>50</option>");
				sb.append("<option value='100' selected='selected'>100</option>");
				sb.append("<option value='500'>500</option>");
			} else if(pageSize==500) {
				sb.append("<option value='50'>50</option>");
				sb.append("<option value='100'>100</option>");
				sb.append("<option value='500' selected='selected'>500</option>");
			}
			sb.append("</select>");
			sb.append("</div>");
			sb.append("<ul class=\"pagination pagination-sm\">");
			// 上一页翻页
			if (pageNum == 1) {
				sb.append("<li class=\"disabled\"><a href=\"#\">&laquo;</a></li>\r\n");
			} else {
				sb.append("<li><a href=\"javascript:pageDown(").append((pageNum - 1)).append(")\">&laquo;</a></li>\r\n");
			} 
			//前面显示的页数太多处理
			if (pageNum > 4) {
				start = pageNum - 1;
				sb.append("<li><a href=\"javascript:pageDown(1)\">1</a><li>\r\n");
				sb.append("<li><a href=\"javascript:pageDown(2)\">2</a><li>\r\n");
				sb.append("<li><a href=\"#\">…</a></li>\r\n");
			}
			// 显示当前页附近的页
			end = pageNum + 1;
			if (end > pages) {
				end = pages;
			}
			for (int i = start; i <= end; i++) {
				if (pageNum == i) { // 当前页号不需要超链接
					sb.append("<li class=\"active\"><a href=\"#\">").append(i).append("</a></li>\r\n");
				} else {
					sb.append("<li><a href=\"javascript:pageDown(").append(i).append(")\">").append(i).append("</a><li>\r\n");
				}
			}
			// 如果后面页数过多,显示"..."
			if (end < pages - 2) {
				sb.append("<li><a href=\"#\">…</a></li>\r\n");
			}
			if (end < pages - 1) {
				sb.append("<li><a href=\"javascript:pageDown(").append(pages - 1).append(")\">").append(pages - 1)
						.append("</a></li>\r\n");
			}
			if (end < pages) {
				sb.append("<li><a href=\"javascript:pageDown(").append(pages).append(")\">").append(pages).append("</a></li>\r\n");
			}
			// 下一页处理
			if (pageNum == pages) {
				sb.append("<li class=\"disabled\"><a href=\"#\">&raquo;</a></li>\r\n");
			} else {
				sb.append("<li><a href=\"javascript:pageDown(").append((pageNum + 1)).append(")\">&raquo;</a><li>\r\n");
			}
			sb.append("</ul>");
			sb.append("<div style='float:right'>");
			sb.append("跳转<input type='text' id='ye' style='width:40px; border:1px solid #ddd'>页");
			sb.append("<button class=\"btn btn-default btn-xs\" type=\"button\" id=\"search_d20\" onclick=\"sendPage()\" style='margin-top:-3px;'>GO</button>");
			sb.append("共"+total+"条记录");
			sb.append("</div>");
			sb.append("</div>\r\n");
			sb.append("</div>\r\n");
			sb.append("<script type='text/javascript'>\r\n");
			sb.append("	function pageDown(currentPage){\r\n");
			sb.append("		var formObject = $('#"+seachForm+"')\r\n");
			sb.append("		formObject.attr('method','post')\r\n");
			sb.append("		var temp = $(\"#pagesize\").val()\r\n");
			sb.append("		var currentPage = \"<input type='hidden' id='currentPage' value=\"+currentPage+\" name='pagination.pageNum'/>\"\r\n");
			sb.append("		var pageSize = \"<input type='hidden' id='numPerPage' value=\"+temp+\" name='pagination.numPerPage'/>\"\r\n");
			sb.append("		var pageForm = $('#pagediv')\r\n");
			sb.append("		formObject.append(pageSize)\r\n");
			sb.append("		formObject.append(currentPage)\r\n");
			sb.append("		formObject.append(pageForm)\r\n");
			sb.append("		formObject.submit()\r\n");
			sb.append("	}\r\n");
			sb.append("	function sendPage(){\r\n");
			sb.append("		var temp=$(\"#ye\").val()\r\n");
			sb.append("		var value=''\r\n");
			sb.append("		if (!(/(^[0-9]*$)/.test(temp))){\r\n");
			sb.append("			alert(\"只能输入正整数\")\r\n");
			sb.append("		}else{\r\n");
		sb.append("				if(temp>"+pages+"){\r\n");
			sb.append("				value = "+pages+"\r\n");
			sb.append("			}else{\r\n");
			sb.append("				value = temp\r\n");
			sb.append("			}\r\n");
			sb.append("			pageDown(value)\r\n");
			sb.append("		}\r\n");
			sb.append("	}\r\n");
	        sb.append("</script>");
		}
		return sb.toString();
	}

	
	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.write(buildPage());
		} catch (IOException e) {
			e.printStackTrace();
			 throw new RuntimeException(e);
		}
		return 0;
	}
}
