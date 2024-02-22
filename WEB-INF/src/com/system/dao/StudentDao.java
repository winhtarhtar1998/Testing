package com.system.dao;

import com.system.business.entity.PjStudent;

public interface StudentDao {
	public PjStudent getStudentByEmailAndPassword(String strEmail,String strPassword);
	public PjStudent getStudentByEmail(String accountEmail);
	public void saveStudent(PjStudent student);
	public PjStudent getStudentById(Integer studentId);
	
	public void deleteStudent(PjStudent deleteStudent);
}
