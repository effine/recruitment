package cn.effine.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.effine.dao.CorJobDao;
import cn.effine.dao.HibernateDaoSupport;
import cn.effine.model.CorJob;
import cn.effine.utils.Constants;
import cn.effine.utils.Pagination;

@Repository
public class CorJobDaoImpl extends HibernateDaoSupport implements CorJobDao {

	@Override
	public int addCorJob(CorJob corJob) {
		return super.addModel(corJob).getId();
	}

	@Override
	public boolean updateRefreshTime(int jobId, String nowTime) {
		String sql = "update cor_job set refresh_time=? where id=?";
		return super.executeSql(sql, nowTime, jobId);
	}

	@Override
	public boolean updateStatus(int jobId, int status) {
		String sql = "update cor_job set status=? where id=?";
		return super.executeSql(sql, status, jobId);
	}

	@Override
	public Map<String, Object> getJob(int jobId) {
		StringBuilder sql = new StringBuilder();
		sql.append("select cor_id coreId, kno_id knoId, region_id regionId, education_id educationId,name,");
		sql.append(" department, type, lowest_month_salary lowestMonthSalary, highest_month_salary highestMonthSalary,");
		sql.append(" lure, description, address, refresh_timerefresh_time refreshTime");
		sql.append(" from cor_job where id=?");
		List<Map<String,Object>> list = super.querySql(sql.toString(), jobId);
		return  null!=list && 1==list.size() ? list.get(0) : null;
	}
	
	@Override
	public Map<String, Object> getCorJob(int jobId) {
		String sql = "select job.name, job.type, job.lowest_month_salary lowestMonthSalary, job.highest_month_salary highestMonthSalary,"
				+ " job.lure, job.description, job.published_time publishedTime, "
				+ " cor.cor_name corName, cor.homepage_url corUrl, cor.fields corFields, cor.scale corScale, cor.logo_img_url corLogoUrl,"
				+ " dict.name regionName, dict.name educationName"
				+ " from cor_job job"
				+ " left join corporation cor on cor.id = job.cor_id"
				+ " left join dict dict on dict.id = job.region_id"
				+ " left join dict dict1 on dict1.id = job.education_id"
				+ " where job.id=?";
		List<Map<String,Object>> list = super.querySql(sql, jobId);
		return  null!=list && 1==list.size() ? list.get(0) : null;
	}

	@Override
	public Pagination getJobListByCorId(int corporationId, int currentPage) {
		//统计中记录数
		String sql  = "select count(id) total from cor_job where cor_id = ?";
		int totalSize = 0; // 总记录数
		List<Map<String, Object>> countList = super.querySql(sql, corporationId);
		if (null != countList && 1 == countList.size())
			totalSize = Integer.parseInt(countList.get(0).get("total").toString(), 10);
		if (0 == totalSize)
			return null;
		
		//获取指定页面的记录
		int pageSize = Constants.CORPORATION_JOB_PAGE_SIZE;	//每页记录数
		int startIndex = (currentPage - 1) * pageSize;	//起始索引序号
		int pageCount = totalSize % pageSize == 0 ? totalSize / pageSize : (totalSize / pageSize)+1;	//总页数
		if(currentPage > pageCount) currentPage = pageCount;	//当前页大于总页数则等于总页数
		else if(currentPage < 1) currentPage = 1;	//当前页小于第一页则等于第一页
		
		sql = "select job.id, dict.name regionName, dict1.name educationName, job.name, job.type,"
				+ " lowest_month_salary lowestMonthSalary,highest_month_salary highestMonthSalary, published_time publishTime"
				+ " from cor_job job"
				+ " left join dict dict on job.region_id = dict.id"
				+ " left join dict dict1 on job.education_id = dict.id"
				+ " where cor_id = ? and status=1 order by job.refresh_time desc limit ?, ?";
		Pagination pagination = super.querySqlPagination(sql, corporationId, startIndex, pageSize);
		if(null != pagination) pagination.setTotalSize(totalSize);
		return pagination;
	}
	
	@Override
	public Pagination getJobListByStatus(int status, int currentPage) {
		//统计中记录数
		String sql  = "select count(id) total from cor_job where status = ?";
		int totalSize = 0; // 总记录数
		List<Map<String, Object>> countList = super.querySql(sql, status);
		if (null != countList && 1 == countList.size())
			totalSize = Integer.parseInt(countList.get(0).get("total").toString(), 10);
		if (0 == totalSize)
			return null;
		
		//获取指定页面的记录
		int pageSize = Constants.PAGE_SIZE;	//每页记录数
		int startIndex = (currentPage - 1) * pageSize;	//起始索引序号
		int pageCount = totalSize % pageSize == 0 ? totalSize / pageSize : (totalSize / pageSize)+1;	//总页数
		if(currentPage > pageCount) currentPage = pageCount;	//当前页大于总页数则等于总页数
		else if(currentPage < 1) currentPage = 1;	//当前页小于第一页则等于第一页
		
		sql = "select job.id, dict.name regionName, dict1.name educationName, job.name, job.type,"
				+ " lowest_month_salary lowestMonthSalary,highest_month_salary highestMonthSalary, refresh_time refreshTime"
				+ " from cor_job job"
				+ " left join dict dict on job.region_id = dict.id"
				+ " left join dict dict1 on job.education_id = dict.id"
				+ " where status = ? order by job.refresh_time desc limit ?, ?";
		 
		 Pagination pagination = super.querySqlPagination(sql, status, startIndex, pageSize);
		 if(null != pagination) pagination.setTotalSize(totalSize);
		 return pagination;
	}

	@Override
	public Pagination getJobList(int currentPage) {
		//统计中记录数
		String sql  = "select count(id) total from cor_job where status = 1";
		int totalSize = 0; // 总记录数
		List<Map<String, Object>> countList = super.querySql(sql);
		if (null != countList && 1 == countList.size())
			totalSize = Integer.parseInt(countList.get(0).get("total").toString(), 10);
		if (0 == totalSize)
			return null;
		
		//获取指定页面的记录
		int pageSize = Constants.PAGE_SIZE;	//每页记录数
		int startIndex = (currentPage - 1) * pageSize;	//起始索引序号
		int pageCount = totalSize % pageSize == 0 ? totalSize / pageSize : (totalSize / pageSize)+1;	//总页数
		if(currentPage > pageCount) currentPage = pageCount;	//当前页大于总页数则等于总页数
		else if(currentPage < 1) currentPage = 1;	//当前页小于第一页则等于第一页
		
		StringBuilder builder = new StringBuilder();
		builder.append("select job.id, dict.name regionName, dict1.name educationName, job.name, job.department,");
		builder.append(" lowest_month_salary lowestMonthSalary,highest_month_salary highestMonthSalary, job.lure, job.published_time publishTime");
		builder.append(" cor.label, cor.fields, cor.scale");
		builder.append(" from cor_job job");
		builder.append(" left join dict dict on job.region_id = dict.id");
		builder.append(" left join dict dict1 on job.education_id = dict.id");
		builder.append(" left join corporation cor on cor.id = job.cor_id");
		builder.append(" where status = 1 order by job.refresh_time desc limit ?, ?");
		 
		 Pagination pagination = super.querySqlPagination(builder.toString(), startIndex, pageSize);
		 if(null != pagination) pagination.setTotalSize(totalSize);
		 return pagination;
	}
}