
/**
 * @Date 2015年1月21日  下午7:45:35
 * @author 张亚飞
 * @email verphen@163.com
 */

package cn.effine.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.effine.dao.CorporationDao;
import cn.effine.service.CorporationService;

@Service
public class CorporationServiceImpl implements CorporationService{
	@Autowired
	private CorporationDao corporationDao;

	public Map<String,Object> getCorporation(int corporationId) {
		return corporationDao.getCorporation(corporationId);
	}
}

