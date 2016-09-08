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
 * 2016年7月20日    Li Xiao Fei         Create the class
*/

package com.lixf.urp.sys.model;

import java.io.Serializable;

/**
 * @FileName Role.java
 * @Description: 
 *
 * @Date 2016年7月20日 
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
public class Role implements Serializable{
	private static final long serialVersionUID = 1L;
	private String roleId;
	private String roleName;
	private String available;
	private String belongoffice;
	private String englishname;
	private String roletype;
	private String createperson;
	private String createdate;
	private String remark;
	private String userId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	public String getBelongoffice() {
		return belongoffice;
	}
	public void setBelongoffice(String belongoffice) {
		this.belongoffice = belongoffice;
	}
	public String getEnglishname() {
		return englishname;
	}
	public void setEnglishname(String englishname) {
		this.englishname = englishname;
	}
	public String getRoletype() {
		return roletype;
	}
	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}
	public String getCreateperson() {
		return createperson;
	}
	public void setCreateperson(String createperson) {
		this.createperson = createperson;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
