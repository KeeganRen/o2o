/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：区域实体类的Dao
 * @Package: com.imooc.o2o.dao 
 * @author: KeeganRen   
 * @date: 2018年8月13日 下午9:59:59 
 */
package com.imooc.o2o.dao;

import java.util.List;

import com.imooc.o2o.entity.Area;

public interface AreaDao {

	/**
	 * 
	 * @Function: AreaDao.java
	 * @Description: 列出区域列表
	 *
	 */
	List<Area> queryArea();
	
}
