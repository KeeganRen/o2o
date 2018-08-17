/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：店铺实体类-Dao层
 * @Package: com.imooc.o2o.dao 
 * @author: KeeganRen   
 * @date: 2018年8月15日 下午8:29:28 
 */
package com.imooc.o2o.dao;

import com.imooc.o2o.entity.Shop;

public interface ShopDao {

	/**
	 * 
	 * @Function: ShopDao.java
	 * @Description: 新增店铺
	 */
	int insertShop(Shop shop);
	
	/**
	 * 
	 * @Function: ShopDao.java
	 * @Description: 更新店铺
	 *
	 */
	int updateShop(Shop shop);
	
}
