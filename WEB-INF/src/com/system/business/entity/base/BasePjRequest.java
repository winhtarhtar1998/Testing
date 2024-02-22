package com.system.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the pj_request table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="pj_request"
 */

public abstract class BasePjRequest  implements Serializable {

	public static String REF = "PjRequest";
	public static String PROP_STATUS = "status";
	public static String PROP_CONNECTED_DATE = "connectedDate";
	public static String PROP_REQUEST_DATE = "requestDate";
	public static String PROP_FEEDBACK = "feedback";
	public static String PROP_EXTRA_REQUEST_MESSAGE = "extraRequestMessage";
	public static String PROP_TEACH = "teach";
	public static String PROP_ID = "id";
	public static String PROP_STUDENT = "student";
	public static String PROP_RATING_POINT = "ratingPoint";
	public static String PROP_COMPLETED_DATE = "completedDate";


	// constructors
	public BasePjRequest () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePjRequest (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePjRequest (
		java.lang.Integer id,
		com.system.business.entity.PjTeach teach) {

		this.setId(id);
		this.setTeach(teach);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date requestDate;
	private java.util.Date connectedDate;
	private java.util.Date completedDate;
	private java.lang.String status;
	private java.lang.String extraRequestMessage;
	private java.lang.String feedback;
	private java.lang.Integer ratingPoint;

	// many to one
	private com.system.business.entity.PjTeach teach;
	private com.system.business.entity.PjStudent student;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="request_id"
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
	 * Return the value associated with the column: request_date
	 */
	public java.util.Date getRequestDate () {
		return requestDate;
	}

	/**
	 * Set the value related to the column: request_date
	 * @param requestDate the request_date value
	 */
	public void setRequestDate (java.util.Date requestDate) {
		this.requestDate = requestDate;
	}



	/**
	 * Return the value associated with the column: connected_date
	 */
	public java.util.Date getConnectedDate () {
		return connectedDate;
	}

	/**
	 * Set the value related to the column: connected_date
	 * @param connectedDate the connected_date value
	 */
	public void setConnectedDate (java.util.Date connectedDate) {
		this.connectedDate = connectedDate;
	}



	/**
	 * Return the value associated with the column: completed_date
	 */
	public java.util.Date getCompletedDate () {
		return completedDate;
	}

	/**
	 * Set the value related to the column: completed_date
	 * @param completedDate the completed_date value
	 */
	public void setCompletedDate (java.util.Date completedDate) {
		this.completedDate = completedDate;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: extra_request_message
	 */
	public java.lang.String getExtraRequestMessage () {
		return extraRequestMessage;
	}

	/**
	 * Set the value related to the column: extra_request_message
	 * @param extraRequestMessage the extra_request_message value
	 */
	public void setExtraRequestMessage (java.lang.String extraRequestMessage) {
		this.extraRequestMessage = extraRequestMessage;
	}



	/**
	 * Return the value associated with the column: feedback
	 */
	public java.lang.String getFeedback () {
		return feedback;
	}

	/**
	 * Set the value related to the column: feedback
	 * @param feedback the feedback value
	 */
	public void setFeedback (java.lang.String feedback) {
		this.feedback = feedback;
	}



	/**
	 * Return the value associated with the column: rating_point
	 */
	public java.lang.Integer getRatingPoint () {
		return ratingPoint;
	}

	/**
	 * Set the value related to the column: rating_point
	 * @param ratingPoint the rating_point value
	 */
	public void setRatingPoint (java.lang.Integer ratingPoint) {
		this.ratingPoint = ratingPoint;
	}



	/**
	 * Return the value associated with the column: teach_id
	 */
	public com.system.business.entity.PjTeach getTeach () {
		return teach;
	}

	/**
	 * Set the value related to the column: teach_id
	 * @param teach the teach_id value
	 */
	public void setTeach (com.system.business.entity.PjTeach teach) {
		this.teach = teach;
	}



	/**
	 * Return the value associated with the column: student_id
	 */
	public com.system.business.entity.PjStudent getStudent () {
		return student;
	}

	/**
	 * Set the value related to the column: student_id
	 * @param student the student_id value
	 */
	public void setStudent (com.system.business.entity.PjStudent student) {
		this.student = student;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.system.business.entity.PjRequest)) return false;
		else {
			com.system.business.entity.PjRequest pjRequest = (com.system.business.entity.PjRequest) obj;
			if (null == this.getId() || null == pjRequest.getId()) return false;
			else return (this.getId().equals(pjRequest.getId()));
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