/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.exceptions 
 * @author: KeeganRen   
 * @date: 2018年8月17日 下午9:24:57 
 */
package com.imooc.o2o.exceptions;

/**   
* Copyright: Copyright (c) 2018 ICBC。 All rights reserved.
* 
* @ClassName: ShopOperationException.java
* @Description: 店铺操作异常类
*
* @version: v1.0.0
* @author: KeeganRen
* @date: 2018年8月17日 下午9:24:57 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年8月17日     KeeganRen           v1.0.0               修改原因
*/
public class ShopOperationException extends RuntimeException {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 2361446884822298905L;

	public ShopOperationException(String msg) {
		super(msg);
	}
	
}
