package cn.effine.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.effine.dao.HibernateDaoSupport;
import cn.effine.dao.KnowledgeDao;

@Repository
public class KnowledgeDaoImpl extends HibernateDaoSupport implements KnowledgeDao {

	@Override
	public List<Map<String, Object>> getKnowlegeList() {
		String sql = "select id, kno_name name from knowledge where status=1 order by sort_index";
		return super.querySql(sql);
	}
}