package com.system.dao;

import java.util.List;

import com.system.business.entity.PjSubject;

public interface SubjectDao {
	public List<PjSubject> getAllSubject();
	 public PjSubject getSubjectById(Integer id);
}
