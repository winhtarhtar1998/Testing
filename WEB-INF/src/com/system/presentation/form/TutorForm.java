package com.system.presentation.form;

import java.util.List;

import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

import com.system.business.entity.PjRequest;
import com.system.business.entity.PjStudent;
import com.system.business.entity.PjSubject;
import com.system.business.entity.PjTeach;
import com.system.business.entity.PjTutor;

public class TutorForm extends ValidatorForm {
	
	// for tutor login
	private String frmTutorEmail;
	private String frmPassword;
	private PjTutor loginPjTutor;
	
	// for registration
	private String frmRegName;
	private String frmRegEmail;
	private String frmRegTutorType;
	private String frmRegHighestDegree;
	private String frmRegSpecialization;
	private String frmRegMoreDegrees;
	private String frmRegGender;
	private String frmRegPhoneNo;
	private String frmRegAddress;
	private String frmRegAbout;
	private FormFile frmRegPhotoFormFile;
	//private String frmPhotoFilePath;
	private String frmRegPassword;
	private String frmRegConfPassword;
	private String frmRegSubjectId;
	private String frmRegEmailError; // modified 'RegName' -> 'RegEmail'
	private String frmRegFormControl;
	private String frmRegSubjectName;
	
	//for first load 'My Subjects'
	private int begin;
	private int end;
	private List<PjTeach> myTeachList;
	
	//for add new subject
	private List<PjSubject> frmAddSubjectList;
	private String frmSubjectName;
	private String frmAddSubjectId;
	private String frmAddSubjectName;
	private String frmAddTeachingType;
	private String frmAddFee;
	private String frmAddPeriodPerWeek;
	private String frmAddPreferableTime;
	private String[] frmAddPreferableDays;
	private String frmAddPreferableDaysString;

	// for response students
	private List<PjRequest> frmRequestList;
	private int beginRequested;
	private int endRequested;
	private String frmFormControlResponse;
	private PjStudent frmStudentDetails;
	private String frmStudentDetailsId;
	private String frmRequestTeachId;
	private PjTeach frmRequestTeach;
	private String frmRequestId;
	private PjRequest frmRequest;
	
	// for 'My Students'
	private String frmFormControlMyStudents;
	private List<PjRequest> frmConnectedList;
	private List<PjRequest> frmCompletedList;
	private int beginCompleted;
	private int endCompleted;
	
	// for 'My Profile'
	private PjTutor frmTutorDetails;
	private String frmControl;
	
	// for 'Home' showing data
	private int frmNumRequestStudents;
	private int frmNumConnectedStudents;
	private int frmNumCompletedStudents;
	private int[][] totalPointsList;
	private List<PjTutor> frmCalculatedTutorList;
	private List frmAllTeachList;
	private PjTutor frmTopTutorsDetails;
	private String frmTopTutorDetailsId;
	private int frmMyPosition;
		
	// for Confirm Request 'Mail'
	private String frmMailAdd;
	private String frmMailMessage;
	private String frmMailName;
	
	// for delete action
	private String frmDeleteMessage;
	
	// for change password
	private String frmCurrentPassword;
	private String frmCurrentPasswordError;
	
	// getters and setters for login
	public String getFrmTutorEmail() {
		return frmTutorEmail;
	}
	public void setFrmTutorEmail(String frmTutorEmail) {
		this.frmTutorEmail = frmTutorEmail;
	}
	public String getFrmPassword() {
		return frmPassword;
	}
	public void setFrmPassword(String frmPassword) {
		this.frmPassword = frmPassword;
	}
	public PjTutor getLoginPjTutor() {
		return loginPjTutor;
	}
	public void setLoginPjTutor(PjTutor loginPjTutor) {
		this.loginPjTutor = loginPjTutor;
	}
	
	// getters and setters for registration
	public String getFrmRegName() {
		return frmRegName;
	}
	public void setFrmRegName(String frmRegName) {
		this.frmRegName = frmRegName;
	}
	public String getFrmRegEmail() {
		return frmRegEmail;
	}
	public void setFrmRegEmail(String frmRegEmail) {
		this.frmRegEmail = frmRegEmail;
	}
	public String getFrmRegTutorType() {
		return frmRegTutorType;
	}
	public void setFrmRegTutorType(String frmRegTutorType) {
		this.frmRegTutorType = frmRegTutorType;
	}
	
