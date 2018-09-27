/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.service.impl 
 * @author: KeeganRen   
 * @date: 2018年9月9日 下午3:20:35 
 */
package com.imooc.o2o.service.impl;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.o2o.dao.ProductDao;
import com.imooc.o2o.dao.ProductImgDao;
import com.imooc.o2o.dto.ImageHolder;
import com.imooc.o2o.dto.ProductExecution;
import com.imooc.o2o.entity.Product;
import com.imooc.o2o.entity.ProductImg;
import com.imooc.o2o.enums.ProductStateEnum;
import com.imooc.o2o.exceptions.ProductOperationException;
import com.imooc.o2o.service.ProductService;
import com.imooc.o2o.util.ImageUtil;
import com.imooc.o2o.util.PathUtil;

/**   
 * @ClassName: ProductServiceImpl.java
 * @Description: 该类的功能描述
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ProductImgDao productImgDao;
	
	/** (non-Javadoc)
	 * @see com.imooc.o2o.service.ProductService#addProduct(com.imooc.o2o.entity.Product, com.imooc.o2o.dto.ImageHolder, java.util.List)  
	 * @Function: ProductServiceImpl.java
	 * @Description: 该函数的功能描述
	 * 
	 * 1。处理缩略图、获取缩略图相对路劲并赋值给product
	 * 2。往tb_product写入商品信息、获取productId
	 * 3。结合productId批量处理商品详情图
	 * 4。将商品详情图列表批量插入tb_product_img中
	 * 
	 */
	@Override
	@Transactional
	public ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgHolderList)
			throws ProductOperationException {

		// 空值判断
		if(product != null && product.getShop() != null && product.getShop().getShopId() != null) {
			// 给商品设置成默认属性
			product.setCreateTime(new Date());
			product.setLastEditTime(new Date());
			// 默认为上架的状态
			product.setEnableStatus(1);
			// 若商品缩略图不为空则添加
			if (thumbnail != null) {
				addThumbnail(product, thumbnail);
			}
			try {
				// 创建商品信息
				int effectedNum = productDao.insertProduct(product);
				if (effectedNum <= 0) {
					throw new ProductOperationException("创建商品失败");
				}
			} catch (Exception e) {
				throw new ProductOperationException("创建商品失败" + e.toString());
			}
			// 若商品详情图不为空则添加
			if (productImgHolderList != null && productImgHolderList.size() > 0) {
				addProductImgList(product, productImgHolderList);
			}
			return new ProductExecution(ProductStateEnum.SUCCESS, product);	
		} else {
			return new ProductExecution(ProductStateEnum.EMPTY);
		}
	}

	/**
	 * 
	 * @Function: ProductServiceImpl.java
	 * @Description: 添加缩略图
	 *
	 */
	private void addThumbnail(Product product, ImageHolder thumbnail) {
		String dest = PathUtil.getShopImagePath(product.getShop().getShopId());
		String thumbnailAddr = ImageUtil.generateThumbnail(thumbnail, dest);
		product.setImgAddr(thumbnailAddr);
	}
	
	/**
	 * 
	 * @Function: ProductServiceImpl.java
	 * @Description: 批量添加图片
	 *
	 */
	private void addProductImgList(Product product, List<ImageHolder> productImgHolderList) {
		// 获取图片的存储路径，这里直接存放到相应店铺的文件夹下
		String dest = PathUtil.getShopImagePath(product.getShop().getShopId());
		List<ProductImg> productImgList = new ArrayList<ProductImg>();
		// 
		for (ImageHolder productImgHolder : productImgHolderList) {
			String imgAddr = ImageUtil.generateNormalThumbnail(productImgHolder, dest);
			ProductImg productImg = new ProductImg();
			productImg.setImgAddr(imgAddr);
			// TODO: Column 'img_desc' cannot be null
			productImg.setImgDesc("TODO");
			productImg.setProductId(product.getProductId());
			productImg.setCreateTime(new Date());
			productImgList.add(productImg);
		}
		//
		if (productImgList.size() > 0) {
			try {
				int effectedNum = productImgDao.batchInsertProductImg(productImgList);
				if (effectedNum <= 0) {
					throw new ProductOperationException("创建商品详情图片失败");
				}
			} catch (Exception e) {
				throw new ProductOperationException("创建商品详情图片失败" + e.toString());
			}
		}
	}

	/** (non-Javadoc)
	 * @see com.imooc.o2o.service.ProductService#getProductById(long)  
	 * @Function: ProductServiceImpl.java
	 * @Description: 通过商品ID查询唯一的商品信息
	 */
	@Override
	public Product getProductById(long productId) {
		return productDao.queryProductByProductId(productId);
	}

	/** (non-Javadoc)
	 * @see com.imooc.o2o.service.ProductService#modifyProduct(com.imooc.o2o.entity.Product, com.imooc.o2o.dto.ImageHolder, java.util.List)  
	 * @Function: ProductServiceImpl.java
	 * @Description: 修改商品信息以及图片处理
	 * 
	 * 1.若缩略图参数有值，则处理缩略图；若原本存有缩略图则先删除原缩略图再添加新图，之后获取缩略图的相对路径，并赋值给product
	 * 2.若商品详情图列表参数有值，则对商品详情图列表进行同样的操作
	 * 3.将tb_product_img下面的该商品原先的商品详情图记录全部清除
	 * 4.更细tb_product的信息
	 * 
	 */
	@Override
	@Transactional
	public ProductExecution modifyProduct(Product product, ImageHolder thumbnail,
			List<ImageHolder> productImgHolderList) throws ProductOperationException {
		
		// 空值判断
		if (product != null && product.getShop() != null && product.getShop().getShopId() != null) {
			// 设置商品默认属性
			product.setLastEditTime(new Date());
			// 若商品缩略图不为空且原有缩略图不为空则删除原有缩略图并添加新图
			if (thumbnail != null) {
				// 读取原有信息，因为原本信息中存在原图地址
				Product tempProduct = productDao.queryProductByProductId(product.getProductId());
				if(tempProduct.getImgAddr() != null) {
					ImageUtil.deleteFileOrPath(tempProduct.getImgAddr());
				}
				addThumbnail(product, thumbnail);
			}
			// 如果有新存入的商品详情图，则将原本的删除，并添加新图片
			if (productImgHolderList != null && productImgHolderList.size() > 0) {
				deleteProductImgList(product.getProductId());
				addProductImgList(product, productImgHolderList);
			}
			
			try {
				// 更新商品信息
				int effectedNum = productDao.updateProduct(product);
				if (effectedNum <= 0) {
					throw new ProductOperationException("更新商品信息失败");
				}
				return new ProductExecution(ProductStateEnum.SUCCESS, product);
			} catch (Exception e) {
				throw new ProductOperationException("更新商品信息失败" + e.toString());
			}
		} else {
			return new ProductExecution(ProductStateEnum.EMPTY);
		}
	}
	
	/**
	 * 
	 * @Function: ProductServiceImpl.java
	 * @Description: 删除某个商品下的所有详情图
	 *
	 */
	private void deleteProductImgList(long productId) {
		// 根据productId获取原来的图片
		List<ProductImg> productImgs = productImgDao.queryProductImgList(productId);
		// 删除旧图片
		for (ProductImg productImg : productImgs) {
			ImageUtil.deleteFileOrPath(productImg.getImgAddr());
		}
		// 删除数据库中旧图片的信息
		productImgDao.deleteProductImgByProductId(productId);
	}
	
}
