package com.system.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.system.business.entity.PjSubject;
import com.system.business.entity.PjTeach;
import com.system.business.entity.PjTutor;
import com.system.presentation.form.StudentForm;

public class TeachDaoImpl extends HibernateDaoSupport implements TeachDao {

	public void saveTeach(PjTeach myTeach) {
		getHibernateTemplate().saveOrUpdate(myTeach);
	}
	
	public List<PjTeach> getTeachListAll() {
		String hql="from PjTeach i";
		List<PjTeach> l=getHibernateTemplate().find(hql);
		return l.isEmpty()||l==null? null:l;
	}
	
	public PjTeach getTeachById(Integer teachId) {
		String hql="from PjTeach i where i.id=?";
		List<PjTeach> list=getHibernateTemplate().find(hql,teachId);
		return list.isEmpty()||list==null?null:list.get(0);
	}
	
	public List<PjTeach> getAllTeachofTutor(PjTutor myTutor) {
		String hql="from PjTeach i where i.tutor=?";
		List<PjTeach> list=getHibernateTemplate().find(hql,myTutor);
		return list.isEmpty()||list==null?null:list;
	}

	public List<PjTeach> getTeachListBySubject(PjSubject subject) {
		String hql="from PjTeach i where i.subject=?";
		List<PjTeach> list=getHibernateTemplate().find(hql,subject);
		return list.isEmpty()||list==null?null:list;
	}

	public List<PjTeach> getTeachListByTeachingType(String teachingType) {
		String hql="from PjTeach i where i.teachingType=?";
		List<PjTeach> list=getHibernateTemplate().find(hql,teachingType);
		return list.isEmpty()||list==null?null:list;
	}

	public List<PjTeach> getTeachListBySubjectAndTeachType(PjSubject subject,
			String teachingType) {
		String hql="from PjTeach i where i.subject=? and i.teachingType=?";
		Object[] param={subject,teachingType};
		List<PjTeach> list=getHibernateTemplate().find(hql,param);
		return list.isEmpty()||list==null?null:list;
	}

	public void deleteTeachById(PjTeach deleteTeach) {
		getHibernateTemplate().delete(deleteTeach);
	}

}
