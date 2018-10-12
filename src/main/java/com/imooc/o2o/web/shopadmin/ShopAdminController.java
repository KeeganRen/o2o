/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.web.shopadmin 
 * @author: KeeganRen   
 * @date: 2018年8月18日 下午2:15:55 
 */
package com.imooc.o2o.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**   
 * @ClassName: ShopAdminController.java
 * @Description: 路由，经SpringMVC拼接链接
 */
@Controller
@RequestMapping(value="shopadmin", method= {RequestMethod.GET})
public class ShopAdminController {

	@RequestMapping(value="/shopoperation")
	public String shopOperation() {
		return "shop/shopoperation";
	}
	
	@RequestMapping(value="/shoplist")
	public String shopList() {
		return "shop/shoplist";
	}
	
	@RequestMapping(value="/shopmanagement")
	public String shopManagement() {
		return "shop/shopmanagement";
	}
	
	@RequestMapping(value="/productcategorymanagement", method = RequestMethod.GET)
	public String productCategoryManage() {
		return "shop/productcategorymanagement";
	}
	
	@RequestMapping(value="/productoperation")
	public String productOperation() {
		// 转发至商品添加/编辑页面
		return "shop/productoperation";
	}
	
	@RequestMapping(value="/productmanagement")
	public String productManagement() {
		// 转发至商品管理页面
		return "shop/productmanagement";
	}
}
