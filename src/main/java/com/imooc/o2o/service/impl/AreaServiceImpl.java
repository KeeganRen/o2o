/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
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

/**   
* Copyright: Copyright (c) 2018 ICBC。 All rights reserved.
* 
* @ClassName: AreaServiceImpl.java
* @Description: 区域-服务实现
*
* @version: v1.0.0
* @author: KeeganRen
* @date: 2018年8月14日 下午6:41:07 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年8月14日     KeeganRen           v1.0.0               修改原因
*/
@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaDao areaDao;
	
	/** (non-Javadoc)
	* @see com.imooc.o2o.service.AreaService#getAreaList()  
	* @Function: AreaServiceImpl.java
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: KeeganRen
	* @date: 2018年8月14日 下午6:41:07 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年8月14日     KeeganRen           v1.0.0               修改原因
	*/
	@Override
	public List<Area> getAreaList() {
		// TODO Auto-generated method stub
		return areaDao.queryArea();
	}

}
