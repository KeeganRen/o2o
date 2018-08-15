/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.util 
 * @author: KeeganRen   
 * @date: 2018年8月15日 下午9:48:42 
 */
package com.imooc.o2o.util;

import java.io.File;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

/**   
* Copyright: Copyright (c) 2018 ICBC。 All rights reserved.
* 
* @ClassName: ImageUtil.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: KeeganRen
* @date: 2018年8月15日 下午9:48:42 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年8月15日     KeeganRen           v1.0.0               修改原因
*/
public class ImageUtil {

	
	
	
	public static void main(String[] args) throws Exception {
		String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		Thumbnails.of(new File("C:\\Users\\KeeganRen\\Pictures\\图片1.jpg"))
		.size(200, 200).watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.png")), 0.25f)
		.outputQuality(0.8f).toFile("C:\\\\Users\\\\KeeganRen\\\\Pictures\\\\图片2.jpg");;
	}
}
