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

package com.lixf.urp.sys.dao;

import java.util.List;
import java.util.Map;

import com.lixf.urp.common.dao.BaseDao;
import com.lixf.urp.common.model.TreeNode;
import com.lixf.urp.sys.model.Office;

/**
 * @FileName OfficeDao.java
 * @Description: 
 *
 * @Date 2016年9月3日 
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
public interface OfficeDao extends BaseDao<Office, String>{
	/**
	 * @Title: queryListOffice 
	 * @Description:查询机构列表
	 * @param map
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年9月3日
	 */
	public List<Office> queryListOffice(Map<String, Object> map);
	/**
	 * @Title: queryTreeOffice 
	 * @Description:查询结构树形结构数据
	 * @param map
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年9月3日
	 */
	public List<TreeNode> queryTreeOffice(Map<String, Object> map);
}
