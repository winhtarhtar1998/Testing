package com.system.dao;

import java.util.List;

import com.system.business.entity.PjTutor;

public interface TutorDao {
	public PjTutor getTutorByEmailAndPassword(String strEmail,String strPassword);
	public PjTutor getTutorByEmail(String accountEmail);
	public void saveTutor(PjTutor tutor);
	
	// for explore tutors
	public PjTutor getTutorById(Integer Id);
	public List<PjTutor> getAllTutors();
	
	// delete tutor
	public void deleteTutor(PjTutor deleteTutor);
	
}
