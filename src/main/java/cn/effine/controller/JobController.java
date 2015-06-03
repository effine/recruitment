/**
 * @Date 2015年1月21日  下午7:38:24
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

import cn.effine.model.CorJob;
import cn.effine.service.CorporationService;
import cn.effine.service.JobService;
import cn.effine.utils.Constants;
import cn.effine.utils.JsonUtils;
import cn.effine.utils.Pagination;
import cn.effine.utils.TimeUtils;

/** 岗位 */
@Controller
@RequestMapping("job")
public class JobController extends ControllerSupport{
	@Autowired
	private JobService jobService;
	@Autowired
	private CorporationService corporationService;
	
	/**
	 * 岗位：添加
	 *
	 * @param job
	 *            岗位Model
	 * @return 岗位ID
	 */
	@RequestMapping(value ="add", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String addJob(HttpServletRequest request, HttpServletResponse response, CorJob job) {
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("status", 0);
		if(super.isLogin(request)){
			job.setIsTomember(0); //未转正
			job.setIsFoodPill(0); //没有餐补
			job.setStatus(1);
			job.setRefreshTime(TimeUtils.getNowTime());
			job.setPublishedTime(TimeUtils.getNowTime());
			
			int jobId = jobService.addJob(job);
			if(0 != jobId){
				result.put("status", 1);
	            result.put("jobId", jobId);
			}
		}else result.put("msg", "用户未登录");
		return JsonUtils.mapToJSONString(result);
	}
	
	/**
	 * 岗位: 更新岗位刷新时间
	 *
	 * @param jobId
	 *            岗位ID
	 * @return Boolean
	 */
	@RequestMapping(value ="refresh", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String updateJobFreshTime(HttpServletRequest request, HttpServletResponse response, int jobId) {
		Map<String,Object> result = new    HashMap<String,Object>();
		result.put("status", 0);
		if(super.isLogin(request)){
			if(0 != jobId){
				Map<String,Object> map = jobService.getJob(jobId);	//获取岗位相关信息
				//验证: "刷新时间"操作是否合法
				long refreshTime = TimeUtils.stringToMillis(map.get("refreshTime").toString());
				long currentTime = TimeUtils.getCurrentTiem();
				long intervalTime = currentTime - refreshTime; 	//得出间隔时间
				boolean isLllegal = false;	//是否非法
				if(intervalTime < Constants.SEVEN_MILLIS) isLllegal=true;
				if(isLllegal){
					String nowTime = TimeUtils.getNowTime();
					boolean isSuccess = jobService.updateRefreshTime(jobId, nowTime);		//更新岗位刷新时间
					if(isSuccess){
						result.put("status", 1);
						result.put("nowTime", nowTime);
						result.put("msg", "刷新成功");
					}else result.put("msg", "刷新失败");
				}else result.put("msg", "刷新失败");
			}else result.put("msg", "参数错误");
		}else result.put("msg", "用户未登录");
		return JsonUtils.mapToJSONString(result);
	}
	
	/**
	 * 岗位: 更新岗位状态(删除，上线，下线)
	 *
	 * @param jobId
	 *            岗位ID
	 * @param status
	 *            岗位状态(删除:0，上线:1，下线:2)
	 * @return Boolean
	 */
	@RequestMapping(value ="change", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String updateJobStatus(HttpServletRequest request, HttpServletResponse response, int jobId, int status) {
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("status", 0);
		if(super.isLogin(request)){
			if(0 != jobId){
				//TODO effine 验证status参数是否合法
				//boolean isLegal = true;	//是否合法
				boolean isSuccess = jobService.updateStatus(jobId, status);		//更新岗位状态
				if(isSuccess){
					result.put("status", 1);
					result.put("msg", "操作成功");
				}else result.put("msg", "操作失败");
			}else result.put("msg", "参数错误");
		}else result.put("msg", "用户未登录");
		return JsonUtils.mapToJSONString(result);
	}
	
	/**
	 * 岗位：获取岗位列表
	 *
	 * @param corporationId
	 *            公司ID
	 * @param currentPage
	 *            当前页
	 * @return 岗位列表
	 */
	@RequestMapping("list")
	@ResponseBody
	public String getJobListByCorId(HttpServletRequest request, HttpServletResponse response, int corporationId, int currentPage) {
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("status", 0);
		if(0 != corporationId){
			Pagination pagination = jobService.getJobListByCorId(corporationId, currentPage);	//获取岗位列表
			if(null != pagination && pagination.getResultList().size()>0){
				result.put("status", 1);
				result.put("job", pagination);
			}else{
				result.put("status", 2);
				result.put("msg", "没有结果集");
			}
		}else result.put("msg", "参数错误");
		return JsonUtils.mapToJSONString(result);
	}
	
	/**
	 * 岗位：获取岗位列表
	 *
	 * @param status
	 *            岗位状态(上线<有效职位>：1;已下线：2)
	 * @param currentPage
	 *            当前页
	 * @return 岗位列表
	 */
	@RequestMapping("lists")
	@ResponseBody
	public String getJobListByStatus(HttpServletRequest request, HttpServletResponse response, int status, int currentPage) {
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("status", 0);
		if(super.isLogin(request)){
			if(0 != status){
				Pagination pagination = jobService.getJobListByStatus(status, currentPage);	//获取岗位列表
				if(null != pagination && pagination.getResultList().size()>0){
					result.put("status", 1);
		            result.put("job", pagination);
				}else{
					result.put("status", 2);
					result.put("msg", "没有结果集");
				}
			}else result.put("msg", "参数错误");
		}else result.put("msg", "用户未登录");
		return JsonUtils.mapToJSONString(result);
	}
	
	/**
	 * 跳转：预览新岗位
	 *
	 * @param job
	 *            岗位Model
	 * @return 跳转：预览新岗位
	 */
	@RequestMapping("preview")
	public String toPreviewJob(HttpServletRequest request, HttpServletResponse response, Model responseModel, CorJob job) {
		if(super.isLogin(request)){
			responseModel.addAttribute(job);
			Map<String,Object> map = corporationService.getCorporation(job.getCorId());	//获取公司信息
			//TODO effine 去掉map中不需要的属性
			responseModel.addAttribute(map);
		}
		return "/server/job/previewJob";
	}
	
	/**
	 * 跳转：岗位[发布新岗位publish | 有效岗位effective | 已下线岗位downline]
	 *
	 * @return 跳转：岗位相关页面
	 */
	@RequestMapping("{status}")
	public String toStausJob(HttpServletRequest request, HttpServletResponse response, Model responseModel) {
		String url = request.getServletPath();
		String[] urlArr = url.split("/");
		if (null == urlArr || urlArr.length != 3) return "404";
		String jobStatus = urlArr[urlArr.length - 1].toLowerCase(); /* 获得页面状态属性 */
		
		//发布新岗位
		if("publish".equals(jobStatus)){
			responseModel.addAllAttributes(jobService.getInitParamList());	//发布新岗位：初始化页面参数列表
		}
		return "/server/job/"+ jobStatus +"Job";
	}
}
