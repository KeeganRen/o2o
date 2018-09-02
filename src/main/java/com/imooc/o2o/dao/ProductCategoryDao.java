/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.dao 
 * @author: KeeganRen   
 * @date: 2018年9月1日 下午10:12:09 
 */
package com.imooc.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imooc.o2o.entity.ProductCategory;

/**   
 * @ClassName: ProductCategoryDao.java
 * @Description: 产品分类Dao
 */
public interface ProductCategoryDao {

	/**
	 * @Function: ProductCategoryDao.java
	 * @Description: 通过shopId查询店铺商品类别
	 * @param long shopId
	 *
	 */
	List<ProductCategory> queryProductCategoryList(@Param("shopId") long shopId);
	
	/**
	 * 
	 * @Function: ProductCategoryDao.java
	 * @Description: 批量新增商品类别
	 *
	 */
	int batchInsertProductCategory(List<ProductCategory> productCategoryList);
}
