package com.system.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.system.business.service.StudentService;
import com.system.presentation.form.StudentForm;
import com.system.presentation.form.TutorForm;

public class StudentRegistrationAction extends BaseAction {
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
		myForm=(StudentForm) request.getSession().getAttribute("StuRegFormBean");
		if (request.getParameter("btnRegisterCancel") != null) {
			return "gotoLogin";
		}
		if (request.getParameter("btnSaveCancel") != null) {
			myForm.setFrmRegFormControl(null);
			return "gotoRegister";
		}
		if(isCancelled(request))
		{
			return "gotoLogin";
		}
		if (request.getParameter("btnRegister") != null) {
			int flag = 0;
			ActionErrors errors = new ActionErrors();
			if (myForm.getFrmRegGrade().equals("0")) {
				errors.add("gradeError", new ActionMessage("errors.grade"));
				saveErrors(request, errors);
				flag = 1;
			}
			if (!myForm.getFrmRegPassword().equals(
					myForm.getFrmRegConfPassword())) {
				errors.add("passwordError", new ActionMessage(
						"errors.matchPassword"));
				saveErrors(request, errors);
				flag = 1;
			}
			if (flag == 0) {
				myStudentService.checkAccountEmail(myForm);
				if (myForm.getFrmRegEmailError() == null) {
					errors.add("accountError", new ActionMessage(
							"errors.account"));
					saveErrors(request, errors);
				}
			}
			return "gotoRegister";
		}
		if (request.getParameter("btnSave") != null) {
			
			myStudentService.saveNewStudent(myForm);
			myForm=(StudentForm) request.getSession().getAttribute("StuRegFormBean");
			String photoFilePath=getServlet().getServletContext().getRealPath("");
			myStudentService.writeStudentPhotoFile(myForm, photoFilePath);
			return "gotoRegisterSuccess"; // add here
		}

		return "gotoRegister";

	}
	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		StudentForm myForm = (StudentForm) form;
		myStudentService.firstLoadRegistration(myForm);
		return "gotoRegister"; 
	}
	
}
