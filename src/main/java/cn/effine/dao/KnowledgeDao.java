package cn.effine.dao;

import java.util.List;
import java.util.Map;

public interface KnowledgeDao {
	/**
	 * 获取：知识分类列表
	 * 
	 * @return 知识分类列表
	 */
	List<Map<String, Object>> getKnowlegeList();
}