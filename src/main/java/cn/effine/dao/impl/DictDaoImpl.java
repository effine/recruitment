package cn.effine.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.effine.dao.DictDao;
import cn.effine.dao.HibernateDaoSupport;

@Repository
public class DictDaoImpl extends HibernateDaoSupport implements DictDao {
	
	@Override
	public List<Map<String, Object>> getDictList(String dictKey) {
		String sql ="select id, name, dict_key, dict_value from  y_dict"
				+ " where parent_id in (select id from  y_dict where dict_key = ?) order by sort_index";
		return super.querySql(sql, dictKey);
	}
}