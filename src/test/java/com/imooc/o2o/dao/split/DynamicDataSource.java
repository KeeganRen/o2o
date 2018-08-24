/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.dao.split 
 * @author: KeeganRen   
 * @date: 2018年8月24日 下午9:51:43 
 */
package com.imooc.o2o.dao.split;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**   
 * @ClassName: DynamicDataSource.java
 * @Description: 数据库读写分离路由
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	/** (non-Javadoc)
	 * @see org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#determineCurrentLookupKey()  
	 * @Function: DynamicDataSource.java
	 * @Description: 该函数的功能描述
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		// TODO Auto-generated method stub
		return DynamicDataSourceHolder.getDBType();
	}

}
