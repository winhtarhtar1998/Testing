package com.system.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the pj_teach table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="pj_teach"
 */

public abstract class BasePjTeach  implements Serializable {

	public static String REF = "PjTeach";
	public static String PROP_PREFERABLE_TIME = "preferableTime";
	public static String PROP_TUTOR = "tutor";
	public static String PROP_PREFERABLE_DAYS = "preferableDays";
	public static String PROP_TEACHING_TYPE = "teachingType";
	public static String PROP_FEE = "fee";
	public static String PROP_ID = "id";
	public static String PROP_PERIOD_PER_WEEK = "periodPerWeek";
	public static String PROP_SUBJECT = "subject";


	// constructors
	public BasePjTeach () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePjTeach (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String teachingType;
	private java.lang.Double fee;
	private java.lang.Integer periodPerWeek;
	private java.lang.String preferableTime;
	private java.lang.String preferableDays;

	// many to one
	private com.system.business.entity.PjSubject subject;
	private com.system.business.entity.PjTutor tutor;

	// collections
	private java.util.Set<com.system.business.entity.PjRequest> pjRequests;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="teach_id"
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
	 * Return the value associated with the column: teaching_type
	 */
	public java.lang.String getTeachingType () {
		return teachingType;
	}

	/**
	 * Set the value related to the column: teaching_type
	 * @param teachingType the teaching_type value
	 */
	public void setTeachingType (java.lang.String teachingType) {
		this.teachingType = teachingType;
	}



	/**
	 * Return the value associated with the column: fee
	 */
	public java.lang.Double getFee () {
		return fee;
	}

	/**
	 * Set the value related to the column: fee
	 * @param fee the fee value
	 */
	public void setFee (java.lang.Double fee) {
		this.fee = fee;
	}



	/**
	 * Return the value associated with the column: period_per_week
	 */
	public java.lang.Integer getPeriodPerWeek () {
		return periodPerWeek;
	}

	/**
	 * Set the value related to the column: period_per_week
	 * @param periodPerWeek the period_per_week value
	 */
	public void setPeriodPerWeek (java.lang.Integer periodPerWeek) {
		this.periodPerWeek = periodPerWeek;
	}



	/**
	 * Return the value associated with the column: preferable_time
	 */
	public java.lang.String getPreferableTime () {
		return preferableTime;
	}

	/**
	 * Set the value related to the column: preferable_time
	 * @param preferableTime the preferable_time value
	 */
	public void setPreferableTime (java.lang.String preferableTime) {
		this.preferableTime = preferableTime;
	}



	/**
	 * Return the value associated with the column: preferable_days
	 */
	public java.lang.String getPreferableDays () {
		return preferableDays;
	}

	/**
	 * Set the value related to the column: preferable_days
	 * @param preferableDays the preferable_days value
	 */
	public void setPreferableDays (java.lang.String preferableDays) {
		this.preferableDays = preferableDays;
	}



	/**
	 * Return the value associated with the column: subject_id
	 */
	public com.system.business.entity.PjSubject getSubject () {
		return subject;
	}

	/**
	 * Set the value related to the column: subject_id
	 * @param subject the subject_id value
	 */
	public void setSubject (com.system.business.entity.PjSubject subject) {
		this.subject = subject;
	}



	/**
	 * Return the value associated with the column: tutor_id
	 */
	public com.system.business.entity.PjTutor getTutor () {
		return tutor;
	}

	/**
	 * Set the value related to the column: tutor_id
	 * @param tutor the tutor_id value
	 */
	public void setTutor (com.system.business.entity.PjTutor tutor) {
		this.tutor = tutor;
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
		if (!(obj instanceof com.system.business.entity.PjTeach)) return false;
		else {
			com.system.business.entity.PjTeach pjTeach = (com.system.business.entity.PjTeach) obj;
			if (null == this.getId() || null == pjTeach.getId()) return false;
			else return (this.getId().equals(pjTeach.getId()));
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