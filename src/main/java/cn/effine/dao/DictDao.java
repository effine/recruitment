package cn.effine.dao;

import java.util.List;
import java.util.Map;

/** 字典 */
public interface DictDao {
	/**
	 * 获取: 字典列表(城市city、学历education...)
	 * 
	 * @return 字典列表List<Map<String, Object>>
	 */
	List<Map<String, Object>> getDictList(String dictKey);
}