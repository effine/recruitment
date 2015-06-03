package cn.effine.dao;

import cn.effine.utils.Pagination;

/** 岗位申请 */
public interface CorJobRequestDao {

	/**
	 * 更新：简历处理状态
	 *
	 * @param id
	 *            简历申请ID
	 * @param status
	 *            简历处理状态（0:未阅读;1:已阅读；2:不适合；3:已发送面试邀请；4:已删除）
	 * @return Boolean
	 */
	boolean updateResumeStatus(int id, int status);

	/**
	 * 岗位：统计岗位人数
	 *
	 * @param jobId
	 *            岗位ID
	 * @return 岗位求职者总数
	 */
	int countResumeRequestNumber(int jobId);

	/**
	 * 获取：岗位申请列表
	 *
	 * @param status
	 *            简历处理状态（0:未阅读;1:不适合；2:已发送面试邀请；3:已删除）
	 * @param currentPage
	 *            当前页序号
	 * @return 岗位申请列表
	 */
	Pagination getResumeRequestList(int status, int currentPage);
}