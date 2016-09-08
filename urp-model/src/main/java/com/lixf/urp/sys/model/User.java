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

package com.lixf.urp.sys.model;

import java.io.Serializable;

/**
 * @FileName User.java
 * @Description: 用户实体
 *
 * @Date 2016年7月1日 
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String userCode;
	private String userName;
	private String password;
	private String phone;
	private String email;
	private String salt;
	private int locked;
	private String officeId;
	private String post;
	private String birthday;
	private String address;
	private String createDate;
	private String name;
	private String remark;
	
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public int getLocked() {
		return locked;
	}
	public void setLocked(int locked) {
		this.locked = locked;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getOfficeId() {
		return officeId;
	}
	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	//用户的私盐
	public String getCredentialsSalt() {
        return userName + salt;
    }
	@Override
	public String toString() {
		return "User [id=" + id + ", userCode=" + userCode + ", userName=" + userName + ", password=" + password + ", phone=" + phone
				+ ", email=" + email + ", salt=" + salt + ", locked=" + locked + ", departMent=" + officeId + ", post=" + post
				+ ", birthday=" + birthday + ", address=" + address + ", remark=" + remark + "]";
	}
	
	
}
