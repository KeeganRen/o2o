/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.dao 
 * @author: KeeganRen   
 * @date: 2018年8月15日 下午9:04:39 
 */
package com.imooc.o2o.dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;

/**   
* Copyright: Copyright (c) 2018 ICBC。 All rights reserved.
* 
* @ClassName: ShopDaoTest.java
* @Description: 店铺实体类-Dao层-测试案例
*
* @version: v1.0.0
* @author: KeeganRen
* @date: 2018年8月15日 下午9:04:39 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年8月15日     KeeganRen           v1.0.0               修改原因
*/
public class ShopDaoTest extends BaseTest {

	@Autowired
	private ShopDao shopDao;
	
	@Test
	public void testInsertShop() {
			
		PersonInfo personInfo = new PersonInfo();
		personInfo.setUserId(1L);
		Area area = new Area();
		area.setAreaId(2);
		ShopCategory shopCategory = new ShopCategory();
		shopCategory.setShopCategoryId(1L);
		
		Shop shop = new Shop();
		shop.setOwner(personInfo);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("测试的店铺");
		shop.setShopDesc("desc");
		shop.setShopAddr("adrr");
		shop.setPhone("17826801261");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		try {
			int effectedNum = shopDao.insertShop(shop);
			assertEquals(1, effectedNum);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
