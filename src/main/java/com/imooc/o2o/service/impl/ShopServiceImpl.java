/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.service.impl 
 * @author: KeeganRen   
 * @date: 2018年8月16日 下午10:53:31 
 */
package com.imooc.o2o.service.impl;

import java.io.File;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.imooc.o2o.dao.ShopDao;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.enums.ShopStateEnum;
import com.imooc.o2o.exceptions.ShopOperationException;
import com.imooc.o2o.service.ShopService;
import com.imooc.o2o.util.ImageUtil;
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
	public ShopExecution addShop(Shop shop, File shopImg) {
		// 空店铺判断
		if (shop == null) {
			return new ShopExecution(ShopStateEnum.NULLSHOP);
		}
		
		try {
			// 店铺信息赋初始值
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			int effectNum = shopDao.insertShop(shop);
			if (effectNum <= 0) {
				// RuntimeException 回滚，Exception 不会回滚
				throw new ShopOperationException("店铺创建失败");
			} else {
				if (shopImg != null) {
					// 存储图片
					try {
						addShopImg(shop, shopImg);
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
	private void addShopImg(Shop shop, File shopImg) {
		String dest = PathUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr = ImageUtil.generateThumbnail(shopImg, dest);
		shop.setShopImg(shopImgAddr);
	}

}
