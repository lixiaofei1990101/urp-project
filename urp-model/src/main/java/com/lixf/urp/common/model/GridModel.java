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
 * 2016年7月16日    Li Xiao Fei         Create the class
*/

package com.lixf.urp.common.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @FileName GridModel.java
 * @Description: Easyui 表格数据封装
 *
 * @Date 2016年7月16日 
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
public class GridModel implements Serializable{
	private static final long serialVersionUID = 4256325377818557460L;
	//表格集合对象
	private List<?> rows = new ArrayList<Object>();
	//总记录数
	private long total;
	
	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	
}
