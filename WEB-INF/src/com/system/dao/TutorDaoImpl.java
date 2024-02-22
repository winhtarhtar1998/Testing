package com.system.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.system.business.entity.PjTutor;

public class TutorDaoImpl extends HibernateDaoSupport implements TutorDao {

	public PjTutor getTutorByEmailAndPassword(String strEmail,
			String strPassword) {
		String hql="from PjTutor i where i.tutorEmail=? and i.password=?";
		Object[] param={strEmail,strPassword};
		List l=getHibernateTemplate().find(hql,param);
		return l.isEmpty() || l==null ? null: (PjTutor)l.get(0);
	}

	public PjTutor getTutorByEmail(String accountEmail) {
		String hql="from PjTutor i where i.tutorEmail=?";
		List l=getHibernateTemplate().find(hql, accountEmail);
		return l.isEmpty()||l==null? null:(PjTutor)l.get(0);
	}

	public void saveTutor(PjTutor tutor) {
		getHibernateTemplate().saveOrUpdate(tutor);
		
	}
	
	// for explore tutors
	public List<PjTutor> getAllTutors() {
		String hql="from PjTutor i";
		List<PjTutor> l=getHibernateTemplate().find(hql);
		return l.isEmpty()||l==null? null:l;
	}
	
	public PjTutor getTutorById(Integer Id) {
		String hql="from PjTutor i where i.id=?";
		List<PjTutor> list=getHibernateTemplate().find(hql,Id);
		return list.isEmpty()||list==null?null:list.get(0);
	}

	// delete tutor account
	public void deleteTutor(PjTutor deleteTutor) {
		getHibernateTemplate().delete(deleteTutor);
	}
}
