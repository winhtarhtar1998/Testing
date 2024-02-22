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

public class TutorDeleteAccountAction extends BaseAction {
	
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
		
		// for confirm 
		if (request.getParameter("btnConfirmPassword") != null) {
			ActionErrors errors = new ActionErrors();
			int flag=0;
			myTutorService.checkCurrentPassword(myForm);
			if (myForm.getFrmCurrentPasswordError() == null) {
				errors.add("currentPasswordError", new ActionMessage("errors.currentPassword"));
				saveErrors(request, errors);
				flag=1;
			}
			
			if(flag==0){
				myForm.setFrmRegFormControl("data");
			}
			return "gotoDeleteAccount";
		}
		
		if (request.getParameter("btnDeleteAccount") != null) {
			
			myTutorService.deleteAccount(myForm);
			
			session=request.getSession(false);
			session.removeAttribute("TutorFormBean");
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
		TutorForm myForm = (TutorForm) form;
		TutorForm loginForm = (TutorForm) request.getSession().getAttribute("TutorFormBean");
		myForm.setLoginPjTutor(loginForm.getLoginPjTutor());
		myForm.setFrmTutorDetails(myForm.getLoginPjTutor());
		myForm.setFrmCurrentPassword(null);
		myForm.setFrmDeleteMessage(null);
		myForm.setFrmRegFormControl(null);
		
		myTutorService.checkAccountCanDeleteOrNot(myForm);
		
		if(myForm.getFrmDeleteMessage().equals("no"))
			return "gotoNotDeleteAccount";
		else 
			return "gotoDeleteAccount";
	}
}