	public String getFrmRegHighestDegree() {
		return frmRegHighestDegree;
	}
	public void setFrmRegHighestDegree(String frmRegHighestDegree) {
		this.frmRegHighestDegree = frmRegHighestDegree;
	}
	public String getFrmRegMoreDegrees() {
		return frmRegMoreDegrees;
	}
	public void setFrmRegMoreDegrees(String frmRegMoreDegrees) {
		this.frmRegMoreDegrees = frmRegMoreDegrees;
	}
	public String getFrmRegSpecialization() {
		return frmRegSpecialization;
	}
	public void setFrmRegSpecialization(String frmRegSpecialization) {
		this.frmRegSpecialization = frmRegSpecialization;
	}
	public String getFrmRegGender() {
		return frmRegGender;
	}
	public void setFrmRegGender(String frmRegGender) {
		this.frmRegGender = frmRegGender;
	}
	public String getFrmRegPhoneNo() {
		return frmRegPhoneNo;
	}
	public void setFrmRegPhoneNo(String frmRegPhoneNo) {
		this.frmRegPhoneNo = frmRegPhoneNo;
	}
	public String getFrmRegAddress() {
		return frmRegAddress;
	}
	public void setFrmRegAddress(String frmRegAddress) {
		this.frmRegAddress = frmRegAddress;
	}
	public String getFrmRegAbout() {
		return frmRegAbout;
	}
	public void setFrmRegAbout(String frmRegAbout) {
		this.frmRegAbout = frmRegAbout;
	}
	public String getFrmRegPassword() {
		return frmRegPassword;
	}
	public void setFrmRegPassword(String frmRegPassword) {
		this.frmRegPassword = frmRegPassword;
	}
	public String getFrmRegConfPassword() {
		return frmRegConfPassword;
	}
	public void setFrmRegConfPassword(String frmRegConfPassword) {
		this.frmRegConfPassword = frmRegConfPassword;
	}
	public String getFrmRegSubjectId() {
		return frmRegSubjectId;
	}
	public void setFrmRegSubjectId(String frmRegSubjectId) {
		this.frmRegSubjectId = frmRegSubjectId;
	}
	public String getFrmRegEmailError() {
		return frmRegEmailError;
	}
	public void setFrmRegEmailError(String frmRegEmailError) {
		this.frmRegEmailError = frmRegEmailError;
	}
	public String getFrmRegFormControl() {
		return frmRegFormControl;
	}
	public void setFrmRegFormControl(String frmRegFormControl) {
		this.frmRegFormControl = frmRegFormControl;
	}
	public String getFrmRegSubjectName() {
		return frmRegSubjectName;
	}
	public void setFrmRegSubjectName(String frmRegSubjectName) {
		this.frmRegSubjectName = frmRegSubjectName;
	}
	
