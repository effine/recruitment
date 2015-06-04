package cn.effine.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.effine.dao.CorJobRequestDao;
import cn.effine.dao.HibernateDaoSupport;
import cn.effine.model.CorJobRequest;
import cn.effine.utils.Constants;
import cn.effine.utils.Pagination;

@Repository
public class CorJobRequestDaoImpl extends HibernateDaoSupport implements CorJobRequestDao {
	
	@Override
	public boolean updateResumeStatus(int id, int status) {
		String hql = "update CorJobRequest set status=? where id=?";
		return super.executeHql(hql, status, id);
	}

	@Override
	public int countResumeRequestNumber(int jobId) {
		String hql = "from CorJobRequest where jobId = ?";
		List<CorJobRequest> list = super.queryHql(CorJobRequest.class, hql, jobId);
		return null != list ? list.size() : 0;
	}

	@Override
	public Pagination getResumeRequestList(int status, int currentPage) {
		//统计中记录数
		String sql = "select count(id) total from cor_job_request where status = ?";
		int totalSize = 0; // 总记录数
		List<Map<String, Object>> countList = super.querySql(sql, status);
		if (null != countList && 1 == countList.size())
			totalSize = Integer.parseInt(countList.get(0).get("total").toString(), 10);
		if (0 == totalSize)	return null;
		
		//获取指定页面的记录
		int pageSize = Constants.PAGE_SIZE;	//每页记录数
		int startIndex = (currentPage - 1) * pageSize;	//起始索引序号
		int pageCount = totalSize % pageSize == 0 ? totalSize / pageSize : (totalSize / pageSize)+1;	//总页数
		if(currentPage > pageCount) currentPage = pageCount;	//当前页大于总页数则等于总页数
		else if(currentPage < 1) currentPage = 1;	//当前页小于第一页则等于第一页
		
		sql = "select request.id, request.apply_time applyTime, kno.kno_name jobName,"
				+ " resume.name, resume.gender, resume.school, resume.major, resume.avatar, resume.education"
				+ " from cor_job_request request"
				+ " left join cor_job job on job.id = request.job_id"
				+ " left join knowledge kno on kno.id = job.kno_id"
				+ " left join usr_resume resume on resume.id = request.usr_id"
				+ " where status = ? order by request.apply_time desc limit ?, ?";
		Pagination pagination = super.querySqlPagination(sql, status, startIndex, pageSize);
		if(null != pagination) pagination.setTotalSize(totalSize);
		return pagination;
	}
}