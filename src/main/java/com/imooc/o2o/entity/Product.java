/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.entity 
 * @author: KeeganRen   
 * @date: 2018年8月12日 下午8:41:14 
 */
package com.imooc.o2o.entity;

import java.util.Date;
import java.util.List;

/**   
* Copyright: Copyright (c) 2018 ICBC。 All rights reserved.
* 
* @ClassName: Product.java
* @Description: 商品实体类
*
* @version: v1.0.0
* @author: KeeganRen
* @date: 2018年8月12日 下午8:41:14 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年8月12日     KeeganRen           v1.0.0               修改原因
*/
public class Product {
	// ID
	private Long productId;
	
	// 商品名
	private String productName;
	
	// 商品描述
	private String productDesc;
	
	// 商品缩略图地址
	private String imgAddr;
	
	// 原价
	private String normalPrice;
	
	// 折扣价
	private String promotionPrice;
	
	// 权重
	private Integer priority;
	
	// 创建时间
	private Date createTime;
	
	// 最后修改时间
	private Date lastEditTime;
	
	// 商品状态
	// -1. 不可用
	// 0.下架
	// 1.在前端展示系统展示
	private Integer enableStatus;
	
	// 商品详情图片列表
	private List<ProductImg> productImgList;
	
	// 商品类别
	private ProductCategory productCategory;
	
	// 商品店铺
	private Shop shop;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getImgAddr() {
		return imgAddr;
	}

	public void setImgAddr(String imgAddr) {
		this.imgAddr = imgAddr;
	}

	public String getNormalPrice() {
		return normalPrice;
	}

	public void setNormalPrice(String normalPrice) {
		this.normalPrice = normalPrice;
	}

	public String getPromotionPrice() {
		return promotionPrice;
	}

	public void setPromotionPrice(String promotionPrice) {
		this.promotionPrice = promotionPrice;
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

	public List<ProductImg> getProductImgList() {
		return productImgList;
	}

	public void setProductImgList(List<ProductImg> productImgList) {
		this.productImgList = productImgList;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [productId=").append(productId).append(", productName=").append(productName)
				.append(", productDesc=").append(productDesc).append(", imgAddr=").append(imgAddr)
				.append(", normalPrice=").append(normalPrice).append(", promotionPrice=").append(promotionPrice)
				.append(", priority=").append(priority).append(", createTime=").append(createTime)
				.append(", lastEditTime=").append(lastEditTime).append(", enableStatus=").append(enableStatus)
				.append(", productImgList=").append(productImgList).append(", productCategory=").append(productCategory)
				.append(", shop=").append(shop).append("]");
		return builder.toString();
	}
	
}
