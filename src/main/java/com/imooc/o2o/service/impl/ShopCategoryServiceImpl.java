/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.service.impl 
 * @author: KeeganRen   
 * @date: 2018年8月18日 下午5:23:05 
 */
package com.imooc.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.o2o.dao.ShopCategoryDao;
import com.imooc.o2o.entity.ShopCategory;
import com.imooc.o2o.service.ShopCategoryService;

/**   
 * @ClassName: ShopCategoryServiceImpl.java
 * @Description: 该类的功能描述
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

	@Autowired
	private ShopCategoryDao shopCategoryDao;
	
	/** (non-Javadoc)
	 * @see com.imooc.o2o.service.ShopCategoryService#getShopCategoryList(com.imooc.o2o.entity.ShopCategory)  
	 * @Function: ShopCategoryServiceImpl.java
	 * @Description: 该函数的功能描述
	 */
	@Override
	public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
		return shopCategoryDao.queryShopCategory(shopCategoryCondition);
	}

}
