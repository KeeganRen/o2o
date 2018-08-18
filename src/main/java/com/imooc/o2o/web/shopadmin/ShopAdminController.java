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
 * @Description: 该类的功能描述
 */
@Controller
@RequestMapping(value="shopadmin", method= {RequestMethod.GET})
public class ShopAdminController {

	@RequestMapping(value="/shopoperation")
	public String shopOperation() {
		return "shop/shopoperation";
	}
	
}