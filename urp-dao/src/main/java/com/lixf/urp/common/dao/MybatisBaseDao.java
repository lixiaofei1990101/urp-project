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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.util.Assert;

import com.github.pagehelper.PageHelper;
import com.lixf.urp.common.model.Pagination;

/**
 * @FileName MybatisBaseDao.java
 * @Description: 
 *
 * @Date 2016年7月1日 
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
public abstract class MybatisBaseDao<T, PK extends Serializable> implements BaseDao<T, PK>{
	/**
	 * 返回类的域对象
	 */
	public abstract String getClassPath();
	
	@Resource
	private SqlSessionTemplate sessionTemplate;
	
	/**
	 * 
	 * @Title: get
	 * @Description: 通过主键获取对象
	 * @param id
	 * @return
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	public T get(PK id) {
		T t = sessionTemplate.selectOne(getClassPath() + GET, id);
		return t;
	}

	/**
	 * 
	 * @Title: update
	 * @Description: 修改实体
	 * @param t
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	public void update(T t) {
		sessionTemplate.update(getClassPath() + UPDATE, t);
	}

	/**
	 * 
	 * @Title: save
	 * @Description: 新增实体
	 * @param t
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	public void save(T t) {
		sessionTemplate.insert(getClassPath() + SAVE, t);
	}

	/**
	 * @Title: save 
	 * @Description:新增数据
	 * @param uniqueKey
	 * @param params 
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	protected void save(String uniqueKey, Map<String, Object> params) {
		Assert.hasText(uniqueKey);
		if (params == null || params.size() == 0) {
			try {
				throw new Exception("参数集合为空");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		sessionTemplate.insert(getClassPath() + uniqueKey, params);
	}
	/**
	 * @Title: save 
	 * @Description:新增数据
	 * @param uniqueKey
	 * @param t 
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	protected void save(String uniqueKey, T t) {
		Assert.hasText(uniqueKey);
		sessionTemplate.insert(getClassPath() + uniqueKey, t);
	}
	/**
	 * 删除数据
	 */
	public void delete(PK id) {
		sessionTemplate.delete(getClassPath() + DELETE, id);
	}
	
	/**
	 * @Title: delete 
	 * @Description:删除
	 * @param uniqueKey
	 * @param object 
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	public void delete(String uniqueKey,Object object ) {
		Assert.hasText(uniqueKey);
		sessionTemplate.delete(getClassPath() + uniqueKey, object);
	}
	/**
	 * @Title: getAll 
	 * @Description:获取全部实体
	 * @param params
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	public List<T> getAll(Map<String, Object> params) {
		if (params == null || params.size() == 0) {
			List<T> dataList = sessionTemplate.selectList(getClassPath() + LIST);
			return dataList;
		}
		else {
			List<T> dataList = sessionTemplate.selectList(getClassPath() + LIST, params);
			return dataList;
		}
	}

	/**
	 * @Title: queryList 
	 * @Description:返回查询列表
	 * @param uniqueKey
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	@SuppressWarnings("rawtypes")
	protected List queryList(String uniqueKey) {
		Assert.hasText(uniqueKey);
		return sessionTemplate.selectList(getClassPath() + uniqueKey);
	}
	
	/**
	 * @Title: queryList 
	 * @Description:返回查询列表
	 * @param uniqueKey
	 * @param t
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	@SuppressWarnings("rawtypes")
	protected List queryList(String uniqueKey,  T t) {
		Assert.hasText(uniqueKey);
		List list = sessionTemplate.selectList(getClassPath() + uniqueKey, t);
		return list;
	}
	
	/**
	 * @Title: queryList 
	 * @Description:查询结合对象
	 * @param uniqueKey
	 * @param params
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	@SuppressWarnings("rawtypes")
	protected List queryList(String uniqueKey, Map<String, Object> params) {
		Assert.hasText(uniqueKey);
		if (params == null || params.size() == 0) {
			try {
				throw new Exception("参数集合为空");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		List list = sessionTemplate.selectList(getClassPath() + uniqueKey, params);
		return list;
	}
	
	/**
	 * @Title: queryList 
	 * @Description:返回查询列表(此方法只是为方便败欧洲移植用，
	 * 其它项目不要用此方法，并且只支持String , Integer两种类型的单个参数,两个或以上参数的，用map重截的方法)
	 * @param uniqueKey
	 * @param param
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	@SuppressWarnings("rawtypes")
	protected List queryList(String uniqueKey, Object ... param ) {
		Assert.hasText(uniqueKey);
		if(param.length>1){
			try {
				throw new Exception("不支持两个或以上参数");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		List list = null;
		if( param[0] instanceof String){
			String strParam =(String) param[0];
			list = sessionTemplate.selectList(getClassPath() + uniqueKey, strParam);
		}else if(param[0] instanceof Integer){
			Integer intParam = (Integer) param[0];
			list = sessionTemplate.selectList(getClassPath() + uniqueKey, intParam);
		}
		return list;
	}
	
	/**
	 * @Title: queryUniqueResult 
	 * @Description:查询单个对象
	 * @param uniqueKey
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	protected Object queryUniqueResult(String uniqueKey) {
		Assert.hasText(uniqueKey);
		return sessionTemplate.selectOne(getClassPath() + uniqueKey);
	}
	
	/**
	 * @Title: queryUniqueResult 
	 * @Description:查询单个对象
	 * @param uniqueKey
	 * @param t
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	protected Object queryUniqueResult(String uniqueKey, T t) {
		Assert.hasText(uniqueKey);
		return sessionTemplate.selectOne(getClassPath() + uniqueKey, t);
	}
	
	/**
	 * @Title: queryUniqueResult 
	 * @Description:查询集合对象
	 * @param uniqueKey
	 * @param params
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	protected Object queryUniqueResult(String uniqueKey, Map<String, Object> params) {
		Assert.hasText(uniqueKey);
		if (params == null || params.size() == 0) {
			try {
				throw new Exception("参数集合为空");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionTemplate.selectOne(getClassPath() + uniqueKey, params);
	}

	/**
	 * @Title: queryPaging 
	 * @Description:分页查询
	 * @param page
	 * @param getTotalRecordKey
	 * @param getPageKey
	 * @param params
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Deprecated
	protected Pagination queryPaging(Pagination page, String getTotalRecordKey, String getPageKey, Map<String, Object> params) {
		if (params == null) {
			params = new HashMap<String, Object>();
		}
		// 设置查询
		params.put(START_ROW, page.getStartRow());
		params.put(END_ROW, page.getEndRow());
		
		Integer totalCount = (Integer) sessionTemplate.selectOne(getClassPath() + getTotalRecordKey, params);
        page.setTotalCount(totalCount);
        
        List dataList = sessionTemplate.selectList(getClassPath() + getPageKey, params);
        page.setItemList(dataList);  
		return page;
	}
	/**
	 * @Title: queryByPaging 
	 * @Description:分页查询
	 * @param page
	 * @param getPageKey
	 * @param params
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Pagination queryByPaging(Pagination page,  String getPageKey, Map<String, Object> params) {
		if (params == null) {
			params = new HashMap<String, Object>();
		}
		// 设置查询
		params.put(START_ROW, page.getStartRow());
		params.put(END_ROW, page.getEndRow());
		
 
		PageHelper.startPage(page.getCurrentPage(),page.getPageSize());
        List dataList = sessionTemplate.selectList(getClassPath() + getPageKey, params);
        
        page.setItemList(dataList);  
        Long total = (long) dataList.size();
		page.setTotalCount(total.intValue());
        return page;
	}
 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Pagination queryByPaging(Pagination page,  String getPageKey, Object params) {
		if(page==null){
			page = new Pagination();
		}
		PageHelper.startPage(page.getCurrentPage(),page.getPageSize());
        List dataList = sessionTemplate.selectList(getClassPath() + getPageKey, params);
        
        page.setItemList(dataList);  
        Long total = (long) dataList.size();
		page.setTotalCount(total.intValue());
        return page;
	}
	/**
	 * @Title: update 
	 * @Description:修改数据
	 * @param uniqueKey
	 * @param params 
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	public void update(String uniqueKey, Map<String, Object> params) {
		Assert.hasText(uniqueKey);
		sessionTemplate.update(getClassPath() + uniqueKey, params);
	}
	
	/**
	 * @Title: delete 
	 * @Description:删除数据
	 * @param uniqueKey
	 * @param params 
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	public void delete(String uniqueKey, Map<String, Object> params) {
		Assert.hasText(uniqueKey);
		sessionTemplate.delete(getClassPath() + uniqueKey, params);
	}
	/**
	 * @Title: delete 
	 * @Description:删除数据
	 * @param uniqueKey
	 * @param params 
	 * @author Li Xiao Fei
	 * @date 2016年7月1日
	 */
	@SuppressWarnings("rawtypes")
	public void delete(String uniqueKey,List params) {
		Assert.hasText(uniqueKey);
		sessionTemplate.delete(getClassPath() + uniqueKey, params);
	}
}
