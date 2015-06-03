/**
 * @Date 2015年1月21日  下午7:45:27
 * @author 张亚飞
 * @email verphen@163.com
 */

package cn.effine.service;

import java.util.Map;

/** 公司   */
public interface CorporationService {

	/**
	 * 公司: 获取
	 *
	 * @param corporationId
	 *            公司ID
	 * @return 公司相关属性
	 */
	Map<String,Object> getCorporation(int corporationId);
}
