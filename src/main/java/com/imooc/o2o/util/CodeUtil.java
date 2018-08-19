/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.util 
 * @author: KeeganRen   
 * @date: 2018年8月19日 下午3:58:46 
 */
package com.imooc.o2o.util;

import javax.servlet.http.HttpServletRequest;

/**   
 * @ClassName: CodeUtil.java
 * @Description: 该类的功能描述
 */
public class CodeUtil {

	public static boolean chechVerifyCode(HttpServletRequest request) {
		
		String verifyCodeExpected = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		String verifyCodeActual = HttpServletRequestUtil.getString(request, "verifyCodeActual");
		if(verifyCodeActual == null || !verifyCodeActual.equals(verifyCodeExpected)) {
			return false;
		}
		return true;
	}
}
