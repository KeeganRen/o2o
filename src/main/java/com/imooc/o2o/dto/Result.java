/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.dto 
 * @author: KeeganRen   
 * @date: 2018年9月2日 下午5:09:51 
 */
package com.imooc.o2o.dto;

/**   
 * @ClassName: Result.java
 * @Description: 封装json对象，所有返回结果都是用它
 */
public class Result<T> {

	// 是否成功
	private boolean success;
	
	// 成功时返回的数据
	private T data;
	
	// 错误信息
	private String errorMsg;
	
	// 错误码
	private int errorCode;

	public Result() {
	}
	
	// 成功时构造器
	public Result(boolean success, T data) {
		this.success = success;
		this.data = data;
	}
	
	// 失败时构造器
	public Result(boolean success, int errorCode, String errorMsg) {
		this.success = success;
		this.errorMsg = errorMsg;
		this.errorCode = errorCode;
	}
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
}
