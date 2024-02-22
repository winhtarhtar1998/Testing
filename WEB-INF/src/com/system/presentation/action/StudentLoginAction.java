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

public class StudentLoginAction extends BaseAction {
	
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
		  StudentForm myForm=(StudentForm) form;
		   myStudentService.checkLoginStudent(myForm);
		 	   
		   ActionErrors errors=new ActionErrors();
		   if(myForm.getLoginPjStudent()==null)
		   {
			   errors.add("loginerror", new ActionMessage("errors.login"));
			   saveErrors(request,errors);
			   return "gotoLogin";
		   }
		   else
		   {	
			   request.getSession(true);
			   request.getSession().setAttribute("id", request.getSession().getId());
			   
			   myStudentService.firstLoadHome(myForm);
			   return "gotoHome";
			   
		   }
		   
	
	}
	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {

		StudentForm myForm=(StudentForm) form;
		StudentForm loginStudentForm=(StudentForm)request.getSession().getAttribute("StudentFormBean");
		myForm.setLoginPjStudent(loginStudentForm.getLoginPjStudent());
		myForm.setFrmStudentDetails(myForm.getLoginPjStudent());
		return "gotoLogin";
	}

}
