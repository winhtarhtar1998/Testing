package com.system.presentation.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

import com.system.business.entity.PjRequest;
import com.system.business.entity.PjStudent;
import com.system.business.entity.PjSubject;
import com.system.business.entity.PjTeach;
import com.system.business.entity.PjTutor;

/**
 * @author PC054
 *
 */
public class StudentForm extends ValidatorForm {
	// for student login
	private String frmStudentEmail;
	private String frmPassword;
	private PjStudent loginPjStudent;
	
	// for student registration 
	private String frmRegName;
	private String frmRegEmail;
	private String frmRegGrade;
	private String frmRegGender;
	private String frmRegPhoneNo;
	private String frmRegAddress;
	private FormFile frmRegPhotoFormFile;
	//private String frmPhotoFilePath;
	private String frmRegPassword;
	private String frmRegConfPassword;
	private String frmRegEmailError; // modified 'RegName' -> 'RegEmail'
	private String frmRegFormControl;
	
	//for find Tutor 
	private List<PjSubject> frmFindSubjectList;	// for user choose subject
	private String frmSubjectName;
	private String frmFindSubjectId;
	private String frmFindSubjectName;
	private String frmFindTeachingType;
	private List<PjTeach> frmFindTeachList;
	private List<PjTutor> frmFindTutorList;
	private int begin;
	private int end;
	private String frmControlFind;
	private String frmFindTutorDetailsId;
	private PjTutor frmFindTutorDetails;
	
	private String frmDetailTeachId;// for teach details
	private String frmControl;		// for find tutor		
	private PjTeach frmDetailTeach;
	
	// for request tutor
	private String frmRequestTeachId; 		// for 'request now' link & 'Request Cancel' link
	private PjTeach frmRequestTeach;
	private String frmRequestDate;
	private String frmStatus;
	private String frmExtraRequestMessage;
	
	// for My Tutors
	private String frmControlMyTutors;
	private List<PjRequest> frmRequestedTutorsList;
	private List<PjRequest> frmConnectedTutorsList;
	private List<PjRequest> frmCompletedTutorsList;
	private int beginConnected;
	private int endConnected;
	private int beginCompleted;
	private int endCompleted;
	
	// for 'Send Feedback'
	private String frmFeedbackArea;
	private Integer frmRatingPoint;
	private PjRequest frmRequest;
	
	// for 'My Profile'
	private PjStudent frmStudentDetails;
	
	// for 'Home' showing data
	private int frmNumRequestTutors;
	private int frmNumConnectedTutors;
	private int frmNumCompletedTutors;
	private int[][] totalPointsList;
	private List<PjTutor> frmCalculatedTutorList;
	private List frmAllTeachList;
	private PjTutor frmTopTutorsDetails;
	private String frmTopTutorDetailsId;
	private List<PjTeach> frmMyTeachList;
	private ArrayList<String> frmRequestStatus;
	
	// for change password
	private String frmCurrentPassword;
	private String frmCurrentPasswordError;
	
	// for delete account
	private String frmDeleteMessage;
	
