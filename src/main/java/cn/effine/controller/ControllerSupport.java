/**
 * @Date 2015年1月21日  下午7:38:24
 * @author 张亚飞
 * @email verphen@163.com
 */

package cn.effine.controller;

import javax.servlet.http.HttpServletRequest;

/** Controller层基类 */
public class ControllerSupport {

	/**
	 * 判断用户是否登录
	 *
	 * @return
	 */
	public boolean isLogin(HttpServletRequest request) {
		return true;
	}

}
