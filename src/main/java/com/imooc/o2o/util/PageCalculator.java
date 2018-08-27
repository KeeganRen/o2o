/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.util 
 * @author: KeeganRen   
 * @date: 2018年8月27日 下午11:44:05 
 */
package com.imooc.o2o.util;

/**   
 * @ClassName: PageCalculator.java
 * @Description: 该类的功能描述
 */
public class PageCalculator {

	/**
	 * 
	 * @Function: PageCalculator.java
	 * @Description: 该函数的功能描述
	 *
	 */
	public static int calculateRowIndex(int pageIndex, int pageSize) {
		return (pageIndex > 0) ? (pageIndex - 1) * pageSize : 0;	
	}
	
}
