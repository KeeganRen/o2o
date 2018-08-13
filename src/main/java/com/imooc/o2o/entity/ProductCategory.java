/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.entity 
 * @author: KeeganRen   
 * @date: 2018年8月12日 下午8:11:57 
 */
package com.imooc.o2o.entity;

import java.util.Date;

/**   
* Copyright: Copyright (c) 2018 ICBC。 All rights reserved.
* 
* @ClassName: ProductCategory.java
* @Description: 商品类别实体类
*
* @version: v1.0.0
* @author: KeeganRen
* @date: 2018年8月12日 下午8:11:57 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年8月12日     KeeganRen           v1.0.0               修改原因
*/
public class ProductCategory {
	// ID
	private Long productCategoryId;
	
	// shop ID
	private Long shopId;
	
	// 名称
	private String productCategoryName;
	
	// 权重
	private Integer priority;
	
	// 创建时间
	private Date createTime;

	public Long getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(Long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getProductCategoryName() {
		return productCategoryName;
	}

	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductCategory [productCategoryId=").append(productCategoryId).append(", shopId=")
				.append(shopId).append(", productCategoryName=").append(productCategoryName).append(", priority=")
				.append(priority).append(", createTime=").append(createTime).append("]");
		return builder.toString();
	}
	
}
