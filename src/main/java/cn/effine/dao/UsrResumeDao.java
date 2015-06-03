package cn.effine.dao;

import cn.effine.model.UsrResume;

/** 用户简历-基本信息 */
public interface UsrResumeDao {

	/**
	 * 用户简历-基本信息: 获取
	 *
	 * @param id
	 *            用户简历-基本信息 Id
	 * @return 公司ID
	 */
	UsrResume getUsrResume(int id);

}