/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.service 
 * @author: KeeganRen   
 * @date: 2018年8月16日 下午10:51:49 
 */
package com.imooc.o2o.service;

import java.io.File;

import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;

/**   
* Copyright: Copyright (c) 2018 ICBC。 All rights reserved.
* 
* @ClassName: ShopService.java
* @Description: 店铺注册服务类
*
* @version: v1.0.0
* @author: KeeganRen
* @date: 2018年8月16日 下午10:51:49 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年8月16日     KeeganRen           v1.0.0               修改原因
*/
public interface ShopService {

	ShopExecution addShop(Shop shop, File shopImg);
	
}
