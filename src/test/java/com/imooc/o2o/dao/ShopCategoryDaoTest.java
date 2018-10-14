/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.dao 
 * @author: KeeganRen   
 * @date: 2018年8月18日 下午4:41:13 
 */
package com.imooc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ShopCategory;

/**   
 * @ClassName: ShopCategoryDaoTest.java
 * @Description: 该类的功能描述
 */
public class ShopCategoryDaoTest extends BaseTest {

	@Autowired
	private ShopCategoryDao shopCategoryDao;
	
	@Test
	public void testQueryShopCategoryNull() {
		
		try {
			List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(null);
			assertEquals(1, shopCategoryList.size());
			System.out.println(shopCategoryList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryShopCategory() {
		
		try {
			List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(new ShopCategory());
			assertEquals(2, shopCategoryList.size());
			
			ShopCategory testCategory = new ShopCategory();
			ShopCategory parentCategory = new ShopCategory();
			parentCategory.setShopCategoryId(1L);
			testCategory.setParent(parentCategory);
			List<ShopCategory> shopCategoryListP = shopCategoryDao.queryShopCategory(testCategory);
			assertEquals(1, shopCategoryListP.size());
			
			System.out.println(shopCategoryListP.get(0).getShopCategoryName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
