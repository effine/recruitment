package cn.effine.dao;

import java.util.Map;

import cn.effine.model.CorJob;
import cn.effine.utils.Pagination;

/** 岗位 */
public interface CorJobDao {

	/**
	 * 岗位: 添加
	 *
	 * @param corJob
	 *            岗位Model
	 * @return 岗位ID
	 */
	int addCorJob(CorJob corJob);

	/**
	 * 更新：岗位刷新时间：
	 *
	 * @param jobId
	 *            岗位ID
	 * @param nowTime
	 *            当前时间
	 * @return Boolean
	 */
	boolean updateRefreshTime(int jobId, String nowTime);

	/**
	 * 岗位: 更新岗位状态(删除，上线，下线)
	 *
	 * @param jobId
	 *            岗位ID
	 * @param status
	 *            岗位状态(删除:0，上线:1，下线:2)
	 * @return Boolean
	 */
	boolean updateStatus(int jobId, int status);

	/**
	 * 岗位: 获取岗位信息
	 *
	 * @param jobId
	 *            岗位ID
	 * @return 岗位信息Map
	 */
	Map<String, Object> getJob(int jobId);

	/**
	 * 岗位: 获取岗位及公司信息
	 *
	 * @param jobId
	 *            岗位ID
	 * @return 岗位及公司信息Map
	 */
	Map<String, Object> getCorJob(int jobId);

	/**
	 * 岗位: 岗位列表
	 *
	 * @param corporationId
	 *            公司ID
	 * @param currentPage
	 *            当前页
	 * @return 岗位列表
	 */
	Pagination getJobListByCorId(int corporationId, int currentPage);

	/**
	 * 岗位: 岗位列表
	 *
	 * @param status
	 *            岗位状态(删除，上线，下线)
	 * @param currentPage
	 *            当前页
	 * @return 岗位列表
	 */
	Pagination getJobListByStatus(int status, int currentPage);

	/**
	 * 岗位: 岗位列表(求职端)
	 *
	 * @param currentPage
	 *            当前页
	 * @return 岗位列表
	 */
	Pagination getJobList(int currentPage);
}