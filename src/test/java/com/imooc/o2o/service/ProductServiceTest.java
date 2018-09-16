/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.service 
 * @author: KeeganRen   
 * @date: 2018年9月9日 下午5:27:53 
 */
package com.imooc.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.ImageHolder;
import com.imooc.o2o.dto.ProductExecution;
import com.imooc.o2o.entity.Product;
import com.imooc.o2o.entity.ProductCategory;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.enums.ProductStateEnum;
import com.imooc.o2o.exceptions.ShopOperationException;

/**   
 * @ClassName: ProductServiceTest.java
 * @Description: 该类的功能描述
 */
public class ProductServiceTest extends BaseTest {

	@Autowired
	private ProductService productService;
	
	@Test
	public void testAddProduct() throws ShopOperationException, FileNotFoundException {
		//创建shopId为1且productCategoryId为1的商品实例并给其成员变量赋值
		Product product = new Product();
		Shop shop = new Shop();
		shop.setShopId(1L);
		ProductCategory pCategory = new ProductCategory();
		pCategory.setProductCategoryId(1L);
		product.setShop(shop);
		product.setProductCategory(pCategory);
		product.setProductName("测试商品1");
		product.setProductDesc("测试商品1");
		product.setPriority(20);
		product.setCreateTime(new Date());
		product.setEnableStatus(ProductStateEnum.SUCCESS.getState());
		// 创建缩略图文件流
		File thumbnailFile = new File("C:\\Users\\KeeganRen\\Pictures\\图片1.jpg");
		InputStream isInputStream = new FileInputStream(thumbnailFile);
		ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(), isInputStream);
		// 创建两个商品详情图文件流并将它们添加到详情图列表中
		File productImg1 = new File("C:\\Users\\KeeganRen\\Pictures\\图片1.jpg");
		InputStream is1 = new FileInputStream(productImg1);
		File productImg2 = new File("C:\\Users\\KeeganRen\\Pictures\\生活.jpg");
		InputStream is2 = new FileInputStream(productImg2);
		List<ImageHolder> productImgList = new ArrayList<ImageHolder>();
		productImgList.add(new ImageHolder(productImg1.getName(), is1));
		productImgList.add(new ImageHolder(productImg2.getName(), is2));
		// 添加商品并验证
		ProductExecution pExecution = productService.addProduct(product, thumbnail, productImgList);
		assertEquals(ProductStateEnum.SUCCESS.getState(), pExecution.getState());
		
		
	}
	
	@Test
	public void testModefyProduct() throws ShopOperationException, FileNotFoundException {
		// 创建shopId为1且productCategoryId为1的商品实例并给其成员变量赋值
		Product product = new Product();
		Shop shop = new Shop();
		shop.setShopId(1L);
		ProductCategory pCategory = new ProductCategory();
		pCategory.setProductCategoryId(1L);
		product.setProductId(1L);
		product.setShop(shop);
		product.setProductCategory(pCategory);
		product.setProductName("正式的商品");
		product.setProductDesc("正式的商品");
		// 创建缩略图文件流
		File thumbnailFile = new File("C:\\Users\\KeeganRen\\Pictures\\生活320240.jpg");
		InputStream isStream = new FileInputStream(thumbnailFile);
		ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(), isStream);
		// 创建两个商品详情列表图并将它们添加到详情图列表中
		File productImg1 = new File("C:\\Users\\KeeganRen\\Pictures\\aa.jpg");
		InputStream is1 = new FileInputStream(productImg1);
		File productImg2 = new File("C:\\Users\\KeeganRen\\Pictures\\bb.jpg");
		InputStream is2 = new FileInputStream(productImg2);
		List<ImageHolder> productImgList = new ArrayList<ImageHolder>();
		productImgList.add(new ImageHolder(productImg1.getName(), is1));
		productImgList.add(new ImageHolder(productImg2.getName(), is2));
		// 添加商品验证
		ProductExecution pExecution = productService.modifyProduct(product, thumbnail, productImgList);
		assertEquals(ProductStateEnum.SUCCESS.getState(), pExecution.getState());
	}
	
}
