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

public class TutorEditSubjectAction extends BaseAction {
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
		TutorForm loginForm = (TutorForm) request.getSession()
		.getAttribute("TutorFormBean");
		myForm.setLoginPjTutor(loginForm.getLoginPjTutor());
		
		if (request.getParameter("btnEditSubject") != null) {
			
			myForm.setFrmDeleteMessage("");
			myForm.setFrmRegFormControl("data");
			
			ActionErrors errors = new ActionErrors();
			
			if (myForm.getFrmAddTeachingType().equals("0")) {
				errors.add("teachingTypeError", new ActionMessage("errors.teachingType"));
				saveErrors(request, errors);
				myForm.setFrmRegFormControl(null);
			}
			if (myForm.getFrmAddPreferableDays()==null) {
				errors.add("preferableDaysError", new ActionMessage("errors.preferableDays"));
				saveErrors(request, errors);
				myForm.setFrmRegFormControl(null);
			}
			if (Double.parseDouble(myForm.getFrmAddFee())<=0) {
				errors.add("feeError", new ActionMessage("errors.minFee"));
				saveErrors(request, errors);
				myForm.setFrmRegFormControl(null);
			}
			if (Integer.parseInt(myForm.getFrmAddPeriodPerWeek())<=0) {
				errors.add("periodError", new ActionMessage("errors.minPeriod"));
				saveErrors(request, errors);
				myForm.setFrmRegFormControl(null);
			}
			
			if(myForm.getFrmRegFormControl()!=null){
				myTutorService.loadEditSubjectConfirm(myForm);
			}
			return "gotoEdit";
		}
		
		if (request.getParameter("btnEditSubjectSave") != null) {
			
			myTutorService.saveEditTeach(myForm);
			myTutorService.loadAllTeachOfTutor(myForm);
			myForm.setFrmDeleteMessage("");
			return "gotoTeach";
		}
		if(isCancelled(request))
		{
			myForm.setFrmDeleteMessage("");
			myTutorService.loadAllTeachOfTutor(myForm);
			return "gotoTeach";
		}
		if (request.getParameter("btnSaveCancel") != null) {
			myForm.setFrmRegFormControl(null);
			return "gotoEdit";
		}
		
		return "gotoTeach";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		TutorForm myForm = (TutorForm) form;
		TutorForm loginForm = (TutorForm) request.getSession().getAttribute("TutorFormBean");
		myForm.setLoginPjTutor(loginForm.getLoginPjTutor());
	
			myTutorService.loadEditTeach(myForm);
			return "gotoEdit";
	}


}
