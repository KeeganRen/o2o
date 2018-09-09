/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.service.impl 
 * @author: KeeganRen   
 * @date: 2018年9月9日 下午3:20:35 
 */
package com.imooc.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.o2o.dao.ProductDao;
import com.imooc.o2o.dao.ProductImgDao;
import com.imooc.o2o.dto.ImageHolder;
import com.imooc.o2o.dto.ProductExecution;
import com.imooc.o2o.entity.Product;
import com.imooc.o2o.exceptions.ProductOperationException;
import com.imooc.o2o.service.ProductService;

/**   
 * @ClassName: ProductServiceImpl.java
 * @Description: 该类的功能描述
 */
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ProductImgDao productImgDao;
	
	/** (non-Javadoc)
	 * @see com.imooc.o2o.service.ProductService#addProduct(com.imooc.o2o.entity.Product, com.imooc.o2o.dto.ImageHolder, java.util.List)  
	 * @Function: ProductServiceImpl.java
	 * @Description: 该函数的功能描述
	 */
	@Override
	@Transactional
	public ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList)
			throws ProductOperationException {
		// 1。
		// 2.
		// 3.
		// 4.
		
		
		
		
		return null;
	}

}
