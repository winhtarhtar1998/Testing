package com.system.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.system.business.service.TutorService;
import com.system.dao.TeachDao;
import com.system.presentation.form.TutorForm;

public class TutorAddNewSubjectAction extends BaseAction {
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
		
		if (request.getParameter("btnAddNewSubjectFirst") != null) {
			myTutorService.firstLoadAddNewSubject(myForm);
			return "gotoAddSubject";
		}
		
		if (request.getParameter("btnAddNewSubject") != null) {
			
			myForm.setFrmDeleteMessage("");
			myForm.setFrmRegFormControl("data");
			
			ActionErrors errors = new ActionErrors();
			
			if (myForm.getFrmAddSubjectId().equals("0")) {
				errors.add("subjectError", new ActionMessage("errors.subject"));
				saveErrors(request, errors);
				myForm.setFrmRegFormControl(null);
			}
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
				myTutorService.loadAddSubjectConfirm(myForm);
			}
			return "gotoAddSubject";
		}
		if (request.getParameter("btnSaveNewSubject") != null) {
			myTutorService.saveNewTeach(myForm);
			myForm.setFrmDeleteMessage("");
			myTutorService.loadAllTeachOfTutor(myForm);
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
			return "gotoAddSubject";
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
		
		if(myForm.getFrmControl().equals("1")){
			myTutorService.deleteSelectedTeach(myForm);
			myTutorService.loadAllTeachOfTutor(myForm);
			return "gotoTeach";
		}
		else{
			myTutorService.loadAllTeachOfTutor(myForm);
			myForm.setFrmDeleteMessage("");
			return "gotoTeach";
		}
	}

}