	// for add new subject
	public String getFrmSubjectName() {
		return frmSubjectName;
	}
	public void setFrmSubjectName(String frmSubjectName) {
		this.frmSubjectName = frmSubjectName;
	}
	public List<PjSubject> getFrmAddSubjectList() {
		return frmAddSubjectList;
	}
	public void setFrmAddSubjectList(List<PjSubject> frmAddSubjectList) {
		this.frmAddSubjectList = frmAddSubjectList;
	}
	public String getFrmAddSubjectName() {
		return frmAddSubjectName;
	}
	public void setFrmAddSubjectName(String frmAddSubjectName) {
		this.frmAddSubjectName = frmAddSubjectName;
	}
	public String getFrmAddTeachingType() {
		return frmAddTeachingType;
	}
	public void setFrmAddTeachingType(String frmAddTeachingType) {
		this.frmAddTeachingType = frmAddTeachingType;
	}
	public String getFrmAddFee() {
		return frmAddFee;
	}
	public void setFrmAddFee(String frmAddFee) {
		this.frmAddFee = frmAddFee;
	}
	public String getFrmAddSubjectId() {
		return frmAddSubjectId;
	}
	public void setFrmAddSubjectId(String frmAddSubjectId) {
		this.frmAddSubjectId = frmAddSubjectId;
	}
	public String getFrmAddPreferableTime() {
		return frmAddPreferableTime;
	}
	public void setFrmAddPreferableTime(String frmAddPreferableTime) {
		this.frmAddPreferableTime = frmAddPreferableTime;
	}
	public String getFrmAddPeriodPerWeek() {
		return frmAddPeriodPerWeek;
	}
	public void setFrmAddPeriodPerWeek(String frmAddPeriodPerWeek) {
		this.frmAddPeriodPerWeek = frmAddPeriodPerWeek;
	}
	public String[] getFrmAddPreferableDays() {
		return frmAddPreferableDays;
	}
	public void setFrmAddPreferableDays(String[] frmAddPreferableDays) {
		this.frmAddPreferableDays = frmAddPreferableDays;
	}
	public FormFile getFrmRegPhotoFormFile() {
		return frmRegPhotoFormFile;
	}
	public void setFrmRegPhotoFormFile(FormFile frmRegPhotoFormFile) {
		this.frmRegPhotoFormFile = frmRegPhotoFormFile;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public List<PjTeach> getMyTeachList() {
		return myTeachList;
	}
	public void setMyTeachList(List<PjTeach> myTeachList) {
		this.myTeachList = myTeachList;
	}
	public int getBeginRequested() {
		return beginRequested;
	}
	public void setBeginRequested(int beginRequested) {
		this.beginRequested = beginRequested;
	}
	public int getEndRequested() {
		return endRequested;
	}
	public void setEndRequested(int endRequested) {
		this.endRequested = endRequested;
	}
	public String getfrmFormControlResponse() {
		return frmFormControlResponse;
	}
	public void setfrmFormControlResponse(String frmFormControlResponse) {
		this.frmFormControlResponse = frmFormControlResponse;
	}
	public String getFrmFormControlResponse() {
		return frmFormControlResponse;
	}
	public void setFrmFormControlResponse(String frmFormControlResponse) {
		this.frmFormControlResponse = frmFormControlResponse;
	}
	public PjStudent getFrmStudentDetails() {
		return frmStudentDetails;
	}
	public void setFrmStudentDetails(PjStudent frmStudentDetails) {
		this.frmStudentDetails = frmStudentDetails;
	}
	public String getFrmStudentDetailsId() {
		return frmStudentDetailsId;
	}
	public void setFrmStudentDetailsId(String frmStudentDetailsId) {
		this.frmStudentDetailsId = frmStudentDetailsId;
	}
	public List<PjRequest> getFrmRequestList() {
		return frmRequestList;
	}
	public void setFrmRequestList(List<PjRequest> frmRequestList) {
		this.frmRequestList = frmRequestList;
	}
	public String getFrmRequestTeachId() {
		return frmRequestTeachId;
	}
	public void setFrmRequestTeachId(String frmRequestTeachId) {
		this.frmRequestTeachId = frmRequestTeachId;
	}
	public PjTeach getFrmRequestTeach() {
		return frmRequestTeach;
	}
	public void setFrmRequestTeach(PjTeach frmRequestTeach) {
		this.frmRequestTeach = frmRequestTeach;
	}
	public String getFrmRequestId() {
		return frmRequestId;
	}
	public void setFrmRequestId(String frmRequestId) {
		this.frmRequestId = frmRequestId;
	}
	public PjRequest getFrmRequest() {
		return frmRequest;
	}
	public void setFrmRequest(PjRequest frmRequest) {
		this.frmRequest = frmRequest;
	}
	public String getFrmFormControlMyStudents() {
		return frmFormControlMyStudents;
	}
	public void setFrmFormControlMyStudents(String frmFormControlMyStudents) {
		this.frmFormControlMyStudents = frmFormControlMyStudents;
	}
	public int getBeginCompleted() {
		return beginCompleted;
	}
	public void setBeginCompleted(int beginCompleted) {
		this.beginCompleted = beginCompleted;
	}
	public int getEndCompleted() {
		return endCompleted;
	}
	public void setEndCompleted(int endCompleted) {
		this.endCompleted = endCompleted;
	}
	public List<PjRequest> getFrmConnectedList() {
		return frmConnectedList;
	}
	public void setFrmConnectedList(List<PjRequest> frmConnectedList) {
		this.frmConnectedList = frmConnectedList;
	}
	public List<PjRequest> getFrmCompletedList() {
		return frmCompletedList;
	}
	public void setFrmCompletedList(List<PjRequest> frmCompletedList) {
		this.frmCompletedList = frmCompletedList;
	}
	/*public String getFrmPhotoFilePath() {
		return frmPhotoFilePath;
	}
	public void setFrmPhotoFilePath(String frmPhotoFilePath) {
		this.frmPhotoFilePath = frmPhotoFilePath;
	}*/
	public PjTutor getFrmTutorDetails() {
		return frmTutorDetails;
	}
	public void setFrmTutorDetails(PjTutor frmTutorDetails) {
		this.frmTutorDetails = frmTutorDetails;
	}
	public String getFrmControl() {
		return frmControl;
	}
	public void setFrmControl(String frmControl) {
		this.frmControl = frmControl;
	}
	public int getFrmNumRequestStudents() {
		return frmNumRequestStudents;
	}
	public void setFrmNumRequestStudents(int frmNumRequestStudents) {
		this.frmNumRequestStudents = frmNumRequestStudents;
	}
	public int getFrmNumConnectedStudents() {
		return frmNumConnectedStudents;
	}
	public void setFrmNumConnectedStudents(int frmNumConnectedStudents) {
		this.frmNumConnectedStudents = frmNumConnectedStudents;
	}
	public int getFrmNumCompletedStudents() {
		return frmNumCompletedStudents;
	}
	public void setFrmNumCompletedStudents(int frmNumCompletedStudents) {
		this.frmNumCompletedStudents = frmNumCompletedStudents;
	}
	public int[][] getTotalPointsList() {
		return totalPointsList;
	}
	public void setTotalPointsList(int[][] totalPointsList) {
		this.totalPointsList = totalPointsList;
	}
	public List<PjTutor> getFrmCalculatedTutorList() {
		return frmCalculatedTutorList;
	}
	public void setFrmCalculatedTutorList(List<PjTutor> frmCalculatedTutorList) {
		this.frmCalculatedTutorList = frmCalculatedTutorList;
	}
	public List getFrmAllTeachList() {
		return frmAllTeachList;
	}
	public void setFrmAllTeachList(List frmAllTeachList) {
		this.frmAllTeachList = frmAllTeachList;
	}
	public PjTutor getFrmTopTutorsDetails() {
		return frmTopTutorsDetails;
	}
	public void setFrmTopTutorsDetails(PjTutor frmTopTutorsDetails) {
		this.frmTopTutorsDetails = frmTopTutorsDetails;
	}
	public String getFrmTopTutorDetailsId() {
		return frmTopTutorDetailsId;
	}
	public void setFrmTopTutorDetailsId(String frmTopTutorDetailsId) {
		this.frmTopTutorDetailsId = frmTopTutorDetailsId;
	}
	public int getFrmMyPosition() {
		return frmMyPosition;
	}
	public void setFrmMyPosition(int frmMyPosition) {
		this.frmMyPosition = frmMyPosition;
	}
	public String getFrmMailAdd() {
		return frmMailAdd;
	}
	public void setFrmMailAdd(String frmMailAdd) {
		this.frmMailAdd = frmMailAdd;
	}
	public String getFrmMailMessage() {
		return frmMailMessage;
	}
	public void setFrmMailMessage(String frmMailMessage) {
		this.frmMailMessage = frmMailMessage;
	}
	public String getFrmMailName() {
		return frmMailName;
	}
	public void setFrmMailName(String frmMailName) {
		this.frmMailName = frmMailName;
	}
	public String getFrmDeleteMessage() {
		return frmDeleteMessage;
	}
	public void setFrmDeleteMessage(String frmDeleteMessage) {
		this.frmDeleteMessage = frmDeleteMessage;
	}
	public String getFrmCurrentPassword() {
		return frmCurrentPassword;
	}
	public void setFrmCurrentPassword(String frmCurrentPassword) {
		this.frmCurrentPassword = frmCurrentPassword;
	}
	public String getFrmCurrentPasswordError() {
		return frmCurrentPasswordError;
	}
	public void setFrmCurrentPasswordError(String frmCurrentPasswordError) {
		this.frmCurrentPasswordError = frmCurrentPasswordError;
	}
	public String getFrmAddPreferableDaysString() {
		return frmAddPreferableDaysString;
	}
	public void setFrmAddPreferableDaysString(String frmAddPreferableDaysString) {
		this.frmAddPreferableDaysString = frmAddPreferableDaysString;
	}
	
}
