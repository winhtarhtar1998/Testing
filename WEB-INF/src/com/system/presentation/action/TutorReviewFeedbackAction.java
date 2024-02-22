package com.system.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.system.business.service.TutorService;
import com.system.presentation.form.TutorForm;

public class TutorReviewFeedbackAction extends BaseAction {
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
		
		if(myForm.getFrmFormControlMyStudents().equals("1")){	// for 'Selected Subject'
			myTutorService.loadFeedbackOfSelectedSubject(myForm);
			return "gotoReviewFeedback";
		}
		else{													// for 'first load' click of left menu
			myForm.setFrmSubjectName("All Subjects");
			myTutorService.loadFeedbackOfSelectedSubject(myForm);
			return "gotoReviewFeedback";
		}
	}

}
