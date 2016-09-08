/*
 * COPYRIGHT. ShenZhen MinSiDa Technology Co., Ltd. 2016.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording, 
 * or otherwise, without the prior written permission of ShenZhen GreatVision Network Technology Co., Ltd.
 *
 * Amendment History:
 * 
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2016年7月28日    Li Xiao Fei         Create the class
 */

package com.lixf.urp.sys.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @FileName ShiroUser.java
 * @Description:
 *
 * @Date 2016年7月28日
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
public class ShiroUser implements Serializable{
	private static final long serialVersionUID = -1373760761780840081L;
	public Integer id;
	public String loginName;
	public String name;

	public ShiroUser(Integer id, String loginName, String name) {
		this.id = id;
		this.loginName = loginName;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	// 本函数输出将作为默认的<shiro:principal/>输出.
	@Override
	public String toString() {
		return loginName;
	}

	// 重载hashCode,只计算loginName;
	@Override
	public int hashCode() {
		return Objects.hashCode(loginName);
	}

	// 重载equals,只计算loginName;
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ShiroUser other = (ShiroUser) obj;
		if (loginName == null) {
			if (other.loginName != null) {
				return false;
			}
		} else if (!loginName.equals(other.loginName)) {
			return false;
		}
		return true;
	}
}
