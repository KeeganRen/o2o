package com.imooc.o2o.entity;

import java.util.Date;

/**   
* Copyright: Copyright (c) 2018 ICBC。 All rights reserved.
* 
* @ClassName: Shop.java
* @Description: 店铺实体类
*
* @version: v1.0.0
* @author: KeeganRen
* @date: 2018年8月12日 下午6:25:22 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年8月12日     KeeganRen           v1.0.0               修改原因
*/
public class Shop {
	// ID
	private Long shopId;
	
	//店名
	private String shopName;
	
	// 描述
	private String shopDesc;
	
	// 地址
	private String shopAddr;
	
	// 联系方式
	private String phone;
	
	// 门面图地址
	private String shopImg;
	
	// 权重
	private Integer priority;
	
	// 创建时间
	private Date createTime;
	
	// 最后修改时间
	private Date lastEditTime;
	
	// 状态
	// -1. 不可用
	// 0.审核中
	// 1.可用
	private Integer enableStatus;
	
	// 建议
	private String advice;
	
	// 区域实体类
	private Area area;
	
	// 用户信息实体类
	private PersonInfo owner;
	
	// 店铺类别实体类
	private ShopCategory shopCategory;

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopDesc() {
		return shopDesc;
	}

	public void setShopDesc(String shopDesc) {
		this.shopDesc = shopDesc;
	}

	public String getShopAddr() {
		return shopAddr;
	}

	public void setShopAddr(String shopAddr) {
		this.shopAddr = shopAddr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getShopImg() {
		return shopImg;
	}

	public void setShopImg(String shopImg) {
		this.shopImg = shopImg;
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

	public Integer getEnableStatus() {
		return enableStatus;
	}

	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public PersonInfo getOwner() {
		return owner;
	}

	public void setOwner(PersonInfo owner) {
		this.owner = owner;
	}

	public ShopCategory getShopCategory() {
		return shopCategory;
	}

	public void setShopCategory(ShopCategory shopCategory) {
		this.shopCategory = shopCategory;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Shop [shopId=").append(shopId).append(", shopName=").append(shopName).append(", shopDesc=")
				.append(shopDesc).append(", shopAddr=").append(shopAddr).append(", phone=").append(phone)
				.append(", shopImg=").append(shopImg).append(", priority=").append(priority).append(", createTime=")
				.append(createTime).append(", lastEditTime=").append(lastEditTime).append(", enableStatus=")
				.append(enableStatus).append(", advice=").append(advice).append(", area=").append(area)
				.append(", owner=").append(owner).append(", shopCategory=").append(shopCategory).append("]");
		return builder.toString();
	}
}
