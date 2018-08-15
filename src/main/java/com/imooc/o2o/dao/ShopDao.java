/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.dao 
 * @author: KeeganRen   
 * @date: 2018年8月15日 下午8:29:28 
 */
package com.imooc.o2o.dao;

import com.imooc.o2o.entity.Shop;

/**   
* Copyright: Copyright (c) 2018 ICBC。 All rights reserved.
* 
* @ClassName: ShopDao.java
* @Description: 店铺实体类-Dao层
*
* @version: v1.0.0
* @author: KeeganRen
* @date: 2018年8月15日 下午8:29:28 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年8月15日     KeeganRen           v1.0.0               修改原因
*/
public interface ShopDao {

	/**
	 * 
	* @Function: ShopDao.java
	* @Description: 新增店铺
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: KeeganRen
	* @date: 2018年8月15日 下午8:31:27 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年8月15日     KeeganRen           v1.0.0               修改原因
	 */
	int insertShop(Shop shop);
	
	/**
	 * 
	* @Function: ShopDao.java
	* @Description: 更新店铺
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: KeeganRen
	* @date: 2018年8月15日 下午9:27:07 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年8月15日     KeeganRen           v1.0.0               修改原因
	 */
	int updateShop(Shop shop);
	
}
