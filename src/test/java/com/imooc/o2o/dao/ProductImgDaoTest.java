/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.dao 
 * @author: KeeganRen   
 * @date: 2018年9月8日 下午10:27:56 
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
import com.imooc.o2o.entity.ProductImg;

/**   
 * @ClassName: ProductImgDaoTest.java
 * @Description: 该类的功能描述
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductImgDaoTest extends BaseTest {

	@Autowired
	private ProductImgDao productImgDao;
	
	@Test
	public void testAbatchInsertProductImg() throws Exception {
		
		try {
			ProductImg productImg1 = new ProductImg();
			productImg1.setImgAddr("img1");
			productImg1.setImgDesc("testImg1");
			productImg1.setPriority(1);
			productImg1.setCreateTime(new Date());
			productImg1.setProductId(1L);
			ProductImg productImg2 = new ProductImg();
			productImg2.setImgAddr("img2");
			productImg2.setImgDesc("testImg2");
			productImg2.setPriority(1);
			productImg2.setCreateTime(new Date());
			productImg2.setProductId(1L);
			List<ProductImg> productImgs = new ArrayList<ProductImg>();
			productImgs.add(productImg1);
			productImgs.add(productImg2);
			
			int effectedNum = productImgDao.batchInsertProductImg(productImgs);
			assertEquals(2, effectedNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void testBQueryProductImgList() throws Exception {
		try {
			List<ProductImg> productImgs = productImgDao.queryProductImgList(1L);
			assertEquals(2, productImgs.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void testCDeleteProductImgByProductId() throws Exception {
		try {
			long productId = 1;
			int effectedNum = productImgDao.deleteProductImgByProductId(productId);
			assertEquals(2, effectedNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
