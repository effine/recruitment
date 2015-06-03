package cn.effine.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cn.effine.utils.Pagination;

/** Hibernate封装数据库操作类 */
public class HibernateDaoSupport {
	@Autowired
	@Qualifier("masterSessionFactory")
	private SessionFactory masterSessionFactory;

	@Autowired
	@Qualifier("slaveSessionFactory")
	private SessionFactory slaveSessionFactory;

	/**
	 * 写操作（添加 | 更新 | 删除 ）
	 * 
	 * @return org.hibernate.Session
	 */
	public Session getMasterSession() {
		return masterSessionFactory.getCurrentSession();
	}

	/**
	 * 读操作(查询)
	 * 
	 * @return org.hibernate.Session
	 */
	public Session getSlaveSession() {
		return slaveSessionFactory.getCurrentSession();
	}

	/**
	 * 实体Model: 添加
	 * 
	 * @param model
	 *            实体Model
	 * @return 实体Model
	 */
	public <T extends Serializable> T addModel(T model) {
		getMasterSession().save(model);
		return model;
	}
	
	/**
	 * HQL执行单表操作(增加 | 更新 | 删除)
	 * 
	 * @param hql
	 *            HQL语句
	 * @param obj
	 *            传入的有序(顺序和hql对应)参数
	 * @return Boolean
	 */
	public boolean executeHql(String hql, Object... obj) {
		Query query = getMasterSession().createQuery(hql);
		for (int i = 0; i < obj.length; i++)
			query.setParameter(i, obj[i]);
		return query.executeUpdate() >= 0 ? true : false;
	}

	/**
	 * SQL执行操作(增加 | 更新 | 删除)
	 * 
	 * @param sql
	 *            sql语句
	 * @param obj
	 *            传入的有序参数(顺序和sql对应)
	 * @return Boolean
	 */
	public boolean executeSql(String sql, Object... obj) {
		SQLQuery query = getMasterSession().createSQLQuery(sql);
		for (int i = 0; i < obj.length; i++)
			query.setParameter(i, obj[i]);
		return query.executeUpdate() >= 0 ? true : false;
	}


	/**
	 * 实体Model: 获取
	 * 
	 * @param clazz
	 *            返回实体Model.class
	 * @param id
	 *            实体ID
	 * @return 实体Model
	 */
	@SuppressWarnings("unchecked")
	public <T extends Serializable> T getModel(Class<T> clazz, int id) {
		return (T) getSlaveSession().get(clazz, id);
	}
	
	/**
	 * HQL查询操作
	 * 
	 * @param clazz
	 *            返回列表List<clazz>
	 * @param hql
	 *            HQL语句
	 * @param obj
	 *            有序参数列表
	 * @return List<Model>
	 */
	@SuppressWarnings("unchecked")
	public <T extends Serializable> List<T> queryHql(Class<T> clazz,
			String hql, Object... obj) {
		Query query = getSlaveSession().createQuery(hql);
		for (int i = 0; i < obj.length; i++)
			query.setParameter(i, obj[i]);
		return (List<T>) query.list();
	}

	/**
	 * SQL查询操作
	 * 
	 * @param sql
	 *            SQL语句
	 * @param obj
	 *            参数列表(顺序对应SQL)
	 * @return List<Map<String, Object>>
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> querySql(String sql, Object... obj) {
		Query query = getSlaveSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		for (int i = 0; i < obj.length; i++)
			query.setParameter(i, obj[i]);
		return query.list();
	}

	/**
	 * SQL查询操作(分页)
	 * 
	 * @param sql
	 *            SQL语句
	 * @param totalSize
	 *            总记录数
	 * @param obj
	 *            参数列表(顺序对应SQL)
	 * @return Pagination
	 */
	public Pagination querySqlPagination(String sql, Object... obj) {
		Pagination pagination = null;
		Query query = getSlaveSession().createSQLQuery(sql)
				.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		for (int i = 0; i < obj.length; i++)
			query.setParameter(i, obj[i]);
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list = query.list();

		if (null != list && list.size() > 0) {
			pagination = new Pagination();
			pagination.setResultList(list);
		}
		return pagination;
	}
}
