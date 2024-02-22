package com.system.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.system.business.entity.PjStudent;
import com.system.business.service.StudentService;
import com.system.business.service.TutorService;
import com.system.presentation.form.TutorForm;

public class TutorResponseStudentAction extends BaseAction {
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
		
		if(myForm.getfrmFormControlResponse().equals("0")){	
			myTutorService.getRequestList(myForm);
			return "gotoResponse";				// just for first load 
		}
		else if(myForm.getfrmFormControlResponse().equals("1")){
			myTutorService.getStudentById(myForm);
			return "gotoStudentDetails";
		}
		else if(myForm.getfrmFormControlResponse().equals("2")){
			myTutorService.getTeachById(myForm);
			return "gotoRequestTeachDetails";
		}
		else if(myForm.getfrmFormControlResponse().equals("3")){
			myTutorService.connectStudent(myForm);
			return "gotoResponseSuccess";		// go to response success page
		}
		else if(myForm.getfrmFormControlResponse().equals("31")){
			myTutorService.cancelRequest(myForm);
			myTutorService.getRequestList(myForm);
			myForm.setfrmFormControlResponse("0");
			return "gotoResponse";		// go to response success page
		}
		else {									// equals to "4"
				// need to add cache when Subject - select box is added at the top
			myTutorService.getRequestList(myForm);
			return "gotoResponse";
		}
	}
	
}
