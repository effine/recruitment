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

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.effine.model.CorJobReqInvitation;
import cn.effine.service.ResumeService;
import cn.effine.utils.Constants.COR_JOB_TYPE;
import cn.effine.utils.JsonUtils;
import cn.effine.utils.Pagination;
import cn.effine.utils.TimeUtils;

/** 简历 */
@Controller
public class ResumeController extends ControllerSupport {
	@Autowired
	private ResumeService resumeService;
	
	/**
	 * 添加：面试邀请
	 *
	 * @param invitation
	 *           面试邀请Model
	 * @return Boolean
	 */
	@RequestMapping("interview/add")
	@ResponseBody
	public String addInterview(HttpServletRequest request, HttpServletResponse response, CorJobReqInvitation invitation){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("status", 0);
		//验证：是否登录
		if(super.isLogin(request)){
			//验证：参数是否合法
			if(null!=invitation && 0!=invitation.getCorId() && 0!=invitation.getUsrId() && 0!=invitation.getJobId()
					&& StringUtils.isNotBlank(invitation.getTitle()) && StringUtils.isNotBlank(invitation.getFaceTime()) 
					&& StringUtils.isNotBlank(invitation.getFaceAddress()) && StringUtils.isNotBlank(invitation.getFaceDetail())){
				invitation.setCreatedTime(TimeUtils.getNowTime());
				boolean isSuccess = resumeService.addInterview(invitation);
				if(isSuccess){
					result.put("status", 1);
		            result.put("msg", "面试邀请发送成功");
				}else result.put("msg", "面试邀请发送失败");
			}else result.put("msg", "参数错误");
		}else result.put("msg", "用户未登录");
		return JsonUtils.mapToJSONString(result);
	}
	
	/**
	 * 更新：简历处理状态
	 *
	 * @param id
	 *            简历申请ID
	 * @param status
	 *            简历处理状态（0:未阅读;1:已阅读；2:不适合；3:已发送面试邀请；4:已删除）
	 * @return Boolean
	 */
	@RequestMapping("resume/operate")
	@ResponseBody
	public String updateResumeStatus(HttpServletRequest request, HttpServletResponse response, int id, int status){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("status", 0);
		if(super.isLogin(request)){
			if(0 != id){
				//验证：简历处理状态参数
				boolean isLllegal = false;
				for(int i=0;i<5;i++){
					if(i == status){
						isLllegal = true;
						break;
					}
				}
				
				if(isLllegal){
					boolean isSuccess = resumeService.updateResumeStatus(id, status);	//更新处理简历状态
					if(isSuccess){
						result.put("status", 1);
			            result.put("msg", "操作成功");
					}else result.put("msg", "操作失败");
				}else result.put("msg", "参数错误");
			}else result.put("msg", "参数错误");
		}else result.put("msg", "用户未登录");
		return JsonUtils.mapToJSONString(result);
	}
	
	/**
	 * 更新：简历处理状态(全选操作)
	 *
	 * @param ids
	 *            简历申请ID数组
	 * @param status
	 *            简历处理状态（0:未阅读;1:已阅读；2:不适合；3:已发送面试邀请；4:已删除）
	 * @return Boolean
	 */
	@RequestMapping("resume/operates")
	@ResponseBody
	public String updateResumeStatus(HttpServletRequest request, HttpServletResponse response, int[] ids, int status){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("status", 0);
		if(super.isLogin(request)){
			if(null != ids){
				//验证：简历处理状态参数
				boolean isLllegal = false;
				for(int i=0;i<5;i++){
					if(i == status){
						isLllegal = true;
						break;
					}
				}
				
				if(isLllegal){
					boolean isSuccess = resumeService.updateResumeStatus(ids, status);	//更新处理简历状态
					if(isSuccess){
						result.put("status", 1);
						result.put("msg", "操作成功");
					}else result.put("msg", "操作失败");
				}else result.put("msg", "参数错误");
			}else result.put("msg", "参数错误");
		}else result.put("msg", "用户未登录");
		return JsonUtils.mapToJSONString(result);
	}
	
	public static void main(String[] args) {
		
		 System.err.println(COR_JOB_TYPE.fullTime.key);
		
	}
	
	/**
	 * 获取：简历申请列表
	 *
	 * @param status
	 *            简历处理状态（0:未阅读;1:不适合；2:已发送面试邀请；3:已删除）
	 * @param currentPage
	 *            当前页序号
	 * @return 简历申请列表
	 */
	@RequestMapping("resume/list")
	@ResponseBody
	public String getResumeList(HttpServletRequest request, HttpServletResponse response, int status, int currentPage){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("status", 0);
		if(super.isLogin(request)){
			if(0 != status){
				Pagination pagination = resumeService.getResumeList(status, currentPage);	//获取简历申请列表
				if(null != pagination && pagination.getResultList().size()>0){
					result.put("status", 1);
		            result.put("resume", pagination);
				}else{
					result.put("status", 2);
					result.put("msg", "没有结果集");
				}
			}else result.put("msg", "参数错误");
		}else result.put("msg", "用户未登录");
		return JsonUtils.mapToJSONString(result);
	}
	
	/**
	 * 获取：面试简历列表
	 *
	 * @param corporationId
	 *            公司ID
	 * @param timeLimit
	 *            时间界限（0:不限；1：今天及以后；2:明天及以前）
	 * @param currentPage
	 *            当前页序号
	 * @return 简历申请列表
	 */
	@RequestMapping("interview/list")
	@ResponseBody
	public String getInterviewList(HttpServletRequest request, HttpServletResponse response, int corporationId, int timeLimit, int currentPage){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("status", 0);
		if(super.isLogin(request)){
			if(0 != corporationId){
				Pagination pagination = resumeService.getInterviewList(corporationId, timeLimit, currentPage);	//获取简历申请列表
				if(null != pagination && pagination.getResultList().size()>0){
					result.put("status", 1);
		            result.put("resume", pagination);
				}else{
					result.put("status", 2);
					result.put("msg", "没有结果集");
				}
			}else result.put("msg", "参数错误");
		}else result.put("msg", "用户未登录");
		return JsonUtils.mapToJSONString(result);
	}
	
	/**
	 * 跳转：简历页面
	 *
	 * @return 跳转：简历页面
	 */
	@RequestMapping("resume/show")
	public String toShowResume(HttpServletRequest request, HttpServletResponse response) {

		return "/server/resume/showResume";
	}
	
	/**
	 * 跳转：简历[面试interview|待处理unhandle|不合适unsatify]
	 *
	 * @return 跳转：简历相关页面
	 */
	@RequestMapping("resume/{status}")
	public String toStausJob(HttpServletRequest request, HttpServletResponse response) {
		String url = request.getServletPath();
		String[] uriArr = url.split("/");
		if (null == uriArr || uriArr.length < 2) return "404";
		String jobStatus = uriArr[uriArr.length - 1].toLowerCase(); /* 获得页面状态属性 */
		return "/server/resume/"+ jobStatus +"Resume";
	}
}
