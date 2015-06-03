
/**
 * @Date 2015年1月21日  下午7:44:53
 * @author 张亚飞
 * @email verphen@163.com
 */

package cn.effine.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.effine.dao.CorJobReqInvitationDao;
import cn.effine.dao.CorJobRequestDao;
import cn.effine.dao.DictDao;
import cn.effine.dao.UsrResumeDao;
import cn.effine.model.CorJobReqInvitation;
import cn.effine.model.UsrResume;
import cn.effine.service.ResumeService;
import cn.effine.utils.EmailUtils;
import cn.effine.utils.ExceptionUtils;
import cn.effine.utils.Pagination;

@Service
public class ResumeServiceImpl implements ResumeService{
	@Autowired
	private CorJobRequestDao requestDao;	//简历申请
	@Autowired
	private CorJobReqInvitationDao invatationDao;	//面试
	@Autowired
	private DictDao dictDao;	//字典
	@Autowired
	private UsrResumeDao resumeDao;	//用户简历-基本信息

	@Override
	public boolean addInterview(CorJobReqInvitation invitation){
		int invitationId = invatationDao.addInvation(invitation);
		if(0 == invitationId){
			ExceptionUtils.throwException("添加面试邀请至面试表失败！");
			return false;
		}
		
		//获取： 邮件配置参数
		List<Map<String,Object>> emailList =  dictDao.getDictList("emailSettings");
		Map<String,Object> emailMap = new HashMap<String,Object>();
		for(Map<String,Object> map: emailList){
			emailMap.put(String.valueOf(map.get("dict_key")), map.get("dict_value"));
		}
		
		//获取： 用户简历-基本信息
		UsrResume resume = resumeDao.getUsrResume(invitation.getUsrId());
		
		//发送面试邀请邮件
		boolean sendStatus =  EmailUtils.sendInterviewInvite(emailMap, resume.getEmail(), resume.getName(), invitation.getFaceDetail());
		if(!sendStatus){
			ExceptionUtils.throwException("发送面试邀请失败");
			return false;
		}
		return true;
	}
	
	@Override
	public boolean updateResumeStatus(int id, int status) {
		return requestDao.updateResumeStatus(id, status);
	}
	
	@Override
	public boolean updateResumeStatus(int[] ids, int status) {
		for(int i=0;i<ids.length;i++){
			boolean isSuccess = requestDao.updateResumeStatus(ids[i], status);
			if(!isSuccess){
				ExceptionUtils.throwException("简历全选操作(删除、不合适)失败");
				return false;
			}
		}
		return true;
	}
	
	@Override
	public Pagination getResumeList(int status, int currentPage) {
		return requestDao.getResumeRequestList(status, currentPage);
	}

	@Override
	public Pagination getInterviewList(int corporationId, int timeLimit, int currentPage) {
		return invatationDao.getInvatation(corporationId, timeLimit, currentPage);
	}
}


