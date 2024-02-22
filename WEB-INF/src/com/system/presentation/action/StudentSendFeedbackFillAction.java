package com.system.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.system.business.service.StudentService;
import com.system.presentation.form.StudentForm;

public class StudentSendFeedbackFillAction extends BaseAction {
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
		StudentForm myForm = (StudentForm) form;
		StudentForm loginStudentForm=(StudentForm) request.getSession().getAttribute("StudentFormBean");
		myForm.setLoginPjStudent(loginStudentForm.getLoginPjStudent());
		
		if(request.getParameter("btnSendFeedback")!=null){
			
			myStudentService.saveStudentFeedback(myForm);
			myForm.setFrmRegFormControl("data");
			return "gotoSendFeedbackFill";
		}
		
		return "gotoSendFeedback";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		StudentForm myForm = (StudentForm) form;
		StudentForm loginStudentForm=(StudentForm) request.getSession().getAttribute("StudentFormBean");
		myForm.setLoginPjStudent(loginStudentForm.getLoginPjStudent());
	
		myStudentService.firstLoadSendFeedback(myForm);
		return "gotoSendFeedbackFill";
	}
}
