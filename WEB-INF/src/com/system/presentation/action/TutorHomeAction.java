package com.system.presentation.action;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.system.business.service.TutorService;
import com.system.presentation.form.TutorForm;

public class TutorHomeAction extends BaseAction {
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
		TutorForm myForm=(TutorForm)form;
		   myTutorService.checkLoginTutor(myForm);
		   ActionErrors errors=new ActionErrors();
		   if(myForm.getLoginPjTutor()==null)
		   {
			   errors.add("loginerror", new ActionMessage("errors.login"));
			   saveErrors(request,errors);
			   return "gotoLogin";
		   }
		   else
		   {
			   request.getSession(true);
			   request.getSession().setAttribute("id", request.getSession().getId());
			   return "gotoHome";
		   }
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		TutorForm myForm=(TutorForm) form;
		TutorForm loginTutorForm=(TutorForm)request.getSession().getAttribute("TutorFormBean");
		myForm.setLoginPjTutor(loginTutorForm.getLoginPjTutor());
		
		if(myForm.getFrmControl().equals("1")){
			myTutorService.loadTopTutorDetails(myForm);
			return "gotoTopTutorDetails";
		}
		else{
			myTutorService.firstLoadHome(myForm);
			return "gotoHome";
		}
	}

}
