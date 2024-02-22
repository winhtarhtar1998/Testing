package com.system.business.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.struts.upload.FormFile;
import org.hibernate.Hibernate;

import com.system.business.entity.PjRequest;
import com.system.business.entity.PjStudent;
import com.system.business.entity.PjSubject;
import com.system.business.entity.PjTeach;
import com.system.business.entity.PjTutor;
import com.system.dao.RequestDao;
import com.system.dao.StudentDao;
import com.system.dao.SubjectDao;
import com.system.dao.TeachDao;
import com.system.dao.TutorDao;
import com.system.presentation.form.StudentForm;
import com.system.presentation.form.TutorForm;

public class StudentService {
	private StudentDao myStudentDao;
	private SubjectDao mySubjectDao;
	private TeachDao myTeachDao;
	private TutorDao myTutorDao;
	private RequestDao myRequestDao;

	public StudentDao getMyStudentDao() {
		return myStudentDao;
	}
	public void setMyStudentDao(StudentDao myStudentDao) {
		this.myStudentDao = myStudentDao;
	}
	
	public SubjectDao getMySubjectDao() {
		return mySubjectDao;
	}
	public void setMySubjectDao(SubjectDao mySubjectDao) {
		this.mySubjectDao = mySubjectDao;
	}
	
	public TeachDao getMyTeachDao() {
		return myTeachDao;
	}
	public void setMyTeachDao(TeachDao myTeachDao) {
		this.myTeachDao = myTeachDao;
	}
	
	public TutorDao getMyTutorDao() {
		return myTutorDao;
	}
	public void setMyTutorDao(TutorDao myTutorDao) {
		this.myTutorDao = myTutorDao;
	}
	
	public RequestDao getMyRequestDao() {
		return myRequestDao;
	}
	public void setMyRequestDao(RequestDao myRequestDao) {
		this.myRequestDao = myRequestDao;
	}
	
	
	// check login student
	public void checkLoginStudent(StudentForm myForm) {
		PjStudent myStudent = myStudentDao.getStudentByEmailAndPassword(myForm.getFrmStudentEmail(), myForm.getFrmPassword());
		myForm.setLoginPjStudent(myStudent);
	}
	
	//for registration 
	public void firstLoadRegistration(StudentForm myForm) {
		myForm.setFrmRegName("");
		myForm.setFrmRegEmail("");
		myForm.setFrmRegGrade("0"); // select box
		myForm.setFrmRegGender("");
		myForm.setFrmRegPhoneNo("");
		myForm.setFrmRegAddress("");
		myForm.setFrmRegPhotoFormFile(null);
		myForm.setFrmRegPassword("");
		myForm.setFrmRegConfPassword("");
		
		myForm.setFrmRegFormControl(null);
	}
	
