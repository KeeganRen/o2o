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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Product;
import com.imooc.o2o.entity.ProductCategory;
import com.imooc.o2o.entity.ProductImg;
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
	
	// TODO:
	/// mysql自增列重置
	// alter table o2o.tb_product auto_increment=1; 
	// 由于存在自增主键，会导致报错
	@Test
	public void testAInsertProduct() throws Exception {
		Shop shop1 = new Shop();
		shop1.setShopId(1L);
		Shop shop2 = new Shop();
		shop2.setShopId(2L);
		ProductCategory pCategory1 = new ProductCategory();
		pCategory1.setProductCategoryId(2L);
		ProductCategory pCategory2 = new ProductCategory();
		pCategory2.setProductCategoryId(3L);
		ProductCategory pCategory3 = new ProductCategory();
		pCategory3.setProductCategoryId(4L);
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
		product2.setProductCategory(pCategory2);
		Product product3 = new Product();
		product3.setProductName("testName3");
		product3.setProductDesc("testDesc3");
		product3.setImgAddr("testAddr2");
		product3.setPriority(11);
		product3.setEnableStatus(0);
		product3.setCreateTime(new Date());
		product3.setLastEditTime(new Date());
		product3.setShop(shop2);
		product3.setProductCategory(pCategory3);
		
		int effectedNum1 = productDao.insertProduct(product1);
		assertEquals(1, effectedNum1);
		int effectedNum2 = productDao.insertProduct(product2);
		assertEquals(1, effectedNum2);
		int effectedNum3 = productDao.insertProduct(product3);
		assertEquals(1, effectedNum3);
	}
	
	@Test
	public void testBQueryProductList() throws Exception {
		Product product = new Product();
		List<Product> products = productDao.queryProductList(product, 0, 3);
		assertEquals(3, products.size());
		int count = productDao.queryProductCount(product);
		assertEquals(3, count);
		product.setProductName("testName1");
		products = productDao.queryProductList(product, 0, 3);
		assertEquals(1, products.size());
		
		Shop shop = new Shop();
		shop.setShopId(2L);
		Product product2 = new Product();
		product2.setShop(shop);
		products = productDao.queryProductList(product2, 0, 3);
		assertEquals(1, products.size());
		count = productDao.queryProductCount(product2);
		assertEquals(1, count);
	}
	
	@Test
	public void testCQueryProductByProductId() throws Exception {
		long productId = 1L;
		ProductImg productImg1 = new ProductImg();
		productImg1.setImgAddr("imgaddr1");
		productImg1.setImgDesc("testImgaddr1");
		productImg1.setPriority(1);
		productImg1.setCreateTime(new Date());
		productImg1.setProductId(productId);
		ProductImg productImg2 = new ProductImg();
		productImg2.setImgAddr("imgaddr2");
		productImg2.setImgDesc("testImgaddr2");
		productImg2.setPriority(1);
		productImg2.setCreateTime(new Date());
		productImg2.setProductId(productId);
		List<ProductImg> productImgList = new ArrayList<ProductImg>();
		productImgList.add(productImg1);
		productImgList.add(productImg2);
		
		int effectedNum = productImgDao.batchInsertProductImg(productImgList);
		assertEquals(2, effectedNum);
		Product product = productDao.queryProductByProductId(productId);
		assertEquals(2, product.getProductImgList().size());
		effectedNum = productImgDao.deleteProductImgByProductId(productId);
		assertEquals(2, effectedNum);
	}
	
	@Test
	public void testCQueryProductById() throws Exception {
		long productId = 1L;
		Product product = productDao.queryProductByProductId(productId);
		assertEquals(2, product.getProductImgList().size());
	}
	
	@Test
	public void testDUpdateProduct() throws Exception {
		Shop shop1 = new Shop();
		shop1.setShopId(1L);
		Product product = new Product();
		product.setShop(shop1);
		product.setProductId(1L);
		product.setProductName("测试1");
		int effectedNum3 = productDao.updateProduct(product);
		assertEquals(1, effectedNum3);
	}
	
	@Test
	public void testEDeleteProduct() throws Exception {
		long productId1 = 1L;
		long productId2 = 2L;
		long productId3 = 3L;
		long shopId1 = 1L;
		long shopId2 = 2L;
		int effectedNum1 = productDao.deleteProduct(productId1, shopId1);
		assertEquals(1, effectedNum1);
		int effectedNum2 = productDao.deleteProduct(productId2, shopId1);
		assertEquals(1, effectedNum2);
		int effectedNum3 = productDao.deleteProduct(productId3, shopId2);
		assertEquals(1, effectedNum3);
	}
}
