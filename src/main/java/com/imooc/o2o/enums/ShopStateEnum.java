/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.enums 
 * @author: KeeganRen   
 * @date: 2018年8月16日 下午10:33:56 
 */
package com.imooc.o2o.enums;

/**   
* Copyright: Copyright (c) 2018 ICBC。 All rights reserved.
* 
* @ClassName: ShopStateEnum.java
* @Description: 店铺状态枚举
*
* @version: v1.0.0
* @author: KeeganRen
* @date: 2018年8月16日 下午10:33:56 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年8月16日     KeeganRen           v1.0.0               修改原因
*/
public enum ShopStateEnum {
	
	CHECK(0, "审核中"), 
	OFFLINE(-1, "非法店铺"), 
	SUCESS(1, "操作成功"), 
	PASS(2, "通过认证"), 
	INNER_ERROR(-1001, "内部系统错误"),
	NULL_SHOPID(-1002, "ShopId为空");
	
	private int state;
	private String stateInfo;
	
	private ShopStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}
	
	// 根据传入state返回相应的enum值
	public static ShopStateEnum stateOf(int state) {
		for (ShopStateEnum stateEnum : values() ) {
			if (stateEnum.getState() == state) {
				return stateEnum;
			}
		}
		return null;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}
}
