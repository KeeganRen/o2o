/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.service 
 * @author: KeeganRen   
 * @date: 2018年9月2日 上午12:41:06 
 */
package com.imooc.o2o.service;

import java.util.List;

import com.imooc.o2o.dto.ProductCategoryExecution;
import com.imooc.o2o.entity.ProductCategory;
import com.imooc.o2o.exceptions.ProductCategoryOperationException;

/**   
 * @ClassName: ProductCategoryService.java
 * @Description: 产品类别查询service
 */
public interface ProductCategoryService {

	/**
	 * 
	 * @Function: ProductCategoryService.java
	 * @Description: 查询指定某店铺下所有商品类别信息
	 *
	 */
	List<ProductCategory> getProductCategoryList(long shopId);
	
	/**
	 * 
	 * @Function: ProductCategoryService.java
	 * @Description: 批量插入商品类别
	 *
	 */
	ProductCategoryExecution batchAddProductCategory(List<ProductCategory>productCategoryList) throws ProductCategoryOperationException;


	/**
	 * 
	 * @Function: ProductCategoryService.java
	 * @Description: 将类别下的商品里的商品类别置空，并删除商品类别
	 *
	 */
	ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId) throws ProductCategoryOperationException;
}
