
/**
 * @Date 2015年1月8日  下午3:40:30
 * @author 张亚飞
 * @email verphen@163.com
 */

package cn.effine.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionUtils {
	private static Logger log = LoggerFactory.getLogger(ExceptionUtils.class);

	/**
	 * 异常: 手动抛出
	 * 
	 * @return 输出到日志文件
	 */
	public static void throwException(String msg){
		try {
			throw new Exception(msg);
		} catch (Exception e) {
			log.error(msg, e);
		}
	}
}


