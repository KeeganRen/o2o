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
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

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

	//
	private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	
	// 时间格式
	private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	// 随机数对象
	private static final Random r = new Random();
	
	// 生成缩略图
	public static String generateThumbnail(CommonsMultipartFile thumbnail, String targetAddr) {
		
		String realFileName = getRandomFileName();
		String extension = getFileExtension(thumbnail);
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		File dest = new File(PathUtil.getImageBasePath() + relativeAddr);
		
		try {
			Thumbnails.of(thumbnail.getInputStream()).size(200, 200)
			.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "watermark.jpg")), 0.25f)
			.outputQuality(0.8f).toFile(dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return relativeAddr;
	}
	
	// 创建文件夹
	private static void makeDirPath(String targetAddr) {
		String realFileParentPath = PathUtil.getImageBasePath() + targetAddr;
		File dirPath = new File(realFileParentPath);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}

	// 获取输入文件的扩展名
	private static String getFileExtension(CommonsMultipartFile cMFile) {
		// 
		String originalFileName = cMFile.getOriginalFilename();
		return originalFileName.substring(originalFileName.lastIndexOf("."));
	}

	// 生成随机文件名，当前年月日时分秒+5位随机数
	private static String getRandomFileName() {
		// 获取五位随机数
		int rannum = r.nextInt(89999) + 10000;
		String nowTimeStr = sDateFormat.format(new Date());
		return nowTimeStr + rannum;
	}


	public static void main(String[] args) throws Exception {
		String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		Thumbnails.of(new File("C:\\Users\\KeeganRen\\Pictures\\图片1.jpg"))
		.size(200, 200).watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.png")), 0.25f)
		.outputQuality(0.8f).toFile("C:\\\\Users\\\\KeeganRen\\\\Pictures\\\\图片2.jpg");;
	}
}
