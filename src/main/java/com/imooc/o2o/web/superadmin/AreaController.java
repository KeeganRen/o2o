/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.web.superadmin 
 * @author: KeeganRen   
 * @date: 2018年8月14日 下午6:58:21 
 */
package com.imooc.o2o.web.superadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.o2o.entity.Area;
import com.imooc.o2o.service.AreaService;

/**   
* Copyright: Copyright (c) 2018 ICBC。 All rights reserved.
* 
* @ClassName: AreaController.java
* @Description: 区域-Controller
*
* @version: v1.0.0
* @author: KeeganRen
* @date: 2018年8月14日 下午6:58:21 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年8月14日     KeeganRen           v1.0.0               修改原因
*/
@Controller
@RequestMapping("/superadmin")
public class AreaController {

	Logger logger = LoggerFactory.getLogger(AreaController.class);
	
	@Autowired
	private AreaService areaService;
	
	// 访问主目录的方法
	@RequestMapping(value = "/listarea", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> listArea() {
		logger.info("===start===");
		long startTime = System.currentTimeMillis();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Area> listArea = new ArrayList<Area>();
		
		try {
			listArea = areaService.getAreaList();
			modelMap.put("success", true);
			modelMap.put("errMsg", null);
			modelMap.put("rows", listArea);
			modelMap.put("total", listArea.size());
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
			logger.error("error:", e.toString());
		}
		long endTime = System.currentTimeMillis();
		logger.info("costTime:[{}ms]", endTime-startTime);
		logger.info("===end===");
		return modelMap;
	}
}
