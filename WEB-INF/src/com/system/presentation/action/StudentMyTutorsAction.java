package com.system.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.system.business.service.StudentService;
import com.system.presentation.form.StudentForm;

public class StudentMyTutorsAction extends BaseAction {
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
		return null;
	}
	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
			StudentForm myForm = (StudentForm) form;
			StudentForm loginStudentForm=(StudentForm) request.getSession().getAttribute("StudentFormBean");
			myForm.setLoginPjStudent(loginStudentForm.getLoginPjStudent());
			
		if(myForm.getFrmControlMyTutors().equals("1")){			// for 'Tutor Details'
			myStudentService.setFindTutorDetails(myForm);
			return "gotoTutorDetails";
		}
		else if(myForm.getFrmControlMyTutors().equals("2")){	// for 'Class Details'
			myStudentService.setTeachDetails(myForm);
			return "gotoTeachDetails";
		}
		else if(myForm.getFrmControlMyTutors().equals("3")){	// for 'Request Cancel'
			myStudentService.requestCancel(myForm);
			myStudentService.firstLoadMyTutors(myForm);
			return "gotoMyTutors";
		}
		else{													// for 'first load' click of left menu
			
			myStudentService.firstLoadMyTutors(myForm);
			return "gotoMyTutors";
		}
	}
	
	
}
