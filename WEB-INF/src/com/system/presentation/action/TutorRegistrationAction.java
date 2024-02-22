package com.system.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.system.business.service.TutorService;
import com.system.presentation.form.StudentForm;
import com.system.presentation.form.TutorForm;

public class TutorRegistrationAction extends BaseAction {
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
		TutorForm myForm = (TutorForm) form;
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
			
			if (!myForm.getFrmRegPassword().equals(
					myForm.getFrmRegConfPassword())) {
				errors.add("passwordError", new ActionMessage(
						"errors.matchPassword"));
				saveErrors(request, errors);
				flag = 1;
			}
			if (flag == 0) {
				myTutorService.checkAccountEmail(myForm);
				if (myForm.getFrmRegEmailError() == null) {
					errors.add("accountError", new ActionMessage(
							"errors.account"));
					saveErrors(request, errors);
				}
			}
			return "gotoRegister";
		}
		if (request.getParameter("btnSave") != null) {
			
			myTutorService.saveNewTutor(myForm);
			myForm=(TutorForm) request.getSession().getAttribute("RegFormBean");
			String photoFilePath=getServlet().getServletContext().getRealPath("");
			myTutorService.writeTutorPhotoFile(myForm, photoFilePath);
			return "gotoRegisterSuccess"; // add here
		}

		return "gotoRegister";

	}
	
	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		TutorForm myForm = (TutorForm) form;
		myTutorService.firstLoadRegistration(myForm);
		return "gotoRegister";
	}

}
