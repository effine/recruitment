/**
 * @Date 2014年11月14日  下午3:48:31
 * @author 张亚飞
 * @Copyright 云路科技  ©2014
 */

package cn.effine.utils;

import java.util.List;
import java.util.Map;

/** 分页工具Model */
public class Pagination {
	//TODO effine 后端只返回总页数,当前页记录数（前端分页插件能否实现）
	private int pageSize; /* 每页显示记录数 */
	private int totalSize; /* 总记录数 */
	private List<Map<String, Object>> resultList; /* 查询结果 */

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public List<Map<String, Object>> getResultList() {
		return resultList;
	}

	public void setResultList(List<Map<String, Object>> resultList) {
		this.resultList = resultList;
	}
}
