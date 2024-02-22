package com.system.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the pj_subject table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="pj_subject"
 */

public abstract class BasePjSubject  implements Serializable {

	public static String REF = "PjSubject";
	public static String PROP_SUBJECT_NAME = "subjectName";
	public static String PROP_ID = "id";


	// constructors
	public BasePjSubject () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePjSubject (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String subjectName;

	// collections
	private java.util.Set<com.system.business.entity.PjTeach> pjTeachs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="subject_id"
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
	 * Return the value associated with the column: subject_name
	 */
	public java.lang.String getSubjectName () {
		return subjectName;
	}

	/**
	 * Set the value related to the column: subject_name
	 * @param subjectName the subject_name value
	 */
	public void setSubjectName (java.lang.String subjectName) {
		this.subjectName = subjectName;
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
		if (!(obj instanceof com.system.business.entity.PjSubject)) return false;
		else {
			com.system.business.entity.PjSubject pjSubject = (com.system.business.entity.PjSubject) obj;
			if (null == this.getId() || null == pjSubject.getId()) return false;
			else return (this.getId().equals(pjSubject.getId()));
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