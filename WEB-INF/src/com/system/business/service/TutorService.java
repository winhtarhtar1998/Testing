package com.system.business.service;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.sql.Array;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.beanutils.converters.ArrayConverter;
import org.apache.struts.upload.FormFile;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.hibernate.Hibernate;
import org.hibernate.mapping.Collection;
import org.hibernate.util.ArrayHelper;

import com.system.util.mail.MailConfig;
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
import com.system.presentation.form.TutorForm;

public class TutorService {
	private TutorDao myTutorDao;
	private SubjectDao mySubjectDao;
	private TeachDao myTeachDao;
	private StudentDao myStudentDao;
	private RequestDao myRequestDao;

	// getter and setter
	public TutorDao getMyTutorDao() {
		return myTutorDao;
	}
	public void setMyTutorDao(TutorDao myTutorDao) {
		this.myTutorDao = myTutorDao;
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
	public StudentDao getMyStudentDao() {
		return myStudentDao;
	}
	public void setMyStudentDao(StudentDao myStudentDao) {
		this.myStudentDao = myStudentDao;
	}
	
	
	public RequestDao getMyRequestDao() {
		return myRequestDao;
	}
	public void setMyRequestDao(RequestDao myRequestDao) {
		this.myRequestDao = myRequestDao;
	}
	// check login tutor
	public void checkLoginTutor(TutorForm myForm) {
		PjTutor myTutor = myTutorDao.getTutorByEmailAndPassword(myForm.getFrmTutorEmail(), myForm.getFrmPassword());
		myForm.setLoginPjTutor(myTutor);
	}
	
	//for registration ~ 1
	public void firstLoadRegistration(TutorForm myForm) {
		myForm.setFrmRegName("");
		myForm.setFrmRegEmail("");
		myForm.setFrmRegTutorType("0"); // select box
		myForm.setFrmRegHighestDegree("0"); // select box
		myForm.setFrmRegSpecialization("");
		myForm.setFrmRegMoreDegrees("");
		myForm.setFrmRegGender("");
		myForm.setFrmRegPhoneNo("");
		myForm.setFrmRegAddress("");
		myForm.setFrmRegAbout("");
		myForm.setFrmRegPhotoFormFile(null);
		myForm.setFrmRegPassword("");
		myForm.setFrmRegConfPassword("");
		
		myForm.setFrmRegFormControl(null);

	}
	
	public void checkAccountEmail(TutorForm myForm) {
		PjTutor myTutor = myTutorDao.getTutorByEmail(myForm.getFrmRegEmail());
		if (myTutor != null) {
			myForm.setFrmRegEmailError(null);
			myForm.setFrmRegFormControl(null);
		} else {
			myForm.setFrmRegFormControl("data");
		}
	}
	
	// write photo in 'images' folder
	public void writeTutorPhotoFile(TutorForm myForm,String photoFilePath){
		
		PjTutor regTutor=myTutorDao.getTutorByEmail(myForm.getFrmRegEmail());
		String filePath =photoFilePath+ "/images/tut_" + regTutor.getId();

		BufferedOutputStream outStream;

		try {
			outStream = new BufferedOutputStream(new FileOutputStream(filePath));
			
			InputStream in = regTutor.getTutorPhoto().getBinaryStream();
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

	}
	
	public void saveNewTutor(TutorForm myForm) {
		PjTutor myTutor = new PjTutor();
		
		FormFile formFile=myForm.getFrmRegPhotoFormFile();
		Blob bfile;
		try {
			bfile=Hibernate.createBlob(formFile.getInputStream());
			myTutor.setId(null);
			myTutor.setTutorName(myForm.getFrmRegName());
			myTutor.setTutorEmail(myForm.getFrmRegEmail());
			myTutor.setTutorType(myForm.getFrmRegTutorType());
			myTutor.setHighestDegree(myForm.getFrmRegHighestDegree());
			myTutor.setSpecialization(myForm.getFrmRegSpecialization());
			myTutor.setMoreDegrees(myForm.getFrmRegMoreDegrees());
			myTutor.setGender(myForm.getFrmRegGender());
			myTutor.setTutorPhoneNo(myForm.getFrmRegPhoneNo());
			myTutor.setTutorAddress(myForm.getFrmRegAddress());
			myTutor.setAbout(myForm.getFrmRegAbout());
		
			myTutor.setTutorPhoto(bfile);
			myTutor.setPassword(myForm.getFrmRegPassword());
			myTutor.setTutorAccountStatus("Active"); // default account status is 'Active'
			myTutorDao.saveTutor(myTutor);
	
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	// first load to add new subject (need to add in Teach Service)
	public void firstLoadAddNewSubject(TutorForm myForm) {
				
		List<PjSubject> l = mySubjectDao.getAllSubject();
		myForm.setFrmAddSubjectList(l);
		myForm.setFrmAddSubjectId("0");
		myForm.setFrmAddTeachingType("0");
		myForm.setFrmAddFee("");
		myForm.setFrmAddPreferableTime("");
		myForm.setFrmAddPeriodPerWeek("");
		myForm.setFrmAddPreferableDays(null);
		myForm.setFrmRegFormControl(null);
		}
	
	// load for Add confirmation page
	public void loadAddSubjectConfirm(TutorForm myForm){
		myForm.setFrmAddSubjectName(mySubjectDao.getSubjectById(Integer.parseInt(myForm.getFrmAddSubjectId())).getSubjectName());
		myForm.setFrmAddPreferableDaysString(ArrayHelper.toString(myForm.getFrmAddPreferableDays()));
	}
	
	// load for Edit confirmation page
	public void loadEditSubjectConfirm(TutorForm myForm){
		myForm.setFrmAddPreferableDaysString(ArrayHelper.toString(myForm.getFrmAddPreferableDays()));
	}
	
	// save in Teach table
	public void saveNewTeach(TutorForm myForm) {
		PjTeach myTeach=new PjTeach();	// creating new object for teach table
		myTeach.setId(null);
		
		PjTutor myLoginTutor=myForm.getLoginPjTutor();
		myTeach.setTutor(myLoginTutor); // set relation for tutor ~ teach
		
		PjSubject mySubject=mySubjectDao.getSubjectById(Integer.parseInt(myForm.getFrmAddSubjectId()));
		myTeach.setSubject(mySubject);  // set relation for teach ~ subject
		
		myTeach.setTeachingType(myForm.getFrmAddTeachingType()); 
		myTeach.setFee(Double.parseDouble(myForm.getFrmAddFee()));
		myTeach.setPreferableTime(myForm.getFrmAddPreferableTime());
		myTeach.setPreferableDays(ArrayHelper.toString(myForm.getFrmAddPreferableDays()));
		myTeach.setPeriodPerWeek(Integer.parseInt(myForm.getFrmAddPeriodPerWeek()));
		myTeachDao.saveTeach(myTeach);
	}
	
	// first load for update tutor profile
	public void firstLoadUpdateProfile(TutorForm myForm,String photoFilePath){
		PjTutor myLoginTutor=myForm.getLoginPjTutor();
		myForm.setFrmTutorDetails(myLoginTutor);  // for profile card
		
		myForm.setFrmRegName(myLoginTutor.getTutorName());
		myForm.setFrmRegEmail(myLoginTutor.getTutorEmail());
		myForm.setFrmRegTutorType(myLoginTutor.getTutorType()); 
		myForm.setFrmRegHighestDegree(myLoginTutor.getHighestDegree());
		myForm.setFrmRegSpecialization(myLoginTutor.getSpecialization());
		myForm.setFrmRegMoreDegrees(myLoginTutor.getMoreDegrees());
		myForm.setFrmRegGender(myLoginTutor.getGender()); 		
		myForm.setFrmRegPhoneNo(myLoginTutor.getTutorPhoneNo());
		myForm.setFrmRegAddress(myLoginTutor.getTutorAddress());
		
		writeTutorPhotoFile(myForm, photoFilePath);
		
		myForm.setFrmRegAbout(myLoginTutor.getAbout());
		myForm.setFrmRegFormControl(null);
	}
	
	// save updated tutor profile
	public void saveUpdateTutor(TutorForm myForm,String photoFilePath){
		PjTutor myUpdateTutor=myForm.getLoginPjTutor();
		
		FormFile formFile=myForm.getFrmRegPhotoFormFile();
		Blob bfile;
	
		try {
			bfile=Hibernate.createBlob(formFile.getInputStream());
			
				myUpdateTutor.setTutorName(myForm.getFrmRegName());
				myUpdateTutor.setTutorType(myForm.getFrmRegTutorType()); 
				myUpdateTutor.setHighestDegree(myForm.getFrmRegHighestDegree());
				myUpdateTutor.setSpecialization(myForm.getFrmRegSpecialization());
				myUpdateTutor.setMoreDegrees(myForm.getFrmRegMoreDegrees());
				myUpdateTutor.setGender(myForm.getFrmRegGender());
				myUpdateTutor.setTutorPhoneNo(myForm.getFrmRegPhoneNo());
				myUpdateTutor.setTutorAddress(myForm.getFrmRegAddress());
				myUpdateTutor.setAbout(myForm.getFrmRegAbout());
				if(myForm.getFrmRegPhotoFormFile().getFileSize()==0){
					System.out.println("formfile is  null");
					
					myUpdateTutor.setTutorPhoto(myForm.getLoginPjTutor().getTutorPhoto());
				}
				else{
					myUpdateTutor.setTutorPhoto(bfile);
					writeTutorPhotoFile(myForm, photoFilePath);
				}
				
				myTutorDao.saveTutor(myUpdateTutor);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	
	// 'My Subject' (1) Load All Teach list
	public void loadAllTeachOfTutor(TutorForm myForm){
		PjTutor myloginTutor=myForm.getLoginPjTutor();
		List<PjTeach> myTeach=myTeachDao.getAllTeachofTutor(myloginTutor);
		myForm.setMyTeachList(myTeach);
		
		if (myTeach != null) {
			myForm.setBegin(1);
			myForm.setEnd(myTeach.size());
		}else{
			myForm.setBegin(0);
		}
		
	}
	
	// 'My Subject' (2) Delete Selected Teach
	public void deleteSelectedTeach(TutorForm myForm){
		PjTeach deleteTeach=myTeachDao.getTeachById(Integer.parseInt(myForm.getFrmRequestId()));
		List<PjRequest> deleteRequest=myRequestDao.getNotCompletedTeachRequest(deleteTeach);
		
		if(deleteRequest!=null){
			myForm.setFrmDeleteMessage("You can't delete this subject Info: it had still requested & connected by Students.");
		}
		else{
			myTeachDao.deleteTeachById(deleteTeach);
			myForm.setFrmDeleteMessage("");
		}
	}
	
	// load Subject Teach Edit Page
	public void loadEditTeach(TutorForm myForm){
		PjTeach editTeach=myTeachDao.getTeachById(Integer.parseInt(myForm.getFrmRequestId()));
		
		myForm.setFrmSubjectName(editTeach.getSubject().getSubjectName());
		myForm.setFrmAddTeachingType(editTeach.getTeachingType());
		myForm.setFrmAddFee(editTeach.getFee().toString());
		myForm.setFrmAddPeriodPerWeek(editTeach.getPeriodPerWeek().toString());
		myForm.setFrmAddPreferableTime(editTeach.getPreferableTime());
		
		String[] preferDays = null;
		String preferDayString=editTeach.getPreferableDays();
		preferDayString=preferDayString.substring(1, (preferDayString.length()-1));
		preferDays=preferDayString.split(",");
		myForm.setFrmAddPreferableDays(preferDays);
		myForm.setFrmRegFormControl(null);
	}
	
	public void saveEditTeach(TutorForm myForm){
		PjTeach myTeach=myTeachDao.getTeachById(Integer.parseInt(myForm.getFrmRequestId()));
		
		PjTutor myLoginTutor=myForm.getLoginPjTutor();
		myTeach.setTutor(myLoginTutor); // set relation for tutor ~ teach
		
		PjSubject mySubject=mySubjectDao.getSubjectById(Integer.parseInt(myForm.getFrmAddSubjectId()));
		myTeach.setSubject(mySubject);  // set relation for teach ~ subject
		
		myTeach.setTeachingType(myForm.getFrmAddTeachingType()); 
		myTeach.setFee(Double.parseDouble(myForm.getFrmAddFee()));
		myTeach.setPreferableTime(myForm.getFrmAddPreferableTime());
		myTeach.setPreferableDays(ArrayHelper.toString(myForm.getFrmAddPreferableDays()));
		myTeach.setPeriodPerWeek(Integer.parseInt(myForm.getFrmAddPeriodPerWeek()));
		myTeachDao.saveTeach(myTeach);
	}
	
	// 'Response Students' - (1) get requested Teach list
	public void getRequestList(TutorForm myForm){
		List<PjRequest> requestList=myRequestDao.getRequestList(myForm.getLoginPjTutor());
		myForm.setFrmRequestList(requestList);
		
		if(requestList!=null){
			myForm.setBeginRequested(1);
			myForm.setEndRequested(requestList.size());
			
			myForm.setFrmNumRequestStudents(requestList.size());
		}else{
			myForm.setBeginRequested(0);
			myForm.setFrmNumRequestStudents(0);
		}
	}
	
	// 'Response Students' - (2) get student by id
	public void getStudentById(TutorForm myForm){
		PjStudent selectedStudent=myStudentDao.getStudentById(Integer.parseInt(myForm.getFrmStudentDetailsId()));
		myForm.setFrmStudentDetails(selectedStudent);
	}
	
	// 'Response Students' - (2) get teach by id
	public void getTeachById(TutorForm myForm){
		PjTeach selectedTeach=myTeachDao.getTeachById(Integer.parseInt(myForm.getFrmRequestTeachId()));
		myForm.setFrmRequestTeach(selectedTeach);
	}
	
	// 'Response Students' - (3)connect student
	public void connectStudent(TutorForm myForm) {
		Integer requestId=Integer.parseInt(myForm.getFrmRequestId());
		PjRequest myRequest=myRequestDao.getRequestById(requestId);
		myRequest.setStatus("Connected");
		myRequest.setConnectedDate(new Date());
		myRequestDao.saveStudentRequest(myRequest);
		
		
		// for send auto mail to student
		String strFrom = "ayechanmsccs@gmail.com";
		String strSubject = "Confirmation for Your Request in TutorFinder WebApp";
		String strContent = new String();
		try {
			VelocityEngine engine = new VelocityEngine();
			Properties properties = new Properties();
			properties.setProperty(VelocityEngine.RESOURCE_LOADER, "classpath");
			properties.setProperty("classpath."
					+ VelocityEngine.RESOURCE_LOADER + ".class",
					ClasspathResourceLoader.class.getName());
			engine.init(properties);
			Template tm = engine.getTemplate("mailTemplate.vm");
			VelocityContext vc = new VelocityContext();
			
			String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
			vc.put("today", today);
			vc.put("studentName", myRequest.getStudent().getStudentName());
			vc.put("tutorName", myRequest.getTeach().getTutor().getTutorName());
			vc.put("subjectName",myRequest.getTeach().getSubject().getSubjectName());
			vc.put("fee", myRequest.getTeach().getFee());
			vc.put("teachingType", myRequest.getTeach().getTeachingType());
			vc.put("requestDate", myRequest.getRequestDate());
			
			StringWriter sw = new StringWriter();
			tm.merge(vc, sw);
			strContent = sw.toString();
			if (strContent != null) {
				MailConfig smtpMailSender = new MailConfig();
				smtpMailSender.sendToOne(myRequest.getStudent().getStudentEmail(), strSubject,
						strContent, strFrom);
				myForm.setFrmMailMessage("Mail can send successfully");
				
				myForm.setFrmMailAdd(null);
				myForm.setFrmMailName(null);
				
			} else {
				myForm.setFrmMailMessage("Mail cannot send because the message is null");
			}
			
		} catch (Exception e) {
			myForm.setFrmMailMessage("Mail Cannot Send");
		}
	
	}
	
	// 'Response Students' - (4) cancel request
	public void cancelRequest(TutorForm myForm){
		PjRequest cancelRequest=myRequestDao.getRequestById(Integer.parseInt(myForm.getFrmRequestId()));
		myRequestDao.deleteRequest(cancelRequest);
	}
	
	// 'My Students' 
	public void firstLoadMyStudents(TutorForm myForm){
		PjTutor myTutor=myForm.getLoginPjTutor();
		
		// for connected list
		List<PjRequest> connectedList=myRequestDao.getConnectedList(myTutor);
		myForm.setFrmConnectedList(connectedList);
		
		if(connectedList!=null){
			myForm.setBegin(1);
			myForm.setEnd(connectedList.size());
			
			myForm.setFrmNumConnectedStudents(connectedList.size());
		}else{
			myForm.setBegin(0);
			myForm.setFrmNumConnectedStudents(0);
		}
		
		// for completed list
		List<PjRequest> completedList=myRequestDao.getCompletedList(myTutor);
		myForm.setFrmCompletedList(completedList);
		
		if(completedList!=null){
			myForm.setBeginCompleted(1);
			myForm.setEndCompleted(completedList.size());
			
			myForm.setFrmNumCompletedStudents(completedList.size());
		}else{
			myForm.setBeginCompleted(0);
			myForm.setFrmNumCompletedStudents(0);
		}
	}
	
	public void setStudentDetails(TutorForm myForm){
		PjStudent selectedStudent=myStudentDao.getStudentById(Integer.parseInt(myForm.getFrmStudentDetailsId()));
		myForm.setFrmStudentDetails(selectedStudent);
	}
	
	public void setTeachDetails(TutorForm myForm){
		PjTeach selectedTeach=myTeachDao.getTeachById(Integer.parseInt(myForm.getFrmRequestTeachId()));
		myForm.setFrmRequestTeach(selectedTeach);
	}
	
	public void changeCompleted(TutorForm myForm){
		PjRequest completeRequest=myRequestDao.getRequestById((Integer.parseInt(myForm.getFrmRequestId())));
		completeRequest.setStatus("Completed");
		completeRequest.setCompletedDate(new Date());
		myRequestDao.changeCompleted(completeRequest);
	}
	
	
	// 'Review Feedback' - load for selected subject
	public void loadFeedbackOfSelectedSubject(TutorForm myForm){
		loadAllTeachOfTutor(myForm);
		
		String selectedSubject=myForm.getFrmSubjectName();
		PjTutor myTutor=myForm.getLoginPjTutor();
		
		List<PjRequest> feedbackList;
		if(selectedSubject.equals("All Subjects")){
			feedbackList=myRequestDao.getCompletedFeedbackList(myTutor);
		}
		else{
			feedbackList=myRequestDao.getCompletedRequestBySelectedSubject(myTutor, selectedSubject);
		}
		
		myForm.setFrmCompletedList(feedbackList);
		
		if(feedbackList!=null){
			myForm.setBeginCompleted(1);
			myForm.setEndCompleted(feedbackList.size());
		}else{
			myForm.setBeginCompleted(0);
		}
	}
	
	// for 'My Profile'
	public void firstLoadMyProfile(TutorForm myForm){
		myForm.setFrmTutorDetails(myForm.getLoginPjTutor());
	}
	
	// for 'Tutor Home'
	public void firstLoadHome(TutorForm myForm){
		getRequestList(myForm);		// to get number of requested students 
		firstLoadMyStudents(myForm);	// to get number of connected & completed students
		
		int[][] tutorScore=getTotalPointsList();		// get total points for all tutors
		Sort2DArrayBasedOnColumnNumber(tutorScore, 1);	// sorting descending order (to get top 10 list)
		
		List<PjTutor> calculatedTutorList = new ArrayList<PjTutor>();
		List<PjTeach> eachTeachList = new ArrayList<PjTeach>();
		PjTutor loginTutor=myForm.getLoginPjTutor();
		
		for(int i=0;i<tutorScore.length;i++){
			PjTutor eachTutor=myTutorDao.getTutorById(tutorScore[i][1]);
			calculatedTutorList.add(i,eachTutor);
			
			if(eachTutor.equals(loginTutor)){
				myForm.setFrmMyPosition(i+1);
			}
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
	public void loadTopTutorDetails(TutorForm myForm){
		PjTutor topTutor=myTutorDao.getTutorById(Integer.parseInt(myForm.getFrmTopTutorDetailsId()));
		myForm.setFrmTopTutorsDetails(topTutor);
		
		List<PjTeach> topTutorTeachList=myTeachDao.getAllTeachofTutor(topTutor);
		myForm.setMyTeachList(topTutorTeachList);
		
		if (topTutorTeachList != null) {
			myForm.setBegin(1);
			myForm.setEnd(topTutorTeachList.size());
		}
		else{
			myForm.setBegin(0);
		}
	}
	
	// change password
	public void checkCurrentPassword(TutorForm myForm) {
		PjTutor myTutor = myForm.getLoginPjTutor();
		String currentPassword=myForm.getFrmCurrentPassword();
		if (!myTutor.getPassword().equals(currentPassword)) {
			myForm.setFrmCurrentPasswordError(null);
		} else {
			myForm.setFrmCurrentPasswordError("data");
		}
	}
	
	public void saveNewPassword(TutorForm myForm){
		PjTutor myUpdateTutor=myForm.getLoginPjTutor();
		
		myUpdateTutor.setPassword(myForm.getFrmRegPassword()); // saving new password
		myTutorDao.saveTutor(myUpdateTutor);
	
	}
	
	// first load for change password
	public void firstLoadChangePassword(TutorForm myForm){
		
		myForm.setFrmTutorDetails(myForm.getLoginPjTutor());
		myForm.setFrmCurrentPassword(null);
		myForm.setFrmCurrentPasswordError(null);
		myForm.setFrmRegPassword(null);
		myForm.setFrmRegConfPassword(null);
		myForm.setFrmRegFormControl(null);
	}
	
	// delete Account section
	public void checkAccountCanDeleteOrNot(TutorForm myForm){
		List<PjRequest> connectedRequest=myRequestDao.getConnectedList(myForm.getLoginPjTutor());
		
		if(connectedRequest!=null){
			myForm.setFrmDeleteMessage("no");
			myForm.setFrmNumConnectedStudents(connectedRequest.size());
		}
		else
			myForm.setFrmDeleteMessage("yes");
	}
	
	public void deleteAccount(TutorForm myfForm){
		PjTutor deleteTutor=myfForm.getLoginPjTutor();
		myTutorDao.deleteTutor(deleteTutor); 		// delete tutor permanently
	}
}






