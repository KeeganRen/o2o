/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.util 
 * @author: KeeganRen   
 * @date: 2018年8月18日 上午10:43:27 
 */
package com.imooc.o2o.util;

import javax.servlet.http.HttpServletRequest;

/**   
 * @ClassName: HttpServletRequestUtil.java
 * @Description: 该类的功能描述
 */
public class HttpServletRequestUtil {

	public static int getInt(HttpServletRequest request, String key) {
		
		try {
			return Integer.decode(request.getParameter(key));
		} catch (Exception e) {
			return -1;
		}
	}
	
	public static long getLong(HttpServletRequest request, String key) {
		
		try {
			return Long.valueOf(request.getParameter(key));
		} catch (Exception e) {
			return -1;
		}
	}
	
	
	public static Double getDouble(HttpServletRequest request, String key) {
		
		try {
			return Double.valueOf(request.getParameter(key));
		} catch (Exception e) {
			return -1d;
		}
	}
	
	
	public static boolean getBoolean(HttpServletRequest request, String key) {
		
		try {
			return Boolean.valueOf(request.getParameter(key));
		} catch (Exception e) {
			return false;
		}
	}
	
	public static String getString(HttpServletRequest request, String key) {
		
		try {
			String result = request.getParameter(key);
			if (result != null) {
				result = result.trim();
			}
			if("".equals(result)) {
				result = null;
			}
			return result;
		} catch (Exception e) {
			return null;
		}
	}
}
