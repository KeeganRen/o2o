/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.exceptions 
 * @author: KeeganRen   
 * @date: 2018年9月9日 下午2:03:35 
 */
package com.imooc.o2o.exceptions;

/**   
 * @ClassName: ProductOperationException.java
 * @Description: 该类的功能描述
 */
public class ProductOperationException extends RuntimeException {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -5658071154280254892L;

	public ProductOperationException(String msg) {
		super(msg);
	}
}
