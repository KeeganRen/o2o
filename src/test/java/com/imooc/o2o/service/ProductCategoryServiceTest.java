/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.service 
 * @author: KeeganRen   
 * @date: 2018年9月2日 上午12:49:24 
 */
package com.imooc.o2o.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ProductCategory;

/**   
 * @ClassName: ProductCategoryServiceImplTest.java
 * @Description: 该类的功能描述
 */
public class ProductCategoryServiceTest extends BaseTest {

	@Autowired
	private ProductCategoryService productCategoryService;
	
	/**
	 * Test method for {@link com.imooc.o2o.service.impl.ProductCategoryServiceImpl#getProductCategoryList(long)}.
	 */
	@Test
	public void testGetProductCategoryList() {
		long shopId = 1L;
		List<ProductCategory> productCategoryList = productCategoryService.getProductCategoryList(shopId);
		System.out.println("店铺信息类别：" + productCategoryList.size());
	}

}
