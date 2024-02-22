package com.system.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.system.business.service.StudentService;
import com.system.presentation.form.StudentForm;
import com.system.presentation.form.TutorForm;

public class StudentProfileAction extends BaseAction {
	private StudentService myStudentService;
	
	public StudentService getMyStudentService() {
		return myStudentService;
	}
	public void setMyStudentService(StudentService myStudentService) {
		this.myStudentService = myStudentService;
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";

		}
		return null; 
	}
	
	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		StudentForm myForm = (StudentForm) form;
		StudentForm loginForm = (StudentForm) request.getSession().getAttribute("StudentFormBean");
		myForm.setLoginPjStudent(loginForm.getLoginPjStudent());
		myStudentService.firstLoadMyProfile(myForm);

		return "gotoMyProfile";
	}

}
