package com.system.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.system.business.service.TutorService;
import com.system.presentation.form.TutorForm;

public class TutorMyStudentsAction extends BaseAction {
	private TutorService myTutorService;

	public TutorService getMyTutorService() {
		return myTutorService;
	}
	public void setMyTutorService(TutorService myTutorService) {
		this.myTutorService = myTutorService;
	}
	
	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		TutorForm myForm=(TutorForm) form;
		TutorForm loginTutorForm=(TutorForm)request.getSession().getAttribute("TutorFormBean");
		myForm.setLoginPjTutor(loginTutorForm.getLoginPjTutor());
		
		if(myForm.getFrmFormControlMyStudents().equals("1")){			// for 'Student Details'
			myTutorService.setStudentDetails(myForm);
			return "gotoStudentDetails";
		}
		else if(myForm.getFrmFormControlMyStudents().equals("2")){	// for 'Class Details'
			myTutorService.setTeachDetails(myForm);
			return "gotoTeachDetails";
		}
		else if(myForm.getFrmFormControlMyStudents().equals("3")){	// for 'Change Completed'
			myTutorService.changeCompleted(myForm);
			myTutorService.firstLoadMyStudents(myForm);
			return "gotoMyStudents";
		}
		else{													// for 'first load' click of left menu
			
			myTutorService.firstLoadMyStudents(myForm);
			return "gotoMyStudents";
		}
	}
	
	

}
