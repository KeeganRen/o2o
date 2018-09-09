/**   
 * Copyright © 2018 ICBC. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.imooc.o2o.dto 
 * @author: KeeganRen   
 * @date: 2018年9月9日 下午2:27:07 
 */
package com.imooc.o2o.dto;

import java.io.InputStream;

/**   
 * @ClassName: ImageHolder.java
 * @Description: 该类的功能描述
 */
public class ImageHolder {

	
	private String imageName;
	private InputStream image;
	
	public ImageHolder(String imageName, InputStream image) {
		this.imageName = imageName;
		this.image = image;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public InputStream getImage() {
		return image;
	}

	public void setImage(InputStream image) {
		this.image = image;
	}
}
