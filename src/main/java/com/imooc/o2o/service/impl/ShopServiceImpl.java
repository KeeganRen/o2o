/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.service.impl 
 * @author: KeeganRen   
 * @date: 2018年8月16日 下午10:53:31 
 */
package com.imooc.o2o.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.imooc.o2o.dao.ShopDao;
import com.imooc.o2o.dto.ImageHolder;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.enums.ShopStateEnum;
import com.imooc.o2o.exceptions.ShopOperationException;
import com.imooc.o2o.service.ShopService;
import com.imooc.o2o.util.ImageUtil;
import com.imooc.o2o.util.PageCalculator;
import com.imooc.o2o.util.PathUtil;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao shopDao;
	
	
	/** (non-Javadoc)
	 * @see com.imooc.o2o.service.ShopService#addShop(com.imooc.o2o.entity.Shop, java.io.File)  
	 * @Function: ShopServiceImpl.java
	 * @Description: 添加店铺
	 */
	@Override
	@Transactional
	public ShopExecution addShop(Shop shop, ImageHolder thumbnail)
			throws ShopOperationException {
		// 空店铺判断
		if (shop == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		}
		
		try {
			// 店铺信息赋初始值
			// bug:Column 'owner_id' cannot be null
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			int effectNum = shopDao.insertShop(shop);
			if (effectNum <= 0) {
				// RuntimeException 回滚，Exception 不会回滚
				throw new ShopOperationException("店铺创建失败");
			} else {
				if (thumbnail.getImage() != null) {
					// 存储图片
					try {
						addShopImg(shop, thumbnail);
					} catch (Exception e) {
						throw new ShopOperationException("addShopImg error:" + e.getMessage());
					}
					// TODO: 会出现并发出错问题吗 ？？？？
					// 更新店铺的图片地址
					int effectedNum = shopDao.updateShop(shop);
					if (effectedNum <= 0) {
						throw new ShopOperationException("更新图片地址失败");
					}
				}
			}
		} catch (Exception e) {
			throw new ShopOperationException("addShop error:" + e.getMessage());
		}
		
		return new ShopExecution(ShopStateEnum.CHECK, shop);
	}


	/**   
	 * @Function: ShopServiceImpl.java
	 * @Description: 该函数的功能描述
	 *
	 */
	private void addShopImg(Shop shop, ImageHolder thumbnail) {
		String dest = PathUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr = ImageUtil.generateThumbnail(thumbnail, dest);
		shop.setShopImg(shopImgAddr);
	}


	/** (non-Javadoc)
	 * @see com.imooc.o2o.service.ShopService#getByShopId(long)  
	 * @Function: ShopServiceImpl.java
	 * @Description: 通过店铺id获取店铺信息
	 */
	@Override
	public Shop getByShopId(long shopId) {
		return shopDao.queryByShopId(shopId);
	}


	/** (non-Javadoc)
	 * @see com.imooc.o2o.service.ShopService#modifyShop(com.imooc.o2o.entity.Shop, java.io.InputStream, java.lang.String)  
	 * @Function: ShopServiceImpl.java
	 * @Description: 更新店铺信息，包括对图像的处理
	 */
	@Override
	public ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException {
		
		if (shop == null || shop.getShopId() == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		} else {
			try {
				// 1.判断是否需要处理图片
				if (thumbnail.getImage() != null && thumbnail.getImageName() != null && !"".equals(thumbnail.getImageName())) {
					Shop tempShop = shopDao.queryByShopId(shop.getShopId());
					if (tempShop.getShopImg() != null) {
						ImageUtil.deleteFileOrPath(tempShop.getShopImg());
					}
					addShopImg(shop, thumbnail);
				}
				// 2.更新店铺信息
				shop.setLastEditTime(new Date());
				int effectedNum = shopDao.updateShop(shop);
				if (effectedNum <= 0) {
					return new ShopExecution(ShopStateEnum.INNER_ERROR);
				} else {
					shop = shopDao.queryByShopId(shop.getShopId());
					return new ShopExecution(ShopStateEnum.SUCCESS, shop);
				}
			} catch (Exception e) {
				throw new ShopOperationException("modifyShop error:" + e.getMessage());
			}
		}
	}


	/** (non-Javadoc)
	 * @see com.imooc.o2o.service.ShopService#getShopList(com.imooc.o2o.entity.Shop, int, int)  
	 * @Function: ShopServiceImpl.java
	 * @Description: 该函数的功能描述
	 */
	@Override
	public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize) {
		
		int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
		List<Shop> shopList = shopDao.queryShopList(shopCondition, rowIndex, pageSize);
		int count = shopDao.queryShopCount(shopCondition);
		ShopExecution sExecution = new ShopExecution();
		if (shopList != null) {
			sExecution.setShopList(shopList);
			sExecution.setCount(count);
		} else {
			sExecution.setState(ShopStateEnum.INNER_ERROR.getState());
		}
		return sExecution;
	}

}
