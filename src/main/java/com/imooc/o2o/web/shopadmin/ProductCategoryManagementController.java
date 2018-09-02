/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.web.shopadmin 
 * @author: KeeganRen   
 * @date: 2018年9月2日 下午5:02:37 
 */
package com.imooc.o2o.web.shopadmin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.o2o.dto.Result;
import com.imooc.o2o.entity.ProductCategory;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.enums.ProductCategoryStateEnum;
import com.imooc.o2o.service.ProductCategoryService;

/**   
 * @ClassName: ProductCategoryManagementController.java
 * @Description: 该类的功能描述
 */
@Controller
@RequestMapping("/shopadmin")
public class ProductCategoryManagementController {

	@Autowired
	private ProductCategoryService productCategoryService;
	
	@RequestMapping(value = "/getproductcategorylist", method = RequestMethod.GET)
	@ResponseBody
	private Result<List<ProductCategory>> getProductCategoryList(HttpServletRequest request) {
		
		Shop shop = new Shop();
		shop.setShopId(1L);
		request.getSession().setAttribute("currentShop", shop);
		
		Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
		List<ProductCategory> list = null;
		if (currentShop != null && currentShop.getShopId() > 0) {
			list = productCategoryService.getProductCategoryList(currentShop.getShopId());
			return new Result<List<ProductCategory>>(true, list);
		} else {
			ProductCategoryStateEnum ps = ProductCategoryStateEnum.INNER_ERROR;
			return new Result<List<ProductCategory>>(false, ps.getState(), ps.getStateInfo());
		}
	}
	
}
