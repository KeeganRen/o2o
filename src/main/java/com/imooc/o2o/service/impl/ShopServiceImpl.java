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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.imooc.o2o.dao.ShopDao;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.enums.ShopStateEnum;
import com.imooc.o2o.service.ShopService;
import com.imooc.o2o.util.ImageUtil;
import com.imooc.o2o.util.PathUtil;

/**   
* Copyright: Copyright (c) 2018 ICBC。 All rights reserved.
* 
* @ClassName: ShopServiceImpl.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: KeeganRen
* @date: 2018年8月16日 下午10:53:31 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年8月16日     KeeganRen           v1.0.0               修改原因
*/
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao shopDao;
	
	
	/** (non-Javadoc)
	* @see com.imooc.o2o.service.ShopService#addShop(com.imooc.o2o.entity.Shop, java.io.File)  
	* @Function: ShopServiceImpl.java
	* @Description: 添加店铺
	*
	* @param: Shop shop 店铺, File shopImg 店铺图像
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: KeeganRen
	* @date: 2018年8月16日 下午10:53:31 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年8月16日     KeeganRen           v1.0.0               修改原因
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
				throw new RuntimeException("店铺创建失败");
			} else {
				if (shopImg != null) {
					// 存储图片
					try {
						addShopImg(shop, shopImg);
					} catch (Exception e) {
						throw new RuntimeException("addShopImg error:" + e.getMessage());
					}
					// TODO: 会出现并发出错问题吗 ？？？？
					// 更新店铺的图片地址
					int effectedNum = shopDao.updateShop(shop);
					if (effectedNum <= 0) {
						throw new RuntimeException("更新图片地址失败");
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("addShop error:" + e.getMessage());
		}
		
		return null;
	}


	/**   
	* @Function: ShopServiceImpl.java
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: KeeganRen
	* @date: 2018年8月16日 下午11:21:14 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年8月16日     KeeganRen           v1.0.0               修改原因
	*/
	private void addShopImg(Shop shop, File shopImg) {
		// 获取shop图片目录相对值路径
		String dest = PathUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr = ImageUtil.generateThumbnail(shopImg, dest);
	}
	
	private void addShopImg(Shop shop, CommonsMultipartFile shopImg) {
		String dest = PathUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr = ImageUtil.generateThumbnail(shopImg, dest);
		shop.setShopImg(shopImgAddr);
	}

}
