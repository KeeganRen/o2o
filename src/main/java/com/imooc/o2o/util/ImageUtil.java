/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：圖像處理公共類
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

import org.apache.jasper.tagplugins.jstl.core.Out;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {

	//
	private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	
	// 时间格式
	private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	// 随机数对象
	private static final Random r = new Random();
	
	// 生成缩略图
	public static String generateThumbnail(File thumbnail, String targetAddr) {
		
		String realFileName = getRandomFileName();
		String extension = getFileExtension(thumbnail);
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		File dest = new File(PathUtil.getImageBasePath() + relativeAddr);
		
		try {
			Thumbnails.of(thumbnail).size(200, 200)
			.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "watermark.png")), 0.25f)
			.outputQuality(0.8f).toFile(dest);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("创建缩略图失败：" + e.toString());
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

	// 获取输入文件的扩展名(带。)
	// 图片1.jpg -->  .jpg
	private static String getFileExtension(File file) {
		// 
		String originalFileName = file.getName();
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
		
		File fileImg = new File("C:\\Users\\KeeganRen\\Pictures\\图片1.jpg");
		
		System.out.println(getFileExtension(fileImg));
		
		String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		System.out.println("basePath = " + basePath);
		Thumbnails.of(fileImg).size(200, 200).watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.png")), 0.25f)
		.outputQuality(0.8f).toFile("C:\\Users\\KeeganRen\\Pictures\\图片2.jpg");
	}
}
