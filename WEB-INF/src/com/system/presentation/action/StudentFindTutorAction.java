package com.system.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import com.system.business.service.StudentService;
import com.system.presentation.form.StudentForm;
import com.system.presentation.form.TutorForm;

public class StudentFindTutorAction extends BaseAction {
	private StudentService myStudentService;
	
	public StudentService getMyStudentService() {
		return myStudentService;
	}
	public void setMyStudentService(StudentService myStudentService) {
		this.myStudentService = myStudentService;
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		
		StudentForm myForm = (StudentForm) form;
		StudentForm loginStudentForm=(StudentForm) request.getSession().getAttribute("StudentFormBean");
		myForm.setLoginPjStudent(loginStudentForm.getLoginPjStudent());
		
		Integer selectedSubjectId=Integer.parseInt(myForm.getFrmFindSubjectId());
		String selectedTeachingType=myForm.getFrmFindTeachingType();
		
		if(request.getParameter("btnFindTutor")!=null)
		{
			
			if(selectedSubjectId==0 && selectedTeachingType.equals("0")){
				myStudentService.getAllTeachList(myForm);
				return "gotoSearch";
			}else{
				if(selectedSubjectId==0 && !selectedTeachingType.equals("0")){
					myStudentService.getFindTeachListByTeachingType(myForm, selectedTeachingType);
					return "gotoSearch";
				}
				else if(selectedSubjectId!=0 && selectedTeachingType.equals("0")){
					myStudentService.getFindTeachListBySubject(myForm, selectedSubjectId);
					return "gotoSearch";
				}
				else {
					myStudentService.getFindTeachListBySubjectAndTeachingType(myForm, selectedSubjectId, selectedTeachingType);
					return "gotoSearch";
				}
			}
		}
		else if(request.getParameter("btnRequestTutor")!=null){
			myStudentService.saveStudentRequest(myForm);
			return "gotoRequestSuccess";
		}
		return "gotoSearch";
	
	}
	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		
		
		StudentForm myForm = (StudentForm) form;
		StudentForm loginStudentForm=(StudentForm) request.getSession().getAttribute("StudentFormBean");
		myForm.setLoginPjStudent(loginStudentForm.getLoginPjStudent());
		
		Integer selectedSubjectId;
		String selectedTeachingType;
		
		if(myForm.getFrmControl().equals("2")){
			selectedSubjectId=Integer.parseInt(myForm.getFrmFindSubjectId());
			selectedTeachingType=myForm.getFrmFindTeachingType();
			
			myStudentService.setFindTutorDetails(myForm);
			return "gotoDetail"; 
		}
		else if(myForm.getFrmControl().equals("1")){
			selectedSubjectId=Integer.parseInt(myForm.getFrmFindSubjectId());
			selectedTeachingType=myForm.getFrmFindTeachingType();
			
			if(selectedSubjectId==0 && selectedTeachingType=="0"){
				myStudentService.getAllTeachList(myForm);
				return "gotoSearch";
			}
			else{
				if(selectedSubjectId==0 && !selectedTeachingType.equals("0")){
					myStudentService.getFindTeachListByTeachingType(myForm, selectedTeachingType);
					return "gotoSearch";
				}
				else if(selectedSubjectId!=0 && selectedTeachingType.equals("0")){
					myStudentService.getFindTeachListBySubject(myForm, selectedSubjectId);
					return "gotoSearch";
				}
				else {
					myStudentService.getFindTeachListBySubjectAndTeachingType(myForm, selectedSubjectId, selectedTeachingType);
					return "gotoSearch";
				}
			}
		}
		else if(myForm.getFrmControl().equals("3")){
			myStudentService.firstLoadRequestTutor(myForm);
			return "gotoRequest";
		}
		else{
		myStudentService.firstLoadFindTutors(myForm);
		myStudentService.getAllTeachList(myForm);
		return "gotoSearch";
		}
	}

}
