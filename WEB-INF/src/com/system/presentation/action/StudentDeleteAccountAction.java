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

public class StudentDeleteAccountAction extends BaseAction {
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
		StudentForm myForm = (StudentForm) form;
		StudentForm loginStudentForm=(StudentForm)request.getSession().getAttribute("StudentFormBean");
		myForm.setLoginPjStudent(loginStudentForm.getLoginPjStudent());
		
		// for confirm 
		if (request.getParameter("btnConfirmPassword") != null) {
			myForm.setFrmRegFormControl("data");
			ActionErrors errors = new ActionErrors();
			
			myStudentService.checkCurrentPassword(myForm);
			if (myForm.getFrmCurrentPasswordError() == null) {
				errors.add("currentPasswordError", new ActionMessage("errors.currentPassword"));
				saveErrors(request, errors);
				myForm.setFrmRegFormControl(null);
			}
			
			return "gotoDeleteAccount";
		}
		
		if (request.getParameter("btnDeleteAccount") != null) {
			
			myStudentService.deleteAccount(myForm);
			
			session=request.getSession(false);
			session.removeAttribute("StudentFormBean");
			session.invalidate();
			return "gotoDeleteSuccess"; 		// to page that will show 'delete is successful
		}
		
		return "gotoMyProfile";
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
		myForm.setFrmStudentDetails(myForm.getLoginPjStudent());
		myForm.setFrmCurrentPassword(null);
		myForm.setFrmDeleteMessage(null);
		myForm.setFrmRegFormControl(null);
		
		myStudentService.checkAccountCanDeleteOrNot(myForm);
		
		if(myForm.getFrmDeleteMessage().equals("no"))
			return "gotoNotDeleteAccount";
		else 
			return "gotoDeleteAccount";
	}


}
