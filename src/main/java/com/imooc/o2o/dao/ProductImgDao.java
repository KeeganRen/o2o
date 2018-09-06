/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.dao 
 * @author: KeeganRen   
 * @date: 2018年9月6日 下午11:31:23 
 */
package com.imooc.o2o.dao;

import java.util.List;

import com.imooc.o2o.entity.ProductImg;

/**   
 * @ClassName: ProductImgDao.java
 * @Description: 该类的功能描述
 */
public interface ProductImgDao {

	List<ProductImg> queryProductImgList(long productId);
	
	/**
	 * 
	 * @Function: ProductImgDao.java
	 * @Description: 批量添加商品详情图片
	 *
	 */
	int batchInsertProductImg(List<ProductImg> productImgList);
	
	int deleteProductImgByProductId(long productId);
	
}
