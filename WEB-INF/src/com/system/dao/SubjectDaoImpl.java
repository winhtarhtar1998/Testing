package com.system.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.system.business.entity.PjSubject;

public class SubjectDaoImpl extends HibernateDaoSupport implements SubjectDao {

	public List<PjSubject> getAllSubject() {
		List l=getHibernateTemplate().find("from PjSubject");
		return l.isEmpty()|| l==null? null:l;
	}

	public PjSubject getSubjectById(Integer id) {
		List l=getHibernateTemplate().find("from PjSubject i where i.id=?",id);
		return l.isEmpty()||l==null? null:(PjSubject)l.get(0);
	}
}
