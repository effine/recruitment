package cn.effine.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.effine.dao.CorporationDao;
import cn.effine.dao.HibernateDaoSupport;
import cn.effine.model.Corporation;

@Repository
public class CorporationDaoImpl extends HibernateDaoSupport implements CorporationDao {

	@Override
	public int addCorporation(Corporation corporation) {
		//TODO effine 是否被调用，如无则删除
		return super.addModel(corporation).getId();
	}

	@Override
	public Map<String,Object> getCorporation(int corporationId) {
		String sql = "select cor.id, cor.cor_name name, cor.full_name fullName, cor.slogon, cor.label,"
				+ " cor.description, dict.name regionName, cor.homepage_url homeUrl, cor.fields,"
				+ " cor.scale, cor.logo_img_url logoUrl"
				+ " from Corporation cor"
				+ " left join dict dict on dict.id = cor.region_id"
				+ " where cor.id=? and cor.status=1";
		List<Map<String,Object>> list = super.querySql(sql, corporationId);
		return null!=list && list.size()==1 ? list.get(0) : null; 
	}

	@Override
	public List<Map<String, Object>> getCorporationList() {
		String sql = "select id, cor_name name, logo_img_url url from corporation where is_main_show=1 and status=1";
		return super.querySql(sql);
	}
}