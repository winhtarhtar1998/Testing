package com.system.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.system.business.entity.PjRequest;
import com.system.business.entity.PjStudent;
import com.system.business.entity.PjSubject;
import com.system.business.entity.PjTeach;
import com.system.business.entity.PjTutor;
import com.system.presentation.form.TutorForm;

public class RequestDaoImpl extends HibernateDaoSupport implements RequestDao {

	public void saveStudentRequest(PjRequest myRequest) {
		getHibernateTemplate().saveOrUpdate(myRequest);
	}

	public List<PjRequest> getRequestList(PjTutor myTutor) {
		String hql="from PjRequest r where r.status=? and r.teach.tutor=?";
		Object[] param={"Requested",myTutor};
		List<PjRequest> l=getHibernateTemplate().find(hql,param);
		
		return l.isEmpty()||l==null? null:l;
	}

	public PjRequest getRequestById(Integer requestId) {
		List l=getHibernateTemplate().find("from PjRequest i where i.id=?",requestId);
		return l.isEmpty()||l==null? null:(PjRequest)l.get(0);
	}

	public void deleteRequest(PjRequest myRequest) {
		getHibernateTemplate().delete(myRequest);
	}
	
	public PjRequest getRequestByTeach(PjTeach teach) {		
		List l=getHibernateTemplate().find("from PjRequest i where i.teach=?",teach);
		return l.isEmpty()||l==null? null:(PjRequest)l.get(0);
	}

	public List<PjRequest> getRequestList(PjStudent myStudent) {
		String hql="from PjRequest r where r.student=?";
		List<PjRequest> l=getHibernateTemplate().find(hql,myStudent);
		
		return l.isEmpty()||l==null? null:l;
	}

	public List<PjRequest> getRequestedList(PjStudent myStudent) {
		String hql="from PjRequest r where r.status=? and r.student=?";
		Object[] param={"Requested",myStudent};
		List<PjRequest> l=getHibernateTemplate().find(hql,param);
		
		return l.isEmpty()||l==null? null:l;
	}

	public List<PjRequest> getConnectedList(PjStudent myStudent) {
		String hql="from PjRequest r where r.status=? and r.student=?";
		Object[] param={"Connected",myStudent};
		List<PjRequest> l=getHibernateTemplate().find(hql,param);
		
		return l.isEmpty()||l==null? null:l;
	}

	public List<PjRequest> getCompletedList(PjStudent myStudent) {
		String hql="from PjRequest r where r.status=? and r.student=?";
		Object[] param={"Completed",myStudent};
		List<PjRequest> l=getHibernateTemplate().find(hql,param);
		
		return l.isEmpty()||l==null? null:l;
	}

	public List<PjRequest> getConnectedList(PjTutor myTutor) {
		String hql="from PjRequest r where r.status=? and r.teach.tutor=?";
		Object[] param={"Connected",myTutor};
		List<PjRequest> l=getHibernateTemplate().find(hql,param);
		
		return l.isEmpty()||l==null? null:l;
	}

	public List<PjRequest> getCompletedList(PjTutor myTutor) {
		String hql="from PjRequest r where r.status=? and r.teach.tutor=?";
		Object[] param={"Completed",myTutor};
		List<PjRequest> l=getHibernateTemplate().find(hql,param);
		
		return l.isEmpty()||l==null? null:l;
	}

	public void changeCompleted(PjRequest myRequest) {
		getHibernateTemplate().saveOrUpdate(myRequest);
	}

	public List<PjRequest> getCompletedRequestBySelectedSubject(
			PjTutor myTutor, String selectedSubjuct) {
		String hql="from PjRequest r where r.feedback is not null and r.status=? and r.teach.tutor=? and r.teach.subject.subjectName=?";
		Object[] param={"Completed",myTutor,selectedSubjuct};
		List<PjRequest> l=getHibernateTemplate().find(hql,param);
		return l.isEmpty()||l==null? null:l;
	}

	public List<PjRequest> getCompletedFeedbackList(PjTutor myTutor) {
		String hql="from PjRequest r where r.feedback is not null and r.status=? and r.teach.tutor=?";
		Object[] param={"Completed",myTutor};
		List<PjRequest> l=getHibernateTemplate().find(hql,param);
		
		return l.isEmpty()||l==null? null:l;
	}

	public List<PjRequest> getRequestListByTutor(PjTutor myTutor) {
		String hql="from PjRequest r where r.teach.tutor=?";
		List<PjRequest> l=getHibernateTemplate().find(hql,myTutor);
		
		return l.isEmpty()||l==null? null:l;
	}

	public List<PjRequest> getNotCompletedTeachRequest(PjTeach myTeach) {
		String hql="from PjRequest r where r.status<>? and r.teach=?";
		Object[] param={"Completed",myTeach};
		List<PjRequest> l=getHibernateTemplate().find(hql,param);
		
		return l.isEmpty()||l==null? null:l;
	}


}
