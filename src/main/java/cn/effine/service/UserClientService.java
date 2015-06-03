/**
 * @Date 2015年1月26日  上午11:24:57
 * @author 张亚飞
 * @email verphen@163.com
 */

package cn.effine.service;

import java.util.Map;

import cn.effine.utils.Pagination;

/** 面向求职者使用端 */
public interface UserClientService {

	/**
	 * 获取：岗位页面显示属性(岗位及公司信息)
	 *
	 * @param jobId
	 *            岗位ID
	 * @return 岗位页面相关属性(岗位及公司信息)
	 */
	Map<String, Object> getCorJob(int jobId);

	/**
	 * 获取：求职端首页初始化页面属性（岗位、学历、薪资、规模、地域）
	 *
	 * @return 页面属性对应列表
	 */
	Map<String, Object> getInitParamList();

	/**
	 * 获取：岗位列表
	 *
	 * @param currentPage
	 *            当前页
	 * @return 岗位列表
	 */
	Pagination getJobList(int currentPage);

}
