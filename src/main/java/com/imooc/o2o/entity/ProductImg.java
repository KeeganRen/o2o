/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.entity 
 * @author: KeeganRen   
 * @date: 2018年8月12日 下午8:21:35 
 */
package com.imooc.o2o.entity;

import java.util.Date;

/**   
* Copyright: Copyright (c) 2018 ICBC。 All rights reserved.
* 
* @ClassName: ProductImg.java
* @Description: 详情图片实体类
*
* @version: v1.0.0
* @author: KeeganRen
* @date: 2018年8月12日 下午8:21:35 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年8月12日     KeeganRen           v1.0.0               修改原因
*/
public class ProductImg {
	// ID
	private Long productImgId;
	
	// 图片地址
	private String imgAddr;
	
	// 图片描述
	private String imgDesc;
	
	// 权重
	private Integer priority;
	
	// 创建时间
	private Date createTime;
	
	// 商品 ID
	private Long productId;

	public Long getProductImgId() {
		return productImgId;
	}

	public void setProductImgId(Long productImgId) {
		this.productImgId = productImgId;
	}

	public String getImgAddr() {
		return imgAddr;
	}

	public void setImgAddr(String imgAddr) {
		this.imgAddr = imgAddr;
	}

	public String getImgDesc() {
		return imgDesc;
	}

	public void setImgDesc(String imgDesc) {
		this.imgDesc = imgDesc;
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

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductImg [productImgId=").append(productImgId).append(", imgAddr=").append(imgAddr)
				.append(", imgDesc=").append(imgDesc).append(", priority=").append(priority).append(", createTime=")
				.append(createTime).append(", productId=").append(productId).append("]");
		return builder.toString();
	}
}
