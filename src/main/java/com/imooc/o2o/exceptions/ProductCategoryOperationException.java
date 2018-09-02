/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.exceptions 
 * @author: KeeganRen   
 * @date: 2018年9月2日 下午10:40:42 
 */
package com.imooc.o2o.exceptions;

/**   
 * @ClassName: ProductCategoryOperationException.java
 * @Description: 该类的功能描述
 */
public class ProductCategoryOperationException extends RuntimeException {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -7758956879714860892L;

	public ProductCategoryOperationException(String msg) {
		super(msg);
	}
	
}
