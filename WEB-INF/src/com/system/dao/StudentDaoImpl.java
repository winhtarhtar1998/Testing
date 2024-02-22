package com.system.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.system.business.entity.PjStudent;

public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {

	public PjStudent getStudentByEmailAndPassword(String strEmail,
			String strPassword) {
		String hql="from PjStudent i where i.studentEmail=? and i.password=?";
		Object[] param={strEmail,strPassword};
		List l=getHibernateTemplate().find(hql,param);
		return l.isEmpty() || l==null ? null: (PjStudent)l.get(0);
	}

	public PjStudent getStudentByEmail(String accountEmail) {
		String hql="from PjStudent i where i.studentEmail=?";
		List l=getHibernateTemplate().find(hql, accountEmail);
		return l.isEmpty()||l==null? null:(PjStudent)l.get(0);
	}

	public void saveStudent(PjStudent student) {
		getHibernateTemplate().saveOrUpdate(student);
	}

	public PjStudent getStudentById(Integer studentId) {
		String hql="from PjStudent i where i.id=?";
		List l=getHibernateTemplate().find(hql, studentId);
		return l.isEmpty()||l==null? null:(PjStudent)l.get(0);
	}

	public void deleteStudent(PjStudent deleteStudent) {
		getHibernateTemplate().delete(deleteStudent);
	}

}
