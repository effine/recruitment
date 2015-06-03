package cn.effine.dao;

import java.util.List;
import java.util.Map;

import cn.effine.model.Corporation;

/** 公司 */
public interface CorporationDao {

	/**
	 * 公司: 添加
	 *
	 * @param corJob
	 *            公司Model
	 * @return 公司ID
	 */
	int addCorporation(Corporation corporation);

	/**
	 * 公司: 获取
	 *
	 * @param corporationId
	 *            公司ID
	 * @return 公司相关属性
	 */
	Map<String, Object> getCorporation(int corporationId);

	/**
	 * 公司: 获取求职端首页公司列表
	 *
	 * @return 公司列表
	 */
	List<Map<String, Object>> getCorporationList();
}