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
	
	
	ProductCategoryExecution batchAddProductCategory(List<ProductCategory>productCategoryList) throws ProductCategoryOperationException;
}
