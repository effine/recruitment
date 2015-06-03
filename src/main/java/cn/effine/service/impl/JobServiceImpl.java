/**
 * @Date 2015年1月21日  下午7:46:00
 * @author 张亚飞
 * @email verphen@163.com
 */

package cn.effine.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.effine.dao.CorJobDao;
import cn.effine.dao.CorJobRequestDao;
import cn.effine.dao.DictDao;
import cn.effine.dao.KnowledgeDao;
import cn.effine.model.CorJob;
import cn.effine.service.JobService;
import cn.effine.utils.Constants;
import cn.effine.utils.Pagination;
import cn.effine.utils.TimeUtils;

@Service
public class JobServiceImpl implements JobService {
	@Autowired
	private CorJobDao jobDao;
	@Autowired
	private DictDao dictDao;
	@Autowired
	private KnowledgeDao knowledgeDao;	//知识分类（岗位类别）
	@Autowired
	private CorJobRequestDao jobRequestDao;		//岗位申请

	@Override
	public int addJob(CorJob corJob) {
		return jobDao.addCorJob(corJob);
	}
	
	@Override
	public boolean updateRefreshTime(int jobId, String nowTime) {
		return jobDao.updateRefreshTime(jobId, nowTime);
	}
	
	@Override
	public boolean updateStatus(int jobId, int status) {
		return jobDao.updateStatus(jobId, status);
	}

	@Override
	public Map<String, Object> getInitParamList() {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("knoledgeList", knowledgeDao.getKnowlegeList()); // 职位类别(知识分类)列表
		returnMap.put("educationList", dictDao.getDictList("education")); // 学历列表
		returnMap.put("cityList", dictDao.getDictList("city")); // 工作城市列表
		return returnMap;
	}

	@Override
	public Map<String,Object> getJob(int jobId) {
		return jobDao.getJob(jobId);
	}
	
	@Override
	public Pagination getJobListByCorId(int corporationId, int currentPage) {
		Pagination pagination =  jobDao.getJobListByCorId(corporationId, currentPage);
		if(null != pagination){
			List<Map<String,Object>> list = pagination.getResultList();
			for(int i=0;i<list.size();i++){
				Map<String,Object> map = list.get(i);
				//转换岗位性质：将数字转换其代表意义
				int type = Integer.parseInt(map.get("type").toString());
				map.put("type", Constants.JOB_TYPE_MAP.get(type));
				list.set(i, map);
			}
			pagination.setResultList(list);
		}
		return pagination;
	}
	
	@Override
	public Pagination getJobListByStatus(int status, int currentPage) {
		Pagination pagination = jobDao.getJobListByStatus(status, currentPage);
		if(null != pagination){
			List<Map<String,Object>> list = pagination.getResultList();
			for(int i=0;i<list.size();i++){
				Map<String,Object> map = list.get(i);
				//获取岗位求职者人数
				int jobId = Integer.parseInt(map.get("id").toString());
				int seekers = jobRequestDao.countResumeRequestNumber(jobId);	
				map.put("seekers", seekers);
				
				//判断: 刷新时间 是否可用
				long refreshTime = TimeUtils.stringToMillis(map.get("refreshTime").toString());
				long currentTime = TimeUtils.getCurrentTiem();
				long intervalTime = currentTime - refreshTime; 	//得出间隔时间
				boolean isAbleRefresh = false;
				if(intervalTime >= Constants.SEVEN_MILLIS) isAbleRefresh=true;
				map.put("isAbleRefresh", isAbleRefresh);
				
				//转换岗位性质：将数字转换其代表意义
				int type = Integer.parseInt(map.get("type").toString());
				map.put("type", Constants.JOB_TYPE_MAP.get(type));
				list.set(i, map);
			}
			pagination.setResultList(list);
		}
		return pagination;
	}
}
