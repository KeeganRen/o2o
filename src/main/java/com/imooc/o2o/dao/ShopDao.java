/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：店铺实体类-Dao层
 * @Package: com.imooc.o2o.dao 
 * @author: KeeganRen   
 * @date: 2018年8月15日 下午8:29:28 
 */
package com.imooc.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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

	/**
	 * 
	 * @Function: ShopDao.java
	 * @Description: 根据店铺id查询店铺信息
	 *
	 */
	Shop queryByShopId(@Param(value = "shopId") long shopId);

	/**
	 * 
	 * @Function: ShopDao.java
	 * @Description: 店铺分页查询，可输入条件：店铺名(模糊),店铺状态,店铺类别,区域Id,owner
	 * @param shopCondition:
	 * @param rowIndex:从第几行开始取数据
	 * @param pageSize：返回的条数
	 *
	 */
	List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition, @Param("rowIndex") int rowIndex,
			@Param("pageSize") int pageSize);
	
	/**
	 * 
	 * @Function: ShopDao.java
	 * @Description: 返回queryShopList的条目数
	 *
	 */
	int queryShopCount(@Param("shopCondition") Shop shopCondition);
}
