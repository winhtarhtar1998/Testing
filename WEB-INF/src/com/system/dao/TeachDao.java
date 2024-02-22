package com.system.dao;

import java.util.List;

import com.system.business.entity.PjSubject;
import com.system.business.entity.PjTeach;
import com.system.business.entity.PjTutor;
import com.system.presentation.form.StudentForm;

public interface TeachDao {
	public void saveTeach(PjTeach myTeach);
	
	// for find tutors
	public List<PjTeach> getTeachListAll(); 		// all teach list (both not specified)
	public List<PjTeach> getTeachListBySubject(PjSubject subject);	// selected Subject
	public List<PjTeach> getTeachListByTeachingType(String teachingType);	// by Teaching Type
	public List<PjTeach> getTeachListBySubjectAndTeachType(PjSubject subject,String teachingType);
	public PjTeach getTeachById(Integer teachId);
	public List<PjTeach> getAllTeachofTutor(PjTutor myTutor);
	public void deleteTeachById(PjTeach deleteTeach);
	
	
}
