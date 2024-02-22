package com.system.business.entity;

import com.system.business.entity.base.BasePjRequest;



public class PjRequest extends BasePjRequest {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PjRequest () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public PjRequest (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public PjRequest (
		java.lang.Integer id,
		com.system.business.entity.PjTeach teach) {

		super (
			id,
			teach);
	}

/*[CONSTRUCTOR MARKER END]*/


}