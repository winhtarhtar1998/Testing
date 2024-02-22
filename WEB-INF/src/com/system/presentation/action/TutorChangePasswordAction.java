package com.system.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.system.business.service.TutorService;
import com.system.presentation.form.TutorForm;

public class TutorChangePasswordAction extends BaseAction {
	
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
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";

		}
		TutorForm myForm = (TutorForm) form;
		TutorForm loginTutorForm=(TutorForm)request.getSession().getAttribute("TutorFormBean");
		myForm.setLoginPjTutor(loginTutorForm.getLoginPjTutor());
		
		// for change password
		if (request.getParameter("btnChangePassword") != null) {
			myForm.setFrmRegFormControl("data");
			ActionErrors errors = new ActionErrors();
			
			if (!myForm.getFrmRegPassword().equals(myForm.getFrmRegConfPassword())) {
				errors.add("passwordError", new ActionMessage(
						"errors.matchPassword"));
				saveErrors(request, errors);
				myForm.setFrmRegFormControl(null);
			}
			
			myTutorService.checkCurrentPassword(myForm);
			if (myForm.getFrmCurrentPasswordError() == null) {
				errors.add("currentPasswordError", new ActionMessage("errors.currentPassword"));
				saveErrors(request, errors);
				myForm.setFrmRegFormControl(null);
			}
			
			return "gotoChangePassword";
		}
		if (request.getParameter("btnSavePassword") != null) {
			
			myTutorService.saveNewPassword(myForm);
			myForm.setFrmTutorDetails(myForm.getLoginPjTutor());
			return "gotoMyProfile"; // add here
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
		TutorForm myForm = (TutorForm) form;
		TutorForm loginForm = (TutorForm) request.getSession().getAttribute("TutorFormBean");
		myForm.setLoginPjTutor(loginForm.getLoginPjTutor());
		
		myTutorService.firstLoadChangePassword(myForm);
		
		return "gotoChangePassword";
	}
}
