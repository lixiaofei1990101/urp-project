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

package com.lixf.urp.sys.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @FileName WebPathListener.java
 * @Description: 
 *
 * @Date 2016年7月13日 
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
public class PathListener implements ServletContextListener{
	
	private static ServletContext servletContext = null;
	
	public void contextInitialized(ServletContextEvent sce) {
		servletContext = sce.getServletContext();
		System.out.println(servletContext.getRealPath("/"));
		servletContext.setAttribute("path", servletContext.getContextPath());
	}

	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
