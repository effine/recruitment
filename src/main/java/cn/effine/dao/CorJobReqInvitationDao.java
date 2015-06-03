package cn.effine.dao;

import cn.effine.model.CorJobReqInvitation;
import cn.effine.utils.Pagination;

/** 面试 */
public interface CorJobReqInvitationDao {

	/**
	 * 面试邀请: 添加
	 *
	 * @param invitation
	 *            面试Model
	 * @return 面试ID
	 */
	int addInvation(CorJobReqInvitation invitation);

	/**
	 * 面试邀请： 获取简历列表
	 *
	 * @param corporationId
	 *            公司ID
	 * @param timeLimit
	 *            时间界限
	 * @param currentPage
	 *            当前页码
	 * @return 面试简历列表
	 */
	Pagination getInvatation(int corporationId, int timeLimit, int currentPage);

}