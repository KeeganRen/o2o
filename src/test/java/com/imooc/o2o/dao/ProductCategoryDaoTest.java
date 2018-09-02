/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.dao 
 * @author: KeeganRen   
 * @date: 2018年9月2日 上午12:22:53 
 */
package com.imooc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ProductCategory;

/**   
 * @ClassName: ProductCategoryDaoTest.java
 * @Description: 该类的功能描述
 */
public class ProductCategoryDaoTest extends BaseTest {

	@Autowired
	private ProductCategoryDao productCategoryDao;
	
	@Test
	public void testQueryProductCategoryList() throws Exception {
		long shopId = 1L;
		List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(shopId);
		System.out.println("该店铺的自定义类别数为:" + productCategoryList.size());		
	}
	
	@Test
	public void testBatchInsertProductCategory() {

		try {
			ProductCategory productCategory = new ProductCategory();
			productCategory.setProductCategoryName("小菜");
			productCategory.setPriority(9);
			productCategory.setCreateTime(new Date());
			productCategory.setShopId(1L);
			
			ProductCategory productCategory2 = new ProductCategory();
			productCategory2.setProductCategoryName("饮品");
			productCategory2.setPriority(13);
			productCategory2.setCreateTime(new Date());
			productCategory2.setShopId(1L);
			
			List<ProductCategory> productCategories = new ArrayList<ProductCategory>();
			productCategories.add(productCategory);
			productCategories.add(productCategory2);
			
			int effectNum = productCategoryDao.batchInsertProductCategory(productCategories);
			assertEquals(2, effectNum);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}