	public void checkAccountEmail(StudentForm myForm) {
		PjStudent myStudent = myStudentDao.getStudentByEmail(myForm.getFrmRegEmail());
		if (myStudent != null) {
			myForm.setFrmRegEmailError(null);
			myForm.setFrmRegFormControl(null);
		} else {
			myForm.setFrmRegFormControl("data");
		}
	}
	
	
	public void saveNewStudent(StudentForm myForm) {
		PjStudent myStudent = new PjStudent();
		
		FormFile formFile=myForm.getFrmRegPhotoFormFile();
		Blob bfile;
		try {
			bfile=Hibernate.createBlob(formFile.getInputStream());
		myStudent.setId(null);
		myStudent.setStudentName(myForm.getFrmRegName());
		myStudent.setStudentEmail(myForm.getFrmRegEmail());
		myStudent.setGrade(myForm.getFrmRegGrade());
		myStudent.setGender(myForm.getFrmRegGender());
		myStudent.setStudentPhoneNo(myForm.getFrmRegPhoneNo());
		myStudent.setStudentAddress(myForm.getFrmRegAddress());
		
		myStudent.setStudentPhoto(bfile);
		
		myStudent.setPassword(myForm.getFrmRegPassword());
		myStudent.setStuAccountStatus("Active"); // default account status is 'Active'
		myStudentDao.saveStudent(myStudent);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void writeStudentPhotoFile(StudentForm myForm,String photoFilePath){
		
		PjStudent regStudent=myStudentDao.getStudentByEmail(myForm.getFrmRegEmail());
		String filePath =photoFilePath+ "/images/stu_" + regStudent.getId();

		BufferedOutputStream outStream;

		try {
			outStream = new BufferedOutputStream(new FileOutputStream(filePath));
			
			InputStream in = regStudent.getStudentPhoto().getBinaryStream();
			byte[] buffer = new byte[1000];
			int n = 0;
			while ((n = in.read(buffer)) != -1) {
			outStream.write(buffer, 0, n);
			}
			in.close();
			outStream.close();


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Photo has been written!!");
	}
	

	// first load for update student profile
	public void firstLoadUpdateProfile(StudentForm myForm,String photoFilePath){
		PjStudent myLoginStudent=myForm.getLoginPjStudent();
		myForm.setFrmStudentDetails(myForm.getLoginPjStudent());
		
		myForm.setFrmRegName(myLoginStudent.getStudentName());
		myForm.setFrmRegEmail(myLoginStudent.getStudentEmail());
		myForm.setFrmRegGrade(myLoginStudent.getGrade());
		myForm.setFrmRegGender(myLoginStudent.getGender());
		writeStudentPhotoFile(myForm,photoFilePath);
		myForm.setFrmRegPhoneNo(myLoginStudent.getStudentPhoneNo());
		myForm.setFrmRegAddress(myLoginStudent.getStudentAddress());
		myForm.setFrmRegFormControl(null);
	}
	
	// save updated student profile
	public void saveUpdateStudent(StudentForm myForm,String photoFilePath){
		PjStudent myUpdateStudent=myForm.getLoginPjStudent();
		
		FormFile formFile=myForm.getFrmRegPhotoFormFile();
		Blob bfile;
		try {
			bfile=Hibernate.createBlob(formFile.getInputStream());
		myUpdateStudent.setStudentName(myForm.getFrmRegName());
		myUpdateStudent.setStudentEmail(myForm.getFrmRegEmail());
		myUpdateStudent.setGrade(myForm.getFrmRegGrade());
		myUpdateStudent.setGender(myForm.getFrmRegGender());
		myUpdateStudent.setStudentPhoneNo(myForm.getFrmRegPhoneNo());
		myUpdateStudent.setStudentAddress(myForm.getFrmRegAddress());
		
		if(myForm.getFrmRegPhotoFormFile().getFileSize()==0){
			System.out.println("photoformfile is null");
			
			myUpdateStudent.setStudentPhoto(myForm.getLoginPjStudent().getStudentPhoto());
			}
		else {
			System.out.println("photoformfile is not null");
			myUpdateStudent.setStudentPhoto(bfile);
			writeStudentPhotoFile(myForm,photoFilePath);
		}
		
		
		myStudentDao.saveStudent(myUpdateStudent);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void firstLoadFindTutors(StudentForm myForm){
		List<PjSubject> l = mySubjectDao.getAllSubject();
		myForm.setFrmFindSubjectList(l);
		myForm.setFrmFindSubjectId("0");
		myForm.setFrmFindTeachingType("0");
		myForm.setFrmRequestStatus(null);
	}
	
	public void getAllTeachList(StudentForm myForm){
		List<PjTeach> findTutorList=myTeachDao.getTeachListAll();
		myForm.setFrmFindTeachList(findTutorList);
		
		//List<PjRequest> myRequests=myRequestDao.getRequestList(myForm.getLoginPjStudent());
		
		/*if(myRequests==null){
			myForm.setFrmFindTeachList(findTutorList);
		}
		else{
			
			for (int i = 0; i < myRequests.size(); i++) {
				for (int j = 0; j < findTutorList.size(); j++) {
					if (myRequests.get(i).getTeach().equals(findTutorList.get(j)) & !myRequests.get(i).getStatus().equals("Completed")) {
							findTutorList.remove(j);
					}
				}
			}
			
		}*/
		setTableSize(findTutorList, myForm);
		setRequestStatus(myForm, findTutorList);
		
	}
	
	
	// set request status
	public void setRequestStatus(StudentForm myForm,List<PjTeach> findTutorList){
		
		// can request or not
		PjStudent myStudent=myForm.getLoginPjStudent();
		List<PjRequest> myRequestedList=myRequestDao.getRequestedList(myStudent);
		List<PjRequest> myConnectedList=myRequestDao.getConnectedList(myStudent);
		
		if(findTutorList!=null){
			ArrayList<String> requestStatus = new ArrayList<String>(findTutorList.size());
			int i=0;
			for(PjTeach tutorTeach:findTutorList){
				requestStatus.add(i,"Request Now");
				if(myRequestedList!=null){
					for (PjRequest requested : myRequestedList) {
						if(requested.getTeach().getId().equals(tutorTeach.getId())){
							requestStatus.add(i, "Requested");
						}
					}
				}
				if(myConnectedList!=null){
					for (PjRequest connected : myConnectedList) {
						if(connected.getTeach().getId().equals(tutorTeach.getId())){
							requestStatus.add(i, "Connected");
						}
					}
				}
				i++;
				}
				
				myForm.setFrmRequestStatus(requestStatus);
				System.out.println(requestStatus.size());
			}
			else{
				myForm.setFrmRequestStatus(null);
			}

	}
	
	// get find tutor list - By Selected Subject
	public void getFindTeachListBySubject(StudentForm myForm,Integer selectedSubjectId){
		PjSubject selctedSubject=mySubjectDao.getSubjectById(selectedSubjectId);
		List<PjTeach> findTutorList=myTeachDao.getTeachListBySubject(selctedSubject);
		myForm.setFrmFindTeachList(findTutorList);
		setTableSize(findTutorList, myForm);
		setRequestStatus(myForm, findTutorList);
		
	}	

	// get find tutor list - By Teaching Type
	public void getFindTeachListByTeachingType(StudentForm myForm,String selectedTeachingType){
		List<PjTeach> findTutorList=myTeachDao.getTeachListByTeachingType(selectedTeachingType);
		myForm.setFrmFindTeachList(findTutorList);
		setTableSize(findTutorList, myForm);
		setRequestStatus(myForm, findTutorList);
	}
	
	// get find tutor list -Both Subject + Teaching Type 
	public void getFindTeachListBySubjectAndTeachingType(StudentForm myForm,Integer selectedSubjectId,String selectedTeachingType){
		
		PjSubject selctedSubject=mySubjectDao.getSubjectById(selectedSubjectId);
		List<PjTeach> findTutorList=myTeachDao.getTeachListBySubjectAndTeachType(selctedSubject, selectedTeachingType);
		myForm.setFrmFindTeachList(findTutorList);
		setTableSize(findTutorList, myForm);
		setRequestStatus(myForm, findTutorList);
	}
	
	// general method - for setting looping size of 'Data Table'
	public void setTableSize(List<PjTeach> findTutorList,StudentForm myForm){
		if (findTutorList != null) {
			myForm.setBegin(1);
			myForm.setEnd(findTutorList.size());
		}else{
			myForm.setBegin(0);
		}
	}
	
	// detail tutor click
	public void setFindTutorDetails(StudentForm myForm)
	{
		PjTutor findTutorDetails=myTutorDao.getTutorById(Integer.parseInt(myForm.getFrmFindTutorDetailsId()));
		myForm.setFrmFindTutorDetails(findTutorDetails);
	}
	
	// detail Class Info click
	public void setTeachDetails(StudentForm myForm)
	{
		PjTeach teachDetails=myTeachDao.getTeachById(Integer.parseInt(myForm.getFrmDetailTeachId()));
		myForm.setFrmDetailTeach(teachDetails);
	}
	
	// request tutor
	public void firstLoadRequestTutor(StudentForm myform){
		PjTeach requestTeach=myTeachDao.getTeachById(Integer.parseInt(myform.getFrmRequestTeachId()));
		myform.setFrmRequestTeach(requestTeach);
		myform.setFrmExtraRequestMessage("");
	}
	
	public void saveStudentRequest(StudentForm myForm){
		PjRequest myRequest=new PjRequest();
		
		myRequest.setId(null);
		
		PjStudent loginStudent=myForm.getLoginPjStudent();	// set student object (id)
		myRequest.setStudent(loginStudent);
		
		PjTeach requestTeach=myForm.getFrmRequestTeach();
		myRequest.setTeach(requestTeach);
		
		myRequest.setRequestDate(new Date());
		myRequest.setStatus("Requested");
		myRequest.setExtraRequestMessage(myForm.getFrmExtraRequestMessage());
		
		myRequestDao.saveStudentRequest(myRequest);
	}
	
	// for 'My Tutors' - first load
	public void firstLoadMyTutors(StudentForm myForm){
		
		PjStudent myStudent=myForm.getLoginPjStudent();
		
		// for requested list
		List<PjRequest> requestedList=myRequestDao.getRequestedList(myStudent);
		myForm.setFrmRequestedTutorsList(requestedList);
		
		if (requestedList != null) {
			myForm.setBegin(1);
			myForm.setEnd(requestedList.size());
			
			myForm.setFrmNumRequestTutors(requestedList.size());
		}else{
			myForm.setBegin(0);
		}
		
		// for connected list
		List<PjRequest> connectedList=myRequestDao.getConnectedList(myStudent);
		myForm.setFrmConnectedTutorsList(connectedList);
		
		if (connectedList != null) {
			myForm.setBeginConnected(1);
			myForm.setEndConnected(connectedList.size());
			
			myForm.setFrmNumConnectedTutors(connectedList.size());
		}else{
			myForm.setBeginConnected(0);
		}
		
		// for completed list
		List<PjRequest> completedList=myRequestDao.getCompletedList(myStudent);
		myForm.setFrmCompletedTutorsList(completedList);
		
		if (completedList != null) {
			myForm.setBeginCompleted(1);
			myForm.setEndCompleted(completedList.size());
			
			myForm.setFrmNumCompletedTutors(completedList.size());
		}else{
			myForm.setBeginCompleted(0);
		}
	}
	
	// request cancel 
	public void requestCancel(StudentForm myForm){
		PjRequest myRequest=myRequestDao.getRequestById(Integer.parseInt(myForm.getFrmRequestTeachId()));
		myRequestDao.deleteRequest(myRequest);
	}
	
	// for 'Send Feedback'
	public void firstLoadCompletedList(StudentForm myForm){
		
		PjStudent myStudent=myForm.getLoginPjStudent();
		// for completed list
		List<PjRequest> completedList=myRequestDao.getCompletedList(myStudent);
		myForm.setFrmCompletedTutorsList(completedList);
		
		if (completedList != null) {
			myForm.setBeginCompleted(1);
			myForm.setEndCompleted(completedList.size());
		}else{
			myForm.setBeginCompleted(0);
		}
	}
	
	// for 'Send Feedback' ~ first load send feedback
	public void firstLoadSendFeedback(StudentForm myForm){
		PjRequest myRequest=myRequestDao.getRequestById(Integer.parseInt(myForm.getFrmRequestTeachId()));
		
		if (myRequest.getRatingPoint()==null) {
			myForm.setFrmRatingPoint(0);
		}else {
			myForm.setFrmRatingPoint(myRequest.getRatingPoint());
		}
		
		if (myRequest.getFeedback()==null) {
			myForm.setFrmFeedbackArea("");
		}
		else{
			myForm.setFrmFeedbackArea(myRequest.getFeedback());
		}
		myForm.setFrmRequest(myRequest);
		myForm.setFrmRegFormControl(null);
	}
	
	// save student feedback
	public void saveStudentFeedback(StudentForm myForm){
		PjRequest feedbackRequest=myForm.getFrmRequest();
		
		feedbackRequest.setRatingPoint(myForm.getFrmRatingPoint());
		feedbackRequest.setFeedback(myForm.getFrmFeedbackArea());
		
		myRequestDao.saveStudentRequest(feedbackRequest);
	}
	
	// for 'My Profile'
	public void firstLoadMyProfile(StudentForm myForm){
		myForm.setFrmStudentDetails(myForm.getLoginPjStudent());
	}
	

	// for 'Student Home'
	public void firstLoadHome(StudentForm myForm){
		firstLoadMyTutors(myForm);		// get & set the numbers of students in each kind
		
		int[][] tutorScore=getTotalPointsList();		// get total points for all tutors
		Sort2DArrayBasedOnColumnNumber(tutorScore, 1);	// sorting descending order (to get top 10 list)
		
		List<PjTutor> calculatedTutorList = new ArrayList<PjTutor>();
		List<PjTeach> eachTeachList = new ArrayList<PjTeach>();
		
		for(int i=0;i<tutorScore.length;i++){
			PjTutor eachTutor=myTutorDao.getTutorById(tutorScore[i][1]);
			calculatedTutorList.add(i,eachTutor);
		}
		
		myForm.setFrmCalculatedTutorList(calculatedTutorList);
		myForm.setTotalPointsList(tutorScore);
		
		if (calculatedTutorList != null) {
			myForm.setBegin(1);
			myForm.setEnd(calculatedTutorList.size());
		}
		else{
			myForm.setBegin(0);
		}
	}
	
	// for generating total points list
	public int[][] getTotalPointsList(){
		List<PjTutor> tutorList=myTutorDao.getAllTutors();
		int[][] tutorScore = new int[tutorList.size()][2];
		
		int i=0;
		for (PjTutor eachTutor : tutorList) {
			int totalPoints=0;
			
			List<PjRequest> eachTutorRequest=myRequestDao.getRequestListByTutor(eachTutor);
			
			if(eachTutorRequest!=null){
			for (PjRequest  eachRequest : eachTutorRequest) {
				if(eachTutor.equals(eachRequest.getTeach().getTutor())){
					if(eachRequest.getRatingPoint()!=null)
						totalPoints+=eachRequest.getRatingPoint();
				}
			  }
			}
			tutorScore[i][0]=totalPoints;
			tutorScore[i][1]=eachTutor.getId();
			i++;
		}
		return tutorScore;
	}
	
	// method for sorting 2D array descending order
	public void Sort2DArrayBasedOnColumnNumber (int[][] array, final int columnNumber){
        Arrays.sort(array, new Comparator<int[]>() {
            public int compare(int[] first, int[] second) {
               if(first[columnNumber-1] < second[columnNumber-1]) return 1;
               else return -1;
            }
        });
    }
	
	// for 'Home' -> Selected 'Top Tutor's Details'
	public void loadTopTutorDetails(StudentForm myForm){
		PjTutor topTutor=myTutorDao.getTutorById(Integer.parseInt(myForm.getFrmTopTutorDetailsId()));
		myForm.setFrmTopTutorsDetails(topTutor);
		
		List<PjTeach> topTutorTeachList=myTeachDao.getAllTeachofTutor(topTutor);
		myForm.setFrmMyTeachList(topTutorTeachList);
		
		if (topTutorTeachList != null) {
			myForm.setBegin(1);
			myForm.setEnd(topTutorTeachList.size());
		}
		else{
			myForm.setBegin(0);
		}
		
		// can request or not
		PjStudent myStudent=myForm.getLoginPjStudent();
		List<PjRequest> myRequestedList=myRequestDao.getRequestedList(myStudent);
		List<PjRequest> myConnectedList=myRequestDao.getConnectedList(myStudent);
		
		if(topTutorTeachList!=null){
			ArrayList<String> requestStatus = new ArrayList<String>(topTutorTeachList.size());
			int i=0;
		for(PjTeach tutorTeach:topTutorTeachList){
			requestStatus.add(i,"Request Now");
			if(myRequestedList!=null){
				for (PjRequest requested : myRequestedList) {
					if(requested.getTeach().getId().equals(tutorTeach.getId())){
						requestStatus.add(i, "Requested");
					}
				}
			}
			if(myConnectedList!=null){
				for (PjRequest connected : myConnectedList) {
					if(connected.getTeach().getId().equals(tutorTeach.getId())){
						requestStatus.add(i, "Connected");
					}
				}
			}
			i++;
			}
			
			myForm.setFrmRequestStatus(requestStatus);
			
		}
		

	}
	
	// change password
	public void checkCurrentPassword(StudentForm myForm) {
		PjStudent myStudent=myForm.getLoginPjStudent();
		String currentPassword=myForm.getFrmCurrentPassword();
		if (!myStudent.getPassword().equals(currentPassword)) {
			myForm.setFrmCurrentPasswordError(null);
		} else {
			myForm.setFrmCurrentPasswordError("data");
		}
	}
	
	public void saveNewPassword(StudentForm myForm){
		PjStudent myUpdateStudent=myForm.getLoginPjStudent();
		
		myUpdateStudent.setPassword(myForm.getFrmRegPassword()); // saving new password
		myStudentDao.saveStudent(myUpdateStudent);
	
	}
	
	// first load for change password
	public void firstLoadChangePassword(StudentForm myForm){
		
		myForm.setFrmStudentDetails(myForm.getLoginPjStudent());
		myForm.setFrmCurrentPassword(null);
		myForm.setFrmCurrentPasswordError(null);
		myForm.setFrmRegPassword(null);
		myForm.setFrmRegConfPassword(null);
		myForm.setFrmRegFormControl(null);
	}
	
	// delete Account section
	public void checkAccountCanDeleteOrNot(StudentForm myForm){
		List<PjRequest> connectedRequest=myRequestDao.getConnectedList(myForm.getLoginPjStudent());
		
		if(connectedRequest!=null){
			myForm.setFrmDeleteMessage("no");
			myForm.setFrmNumConnectedTutors(connectedRequest.size());
		}
		else
			myForm.setFrmDeleteMessage("yes");
	}
	
	public void deleteAccount(StudentForm myfForm){
		PjStudent deleteStudent=myfForm.getLoginPjStudent();
		myStudentDao.deleteStudent(deleteStudent);		// delete student permanently
		
	}
}
