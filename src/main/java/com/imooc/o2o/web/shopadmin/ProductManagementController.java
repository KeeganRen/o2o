/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.web.shopadmin 
 * @author: KeeganRen   
 * @date: 2018年9月9日 下午9:20:27 
 */
package com.imooc.o2o.web.shopadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.o2o.dto.ImageHolder;
import com.imooc.o2o.entity.Product;
import com.imooc.o2o.service.ProductService;
import com.imooc.o2o.util.CodeUtil;
import com.imooc.o2o.util.HttpServletRequestUtil;

/**   
 * @ClassName: ProductManagementController.java
 * @Description: 该类的功能描述
 */
@Controller
@RequestMapping("/shopadmin")
public class ProductManagementController {

	@Autowired
	private ProductService productService;
	
	// 支持上传商品详情图的最大数量
	private static final int IMAGEMAXCOUNT = 6;
	
	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> addProduct(HttpServletRequest request) {
		
		Map<String, Object> modelMap = new HashMap<String, Object>();		
		// 验证码校验
		if (!CodeUtil.chechVerifyCode(request)) {
			modelMap.put("success", false);
			modelMap.put("errMsg", "输入了错误的验证码");
			return modelMap;
		}
		// 接收前端参数的变量的初始化，包括商品、缩略图、
		ObjectMapper mapper = new ObjectMapper();
		Product product = null;
		String productStr = HttpServletRequestUtil.getString(request, "productStr");
		MultipartHttpServletRequest multipartHttpServletRequest = null;
		ImageHolder thumbnail = null;
		List<ImageHolder> productImgList = new ArrayList<ImageHolder>();
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		try {
			// 若请求中存在文件流，则取出相关的文件(包括缩略图和详情图)
			if (multipartResolver.isMultipart(request)) {
				multipartHttpServletRequest = (MultipartHttpServletRequest) request;
				// 取出缩略图并构建ImageHolder对象
				CommonsMultipartFile thumbnailFile = (CommonsMultipartFile) multipartHttpServletRequest.getFile("thumbnail");
				thumbnail = new ImageHolder(thumbnailFile.getOriginalFilename(), thumbnailFile.getInputStream());
				// 取出详情图列表并构建List<ImageHolder>列表对象，最多支持六张图上传
				for (int i = 0; i < IMAGEMAXCOUNT; i++) {
					CommonsMultipartFile productImgFile = (CommonsMultipartFile) multipartHttpServletRequest.getFile("productImg" + i);
					if (productImgFile != null) {
						// 若取出的第i个详情图片文件流不为空，则将其加入详情图列表
						ImageHolder productImg = new ImageHolder(productImgFile.getOriginalFilename(), productImgFile.getInputStream());
						productImgList.add(productImg);
					} else {
						// 若取出来的第i个详情图片文件流为空，则终止循环
						break;
					}
				}
			} else {
				modelMap.put("success", false);
				modelMap.put("errMsg", "上传图片不能为空");
				return modelMap;
			}
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
			return modelMap;
		}
		
		// TODO：获取前端传入的表单String流并将其转换成Product实体类
		
		return modelMap;
	}
}
