
/**
 * @Date 2015年1月22日  上午11:46:31
 * @author 张亚飞
 * @email verphen@163.com
 */

package cn.effine.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.effine.service.UserClientService;
import cn.effine.utils.JsonUtils;
import cn.effine.utils.Pagination;

/** 面向求职者使用端 */
@Controller
public class UserClientController {
	@Autowired
	private UserClientService userClientService;
	
	/**
	 * 获取：求职端岗位列表
	 *
	 * @param currentPage
	 *            当前页
	 * @return 岗位列表
	 */
	@RequestMapping("main/list")
	@ResponseBody
	public String getJobList(HttpServletRequest request, HttpServletResponse response, int currentPage) {
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("status", 0);
		Pagination pagination = userClientService.getJobList(currentPage);
		return JsonUtils.objectToJSONString(pagination);
	}
	
	/**
	 * 跳转：首页
	 *
	 * @return 跳转：首页
	 */
	@RequestMapping("main")
	public String toMain(HttpServletRequest request, HttpServletResponse response, Model model) {
		//初始化页面属性列表
		model.addAllAttributes(userClientService.getInitParamList());
		return "customer/main";
	}

	/**
	 * 跳转：岗位页面
	 * 
	 * @param jobId
	 *            岗位ID
	 *
	 * @return 跳转：岗位页面
	 */
	@RequestMapping("main/job")
	public String toJob(HttpServletRequest request, HttpServletResponse response, Model model, int jobId) {
		if(0 >= jobId) return "500";   //验证：参数是否合法
		Map<String,Object> map = userClientService.getCorJob(jobId);	//获取：岗位页面相关属性(岗位及公司信息)
		if(null != map){
			model.addAllAttributes(map);
			return "customer/job";
		}
		return "500";
	}
}
