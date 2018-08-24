/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.dao.split 
 * @author: KeeganRen   
 * @date: 2018年8月24日 下午9:55:25 
 */
package com.imooc.o2o.dao.split;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**   
 * @ClassName: DynamicDataSourceHolder.java
 * @Description: 该类的功能描述
 */
public class DynamicDataSourceHolder {
	private static Logger logger = LoggerFactory.getLogger(DynamicDataSourceHolder.class);
	// 线程安全
	private static ThreadLocal<String> contextHolder = new ThreadLocal<String>();
	
	public static final String DB_MASTER = "master";
	public static final String DB_SLAVE = "slave";
	
	// 获取线程的dbType
	public static String getDBType() {
		String db = contextHolder.get();
		if (db == null) {
			db = DB_MASTER;
		}
		return db;
	}
	
	// 设置线程的dbType
	public static void setDBType(String db) {
		logger.debug("所使用的数据源为：" + db);
		contextHolder.set(db);
		return;
	}
	
	// 清理连接类型
	public static void clearDBType() {
		contextHolder.remove();
	}
	
}
