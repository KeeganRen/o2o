package com.imooc.o2o.entity;

import java.util.Date;

/**   
* Copyright: Copyright (c) 2018 ICBC。 All rights reserved.
* 
* @ClassName: Area.java
* @Description: 区域实体类
*
* @version: v1.0.0
* @author: KeeganRen
* @date: 2018年8月12日 下午6:22:20 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年8月12日     KeeganRen           v1.0.0               修改原因
*/
public class Area {

	// ID
	private Integer areaId;
	
	// 名称
	private String areaName;
	
	// 权重
	private Integer priority;
	
	// 创建时间
	private Date createTime;
	
	// 更新时间
	private Date lastEditTime;

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
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
		builder.append("Area [areaId=").append(areaId).append(", areaName=").append(areaName).append(", priority=")
				.append(priority).append(", createTime=").append(createTime).append(", lastEditTime=")
				.append(lastEditTime).append("]");
		return builder.toString();
	}
	
}
