/**
 * @Date 2015年1月26日  上午11:27:53
 * @author 张亚飞
 * @email verphen@163.com
 */

package cn.effine.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.effine.dao.CorJobDao;
import cn.effine.dao.CorporationDao;
import cn.effine.dao.DictDao;
import cn.effine.dao.KnowledgeDao;
import cn.effine.service.UserClientService;
import cn.effine.utils.Constants;
import cn.effine.utils.Pagination;

@Service
public class UserClientServiceImpl implements UserClientService {
	@Autowired
	private CorJobDao jobDao;	//岗位
	@Autowired
	private KnowledgeDao knowledgeDao;	//知识分类
	@Autowired
	private DictDao dictDao;	//字典
	@Autowired
	private CorporationDao corporationDao;	//企业

	@Override
	public Map<String, Object> getCorJob(int jobId) {
		return jobDao.getCorJob(jobId);
	}

	@Override
	public Map<String, Object> getInitParamList() {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("knoledgeList", knowledgeDao.getKnowlegeList()); // 职位类别(知识分类)列表
		returnMap.put("educationList", dictDao.getDictList("education")); // 学历列表
		returnMap.put("cityList", dictDao.getDictList("city")); // 工作城市列表
		
		// 公司规模列表
		List<Map<String,Object>> scaleList = new ArrayList<Map<String,Object>>();
		for(Entry<Integer, String> entry: Constants.CORPORATION_SCALE_MAP.entrySet()){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id", entry.getKey());
			map.put("name", entry.getValue());
			scaleList.add(map);
		}
		returnMap.put("scaleList", scaleList); 
		
		//获取：首页公司展示
		List<Map<String,Object>> corporationList = corporationDao.getCorporationList();
		returnMap.put("corporationList", corporationList); 
		return returnMap;
	}

	@Override
	public Pagination getJobList(int currentPage) {
		Pagination pagination = jobDao.getJobList(currentPage);
		if(null != pagination){
			List<Map<String,Object>> list = pagination.getResultList();
			for(int i=0;i<list.size();i++){
				Map<String,Object> map = list.get(i);
				//转换公司规模：将数字转换其代表意义
				int scale = Integer.parseInt(map.get("scale").toString());
				map.put("scale", Constants.CORPORATION_SCALE_MAP.get(scale));
				list.set(i, map);
			}
			pagination.setResultList(list);
		}
		return pagination;
	}
}
