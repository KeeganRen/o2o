/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.dao 
 * @author: KeeganRen   
 * @date: 2018年9月6日 下午11:24:16 
 */
package com.imooc.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imooc.o2o.entity.Product;

/**   
 * @ClassName: ProductDao.java
 * @Description: 该类的功能描述
 */
public interface ProductDao {

	/**
	 * 
	 * @Function: ProductDao.java
	 * @Description: 查询商品列表并分页，可输入的条件有：商品名、商品状态、店铺Id、店铺类别
	 *
	 */
	List<Product> queryProductList(@Param("productCondition") Product productCondition, @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);
	
	/**
	 * 
	 * @Function: ProductDao.java
	 * @Description: 查询对应的商品总数
	 *
	 */
	int queryProductCount(@Param("productCondition") Product productCondition);
	
	/**
	 * 
	 * @Function: ProductDao.java
	 * @Description: 查询对应商品的总数
	 *
	 */
	Product queryProductByProductId(@Param("productId") long productId);
	
	/**
	 * 
	 * @Function: ProductDao.java
	 * @Description: 插入商品
	 *
	 */
	int insertProduct(Product product);
	
	/**
	 * 
	 * @Function: ProductDao.java
	 * @Description: 更新商品信息
	 *
	 */
	int updateProduct(Product product);
	
	/**
	 * 
	 * @Function: ProductDao.java
	 * @Description: 删除商品类别之前，将商品类别ID置为空
	 *
	 */
	int updateProductCategoryToNull(long productCategoryId);
	
	/**   
	 * @Function: ProductDao.java
	 * @Description: 删除商品
	 *
	 */
	int deleteProduct(@Param("productId") long productId, @Param("shopId") long shopId);
}
