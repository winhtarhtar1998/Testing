package com.system.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.system.business.service.TutorService;
import com.system.presentation.form.StudentForm;
import com.system.presentation.form.TutorForm;

public class TutorProfileAction extends BaseAction {
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
		return null;
	}
	
	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		TutorForm myForm = (TutorForm) form;
		TutorForm loginForm = (TutorForm) request.getSession().getAttribute("TutorFormBean");
		myForm.setLoginPjTutor(loginForm.getLoginPjTutor());
		myTutorService.firstLoadMyProfile(myForm);
		
		return "gotoMyProfile";
	}

}
