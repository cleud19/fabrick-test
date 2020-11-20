package it.client.rest.fabricktest.model;

/**
 * 
 * @author Claudiu Iancu
 *  
 */
public class EnumType {
	private String enumeration;
	private String value;
	
	public String getEnumeration() {
		return enumeration;
	}
	public void setEnumeration(String enumeration) {
		this.enumeration = enumeration;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "EnumType [enumeration=" + enumeration + ", value=" + value + "]";
	}
	
	
	
}
