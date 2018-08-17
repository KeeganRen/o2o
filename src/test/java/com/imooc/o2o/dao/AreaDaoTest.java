/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：区域实体类的Dao-测试案例
 * @Package: com.imooc.o2o.dao 
 * @author: KeeganRen   
 * @date: 2018年8月13日 下午10:20:23 
 */
package com.imooc.o2o.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;

/**   
 * @ClassName: AreaDaoTest.java
 * @Description: 该类的功能描述
 */
public class AreaDaoTest extends BaseTest {

	@Autowired
	private AreaDao areaDao;
	
	@Test
	public void testQueryArea() {
		List<Area> areaList = areaDao.queryArea();
		assertEquals(2, areaList.size());
	}

}
