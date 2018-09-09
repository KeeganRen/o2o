/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.service 
 * @author: KeeganRen   
 * @date: 2018年9月9日 下午2:01:22 
 */
package com.imooc.o2o.service;

import java.util.List;

import com.imooc.o2o.dto.ImageHolder;
import com.imooc.o2o.dto.ProductExecution;
import com.imooc.o2o.entity.Product;
import com.imooc.o2o.exceptions.ProductOperationException;

/**   
 * @ClassName: ProductService.java
 * @Description: 商品模块
 */
public interface ProductService {

	/**
	 * 
	 * @Function: ProductService.java
	 * @Description: 添加商品信息以及图片处理
	 *
	 */
	ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgHolderList)
			throws ProductOperationException;
	
}
