package it.client.rest.fabricktest.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author Claudiu Iancu
 *  
 */
public class ResponseObject<T> {
	
	private String status; 
	private List<Error> errors;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private T payload;
	
	public ResponseObject() {
		
	}
	
	public ResponseObject(String status, List<Error> errors, T payload) {
		super();
		this.status = status;
		this.errors = errors;
		this.payload = payload;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Error> getErrors() {
		return errors;
	}
	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	public T getPayload() {
		return payload;
	}
	public void setPayload(T payload) {
		this.payload = payload;
	}
	
	@Override
	public String toString() {
		return "ResponseObject [status=" + status + ", errors=" + errors + ", payload=" + payload + "]";
	}
	
}
