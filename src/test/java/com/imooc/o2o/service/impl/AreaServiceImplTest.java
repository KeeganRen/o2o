/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.service.impl 
 * @author: KeeganRen   
 * @date: 2018年8月14日 下午6:44:43 
 */
package com.imooc.o2o.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.service.AreaService;

/**   
* Copyright: Copyright (c) 2018 ICBC。 All rights reserved.
* 
* @ClassName: AreaServiceImplTest.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: KeeganRen
* @date: 2018年8月14日 下午6:44:43 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年8月14日     KeeganRen           v1.0.0               修改原因
*/
public class AreaServiceImplTest extends BaseTest {

	@Autowired
	private AreaService areaService;
	
	/**
	 * Test method for {@link com.imooc.o2o.service.impl.AreaServiceImpl#getAreaList()}.
	 */
	@Test
	public void testGetAreaList() {

		List<Area> areaList = areaService.getAreaList();
		assertEquals("西苑", areaList.get(0).getAreaName());
		assertEquals("东苑", areaList.get(1).getAreaName());
	}

}
