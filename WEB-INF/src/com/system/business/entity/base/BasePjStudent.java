package com.system.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the pj_student table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="pj_student"
 */

public abstract class BasePjStudent  implements Serializable {

	public static String REF = "PjStudent";
	public static String PROP_STUDENT_PHOTO = "studentPhoto";
	public static String PROP_STUDENT_PHONE_NO = "studentPhoneNo";
	public static String PROP_STU_ACCOUNT_STATUS = "stuAccountStatus";
	public static String PROP_STUDENT_EMAIL = "studentEmail";
	public static String PROP_GRADE = "grade";
	public static String PROP_GENDER = "gender";
	public static String PROP_ID = "id";
	public static String PROP_STUDENT_NAME = "studentName";
	public static String PROP_STUDENT_ADDRESS = "studentAddress";
	public static String PROP_PASSWORD = "password";


	// constructors
	public BasePjStudent () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePjStudent (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String studentName;
	private java.lang.String studentEmail;
	private java.lang.String grade;
	private java.lang.String gender;
	private java.lang.String studentPhoneNo;
	private java.lang.String studentAddress;
	private java.sql.Blob studentPhoto;
	private java.lang.String password;
	private java.lang.String stuAccountStatus;

	// collections
	private java.util.Set<com.system.business.entity.PjRequest> pjRequests;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="student_id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: student_name
	 */
	public java.lang.String getStudentName () {
		return studentName;
	}

	/**
	 * Set the value related to the column: student_name
	 * @param studentName the student_name value
	 */
	public void setStudentName (java.lang.String studentName) {
		this.studentName = studentName;
	}



	/**
	 * Return the value associated with the column: student_email
	 */
	public java.lang.String getStudentEmail () {
		return studentEmail;
	}

	/**
	 * Set the value related to the column: student_email
	 * @param studentEmail the student_email value
	 */
	public void setStudentEmail (java.lang.String studentEmail) {
		this.studentEmail = studentEmail;
	}



	/**
	 * Return the value associated with the column: grade
	 */
	public java.lang.String getGrade () {
		return grade;
	}

	/**
	 * Set the value related to the column: grade
	 * @param grade the grade value
	 */
	public void setGrade (java.lang.String grade) {
		this.grade = grade;
	}



	/**
	 * Return the value associated with the column: gender
	 */
	public java.lang.String getGender () {
		return gender;
	}

	/**
	 * Set the value related to the column: gender
	 * @param gender the gender value
	 */
	public void setGender (java.lang.String gender) {
		this.gender = gender;
	}



	/**
	 * Return the value associated with the column: student_phone_no
	 */
	public java.lang.String getStudentPhoneNo () {
		return studentPhoneNo;
	}

	/**
	 * Set the value related to the column: student_phone_no
	 * @param studentPhoneNo the student_phone_no value
	 */
	public void setStudentPhoneNo (java.lang.String studentPhoneNo) {
		this.studentPhoneNo = studentPhoneNo;
	}



	/**
	 * Return the value associated with the column: student_address
	 */
	public java.lang.String getStudentAddress () {
		return studentAddress;
	}

	/**
	 * Set the value related to the column: student_address
	 * @param studentAddress the student_address value
	 */
	public void setStudentAddress (java.lang.String studentAddress) {
		this.studentAddress = studentAddress;
	}



	/**
	 * Return the value associated with the column: student_photo
	 */
	public java.sql.Blob getStudentPhoto () {
		return studentPhoto;
	}

	/**
	 * Set the value related to the column: student_photo
	 * @param studentPhoto the student_photo value
	 */
	public void setStudentPhoto (java.sql.Blob studentPhoto) {
		this.studentPhoto = studentPhoto;
	}



	/**
	 * Return the value associated with the column: password
	 */
	public java.lang.String getPassword () {
		return password;
	}

	/**
	 * Set the value related to the column: password
	 * @param password the password value
	 */
	public void setPassword (java.lang.String password) {
		this.password = password;
	}



	/**
	 * Return the value associated with the column: stu_account_status
	 */
	public java.lang.String getStuAccountStatus () {
		return stuAccountStatus;
	}

	/**
	 * Set the value related to the column: stu_account_status
	 * @param stuAccountStatus the stu_account_status value
	 */
	public void setStuAccountStatus (java.lang.String stuAccountStatus) {
		this.stuAccountStatus = stuAccountStatus;
	}



	/**
	 * Return the value associated with the column: pjRequests
	 */
	public java.util.Set<com.system.business.entity.PjRequest> getPjRequests () {
		return pjRequests;
	}

	/**
	 * Set the value related to the column: pjRequests
	 * @param pjRequests the pjRequests value
	 */
	public void setPjRequests (java.util.Set<com.system.business.entity.PjRequest> pjRequests) {
		this.pjRequests = pjRequests;
	}

	public void addTopjRequests (com.system.business.entity.PjRequest pjRequest) {
		if (null == getPjRequests()) setPjRequests(new java.util.TreeSet<com.system.business.entity.PjRequest>());
		getPjRequests().add(pjRequest);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.system.business.entity.PjStudent)) return false;
		else {
			com.system.business.entity.PjStudent pjStudent = (com.system.business.entity.PjStudent) obj;
			if (null == this.getId() || null == pjStudent.getId()) return false;
			else return (this.getId().equals(pjStudent.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}