/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述： 区域-服务接口
 * @Package: com.imooc.o2o.service 
 * @author: KeeganRen   
 * @date: 2018年8月14日 下午6:39:21 
 */
package com.imooc.o2o.service;

import java.util.List;

import com.imooc.o2o.entity.Area;

public interface AreaService {

	List<Area> getAreaList();
	
}