	// getters and setters
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
	public String getFrmRegGrade() {
		return frmRegGrade;
	}
	public void setFrmRegGrade(String frmRegGrade) {
		this.frmRegGrade = frmRegGrade;
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
	
	public String getFrmStudentEmail() {
		return frmStudentEmail;
	}
	public void setFrmStudentEmail(String frmStudentEmail) {
		this.frmStudentEmail = frmStudentEmail;
	}
	public String getFrmPassword() {
		return frmPassword;
	}
	public void setFrmPassword(String frmPassword) {
		this.frmPassword = frmPassword;
	}
	public PjStudent getLoginPjStudent() {
		return loginPjStudent;
	}
	public void setLoginPjStudent(PjStudent loginPjStudent) {
		this.loginPjStudent = loginPjStudent;
	}
	public List<PjSubject> getFrmFindSubjectList() {
		return frmFindSubjectList;
	}
	public void setFrmFindSubjectList(List<PjSubject> frmFindSubjectList) {
		this.frmFindSubjectList = frmFindSubjectList;
	}
	public String getFrmSubjectName() {
		return frmSubjectName;
	}
	public void setFrmSubjectName(String frmSubjectName) {
		this.frmSubjectName = frmSubjectName;
	}
	public String getFrmFindSubjectId() {
		return frmFindSubjectId;
	}
	public void setFrmFindSubjectId(String frmFindSubjectId) {
		this.frmFindSubjectId = frmFindSubjectId;
	}
	public String getFrmFindSubjectName() {
		return frmFindSubjectName;
	}
	public void setFrmFindSubjectName(String frmFindSubjectName) {
		this.frmFindSubjectName = frmFindSubjectName;
	}
	public String getFrmFindTeachingType() {
		return frmFindTeachingType;
	}
	public void setFrmFindTeachingType(String frmFindTeachingType) {
		this.frmFindTeachingType = frmFindTeachingType;
	}
	public List<PjTeach> getFrmFindTeachList() {
		return frmFindTeachList;
	}
	public void setFrmFindTeachList(List<PjTeach> frmFindTeachList) {
		this.frmFindTeachList = frmFindTeachList;
	}
	public String getFrmControlFind() {
		return frmControlFind;
	}
	public void setFrmControlFind(String frmControlFind) {
		this.frmControlFind = frmControlFind;
	}
	public String getFrmDetailTeachId() {
		return frmDetailTeachId;
	}
	public void setFrmDetailTeachId(String frmDetailTeachId) {
		this.frmDetailTeachId = frmDetailTeachId;
	}
	public String getFrmControl() {
		return frmControl;
	}
	public void setFrmControl(String frmControl) {
		this.frmControl = frmControl;
	}
	public PjTeach getFrmDetailTeach() {
		return frmDetailTeach;
	}
	public void setFrmDetailTeach(PjTeach frmDetailTeach) {
		this.frmDetailTeach = frmDetailTeach;
	}
	public List<PjTutor> getFrmFindTutorList() {
		return frmFindTutorList;
	}
	public void setFrmFindTutorList(List<PjTutor> frmFindTutorList) {
		this.frmFindTutorList = frmFindTutorList;
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
	public PjTutor getFrmFindTutorDetails() {
		return frmFindTutorDetails;
	}
	public void setFrmFindTutorDetails(PjTutor frmFindTutorDetails) {
		this.frmFindTutorDetails = frmFindTutorDetails;
	}
	public String getFrmFindTutorDetailsId() {
		return frmFindTutorDetailsId;
	}
	public void setFrmFindTutorDetailsId(String frmFindTutorDetailsId) {
		this.frmFindTutorDetailsId = frmFindTutorDetailsId;
	}
	public String getFrmExtraRequestMessage() {
		return frmExtraRequestMessage;
	}
	public void setFrmExtraRequestMessage(String frmExtraRequestMessage) {
		this.frmExtraRequestMessage = frmExtraRequestMessage;
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
	public String getFrmRequestDate() {
		return frmRequestDate;
	}
	public void setFrmRequestDate(String frmRequestDate) {
		this.frmRequestDate = frmRequestDate;
	}
	public String getFrmStatus() {
		return frmStatus;
	}
	public void setFrmStatus(String frmStatus) {
		this.frmStatus = frmStatus;
	}
	public String getFrmControlMyTutors() {
		return frmControlMyTutors;
	}
	public void setFrmControlMyTutors(String frmControlMyTutors) {
		this.frmControlMyTutors = frmControlMyTutors;
	}
	public List<PjRequest> getFrmRequestedTutorsList() {
		return frmRequestedTutorsList;
	}
	public void setFrmRequestedTutorsList(List<PjRequest> frmRequestedTutorsList) {
		this.frmRequestedTutorsList = frmRequestedTutorsList;
	}
	public List<PjRequest> getFrmConnectedTutorsList() {
		return frmConnectedTutorsList;
	}
	public void setFrmConnectedTutorsList(List<PjRequest> frmConnectedTutorsList) {
		this.frmConnectedTutorsList = frmConnectedTutorsList;
	}
	public List<PjRequest> getFrmCompletedTutorsList() {
		return frmCompletedTutorsList;
	}
	public void setFrmCompletedTutorsList(List<PjRequest> frmCompletedTutorsList) {
		this.frmCompletedTutorsList = frmCompletedTutorsList;
	}
	public int getBeginConnected() {
		return beginConnected;
	}
	public void setBeginConnected(int beginConnected) {
		this.beginConnected = beginConnected;
	}
	public int getEndConnected() {
		return endConnected;
	}
	public void setEndConnected(int endConnected) {
		this.endConnected = endConnected;
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
	public String getFrmFeedbackArea() {
		return frmFeedbackArea;
	}
	public void setFrmFeedbackArea(String frmFeedbackArea) {
		this.frmFeedbackArea = frmFeedbackArea;
	}
	public Integer getFrmRatingPoint() {
		return frmRatingPoint;
	}
	public void setFrmRatingPoint(Integer frmRatingPoint) {
		this.frmRatingPoint = frmRatingPoint;
	}
	public PjRequest getFrmRequest() {
		return frmRequest;
	}
	public void setFrmRequest(PjRequest frmRequest) {
		this.frmRequest = frmRequest;
	}
	public PjStudent getFrmStudentDetails() {
		return frmStudentDetails;
	}
	public void setFrmStudentDetails(PjStudent frmStudentDetails) {
		this.frmStudentDetails = frmStudentDetails;
	}
	public FormFile getFrmRegPhotoFormFile() {
		return frmRegPhotoFormFile;
	}
	public void setFrmRegPhotoFormFile(FormFile frmRegPhotoFormFile) {
		this.frmRegPhotoFormFile = frmRegPhotoFormFile;
	}
	/*public String getFrmPhotoFilePath() {
		return frmPhotoFilePath;
	}
	public void setFrmPhotoFilePath(String frmPhotoFilePath) {
		this.frmPhotoFilePath = frmPhotoFilePath;
	}*/
	public int getFrmNumRequestTutors() {
		return frmNumRequestTutors;
	}
	public void setFrmNumRequestTutors(int frmNumRequestTutors) {
		this.frmNumRequestTutors = frmNumRequestTutors;
	}
	public int getFrmNumConnectedTutors() {
		return frmNumConnectedTutors;
	}
	public void setFrmNumConnectedTutors(int frmNumConnectedTutors) {
		this.frmNumConnectedTutors = frmNumConnectedTutors;
	}
	public int getFrmNumCompletedTutors() {
		return frmNumCompletedTutors;
	}
	public void setFrmNumCompletedTutors(int frmNumCompletedTutors) {
		this.frmNumCompletedTutors = frmNumCompletedTutors;
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
	public List<PjTeach> getFrmMyTeachList() {
		return frmMyTeachList;
	}
	public void setFrmMyTeachList(List<PjTeach> frmMyTeachList) {
		this.frmMyTeachList = frmMyTeachList;
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
	public String getFrmDeleteMessage() {
		return frmDeleteMessage;
	}
	public void setFrmDeleteMessage(String frmDeleteMessage) {
		this.frmDeleteMessage = frmDeleteMessage;
	}
	public ArrayList<String> getFrmRequestStatus() {
		return frmRequestStatus;
	}
	public void setFrmRequestStatus(ArrayList<String> frmRequestStatus) {
		this.frmRequestStatus = frmRequestStatus;
	}
	

}
