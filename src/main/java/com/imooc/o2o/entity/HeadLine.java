package com.imooc.o2o.entity;

import java.util.Date;

/**   
* Copyright: Copyright (c) 2018 ICBC。 All rights reserved.
* 
* @ClassName: HeadLine.java
* @Description: 头条实体类
*
* @version: v1.0.0
* @author: KeeganRen
* @date: 2018年8月12日 下午6:24:45 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年8月12日     KeeganRen           v1.0.0               修改原因
*/
public class HeadLine {
	// ID
	private Long lineId;
	
	// 名称
	private String lineName;
	
	// 链接
	private String lineLink;
	
	// 图片
	private String lineImg;
	
	// 权重
	private Integer priority;
	
	// 状态
	// 0.不可用
	// 1.可用
	private String enableStatus;
	
	// 创建时间
	private Date createTime;
	
	// 更新时间
	private Date lastEditTime;
	
	// 用户信息
	private PersonInfo personInfo;

	public Long getLineId() {
		return lineId;
	}

	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getLineLink() {
		return lineLink;
	}

	public void setLineLink(String lineLink) {
		this.lineLink = lineLink;
	}

	public String getLineImg() {
		return lineImg;
	}

	public void setLineImg(String lineImg) {
		this.lineImg = lineImg;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getEnableStatus() {
		return enableStatus;
	}

	public void setEnableStatus(String enableStatus) {
		this.enableStatus = enableStatus;
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
		builder.append("HeadLine [lineId=").append(lineId).append(", lineName=").append(lineName).append(", lineLink=")
				.append(lineLink).append(", lineImg=").append(lineImg).append(", priority=").append(priority)
				.append(", enableStatus=").append(enableStatus).append(", createTime=").append(createTime)
				.append(", lastEditTime=").append(lastEditTime).append(", personInfo=").append(personInfo).append("]");
		return builder.toString();
	}
	
}
