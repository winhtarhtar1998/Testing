package com.system.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the pj_tutor table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="pj_tutor"
 */

public abstract class BasePjTutor  implements Serializable {

	public static String REF = "PjTutor";
	public static String PROP_TUTOR_PHOTO = "tutorPhoto";
	public static String PROP_MORE_DEGREES = "moreDegrees";
	public static String PROP_HIGHEST_DEGREE = "highestDegree";
	public static String PROP_TUTOR_EMAIL = "tutorEmail";
	public static String PROP_TUTOR_NAME = "tutorName";
	public static String PROP_TUTOR_ADDRESS = "tutorAddress";
	public static String PROP_TUTOR_ACCOUNT_STATUS = "tutorAccountStatus";
	public static String PROP_GENDER = "gender";
	public static String PROP_ABOUT = "about";
	public static String PROP_SPECIALIZATION = "specialization";
	public static String PROP_TUTOR_TYPE = "tutorType";
	public static String PROP_TUTOR_PHONE_NO = "tutorPhoneNo";
	public static String PROP_ID = "id";
	public static String PROP_PASSWORD = "password";


	// constructors
	public BasePjTutor () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePjTutor (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String tutorName;
	private java.lang.String tutorEmail;
	private java.lang.String tutorType;
	private java.lang.String highestDegree;
	private java.lang.String specialization;
	private java.lang.String moreDegrees;
	private java.lang.String gender;
	private java.lang.String tutorPhoneNo;
	private java.lang.String tutorAddress;
	private java.lang.String about;
	private java.sql.Blob tutorPhoto;
	private java.lang.String password;
	private java.lang.String tutorAccountStatus;

	// collections
	private java.util.Set<com.system.business.entity.PjTeach> pjTeachs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="tutor_id"
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
	 * Return the value associated with the column: tutor_name
	 */
	public java.lang.String getTutorName () {
		return tutorName;
	}

	/**
	 * Set the value related to the column: tutor_name
	 * @param tutorName the tutor_name value
	 */
	public void setTutorName (java.lang.String tutorName) {
		this.tutorName = tutorName;
	}



	/**
	 * Return the value associated with the column: tutor_email
	 */
	public java.lang.String getTutorEmail () {
		return tutorEmail;
	}

	/**
	 * Set the value related to the column: tutor_email
	 * @param tutorEmail the tutor_email value
	 */
	public void setTutorEmail (java.lang.String tutorEmail) {
		this.tutorEmail = tutorEmail;
	}



	/**
	 * Return the value associated with the column: tutor_type
	 */
	public java.lang.String getTutorType () {
		return tutorType;
	}

	/**
	 * Set the value related to the column: tutor_type
	 * @param tutorType the tutor_type value
	 */
	public void setTutorType (java.lang.String tutorType) {
		this.tutorType = tutorType;
	}



	/**
	 * Return the value associated with the column: highest_degree
	 */
	public java.lang.String getHighestDegree () {
		return highestDegree;
	}

	/**
	 * Set the value related to the column: highest_degree
	 * @param highestDegree the highest_degree value
	 */
	public void setHighestDegree (java.lang.String highestDegree) {
		this.highestDegree = highestDegree;
	}



	/**
	 * Return the value associated with the column: specialization
	 */
	public java.lang.String getSpecialization () {
		return specialization;
	}

	/**
	 * Set the value related to the column: specialization
	 * @param specialization the specialization value
	 */
	public void setSpecialization (java.lang.String specialization) {
		this.specialization = specialization;
	}



	/**
	 * Return the value associated with the column: more_degrees
	 */
	public java.lang.String getMoreDegrees () {
		return moreDegrees;
	}

	/**
	 * Set the value related to the column: more_degrees
	 * @param moreDegrees the more_degrees value
	 */
	public void setMoreDegrees (java.lang.String moreDegrees) {
		this.moreDegrees = moreDegrees;
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
	 * Return the value associated with the column: tutor_phone_no
	 */
	public java.lang.String getTutorPhoneNo () {
		return tutorPhoneNo;
	}

	/**
	 * Set the value related to the column: tutor_phone_no
	 * @param tutorPhoneNo the tutor_phone_no value
	 */
	public void setTutorPhoneNo (java.lang.String tutorPhoneNo) {
		this.tutorPhoneNo = tutorPhoneNo;
	}



	/**
	 * Return the value associated with the column: tutor_address
	 */
	public java.lang.String getTutorAddress () {
		return tutorAddress;
	}

	/**
	 * Set the value related to the column: tutor_address
	 * @param tutorAddress the tutor_address value
	 */
	public void setTutorAddress (java.lang.String tutorAddress) {
		this.tutorAddress = tutorAddress;
	}



	/**
	 * Return the value associated with the column: about
	 */
	public java.lang.String getAbout () {
		return about;
	}

	/**
	 * Set the value related to the column: about
	 * @param about the about value
	 */
	public void setAbout (java.lang.String about) {
		this.about = about;
	}



	/**
	 * Return the value associated with the column: tutor_photo
	 */
	public java.sql.Blob getTutorPhoto () {
		return tutorPhoto;
	}

	/**
	 * Set the value related to the column: tutor_photo
	 * @param tutorPhoto the tutor_photo value
	 */
	public void setTutorPhoto (java.sql.Blob tutorPhoto) {
		this.tutorPhoto = tutorPhoto;
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
	 * Return the value associated with the column: tutor_account_status
	 */
	public java.lang.String getTutorAccountStatus () {
		return tutorAccountStatus;
	}

	/**
	 * Set the value related to the column: tutor_account_status
	 * @param tutorAccountStatus the tutor_account_status value
	 */
	public void setTutorAccountStatus (java.lang.String tutorAccountStatus) {
		this.tutorAccountStatus = tutorAccountStatus;
	}



	/**
	 * Return the value associated with the column: pjTeachs
	 */
	public java.util.Set<com.system.business.entity.PjTeach> getPjTeachs () {
		return pjTeachs;
	}

	/**
	 * Set the value related to the column: pjTeachs
	 * @param pjTeachs the pjTeachs value
	 */
	public void setPjTeachs (java.util.Set<com.system.business.entity.PjTeach> pjTeachs) {
		this.pjTeachs = pjTeachs;
	}

	public void addTopjTeachs (com.system.business.entity.PjTeach pjTeach) {
		if (null == getPjTeachs()) setPjTeachs(new java.util.TreeSet<com.system.business.entity.PjTeach>());
		getPjTeachs().add(pjTeach);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.system.business.entity.PjTutor)) return false;
		else {
			com.system.business.entity.PjTutor pjTutor = (com.system.business.entity.PjTutor) obj;
			if (null == this.getId() || null == pjTutor.getId()) return false;
			else return (this.getId().equals(pjTutor.getId()));
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