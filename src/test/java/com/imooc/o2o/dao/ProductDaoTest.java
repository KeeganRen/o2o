/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.dao 
 * @author: KeeganRen   
 * @date: 2018年9月8日 下午11:43:52 
 */
package com.imooc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Product;
import com.imooc.o2o.entity.ProductCategory;
import com.imooc.o2o.entity.Shop;

/**   
 * @ClassName: ProductDaoTest.java
 * @Description: 该类的功能描述
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest extends BaseTest {

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ProductImgDao productImgDao;
	
	@Test
	public void testAInsertProduct() throws Exception {
		Shop shop1 = new Shop();
		shop1.setShopId(1L);
		ProductCategory pCategory1 = new ProductCategory();
		pCategory1.setProductCategoryId(1L);
		Product product1 = new Product();
		product1.setProductName("testName1");
		product1.setProductDesc("testDesc1");
		product1.setImgAddr("testAddr1");
		product1.setPriority(1);
		product1.setEnableStatus(1);
		product1.setCreateTime(new Date());
		product1.setLastEditTime(new Date());
		product1.setShop(shop1);
		product1.setProductCategory(pCategory1);
		Product product2 = new Product();
		product2.setProductName("testName2");
		product2.setProductDesc("testDesc2");
		product2.setImgAddr("testAddr2");
		product2.setPriority(11);
		product2.setEnableStatus(0);
		product2.setCreateTime(new Date());
		product2.setLastEditTime(new Date());
		product2.setShop(shop1);
		product2.setProductCategory(pCategory1);
		Product product3 = new Product();
		product3.setProductName("testName3");
		product3.setProductDesc("testDesc3");
		product3.setImgAddr("testAddr2");
		product3.setPriority(11);
		product3.setEnableStatus(0);
		product3.setCreateTime(new Date());
		product3.setLastEditTime(new Date());
		product3.setShop(shop1);
		product3.setProductCategory(pCategory1);
		
		int effectedNum1 = productDao.insertProduct(product1);
		assertEquals(1, effectedNum1);
		int effectedNum2 = productDao.insertProduct(product2);
		assertEquals(1, effectedNum2);
		int effectedNum3 = productDao.insertProduct(product3);
		assertEquals(1, effectedNum3);
	}
	
	@Test
	public void testBUpdateProduct() throws Exception {
		Shop shop1 = new Shop();
		shop1.setShopId(1L);
		ProductCategory pCategory1 = new ProductCategory();
		pCategory1.setProductCategoryId(1L);
		Product product3 = new Product();
		product3.setProductId(3L);
		product3.setImgAddr("testAddr3");
		product3.setPriority(13);
		product3.setCreateTime(new Date());
		product3.setLastEditTime(new Date());
		product3.setShop(shop1);
		product3.setProductCategory(pCategory1);
		int effectedNum3 = productDao.updateProduct(product3);
		assertEquals(1, effectedNum3);
	}
	
	@Test
	public void testCDeleteProduct() throws Exception {
		long productId = 3L;
		long shopId = 1L;
		int effectedNum3 = productDao.deleteProduct(productId, shopId);
		assertEquals(1, effectedNum3);
	}
}
