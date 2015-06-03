package cn.effine.dao.impl;

import org.springframework.stereotype.Repository;

import cn.effine.dao.HibernateDaoSupport;
import cn.effine.dao.UsrResumeDao;
import cn.effine.model.UsrResume;

@Repository
public class UsrResumeDaoImpl extends HibernateDaoSupport implements UsrResumeDao {

	@Override
	public UsrResume getUsrResume(int id) {
		return super.getModel(UsrResume.class, id);
	}

}