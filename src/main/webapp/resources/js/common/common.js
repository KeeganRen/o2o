/**
 * 公共
 */

// 随点击更换验证码
function changeVerifyCode(img) {
	img.src = "../Kaptcha?" + Math.floor(Math.random() * 100);
}

// 解析shopId=店铺ID，获取店铺ID
function getQueryString(name) {
	var reg = new RegExp("(^|&" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null) {
		return decodeURIComponent(r[2]);
	}
	return '';
}