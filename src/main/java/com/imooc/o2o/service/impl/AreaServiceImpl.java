/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：区域-服务实现
 * @Package: com.imooc.o2o.service.impl 
 * @author: KeeganRen   
 * @date: 2018年8月14日 下午6:41:07 
 */
package com.imooc.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.o2o.dao.AreaDao;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaDao areaDao;
	
	/** (non-Javadoc)
	 * @see com.imooc.o2o.service.AreaService#getAreaList()  
	 * @Function: AreaServiceImpl.java
	 * @Description: 该函数的功能描述
	 */
	@Override
	public List<Area> getAreaList() {
		// TODO Auto-generated method stub
		return areaDao.queryArea();
	}

}
