/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.service 
 * @author: KeeganRen   
 * @date: 2018年8月18日 下午5:21:27 
 */
package com.imooc.o2o.service;

import java.util.List;

import com.imooc.o2o.entity.ShopCategory;

/**   
 * @ClassName: ShopCategoryService.java
 * @Description: 该类的功能描述
 */
public interface ShopCategoryService {

	/**
	 * 根据查询条件获取ShopCategory列表
	 * @param shopCategoryCondition
	 * @return
	 */
	List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
