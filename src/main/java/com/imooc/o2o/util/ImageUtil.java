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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.imooc.o2o.entity.PersonInfo;

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
	
	// 生成缩略图
	public static String generateThumbnail(InputStream thumbnailInputStream, String fileName, String targetAddr) {
		
		String realFileName = getRandomFileName();
		String extension = getFileExtension(fileName);
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		File dest = new File(PathUtil.getImageBasePath() + relativeAddr);
		
		try {
			Thumbnails.of(thumbnailInputStream).size(200, 200)
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
	
	private static String getFileExtension(String fileName) {
		// 
		return fileName.substring(fileName.lastIndexOf("."));
	}

	// 生成随机文件名，当前年月日时分秒+5位随机数
	public static String getRandomFileName() {
		// 获取五位随机数
		int rannum = r.nextInt(89999) + 10000;
		String nowTimeStr = sDateFormat.format(new Date());
		return nowTimeStr + rannum;
	}

	//// Sample
	//	CommonsMultipartFile shopImg = null;
	//	CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
	//			request.getSession().getServletContext());
	//	if (commonsMultipartResolver.isMultipart(request)) {
	//		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
	//		shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
	//	} 
	//	File shopImgFile = new File(PathUtil.getImageBasePath() + ImageUtil.getRandomFileName());
	//	try {
	//		shopImgFile.createNewFile();
	//	} catch (IOException e) {
	//		e.printStackTrace();
	//	}
	//	inputStreamToFile(shopImg.getInputStream(), shopImgFile);	
	@SuppressWarnings("unused")
	private static void inputStreamToFile(InputStream ins, File file) {
		FileOutputStream oStream = null;
		try {
			oStream = new FileOutputStream(file);
			int bytesRead = 0;
			byte[] buffer = new byte[1024];
			while ((bytesRead = ins.read(buffer)) != -1) {
				oStream.write(buffer, 0, bytesRead);
			}
		} catch (Exception e) {
			throw new RuntimeException("调用inputStreamToFile产生异常：" + e.getMessage());
		} finally {
			try {
				if (oStream != null) {
					oStream.close();
				}
				if (ins != null) {
					ins.close();
				}
			} catch (IOException e2) {
				throw new RuntimeException("inputStreamToFile关闭IO产生异常：" + e2.getMessage());
			}
		}
	}

	/**
	 * 
	 * @Function: ImageUtil.java
	 * @Description: 判断 storePath 是文件的路径还是目录的路径，
	 *               如果storePath是文件路径则删除该文件，
	 *               如果storePath是目录路径则删除该目录下的所有文件
	 *
	 */
	public static void deleteFileOrPath(String storePath) {
		File fileOrPath = new File(PathUtil.getImageBasePath() + storePath);
		if (fileOrPath.exists()) {
			if (fileOrPath.isDirectory()) {
				File files[] = fileOrPath.listFiles();
				for (int i = 0; i < files.length; i++) {
					files[i].delete();
				}
			}
			fileOrPath.delete();
		}	
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
