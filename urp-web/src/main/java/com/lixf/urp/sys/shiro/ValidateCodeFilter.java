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
 * 2016年7月13日    Li Xiao Fei         Create the class
*/

package com.lixf.urp.sys.shiro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @FileName ValidateCodeFilter.java
 * @Description: 
 *
 * @Date 2016年7月13日 
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
public class ValidateCodeFilter implements Filter{
	
	private ArrayList<String> includes = new ArrayList<String>();

	public void init(FilterConfig filterConfig) throws ServletException {
		this.includes.addAll(Arrays.asList(filterConfig.getInitParameter("includeServlets").split(",")));
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
        String target = request.getRequestURI();
        target = target.lastIndexOf("?") > 0 ? target.substring(target.lastIndexOf("/") + 1,
                target.lastIndexOf("?") - target.lastIndexOf("/")) : target.substring(target.lastIndexOf("/") + 1);
        if (this.includes.contains(target)) {
            RequestDispatcher rdsp = request.getRequestDispatcher(target);
            rdsp.forward(req, resp);
        } else
            chain.doFilter(req, resp);
	}

	public void destroy() {
		
	}

}
