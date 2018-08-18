/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.dao 
 * @author: KeeganRen   
 * @date: 2018年8月18日 下午4:31:04 
 */
package com.imooc.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imooc.o2o.entity.ShopCategory;

/**
 * @ClassName: ShopCategoryDao.java
 * @Description: 该类的功能描述
 */
public interface ShopCategoryDao {

	//
	List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategoryCondition);
}
