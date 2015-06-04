package cn.effine.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import cn.effine.dao.CorJobReqInvitationDao;
import cn.effine.dao.HibernateDaoSupport;
import cn.effine.model.CorJobReqInvitation;
import cn.effine.utils.Constants;
import cn.effine.utils.Pagination;
import cn.effine.utils.TimeUtils;

@Service
public class CorJobReqInvitationDaoImpl extends HibernateDaoSupport implements CorJobReqInvitationDao {
	
	@Override
	public int addInvation(CorJobReqInvitation invitation) {
		return super.addModel(invitation).getId();
	}

	@Override
	public Pagination getInvatation(int corporationId, int timeLimit, int currentPage) {
		//构造时间: 当天0点(yyyy-MM-dd 00:00:00)
		String nowtime = TimeUtils.getNowTime();
		nowtime = nowtime.substring(0, nowtime.indexOf(" ")) +" 00:00:00";	
		
		String appendSql = "";
		if(1 == timeLimit){
			appendSql = " and created_time >= " + nowtime + " ";
		}else if(2 == timeLimit){
			appendSql = " and created_time < " + nowtime + " ";
		}
		
		//统计中记录数
		String sql = "select count(id) total from cor_job_req_invitation where cor_id = ?";
		sql += appendSql;
		int totalSize = 0; // 总记录数
		List<Map<String, Object>> countList = super.querySql(sql, corporationId);
		if (null != countList && 1 == countList.size())
			totalSize = Integer.parseInt(countList.get(0).get("total").toString(), 10);
		if (0 == totalSize)	return null;
		
		//获取指定页面的记录
		int pageSize = Constants.PAGE_SIZE;	//每页记录数
		int startIndex = (currentPage - 1) * pageSize;	//起始索引序号
		int pageCount = totalSize % pageSize == 0 ? totalSize / pageSize : (totalSize / pageSize)+1;	//总页数
		if(currentPage > pageCount) currentPage = pageCount;	//当前页大于总页数则等于总页数
		else if(currentPage < 1) currentPage = 1;	//当前页小于第一页则等于第一页
		
		sql = "select invatation.face_time faceTime, kno.kno_name jobName, dict.name jobName,"
				+ " resume.id resumeId, resume.name, resume.avatar, resume.contact phone"
				+ " from cor_job_req_invitation invatation"
				+ " left join cor_job job on job.id = invatation.job_id"
				+ " left join knowledge kno on kno.id = job.kno_id"
				+ " left join usr_resume resume on resume.id = invatation.usr_id"
				+ " where status = ? "+ appendSql +"order by faceTime desc limit ?, ?";
		Pagination pagination = super.querySqlPagination(sql, corporationId, startIndex, pageSize);
		if(null != pagination) pagination.setTotalSize(totalSize);
		return pagination;
	}
}