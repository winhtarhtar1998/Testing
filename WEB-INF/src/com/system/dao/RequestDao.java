package com.system.dao;

import java.util.List;

import com.system.business.entity.PjRequest;
import com.system.business.entity.PjStudent;
import com.system.business.entity.PjTeach;
import com.system.business.entity.PjTutor;
import com.system.presentation.form.TutorForm;

public interface RequestDao {
	public void saveStudentRequest(PjRequest myRequest);
	public List<PjRequest> getRequestList(PjTutor myTutor); 	// get Status 'Request' list
	public List<PjRequest> getRequestList(PjStudent myStudent); // for first load get all lists in PjRequest
	public PjRequest getRequestById(Integer requestId);
	public PjRequest getRequestByTeach(PjTeach teach);
	public void deleteRequest(PjRequest myRequest);
	
	public List<PjRequest> getRequestedList(PjStudent myStudent);
	public List<PjRequest> getConnectedList(PjStudent myStudent);
	public List<PjRequest> getCompletedList(PjStudent myStudent);
	
	public List<PjRequest> getConnectedList(PjTutor myTutor);
	public List<PjRequest> getCompletedList(PjTutor myTutor);
	
	public void changeCompleted(PjRequest myRequest);
	
	public List<PjRequest> getCompletedRequestBySelectedSubject(PjTutor myTutor,String selectedSubjuct);
	public List<PjRequest> getCompletedFeedbackList(PjTutor myTutor);
	
	public List<PjRequest> getRequestListByTutor(PjTutor myTutor);
	
	public List<PjRequest> getNotCompletedTeachRequest(PjTeach myTeach);
}
