/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：配置Spring和Junit启动时加载SpringIOC容器
 * @Package: com.imooc.o2o 
 * @author: KeeganRen   
 * @date: 2018年8月13日 下午10:22:41 
 */
package com.imooc.o2o;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class BaseTest {

}
