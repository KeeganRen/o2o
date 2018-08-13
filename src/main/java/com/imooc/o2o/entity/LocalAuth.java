package com.imooc.o2o.entity;

import java.util.Date;

/**   
* Copyright: Copyright (c) 2018 ICBC。 All rights reserved.
* 
* @ClassName: LocalAuth.java
* @Description: 本地账号实体类
*
* @version: v1.0.0
* @author: KeeganRen
* @date: 2018年8月12日 下午6:24:30 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年8月12日     KeeganRen           v1.0.0               修改原因
*/
public class LocalAuth {
	// ID
	private Long localAuthId;
	
	// 用户名
	private String username;
	
	// 密码
	private String password;
	
	// 创建时间
	private Date createTime;
	
	// 更新时间
	private Date lastEditTime;
	
	// 用户信息
	private PersonInfo personInfo;

	public Long getLocalAuthId() {
		return localAuthId;
	}

	public void setLocalAuthId(Long localAuthId) {
		this.localAuthId = localAuthId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LocalAuth [localAuthId=").append(localAuthId).append(", username=").append(username)
				.append(", password=").append(password).append(", createTime=").append(createTime)
				.append(", lastEditTime=").append(lastEditTime).append(", personInfo=").append(personInfo).append("]");
		return builder.toString();
	}
	
}
