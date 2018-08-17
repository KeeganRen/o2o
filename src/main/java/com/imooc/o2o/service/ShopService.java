/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：店铺注册服务类
 * @Package: com.imooc.o2o.service 
 * @author: KeeganRen   
 * @date: 2018年8月16日 下午10:51:49 
 */
package com.imooc.o2o.service;

import java.io.File;

import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;

public interface ShopService {

	ShopExecution addShop(Shop shop, File shopImg);
	
}
