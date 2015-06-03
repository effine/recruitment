/**
 * @Date 2015年1月21日  下午7:44:08
 * @author 张亚飞
 * @email verphen@163.com
 */

package cn.effine.service;

import cn.effine.model.CorJobReqInvitation;
import cn.effine.utils.Pagination;

public interface ResumeService {

	/**
	 * 添加：面试邀请
	 *
	 * @param invitation
	 *            面试邀请Model
	 * @return Boolean
	 */
	boolean addInterview(CorJobReqInvitation invitation);

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
	 * 更新：简历处理状态(全选操作)
	 *
	 * @param ids
	 *            简历申请ID数组
	 * @param status
	 *            简历处理状态（0:未阅读;1:已阅读；2:不适合；3:已发送面试邀请；4:已删除）
	 * @return Boolean
	 */
	boolean updateResumeStatus(int[] ids, int status);

	/**
	 * 获取：简历申请列表
	 *
	 * @param status
	 *            简历处理状态（0:未阅读;1:不适合；2:已发送面试邀请；3:已删除）
	 * @param currentPage
	 *            当前页序号
	 * @return 简历申请列表
	 */
	Pagination getResumeList(int status, int currentPage);

	/**
	 * 获取：面试简历列表
	 *
	 * @param corporationId
	 *            公司ID
	 * @param timeLimit
	 *            时间界限
	 * @param currentPage
	 *            当前页序号
	 * @return 面试简历列表
	 */
	Pagination getInterviewList(int corporationId, int timeLimit, int currentPage);
}
