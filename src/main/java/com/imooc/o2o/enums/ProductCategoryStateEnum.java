/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.enums 
 * @author: KeeganRen   
 * @date: 2018年9月2日 下午7:26:46 
 */
package com.imooc.o2o.enums;

/**   
 * @ClassName: ProductCategoryStateEnum.java
 * @Description: 该类的功能描述
 */
public enum ProductCategoryStateEnum {

	SUCCESS(1, "创建成功"), 
	INNER_ERROR(-1001, "操作失败"), 
	EMPTY_LIST(-1002, "添加数少于1");
	
	private int state;
	
	private String stateInfo;

	private ProductCategoryStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}
	
	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public static ProductCategoryStateEnum stateOf(int index) {
		for (ProductCategoryStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}
	
}
