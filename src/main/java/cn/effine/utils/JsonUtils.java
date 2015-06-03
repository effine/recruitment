/**
 * @Date 2014年10月17日  下午2:39:51
 * @author 张亚飞
 * @Copyright 云路科技  ©2014
 */

package cn.effine.utils;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @Desc JSON 封装类(采用fastjson实现)
 */
public class JsonUtils {
	/**
	 * 对象转换成json
	 * 
	 * @param obj
	 *            Object对象
	 * @return String
	 */
	public static String objectToJSONString(Object obj) {
		return JSON.toJSONString(obj);
	}

	/**
	 * List转换成json(空值返回"")
	 * 
	 * @param obj
	 *            List对象
	 * @return String
	 */
	public static String listToJSONString(List<?> list) {
		// TODO effine Model转换成json时,空字符串转换成""
		return JSON.toJSONString(list, SerializerFeature.WriteNullListAsEmpty);
	}

	/**
	 * Map转换成json(空值返回"")
	 * 
	 * @param obj
	 *            Map对象
	 * @return String
	 */
	public static String mapToJSONString(Map<String, Object> map) {
		// TODO effine Model转换成json时,空字符串转换成""
		return JSON.toJSONString(map, SerializerFeature.WriteNullStringAsEmpty);
	}
}
