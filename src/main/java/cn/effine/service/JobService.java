/**
 * @Date 2015年1月21日  下午7:45:53
 * @author 张亚飞
 * @email verphen@163.com
 */

package cn.effine.service;

import java.util.Map;

import cn.effine.model.CorJob;
import cn.effine.utils.Pagination;

/** 岗位 */
public interface JobService {

	/**
	 * 岗位：添加
	 *
	 * @param job
	 *            岗位Model
	 * @return 岗位ID
	 */
	int addJob(CorJob job);

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
	 * 岗位：发布（页面初始化属性对应列表）
	 *
	 * @return 属性对应列表
	 */
	Map<String, Object> getInitParamList();

	/**
	 * 岗位: 获取岗位信息
	 *
	 * @param jobId
	 *            岗位ID
	 * @return 岗位信息Map
	 */
	Map<String, Object> getJob(int jobId);

	/**
	 * 岗位：获取岗位列表
	 *
	 * @param corporationId
	 *            公司ID
	 * @param currentPage
	 *            当前页
	 * @return 岗位列表
	 */
	Pagination getJobListByCorId(int corporationId, int currentPage);

	/**
	 * 岗位：获取岗位列表
	 *
	 * @param status
	 *            岗位状态(上线<有效职位>：1;已下线：2)
	 * @param currentPage
	 *            当前页
	 * @return 岗位列表
	 */
	Pagination getJobListByStatus(int status, int currentPage);
}
