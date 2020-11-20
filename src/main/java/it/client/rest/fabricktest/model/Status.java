package it.client.rest.fabricktest.model;


/**
 * 
 * @author Claudiu Iancu
 *  
 */
public enum Status {
	/**	The money transfer has been executed. */
	EXECUTED,
	/**	The money transfer has been booked for execution on execution date. */
	BOOKED,
	/**	The money transfer execution is in progress. */
	WORK_IN_PROGRESS,
	/**	The money transfer has been cancelled by the customer (applies only to formerly booked money transfers). */
	CANCELLED,
	/** 	The money transfer has been rejected. */
	REJECTED;

}
