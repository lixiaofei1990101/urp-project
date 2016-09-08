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

package com.lixf.urp.common.dao;

import java.io.Serializable;

/**
 * @FileName BaseDao.java
 * @Description: 
 *
 * @Date 2016年7月1日 
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
public interface BaseDao <T, PK extends Serializable>{
public static final String GET = "get";
	
	public static final String SAVE = "save";
	
	public static final String DELETE = "delete";
	
	public static final String UPDATE = "update";
	
	public static final String LIST = "list";
	
	public static final String START_ROW = "startRow";
	public static final String END_ROW = "endRow";
	
	public static final String NUM_PER_PAGE = "numPerPage";
	
	
	/**
	 * @Title: getClassPath 
	 * @Description:获取xml的命名空间
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	public String getClassPath();
	
	/**
	 * @Title: get 
	 * @Description:获取实体对象
	 * @param id
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	public T get(PK id);

	/**
	 * @Title: update 
	 * @Description:修改操作
	 * @param t 
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	public void update(T t);

	/**
	 * @Title: save 
	 * @Description:新增保存
	 * @param t 
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	public void save(T t);

	/**
	 * @Title: delete 
	 * @Description:删除操作
	 * @param id 
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	public void delete(PK id);
}
