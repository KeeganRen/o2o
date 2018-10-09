/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：路径处理基础类
 * @Package: com.imooc.o2o.util 
 * @author: KeeganRen   
 * @date: 2018年8月15日 下午10:02:39 
 */
package com.imooc.o2o.util;

public class PathUtil {

	// 系统分隔符
	// win --> \\
	// Linux/Mac --> /
	private static String separator = System.getProperty("file.separator");
	
	// 获取图像路径
	public static String getImageBasePath() {
		String os = System.getProperty("os.name");
		String basePath = "";
		if (os.toLowerCase().startsWith("win")) {
			basePath = "G:/projectdev/image/";
		} else {
			basePath = "/Users/keegan/Programs/JavaWeb/Git/image/";
		}
		basePath = basePath.replace("/", separator);
		return basePath;
	}
	
	// 店铺图片存储路径
	public static String getShopImagePath(long shopId) {
		String imagePath = "upload/item/shop/" + shopId + "/";
		return imagePath.replace("/", separator);
	}
	
	/**   
	* @Function: PathUtil.java
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: KeeganRen
	* @date: 2018年8月15日 下午10:02:39 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年8月15日     KeeganRen           v1.0.0               修改原因
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String imgBasePath = getImageBasePath();
		String shopImgPath = getShopImagePath(11);
		System.out.println("separator = " + separator);
		System.out.println("imgBasePath = " + imgBasePath);
		System.out.println("shopImgPath = " + shopImgPath);
	}

}
