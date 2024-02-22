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

public class StudentUpdateAction extends BaseAction {
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
		
		if (request.getParameter("btnUpdateCancel") != null) {
			return "gotoMyProfile";
		}
		if (request.getParameter("btnSaveCancel") != null) {
			myForm.setFrmRegFormControl(null);
			return "gotoUpdate";
		}
		if (request.getParameter("btnUpdate") != null) {
			int flag = 0;
			ActionErrors errors = new ActionErrors();
			if (myForm.getFrmRegGrade().equals("0")) {
				errors.add("gradeError", new ActionMessage("errors.grade"));
				saveErrors(request, errors);
				flag = 1;
			}
			
			if (flag == 0) {
					myForm.setFrmRegFormControl("data");
			}
			return "gotoUpdate";
		}
		if (request.getParameter("btnSave") != null) {
			String photoFilePath=getServlet().getServletContext().getRealPath("");
			myStudentService.saveUpdateStudent(myForm,photoFilePath);
			myStudentService.firstLoadUpdateProfile(myForm,photoFilePath);
			
			return "gotoUpdate";
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
		StudentForm loginForm = (StudentForm) request.getSession()
				.getAttribute("StudentFormBean");
		myForm.setLoginPjStudent(loginForm.getLoginPjStudent());
		String photoFilePath=getServlet().getServletContext().getRealPath("");
		myStudentService.firstLoadUpdateProfile(myForm,photoFilePath);
		
		return "gotoUpdate";
	}
	
}
