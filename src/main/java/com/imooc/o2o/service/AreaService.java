/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.service 
 * @author: KeeganRen   
 * @date: 2018年8月14日 下午6:39:21 
 */
package com.imooc.o2o.service;

import java.util.List;

import com.imooc.o2o.entity.Area;

/**   
* Copyright: Copyright (c) 2018 ICBC。 All rights reserved.
* 
* @ClassName: AreaService.java
* @Description: 区域-服务接口
*
* @version: v1.0.0
* @author: KeeganRen
* @date: 2018年8月14日 下午6:39:21 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年8月14日     KeeganRen           v1.0.0               修改原因
*/
public interface AreaService {

	List<Area> getAreaList();
	
}
