/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.dao 
 * @author: KeeganRen   
 * @date: 2018年8月13日 下午9:59:59 
 */
package com.imooc.o2o.dao;

import java.util.List;

import com.imooc.o2o.entity.Area;

/**   
* Copyright: Copyright (c) 2018 ICBC。 All rights reserved.
* 
* @ClassName: AreaDao.java
* @Description: 区域实体类的Dao
*
* @version: v1.0.0
* @author: KeeganRen
* @date: 2018年8月13日 下午9:59:59 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年8月13日     KeeganRen           v1.0.0               修改原因
*/
public interface AreaDao {

	/**
	 * 
	* @Function: AreaDao.java
	* @Description: 列出区域列表
	*
	* @param:描述1描述
	* @return：areaList
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: KeeganRen
	* @date: 2018年8月13日 下午10:00:57 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年8月13日     KeeganRen           v1.0.0               修改原因
	 */
	List<Area> queryArea();
	
}
