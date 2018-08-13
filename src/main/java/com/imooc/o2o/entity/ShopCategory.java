package com.imooc.o2o.entity;

import java.util.Date;

/**   
* Copyright: Copyright (c) 2018 ICBC。 All rights reserved.
* 
* @ClassName: ShopCategory.java
* @Description: 店铺类别实体类
*
* @version: v1.0.0
* @author: KeeganRen
* @date: 2018年8月12日 下午6:25:00 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年8月12日     KeeganRen           v1.0.0               修改原因
*/
public class ShopCategory {
	// ID
	private Long shopCategoryId;
	
	// 名称
	private String shopCategoryName;
	
	// 描述
	private String shopCategoryDesc;
	
	// 图片
	private String shopCategoryImg;
	
	// 权重
	private Integer priority;
	
	// 创建时间
	private Date createTime;
	
	// 更新时间
	private Date lastEditTime;
	
	// 用户信息
	private ShopCategory parent;

	public Long getShopCategoryId() {
		return shopCategoryId;
	}

	public void setShopCategoryId(Long shopCategoryId) {
		this.shopCategoryId = shopCategoryId;
	}

	public String getShopCategoryName() {
		return shopCategoryName;
	}

	public void setShopCategoryName(String shopCategoryName) {
		this.shopCategoryName = shopCategoryName;
	}

	public String getShopCategoryDesc() {
		return shopCategoryDesc;
	}

	public void setShopCategoryDesc(String shopCategoryDesc) {
		this.shopCategoryDesc = shopCategoryDesc;
	}

	public String getShopCategoryImg() {
		return shopCategoryImg;
	}

	public void setShopCategoryImg(String shopCategoryImg) {
		this.shopCategoryImg = shopCategoryImg;
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

	public ShopCategory getParent() {
		return parent;
	}

	public void setParent(ShopCategory parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ShopCategory [shopCategoryId=").append(shopCategoryId).append(", shopCategoryName=")
				.append(shopCategoryName).append(", shopCategoryDesc=").append(shopCategoryDesc)
				.append(", shopCategoryImg=").append(shopCategoryImg).append(", priority=").append(priority)
				.append(", createTime=").append(createTime).append(", lastEditTime=").append(lastEditTime)
				.append(", parent=").append(parent).append("]");
		return builder.toString();
	}
	
}
