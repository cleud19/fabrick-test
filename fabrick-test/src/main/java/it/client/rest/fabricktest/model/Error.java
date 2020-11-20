package it.client.rest.fabricktest.model;

public class Error {
	
	private String code;
	private String params;
	private String description;
	
	public Error() {;
	
	}
	
	public Error(String code, String params, String description) {
		super();
		this.code = code;
		this.params = params;
		this.description = description;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Error [code=" + code + ", params=" + params + ", description=" + description + "]";
	}
}
