/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.service 
 * @author: KeeganRen   
 * @date: 2018年8月17日 下午9:43:57 
 */
package com.imooc.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import com.imooc.o2o.enums.ShopStateEnum;

/**   
 * @ClassName: ShopServiceTest.java
 * @Description: 该类的功能描述
 */
public class ShopServiceTest extends BaseTest {

	@Autowired
	private ShopService shopService;
	
	/**
	 * Test method for {@link com.imooc.o2o.service.ShopService#addShop(com.imooc.o2o.entity.Shop, org.springframework.web.multipart.commons.CommonsMultipartFile)}.
	 */
	@Test
	public void testAddShop() {

		Shop shop = new Shop();
		shop.setShopId(2L);
		PersonInfo personInfo = new PersonInfo();
		personInfo.setUserId(1L);
		shop.setOwner(personInfo);
		Area area = new Area();
		area.setAreaId(2);
		shop.setArea(area);
		ShopCategory shopCategory = new ShopCategory();
		shopCategory.setShopCategoryId(1L);
		shop.setShopCategory(shopCategory);
		shop.setShopName("测试的店铺2");
		shop.setShopDesc("test1");
		shop.setShopAddr("test1");
		shop.setPhone("17826801261");
		shop.setCreateTime(new Date());
		shop.setLastEditTime(new Date());
		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		shop.setAdvice("审核中");
		
		File shopImg = new File("C:\\Users\\KeeganRen\\Pictures\\图片1.jpg");
		
		ShopExecution se = shopService.addShop(shop, shopImg);
		assertEquals(ShopStateEnum.CHECK.getState(), se.getState());

	}

}
