/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o 
 * @author: KeeganRen   
 * @date: 2018年8月13日 下午10:22:41 
 */
package com.imooc.o2o;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**   
* Copyright: Copyright (c) 2018 ICBC。 All rights reserved.
* 
* @ClassName: BaseTest.java
* @Description: 配置Spring和Junit启动时加载SpringIOC容器
*
* @version: v1.0.0
* @author: KeeganRen
* @date: 2018年8月13日 下午10:22:41 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年8月13日     KeeganRen           v1.0.0               修改原因
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class BaseTest {

}
