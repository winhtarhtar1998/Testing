package com.system.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.system.business.entity.PjTutor;
import com.system.business.service.TutorService;
import com.system.presentation.form.TutorForm;

public class TutorUpdateAction extends BaseAction {
	
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
		System.out.println("Button click");
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
			if (myForm.getFrmRegTutorType().equals("0")) {
				errors.add("tutorTypeError", new ActionMessage("errors.tutorType"));
				saveErrors(request, errors);
				flag = 1;
			}
			if (myForm.getFrmRegHighestDegree().equals("0")) {
				errors.add("educationError", new ActionMessage("errors.education"));
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
			myTutorService.saveUpdateTutor(myForm,photoFilePath);
			//myForm.setFrmTutorDetails(myForm.getLoginPjTutor());
			myTutorService.firstLoadUpdateProfile(myForm,photoFilePath);
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
		TutorForm myForm = (TutorForm) form;
		TutorForm loginForm = (TutorForm) request.getSession()
				.getAttribute("TutorFormBean");
		myForm.setLoginPjTutor(loginForm.getLoginPjTutor());
		String photoFilePath=getServlet().getServletContext().getRealPath("");
		myTutorService.firstLoadUpdateProfile(myForm,photoFilePath);
		return "gotoUpdate";
	}
}
