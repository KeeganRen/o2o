package com.imooc.o2o.entity;

import java.util.Date;

/**   
* Copyright: Copyright (c) 2018 ICBC。 All rights reserved.
* 
* @ClassName: PersonInfo.java
* @Description: 用户实体类
*
* @version: v1.0.0
* @author: KeeganRen
* @date: 2018年8月12日 下午6:23:16 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年8月12日     KeeganRen           v1.0.0               修改原因
*/
public class PersonInfo {

	// ID
	private Long userId;
	
	// 姓名
	private String name;
	
	// 头像地址
	private String profileImg;
	
	// 邮箱
	private String email;
	
	// 性别
	private String gender;
	
	// 状态
	private String enableStatus;
	
	// 身份标识
	// 1.顾客 
	// 2.店家
	// 3.超级管理员
	private Integer userType;
	
	// 创建时间
	private Date createTime;
	
	// 更新时间
	private Date lastEditTime;

	public Long getAreaId() {
		return userId;
	}

	public void setAreaId(Long areaId) {
		this.userId = areaId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEnableStatus() {
		return enableStatus;
	}

	public void setEnableStatus(String enableStatus) {
		this.enableStatus = enableStatus;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonInfo [areaId=").append(userId).append(", name=").append(name).append(", profileImg=")
				.append(profileImg).append(", email=").append(email).append(", gender=").append(gender)
				.append(", enableStatus=").append(enableStatus).append(", userType=").append(userType)
				.append(", createTime=").append(createTime).append(", lastEditTime=").append(lastEditTime).append("]");
		return builder.toString();
	}

}
