/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：店铺注册服务类
 * @Package: com.imooc.o2o.service 
 * @author: KeeganRen   
 * @date: 2018年8月16日 下午10:51:49 
 */
package com.imooc.o2o.service;

import java.io.InputStream;

import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.exceptions.ShopOperationException;

public interface ShopService {

	/**
	 * 
	 * @Function: ShopService.java
	 * @Description: 添加店铺
	 *
	 */
	ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;
	
	/**
	 * 
	 * @Function: ShopService.java
	 * @Description: 通过店铺id获取店铺信息
	 *
	 */
	Shop getByShopId(long shopId);
	
	/**
	 * 
	 * @Function: ShopService.java
	 * @Description: 更新店铺信息，包括对图像的处理
	 *
	 */
	ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName) throws Exception;
}
